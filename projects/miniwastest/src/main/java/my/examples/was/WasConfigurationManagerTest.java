package my.examples.was;

public class WasConfigurationManagerTest {
    public static void main(String[] args) {
        WasConfigurationManager wcm = WasConfigurationManager.getInstance();
        WasConfigurationManager wcm2 = WasConfigurationManager.getInstance();

        MiniWASConfiguration miniWasConfiguration =
                new MiniWASConfiguration();
        miniWasConfiguration.setStaticDir("/tmp/www");
        miniWasConfiguration.setClasspath(".");

        wcm.saveMiniWASConfiguration(miniWasConfiguration, "/tmp/m.json");
        MiniWASConfiguration mvc = wcm.getMiniWasConfiguration("/tmp/m.json");
        System.out.println(mvc.getStaticDir());
        System.out.println(mvc.getClasspath());
    }
}
