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

    @Test
    @DisplayName("Check user is redirected to checkpoint page after login with valid credentials")
    public void checkUserIsRedirectedToCheckpointPageAfterLoginWithValidCredentials() {
        linkedinLoginPage
                .open()
                .checkLoginFormVisible()
                .sendKeysToUsernameInput(Config.getEmail())
                .sendKeysToPasswordInput(Config.getPassword())
                .clickSubmitButton();

        checkCurrentUrlStartsWith(Config.getBaseUrl() + "checkpoint/challenge/");
    }

    @Test
    @DisplayName("Check joining via main page")
    public void checkJoiningViaMainPageTest() {
        linkedinMainPage
                .open()
                .checkJoinFormVisible()
                .checkPhoneOrEmailInputVisible()
                .checkPasswordInputVisible()
                .sendKeysToPhoneOrEmailInput(faker.phoneNumber().cellPhone())
                .sendKeysToPasswordInput(faker.internet().password())
                .checkAgreeAndJoinButtonVisible()
                .clickAgreeAndJoinButton()
                .checkFirstNameInputVisible()
                .checkLastNameInputVisible()
                .checkContinueButtonIsVisible()
                .sendKeysToFirstNameInput(faker.name().firstName())
                .sendKeysToLastNameInput(faker.name().lastName())
                .clickContinueButton()
                .checkChallengeDialogVisible();
    }

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
