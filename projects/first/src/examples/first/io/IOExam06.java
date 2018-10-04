package examples.first.io;

import java.io.*;

/**
 * "/tmp/data.bin" 파일에 boolean, int, double, UTF 값을 쓰고,
 * "/tmp/data.bin" 파일에서 boolean, int, double, UTF 값을 읽어와서 콘솔에 출력한다.
 */
public class IOExam06 {
    public static void main(String[] args) {
        DataInputStream in = null;
        DataOutputStream out = null;

        try {
            out = new DataOutputStream(new FileOutputStream("/tmp/data.bin"));
            out.writeBoolean(false);
            out.writeInt(1000);
            out.writeDouble(50.5);
            out.writeUTF("HELLO");

            in = new DataInputStream(new FileInputStream("/tmp/data.bin"));
            boolean b = in.readBoolean();
            int i = in.readInt();
            double d = in.readDouble();
            String utf = in.readUTF();

            System.out.println(b);
            System.out.println(i);
            System.out.println(d);
            System.out.println(utf);
        } catch (Exception e) {
            e.printStackTrace();
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
