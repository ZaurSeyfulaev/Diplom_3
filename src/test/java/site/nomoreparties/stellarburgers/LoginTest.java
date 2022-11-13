package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.*;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseUiTest {
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private MainPage mainPage;
    private PersonalAccountPage personalAccountPage;
    private ForgotPasswordPage forgotPasswordPage;

    @Before
    public void openPage() {
        open("https://stellarburgers.nomoreparties.site/register");
        registerPage = new RegisterPage();
        loginPage = new LoginPage();
    }


    @After
    public void clearBrowserStorage() {
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    @DisplayName("Вход в систему")
    @Description("Вход в систему с использованием кнопки Войти в акаунт")
    public void loginUsingSignInButtonTest() {
        open("https://stellarburgers.nomoreparties.site");
        mainPage = new MainPage();
        personalAccountPage = new PersonalAccountPage();
        mainPage.clickSignInButton();
        assertEquals("Вход", loginPage.getLoginTitleText());
        loginPage.userLogin(email, password);
        assertEquals("Оформить заказ", personalAccountPage.getCheckoutButtonText());
    }

    @Test
    @DisplayName("Вход в систему")
    @Description("Вход в систему по кнопке Личный кабинет")
    public void loginUsingPersonalPageButtonTest() {
        open("https://stellarburgers.nomoreparties.site");
        mainPage = new MainPage();
        personalAccountPage = new PersonalAccountPage();
        mainPage.clickPersonalPageButton();
        assertEquals("Вход", loginPage.getLoginTitleText());
        loginPage.userLogin(email, password);
        assertEquals("Оформить заказ", personalAccountPage.getCheckoutButtonText());
    }

    @Test
    @DisplayName("Вход в систему")
    @Description("Вход в систему с использованием ссылки Вход на странице регистрации")
    public void loginUsingLoginLinkOnRegisterPageTest() {
        open("https://stellarburgers.nomoreparties.site/register");
        loginPage = new LoginPage();
        personalAccountPage = new PersonalAccountPage();
        registerPage.clickLoginLink();
        assertEquals("Вход", loginPage.getLoginTitleText());
        loginPage.userLogin(email, password);
        assertEquals("Оформить заказ", personalAccountPage.getCheckoutButtonText());
    }

    @Test
    @DisplayName("Вход в систему")
    @Description("Вход в систему со страницы восстановления пароля")
    public void loginUserfromPasswordRecoveyPageTest() {
        open("https://stellarburgers.nomoreparties.site/forgot-password");
        personalAccountPage = new PersonalAccountPage();
        forgotPasswordPage = new ForgotPasswordPage();
        forgotPasswordPage.clickLoginLink();
        assertEquals("Вход", loginPage.getLoginTitleText());
        loginPage.userLogin(email, password);
        assertEquals("Оформить заказ", personalAccountPage.getCheckoutButtonText());
    }


}
