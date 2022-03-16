package utils;

import java.io.IOException;
import java.util.Properties;

public class Config {

    private static final String propertiesFileName = System.getProperty("propFile", "default-config") + ".properties";
    private static final Properties properties = new Properties();

    private static final String browser = System.getProperty("browser", "firefox");

    private static final String baseUrl;
    private static final String email;
    private static final String password;
    private static final String username;

    static {
        loadProps();
        baseUrl = properties.getProperty("base.url");
        email = properties.getProperty("email");
        password = properties.getProperty("password");
        username = properties.getProperty("test.username");
    }

    private static void loadProps() {
        try {
            properties.load(Config.class.getClassLoader().getResourceAsStream(propertiesFileName));
        } catch (IOException e) {
            throw new IllegalStateException("Unable to load properties file " + propertiesFileName);
        }
    }

    public static String getBrowser() {
        return browser;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }

    public static String getUsername() {
        return username;
    }
}
