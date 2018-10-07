package my.examples.was;

import java.io.File;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderTest04 {
    static String baseDir = "/Users/kyumin/Documents/Programming/fastcampus/JWPM-2/JWPM-2-memo/projects/miniwasanswer/target/classes/";

    public static void main(String[] args) throws Exception {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        // 현재 경로에 있는 class들을 모두 load한다
        Enumeration<URL> resources = contextClassLoader.getResources("");

        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            File root = new File(url.getPath());
//            if (root.isDirectory()) {
//                printDirectory(root);
//            } else {
//                printFile(root);
//            }
            printFile(root);
        }
    }

    public static void printFile(File file) {
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            for (File childFile : children) {
                printFile(childFile);
            }
        } else {
            String path = file.getPath();
            path = path.substring(baseDir.length());
            path = path.replace('/', '.');
            int lastIndex = path.lastIndexOf('.');
            path = path.substring(0, lastIndex);
            System.out.println(path);
        }
    }
}
