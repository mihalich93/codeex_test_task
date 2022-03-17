package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import utils.Config;

public abstract class BaseTest {

    protected static final Faker faker = new Faker();

    static {
        Config.configureDriverManager();
        Configuration.browser = Config.getBrowser();
        Configuration.baseUrl = Config.getBaseUrl();
        Configuration.startMaximized = true;
    }

    @AfterEach
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
