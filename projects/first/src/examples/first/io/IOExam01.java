package examples.first.io;

import java.io.*;

/**
 * "res/test.txt"으로부터 데이터를 읽어들여 "/tmp/readme.out"에 출력(copy)한다
 */
public class IOExam01 {
    public static void main(String[] args) {
        InputStream in = null;
        OutputStream out = null;

        try {
            File file = new File("res/test.txt");
            if (!file.isDirectory() && file.exists()) {
                in = new FileInputStream(file);
                out = new FileOutputStream("/tmp/readme.out");

                int readData = -1;
                while ((readData = in.read()) != -1) {
                    out.write(readData);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException ex) {}
            try {
                out.close();
            } catch (IOException ex) {}
        }
    }
}
