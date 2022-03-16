package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LinkedinLoginPage {

    private final SelenideElement loginForm = $x("//form[@class='login__form']");
    private final SelenideElement usernameInput = loginForm.$x("//input[@id='username']");
    private final SelenideElement passwordInput = loginForm.$x("//input[@id='password']");
    private final SelenideElement submitButton = loginForm.$x("//button[@type='submit']");
    private final SelenideElement errorForUsernameMessage = loginForm.$x("//*[@id='error-for-username']");
    private final SelenideElement errorForPasswordMessage = loginForm.$x("//*[@id='error-for-password']");

    @Step("Open Linkedin \"Login\" page")
    public LinkedinLoginPage open() {
        Selenide.open("login");
        return this;
    }

    @Step("Check \"Login\" form is visible")
    public LinkedinLoginPage checkLoginFormVisible() {
        loginForm.shouldBe(Condition.visible);
        return this;
    }

    @Step("Check \"Username\" input is visible")
    public LinkedinLoginPage checkUsernameInputVisible() {
        usernameInput.shouldBe(Condition.visible);
        return this;
    }

    @Step("Send keys \"{username}\" to \"Username\" input")
    public LinkedinLoginPage sendKeysToUsernameInput(String username) {
        usernameInput.sendKeys(username);
        return this;
    }

    @Step("Send keys \"{password}\" to \"Password\" input")
    public LinkedinLoginPage sendKeysToPasswordInput(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Check \"Password\" input is visible")
    public LinkedinLoginPage checkPasswordInputVisible() {
        passwordInput.shouldBe(Condition.visible);
        return this;
    }

    @Step("Check \"Submit\" button is visible")
    public LinkedinLoginPage checkSubmitButtonVisible() {
        submitButton.shouldBe(Condition.visible);
        return this;
    }

    @Step("Click \"Submit\" button")
    public LinkedinLoginPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    @Step("Check error message for \"Username\" input is visible")
    public LinkedinLoginPage checkErrorForUsernameVisible() {
        errorForUsernameMessage.shouldBe(Condition.visible);
        return this;
    }

    @Step("Check error message for \"Username\" input is not visible")
    public LinkedinLoginPage checkErrorForUsernameNotVisible() {
        errorForUsernameMessage.shouldNotBe(Condition.visible);
        return this;
    }

    @Step("Check error message for \"Password\" input is visible")
    public LinkedinLoginPage checkErrorForPasswordVisible() {
        errorForPasswordMessage.shouldBe(Condition.visible);
        return this;
    }

    @Step("Check error message for \"Password\" input is not visible")
    public LinkedinLoginPage checkErrorForPasswordNotVisible() {
        errorForPasswordMessage.shouldNotBe(Condition.visible);
        return this;
    }
}
