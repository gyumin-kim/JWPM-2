package my.examples.was;

import java.io.*;

public class Engine {
    private Handler handler;
    private InputStream in;
    private OutputStream out;
    private BufferedReader request;
    private PrintWriter response;   // new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

    private String requestPath;
    private String fileName;
    private String connection;
    private String contentType;
    private long contentLength;

    private final String BASE_DIR = "/tmp/mywas";

    public Engine() {

    }

    public Engine(Handler handler, InputStream in, OutputStream out, BufferedReader request, PrintWriter response) {
        this.handler = handler;
        this.in = in;
        this.out = out;
        this.request = request;
        this.response = response;
    }

    public void startEngine() {
        requestPath = handler.getPath();
        /* TODO: requestPath가 유효한 path인지 검사하는 Context 클래스 추가.
           TODO: 서버의 경로 안에 존재하는 자원인지 검사. */

        // 브라우저에서 요청한 경로에 따라 fileName을 결정
        if ("/".equals(requestPath))
            fileName = "/index.html";
        else
            fileName = "/error.html";

        fileName = BASE_DIR + fileName; // fileName 앞에 BASE_DIR을 붙임
        File file = new File(fileName); // 해댱 fileName으로 File 객체 생성

        connection = handler.getReqHeader().get("Connection");
        contentLength = file.length();

        // 일단 몇가지 경우의 수만 간단히 적음
        if (fileName.endsWith("text") || fileName.endsWith("html"))
            contentType = "text/html";
        else if (fileName.endsWith("xhtml"))
            contentType = "application/xhtml+xml";
        else if (fileName.endsWith("png"))
            contentType = "image/png";
        else if (fileName.endsWith("jpg"))
            contentType = "image/jpeg";

        // 유효성 체크
        if (file.exists())
            response.println(handler.getProtocolVersion() + " 200 OK");
        else
            response.println(handler.getProtocolVersion() + " 404 Not Found");

        response.println("");
        response.println("fileName: " + fileName);
        response.println("Connection: " + connection);
        response.println("Content-Length: " + contentLength);
        response.println("Content-Type: " + contentType);   // /tmp/mywas
        response.println("");
        response.flush();

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
//            out = handler.getSocket().getOutputStream();

            byte[] buffer = new byte[1024];
            int readCount = -1;
            while ((readCount = fis.read(buffer)) != -1) {
                out.write(buffer, 0, readCount);
                out.flush();
            }
            fis.close();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                in.close();
            } catch (IOException ie) {
                ie.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException ie) {
                ie.printStackTrace();
            }
            try {
                handler.getSocket().close();
            } catch (IOException ie) {}
        }
    }
}