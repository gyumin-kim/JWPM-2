package my.examples.was;

import java.io.*;

public class DefaultServlet {
    public void service(Request request, Response response){
        // 응답하기
        String webpath = request.getPath();
        if("/".equals(webpath)){
            webpath = webpath + "index.html";
        }
        String path = "/tmp/www" + webpath;
        File file = new File(path);

        OutputStream out = response.getOut();
        PrintWriter pw = response.getPw();

        if(file.exists()) {
            pw.println("HTTP/1.1 200 OK");
            pw.println("Content-Type: text/html; charset=UTF-8");
            pw.println("Content-Length: " + file.length());
            pw.println("");
            pw.flush();

            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                byte[] buffer = new byte[1024];
                int readSize = 0;
                while ((readSize = fis.read(buffer)) != -1) {
                    out.write(buffer, 0, readSize);
                    out.flush();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    fis.close();
                } catch (Exception ex) {
                }
            }
        }
        else {
            pw.println("HTTP/1.1 404 NOT FOUND");
            pw.println("Content-Type: text/html; charset=UTF-8");
            pw.println("");
            pw.flush();
        }
    }
}