package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import utils.Config;

public abstract class BaseTest {
    static {
        Configuration.browser = Config.getBrowser();
        Configuration.startMaximized = true;
        Configuration.baseUrl = Config.getBaseUrl();
    }

    @AfterEach
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}