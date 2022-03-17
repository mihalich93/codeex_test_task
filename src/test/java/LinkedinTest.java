import annotations.TestId;
import base.BaseTest;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.LinkedinHomePage;
import pages.LinkedinLoginPage;
import pages.LinkedinMainPage;
import utils.Config;

import static utils.CommonActions.*;

@Execution(ExecutionMode.CONCURRENT)
@Story("Test Task For Codeex")
public class LinkedinTest extends BaseTest {

    private final LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage();
    private final LinkedinHomePage linkedinHomePage = new LinkedinHomePage();
    private final LinkedinMainPage linkedinMainPage = new LinkedinMainPage();

    @TestId("1")
    @Test
    @DisplayName("Check navigation from home page to login page")
    public void checkNavigationToLoginPageFromHomePageTest() {
        linkedinHomePage
                .open()
                .checkSignInButtonVisible()
                .checkSignUpButtonVisible()
                .clickSignInButton();
        linkedinLoginPage
                .checkLoginFormVisible();
    }

    @TestId("2")
    @Test
    @DisplayName("Check error messages appear on attempt to login with unfilled credentials")
    public void checkErrorMessagesAppearOnAttemptToLoginWithUnfilledCredentialsTest() {
        linkedinLoginPage
                .open()
                .checkLoginFormVisible()
                .checkUsernameInputVisible()
                .checkPasswordInputVisible()
                .checkSubmitButtonVisible()
                .checkErrorForUsernameNotVisible()
                .checkErrorForPasswordNotVisible()
                .clickSubmitButton()
                .checkErrorForUsernameVisible()
                .checkErrorForPasswordNotVisible()
                .sendKeysToUsernameInput(faker.internet().emailAddress())
                .clickSubmitButton()
                .checkErrorForUsernameNotVisible()
                .checkErrorForPasswordVisible();
    }

    @TestId("3")
    @Test
    @DisplayName("Check user is redirected to checkpoint page after login with valid credentials")
    public void checkUserIsRedirectedToCheckpointPageAfterLoginWithValidCredentials() {
        linkedinLoginPage
                .open()
                .checkLoginFormVisible()
                .sendKeysToUsernameInput(Config.getEmail())
                .sendKeysToPasswordInput(Config.getPassword())
                .clickSubmitButton();

        checkCurrentUrlStartsWith(Config.getBaseUrl() + "checkpoint/");
    }

    @TestId("4")
    @Test
    @DisplayName("Check joining via main page sign up form")
    public void checkJoiningViaMainPageSignUpFormTest() {
        linkedinMainPage
                .open()
                .checkJoinFormVisible()
                .checkPhoneOrEmailInputVisible()
                .checkPasswordInputVisible()
                .checkAgreeAndJoinButtonVisible()
                .sendKeysToPhoneOrEmailInput(faker.internet().emailAddress())
                .sendKeysToPasswordInput(faker.internet().password())
                .clickAgreeAndJoinButton()
                .checkFirstNameInputVisible()
                .checkLastNameInputVisible()
                .checkContinueButtonIsVisible()
                .sendKeysToFirstNameInput(faker.name().firstName())
                .sendKeysToLastNameInput(faker.name().lastName())
                .clickContinueButton()
                .checkChallengeDialogVisible();
    }

    @TestId("5")
    @Test
    @DisplayName("Check Google auth window appears on attempt to join with Google account")
    public void checkGoogleAuthWindowAppearsOnAttemptToJoinWithGoogleAccount() {
        linkedinMainPage
                .open();

        checkWindowsCountIs(1);

        linkedinMainPage
                .checkJoinFormVisible()
                .checkJoinWithGoogleButtonIsVisible()
                .clickJoinWithGoogleButton();

        checkWindowsCountIs(2);
        switchToTheLastOpenedWindow();
        checkCurrentUrlStartsWith("https://accounts.google.com/o/oauth2/auth");
    }
}
