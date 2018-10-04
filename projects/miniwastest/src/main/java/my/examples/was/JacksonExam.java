package my.examples.was;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JacksonExam {
    public static void main(String[] args) {
        MiniWASConfiguration miniWASConfiguration =
                new MiniWASConfiguration();
        miniWASConfiguration.setClasspath(".");
        miniWASConfiguration.setStaticDir("/tmp/mywas");

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // POJO -> JSON
            String jsonConfiguration = objectMapper.writeValueAsString(miniWASConfiguration);
//            String jsonConfiguration = objectMapper.writeValueAsString(miniWASConfiguration);
//            System.out.println(jsonConfiguration);

            // JSON -> POJO
            MiniWASConfiguration readObj = objectMapper.readValue(jsonConfiguration, MiniWASConfiguration.class);
//            MiniWASConfiguration readObj = objectMapper.readValue(jsonConfiguration, MiniWASConfiguration.class);
//            System.out.println(readObj.getClasspath());
//            System.out.println(readObj.getStaticDir());

            /*
            json -> 파일
            파일 -> POJO
             */
            File file = new File("sample.json");
            objectMapper.writeValue(file, miniWASConfiguration);
            MiniWASConfiguration fileToObj = objectMapper.readValue(file, MiniWASConfiguration.class);
            System.out.println(fileToObj.getClasspath());
            System.out.println(fileToObj.getStaticDir());
//            objectMapper.writeValue(new File("sample.json"), jsonConfiguration);
//            MiniWASConfiguration fileToObj = objectMapper.readValue(jsonConfiguration, MiniWASConfiguration.class);
//            System.out.println(fileToObj.getClasspath());
//            System.out.println(fileToObj.getStaticDir());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
