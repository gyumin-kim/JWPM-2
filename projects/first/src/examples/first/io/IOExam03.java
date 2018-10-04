package examples.first.io;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * "hello world!"이라는 String을 byte[] 배열(buffer)에 넣고, 배열로부터 데이터를 받아 "/tmp/buffer.txt"에 쓴다.
 * CopyUtilTest.copy(in, out) 메소드를 사용한다.
 */
public class IOExam03 {
    public static void main(String[] args) throws Exception {
        String str = "hello world!";
        byte[] buffer = str.getBytes();

        InputStream in = new ByteArrayInputStream(buffer);
        OutputStream out = new FileOutputStream("/tmp/buffer.txt");

        CopyUtil.copy(in, out);
    }
}
