package my.examples.was;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderTest01 {
    public static void main(String[] args) throws Exception {
        Sample s1 = new Sample();
        s1.print();
        s1.print("world");

        Class clazz = Class.forName("my.examples.was.Sample");
//        Method[] methods = clazz.getMethods();
//        for (Method method : methods)
//            System.out.println(method.getName());

        Sample sample = (Sample) clazz.newInstance();
        sample.print();
        sample.print("world");



        addPath("/tmp/classes");

        Class clazz2 = Class.forName("my.MyData");
        Method[] methods1 = clazz2.getMethods();
        for (Method m : methods1) {
            System.out.println(m.getName());
        }

//        Object myData = clazz2.newInstance();
//        myData.setName("Kim");
//        System.out.println(myData.getName());
    }




    // https://stackoverflow.com/questions/7884393/can-a-directory-be-added-to-the-class-path-at-runtime
    public static void addPath(String s) throws Exception {
        File f = new File(s);
        URL u = f.toURI().toURL();
        URLClassLoader urlClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        Class urlClass = URLClassLoader.class;
        Method method = urlClass.getDeclaredMethod("addURL", new Class[]{URL.class});
        method.setAccessible(true);
        method.invoke(urlClassLoader, new Object[]{u});
    }
}
