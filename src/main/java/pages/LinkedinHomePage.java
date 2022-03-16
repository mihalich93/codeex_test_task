package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LinkedinHomePage {

    private final SelenideElement signInButton = $x("//*[@data-tracking-control-name='guest_homepage-basic_nav-header-signin']");
    private final SelenideElement signUpButton = $x("//*[@data-tracking-control-name='guest_homepage-basic_nav-header-join']");

    @Step("Open Linkedin \"Home\" page")
    public LinkedinHomePage open() {
        Selenide.open("home");
        return this;
    }

    @Step("Check \"Sign in\" button visible")
    public LinkedinHomePage checkSignInButtonVisible() {
        signInButton.shouldBe(Condition.visible);
        return this;
    }

    @Step("Check \"Sign in\" button visible")
    public LinkedinHomePage checkSignUpButtonVisible() {
        signUpButton.shouldBe(Condition.visible);
        return this;
    }

    @Step("Click \"Sign up\" button")
    public LinkedinLoginPage clickSignInButton() {
        signInButton.click();
        return new LinkedinLoginPage();
    }
}
