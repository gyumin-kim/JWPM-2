package my.examples.was;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Handler extends Thread {
    private static Map<String, Class> baseDirServletMap; // < path, class정보 >
    private static Map<String, HttpServlet> httpServletMap;
    private static String baseDir = "/Users/kyumin/Documents/Programming/fastcampus/JWPM-2/JWPM-2-memo/" +
            "projects/miniwasanswer/target/classes/";

    // (baseDir에 있는) WebServlet이 붙어 있는 모든 클래스들을 찾는다. (최초 실행할 때만 처리할 일)
    static {
        httpServletMap = new HashMap<>();
        WebServletMapperManager wsmm = new WebServletMapperManager();
        baseDirServletMap = wsmm.findServlet(baseDir);
        // baseDirServletMap: @WebServlet이 붙어있고, HttpServlet을 상속받는 클래스들 < path, class 정보 >
    }

    private Socket socket;

    public Handler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 요청받기
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            OutputStream out = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));

            Request request = new Request(in, br);
            Response response = new Response(out, pw);

            // request, response를 이용하여 무엇을할까?
            String path = request.getPath();
            Class clazz = baseDirServletMap.get(path);    // clazz: class 이름

            if (clazz != null) {
                // 1. path 정보에 해당하는 동적 프로그램이 있는지 확인한다.
                //    ex : /today  --->  TodayServlet이 실행한 결과가 보여진다.
                HttpServlet httpServlet = httpServletMap.get(path);
                if(httpServlet == null){
                    httpServlet = (HttpServlet)clazz.newInstance(); // 객체가 생성
                    httpServlet.init();
                    httpServletMap.put(path, httpServlet);
                }
                pw.println("HTTP/1.1 200 OK");
                pw.println("Content-Type: text/html; charset=UTF-8");
                pw.println("");
                httpServlet.service(request, response);
                pw.flush();
            }

            else {
                // 2. 동적프로그램이 아니라면
                //    path에 해당하는 파일이 있는지 찾아본다.
                //    있으면 해당 파일의 내용을 보여주고, 없으면 404 오류를 출력한다.
                DefaultServlet defaultServlet = new DefaultServlet();
                defaultServlet.service(request, response);
            }

            in.close();
            out.close();
            socket.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    } // run()
}