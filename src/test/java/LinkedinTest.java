import base.BaseTest;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.LinkedinHomePage;
import pages.LinkedinLoginPage;
import utils.Config;

import static utils.Util.checkCurrentUrlStartsWith;

@Execution(ExecutionMode.CONCURRENT)
@Story("Test Task For Codeex")
public class LinkedinTest extends BaseTest {

    private final LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage();
    private final LinkedinHomePage linkedinHomePage = new LinkedinHomePage();

    @Test
    @DisplayName("Check navigation from home page to login page")
    public void navigationToLoginPageFromHomePageTest() {
        linkedinHomePage
                .open()
                .checkSignInButtonVisible()
                .checkSignUpButtonVisible()
                .clickSignInButton();
        linkedinLoginPage
                .checkLoginFormVisible();
    }

    @Test
    @DisplayName("Check attempt to login with unfilled credentials")
    public void attemptToLoginWithUnfilledCredentialsTest() {
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
                .sendKeysToUsernameInput(Config.getEmail())
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
}
