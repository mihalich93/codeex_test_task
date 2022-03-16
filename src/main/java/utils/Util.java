package utils;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;

public class Util {

    @Step("Check current page url starts with \"{prefix}\"")
    public static void checkCurrentUrlStartsWith(String prefix) {
        Assertions.assertThat(WebDriverRunner.url())
                .as("Url should start with %s", prefix)
                .startsWith(prefix);
    }
}
