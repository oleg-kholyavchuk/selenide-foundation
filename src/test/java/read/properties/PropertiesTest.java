package read.properties;

import config.ConfigProvider;
import objectpage.BasePage;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PropertiesTest extends BasePage {

    @Test
    public void readProperties() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));

        String urlFromSystem = System.getProperty("url");
        System.out.println(urlFromSystem);
    }

    @Test
    public void readFromConf(){
        String urlFromConfig = ConfigProvider.url;
        System.out.println("urlFromConfig = " + urlFromConfig);
        Boolean isDemoAdmin = ConfigProvider.isDemoAdmin;
        System.out.println("isDemoAdmin = " + isDemoAdmin);

        if(ConfigProvider.readConfig().getBoolean("usersParams.admin.isAdmin")){
            System.out.println("Is admin true");
        } else System.out.println("Is admin false");
    }
}
