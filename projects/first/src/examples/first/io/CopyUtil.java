package examples.first.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyUtil {
    /**
     * in으로부터 데이터를 받아 1024byte 크기의 배열 단위로 out에 복사한다.
     * @param in
     * @param out
     */
    public static void copy(InputStream in, OutputStream out) {
        try {
            byte[] buffer = new byte[1024];
            int readSize = -1;
            while ((readSize = in.read(buffer)) != -1)
                out.write(buffer, 0, readSize);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {}
            try {
                out.close();
            } catch (IOException e) {}
        }
    }
}
