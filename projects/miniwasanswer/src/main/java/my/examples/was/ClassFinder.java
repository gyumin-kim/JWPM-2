package my.examples.was;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * baseDir를 가지며,
 */
public class ClassFinder {
    private String baseDir;

    public ClassFinder(String baseDir) {
        this.baseDir = baseDir;
    }

    public List<String> findAllClass() {
        List<String> list = new ArrayList<>();

        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Enumeration<URL> roots = classLoader.getResources("");
            while (roots.hasMoreElements()) {
                URL url = roots.nextElement();
                File file = new File(url.getPath());
                File[] files = file.listFiles();
                addToList(files, list);
            }
        } catch (IOException ie) {}

        return list;
    }

    public void addToList(File[] files, List<String> list) {
        for (File f : files) {
            if (f.isDirectory()) {
                File[] children = f.listFiles();
                addToList(children, list);
            }
            else {
                String path = f.getPath().substring(baseDir.length());
                path = path.replace("/", ".");
                int lastIndex = path.lastIndexOf(".");
                path = path.substring(0, lastIndex);
                list.add(path);
            }
        }
    }
}
