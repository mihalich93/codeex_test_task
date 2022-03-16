package utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonActions {

    @Step("Check current page url starts with \"{prefix}\"")
    public static void checkCurrentUrlStartsWith(String prefix) {
        assertThat(WebDriverRunner.url())
                .as("Url should start with %s", prefix)
                .startsWith(prefix);
    }

    @Step("Check current windows count is {windowsCount}")
    public static void checkWindowsCountIs(int windowsCount) {
        assertThat(WebDriverRunner.getWebDriver().getWindowHandles())
                .as("Check current windows count is %d", windowsCount)
                .hasSize(windowsCount);
    }

    @Step("Switch to the last opened window")
    public static void switchToTheLastOpenedWindow() {
        Selenide.switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);
    }
}
