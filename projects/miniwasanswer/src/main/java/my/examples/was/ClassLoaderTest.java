package my.examples.was;

import java.lang.annotation.Annotation;
import java.util.List;

public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {
        String baseDir = "/Users/kyumin/Documents/Programming/fastcampus/JWPM-2/JWPM-2-memo/projects/miniwasanswer/target/classes/";
        ClassFinder classFinder = new ClassFinder(baseDir);
        List<String> allClasses = classFinder.findAllClass();
        for (String className : allClasses) {
            Class clazz = Class.forName(className);
            Annotation annotation = clazz.getAnnotation(WebServlet.class);

            if (annotation != null) {
                WebServlet webServlet = (WebServlet)annotation;

                // annotation의 value값을 출력
                System.out.println(annotation.toString());
                String value = webServlet.value();
                System.out.println(className + ": " + value);
            }
        }
    }
}
