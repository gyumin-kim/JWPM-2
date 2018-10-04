package my.examples.was;

import java.io.*;
import java.net.Socket;

public class Handler extends Thread{
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
            // 1. path정보에 해당하는 동적 프로그램이 있는지 확인한다.
            // ex : /today  --->  TodayServlet이 실행한 결과가 보여준다.
            // 2. 동적프로그램이 아니라면
            //       path에 해당하는 파일이 있는지 찾아본다.
            //       있으면 해당 파일의 내용을 보여주고, 없으면 404 오류를 출력한다.
            DefaultServlet defaultServlet = new DefaultServlet();
            defaultServlet.service(request, response);

            in.close();
            out.close();
            socket.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    } // run()
}