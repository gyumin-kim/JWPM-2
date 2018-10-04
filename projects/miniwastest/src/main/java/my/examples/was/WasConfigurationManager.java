package my.examples.was;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class WasConfigurationManager {
    private ObjectMapper objectMapper;

    // 2) 자기 자신을 참조하는 private static 변수 생성
    private static WasConfigurationManager instance = new WasConfigurationManager();

    // 1) private한 생성자
    private WasConfigurationManager() {
        objectMapper = new ObjectMapper();
    }

    // 3) public static한 메소드 (instance를 리턴)
    public static WasConfigurationManager getInstance() {
        return instance;
    }

    // WasConfigurationManager wasConfigurationManager = new WasConfigurationManager() ==> 불가능
    // WasConfigurationManager wcm1 = WasConfigurationManager.getInstance();
    // WasConfigurationManager wcm2 = WasConfigurationManager.getInstance();
    // wcm1과 wcm2는 같은 곳을 가리킨다.

    // MiniWASConfiguration 객체를 file에 쓴다.
    public void saveMiniWASConfiguration(MiniWASConfiguration miniWASConfiguration, String fileName) {
        try {
            objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(fileName), miniWASConfiguration);
        } catch (Exception ex) {}
    }

    // file의 값을 담은 MiniWASConfiguration 객체를 생성한다.
    public MiniWASConfiguration getMiniWasConfiguration(String fileName) {
        try {
            MiniWASConfiguration readObj = objectMapper.readValue(new File(fileName), MiniWASConfiguration.class);
            return readObj;
        } catch (Exception e) {
            return null;
        }
    }
}