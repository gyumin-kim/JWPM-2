package my.examples.was;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebServletMapperManager {

    public Map<String, Class> findServlet(String baseDir) {
        Map<String, Class> map = new HashMap<>();   // < path, class 정보 >
        ClassFinder classFinder = new ClassFinder(baseDir);
        // baseDir에 있는 모든 클래스들의 list를 읽어들임
        List<String> classList = classFinder.findAllClass();

        try {
            // 읽어들인 list들 중에서 @WebServlet이 붙어있는 클래스만 map에 저장
            for (String className : classList) {
                Class clazz = Class.forName(className);
                Annotation annotation = clazz.getAnnotation(WebServlet.class);
                Class superClass = clazz.getSuperclass();

                if (annotation != null && superClass == HttpServlet.class) {
                    WebServlet webServlet = (WebServlet) annotation;
                    String value = webServlet.value();

                    map.put(value, clazz);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return map;
    }
}