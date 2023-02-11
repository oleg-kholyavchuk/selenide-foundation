package config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig(){
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");
    }

    String url = readConfig().getString("url");
    Integer age = readConfig().getInt("age");
    String adminLogin = readConfig().getString("usersParams.admin.login");
    String demoPassword = readConfig().getString("usersParams.demo.password");
    Boolean isDemoAdmin = readConfig().getBoolean("usersParams.demo.isAdmin");
}
