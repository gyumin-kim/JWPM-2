package my.examples.was;

import java.io.File;
import java.net.URL;
import java.util.Enumeration;

public class GetClassPath {
    private static final String baseDir = "/Users/kyumin/Documents/Programming/fastcampus/JWPM-2/JWPM-2-memo/projects/miniwasanswer/target/classes/";

    public static void main(String[] args) throws Exception {
//        File file = new File(".");
//        File[] files = file.listFiles();
//
//        printClass(files);

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> roots = classLoader.getResources("");
        while (roots.hasMoreElements()) {
            URL url = roots.nextElement();
            File file = new File(url.getPath());
            File[] files = file.listFiles();
            printClass(files);
        }
    }

    public static void printClass(File[] files) {
        for (File f : files) {
            if (f.isDirectory()) {
                File[] children = f.listFiles();
                printClass(children);
            }
            else {
//                String fileName = f.getName();
//                int nameLen = fileName.length();
//                if (fileName.substring(nameLen-5, nameLen).equals("class"))
//                    System.out.println(f.getPath());
                String path = f.getPath().substring(baseDir.length());
                path = path.replace("/", ".");
                int lastIndex = path.lastIndexOf(".");
                path = path.substring(0, lastIndex);
                System.out.println(path);
            }
        }
    }
}
