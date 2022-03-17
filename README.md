# Test cases covered

#### [1] Check navigation from home page to login page

1. Open Linkedin "Home" page

> "Join now" and "Sign Up" buttons are expected to be displayed.

2. Click the "Sign Up" button

> Linkedin "Login" page is being opened with login form displayed.
---

#### [2] Check error messages appear on attempt to login with unfilled credentials

1. Open Linkedin "Login" page

> Login form with unfilled email, password fields and "Submit" button should be visible.

2. Click "Submit" button

> Error message for email field appears, stating that email field cannot be empty.
> No error message for password field presented.

3. Type a valid email to the username field
4. Click "Submit" button

> Error message for password field appears, stating that password field cannot be empty.
> No error message for email field presented.
---

#### [3] Check user is redirected to the checkpoint page after login with valid credentials

1. Open Linkedin "Home" page

> Login form should be displayed on the page.

2. Fill in valid email and password of the already registered user
3. Click "Submit" button

> User is redirected to the checkpoint page.
---

#### [4] Check joining via "Main" page sign-up form

1. Open Linkedin "Main" page

> Join form with "Phone or Email", "Password" fields and "Agree & Join" button is displayed.

2. Fill in "Phone or Email" and "Password" fields with valid email and password
3. Click "Agree & Join" button

> "First name", "Last name" fields and "Continue" button appear in the sign-up form.

4. Fill in "First name" and "Last name" fields with valid data
5. Click "Continue" button

> "Challenge" dialog appears.
---

#### [5] Check Google auth window appears on attempt to join with Google account

1. Open Linkedin "Main" page

> Join form with "Join with Google" button is displayed.

2. Click "Join with Google" button

> Separate window with "Google Accounts" is opened.
---

# Tools and libraries used:

* Selenide - UI Automation library
* JUnit 5 - Test runner
* Assertj - Assertions library
* Allure - test reporting tools
* Faker - test data generation library

# Prerequisites for running tests

* Java 1.8
* Maven 3.5+
* Allure CLI 2.13+ (not required, but needed to generate and open allure reports)
* Selenium supported browser installed (the latest versions of the Chrome or Firefox is recommended)

# How to run tests

One can use the following command executed from the project root to run tests with default configuration:

```console
mvn clean test
```

Options available:

* `-Dbrowser` (e.g. -Dbrowser=firefox) to specify browser, defaults to chrome. Supported browsers: chrome, firefox,
  edge, opera.
* `-DdriverVersion` to specify desired webdriver version, defaults to the latest available for the chosen browser.
* `-DpropFile` to specify config.properties file from the `main/resources` directory to be used, defaults to '
  default-config'

So to run tests in firefox using gecko driver 0.30.0 with config from the default-config.properties file activated one
need to use the following command:

```console
mvn clean test -Dbrowser=firefox -DdriverVersion="0.30.0" -DpropFile=default-config
```

### Allure

Allure results are generated automatically during tests execution and stored in the target/allure-results folder. One
can open the resulting report using the following command:

```console
allure serve target/allure-results
```