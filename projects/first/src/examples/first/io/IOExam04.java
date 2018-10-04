package examples.first.io;

import java.io.*;
import java.net.URL;

/**
 * url("https://www.naver.com")로부터 데이터를 읽어와서 "/tmp/naver.html"에 복사
 * CopyUtil.copy(in, out) 메소드 사용
 */
public class IOExam04 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.naver.com");
        InputStream in = url.openStream();

        OutputStream out = null;
        out = new FileOutputStream("/tmp/naver.html");

        CopyUtil.copy(in, out);
    }
}
