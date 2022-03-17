package utils;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class Config {

    private static final String propertiesFileName = System.getProperty("propFile", "default-config") + ".properties";
    private static final Properties properties = new Properties();

    private static final String browser = System.getProperty("browser", "chrome");
    private static final String browserVersion = System.getProperty("browserVersion");

    private static final String baseUrl;
    private static final String email;
    private static final String password;

    static {
        loadProps();
        baseUrl = properties.getProperty("base.url");
        email = properties.getProperty("email");
        password = properties.getProperty("password");
    }

    public static void configureDriverManager() {
        validateBrowserParameterValue(browser);
        WebDriverManager manager;
        switch (Browser.valueOf(browser.toUpperCase())) {
            case CHROME:
                manager = WebDriverManager.chromedriver();
                break;
            case FIREFOX:
                manager = WebDriverManager.firefoxdriver();
                break;
            case EDGE:
                manager = WebDriverManager.edgedriver();
                break;
            case OPERA:
                manager = WebDriverManager.operadriver();
                break;
            default:
                manager = WebDriverManager.chromedriver();
                break;
        }
        if (browserVersion != null) {
            manager.version(browserVersion);
        }

        manager.setup();
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

    private static void loadProps() {
        try {
            properties.load(Config.class.getClassLoader().getResourceAsStream(propertiesFileName));
        } catch (IOException e) {
            throw new IllegalStateException("Unable to load properties file " + propertiesFileName);
        }
    }

    private static void validateBrowserParameterValue(String browser) {
        boolean isBrowserSupported = Arrays.stream(Browser.values())
                .map(Browser::toString)
                .anyMatch(browser::equals);
        if (!isBrowserSupported) {
            throw new IllegalStateException(String.format("Desired browser type [%s] not supported. Supported browsers: %s", browser, Arrays.toString(Browser.values())));
        }
    }
}
