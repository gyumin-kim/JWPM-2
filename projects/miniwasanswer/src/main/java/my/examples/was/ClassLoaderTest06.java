package my.examples.was;

import java.util.Map;
import java.util.Set;

public class ClassLoaderTest06 {
    public static void main(String[] args) throws Exception {
        String baseDir = "/Users/kyumin/Documents/Programming/fastcampus" +
                "/JWPM-2/JWPM-2-memo/projects/miniwasanswer/target/classes/";

        WebServletMapperManager wsmm = new WebServletMapperManager();
        Map<String, Class> map = wsmm.findServlet(baseDir);

        Set<String> paths = map.keySet();
        for (String path : paths) {
            System.out.println(path + ": " + map.get(path).getName());
        }
    }
}
