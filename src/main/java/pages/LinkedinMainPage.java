package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LinkedinMainPage {

    private final SelenideElement joinFormSection = $x("//section[contains(@class, 'join-form__form-body')]");
    private final SelenideElement phoneOrEmailInput = joinFormSection.$x("//input[@id='email-or-phone']");
    private final SelenideElement firstNameInput = joinFormSection.$x("//input[@id='first-name']");
    private final SelenideElement lastNameInput = joinFormSection.$x("//input[@id='last-name']");
    private final SelenideElement passwordInput = joinFormSection.$x("//input[@id='password']");
    private final SelenideElement agreeAndJoinButton = joinFormSection.$x("//button[@id='join-form-submit']");
    private final SelenideElement continueButton = joinFormSection.$x("//button[@data-tracking-control-name='homepage-basic_join-form-submit']");
    private final SelenideElement joinWithGoogleButton = joinFormSection.$x("//button[@data-tracking-control-name='homepage-basic_join-form-join-with-google']");
    private final SelenideElement challengeDialog = $x("//section[@class='challenge-dialog'][@role='dialog']");


    @Step("Open Linkedin \"Main\" page")
    public LinkedinMainPage open() {
        Selenide.open("/");
        return this;
    }

    @Step("Check \"Join\" form is visible")
    public LinkedinMainPage checkJoinFormVisible() {
        joinFormSection.shouldBe(Condition.visible);
        return this;
    }

    @Step("Check \"Phone or Email\" input is visible")
    public LinkedinMainPage checkPhoneOrEmailInputVisible() {
        phoneOrEmailInput.shouldBe(Condition.visible);
        return this;
    }

    @Step("Send keys \"{phoneOrEmail}\" to \"Phone or Email\" input")
    public LinkedinMainPage sendKeysToPhoneOrEmailInput(String phoneOrEmail) {
        phoneOrEmailInput.sendKeys(phoneOrEmail);
        return this;
    }

    @Step("Send keys \"{password}\" to \"Password\" input")
    public LinkedinMainPage sendKeysToPasswordInput(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Check \"Password\" input is visible")
    public LinkedinMainPage checkPasswordInputVisible() {
        passwordInput.shouldBe(Condition.visible);
        return this;
    }

    @Step("Check \"Agree & Join\" button is visible")
    public LinkedinMainPage checkAgreeAndJoinButtonVisible() {
        agreeAndJoinButton.shouldBe(Condition.visible);
        return this;
    }

    @Step("Click \"Agree & Join\" button")
    public LinkedinMainPage clickAgreeAndJoinButton() {
        agreeAndJoinButton.click();
        return this;
    }

    @Step("Check \"First name\" input is visible")
    public LinkedinMainPage checkFirstNameInputVisible() {
        firstNameInput.shouldBe(Condition.visible);
        return this;
    }

    @Step("Check \"Last name\" input is visible")
    public LinkedinMainPage checkLastNameInputVisible() {
        firstNameInput.shouldBe(Condition.visible);
        return this;
    }

    @Step("Send keys \"{firstName}\" to \"First name\" input")
    public LinkedinMainPage sendKeysToFirstNameInput(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    @Step("Send keys \"{lastName}\" to \"Last name\" input")
    public LinkedinMainPage sendKeysToLastNameInput(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    @Step("Check \"Continue\" button is visible")
    public LinkedinMainPage checkContinueButtonIsVisible() {
        continueButton.shouldBe(Condition.visible);
        return this;
    }

    @Step("Check \"Join with Google\" button is visible")
    public LinkedinMainPage checkJoinWithGoogleButtonIsVisible() {
        joinWithGoogleButton.shouldBe(Condition.visible);
        return this;
    }

    @Step("Click \"Join with Google\" button")
    public LinkedinMainPage clickJoinWithGoogleButton() {
        joinWithGoogleButton.click();
        return this;
    }

    @Step("Click \"Continue\" button")
    public LinkedinMainPage clickContinueButton() {
        continueButton.click();
        return this;
    }

    @Step("Check \"Challenge\" dialog visible")
    public LinkedinMainPage checkChallengeDialogVisible() {
        challengeDialog.shouldBe(Condition.visible);
        return this;
    }
}
