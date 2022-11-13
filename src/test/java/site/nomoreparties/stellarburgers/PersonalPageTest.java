package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.LoginPage;
import site.nomoreparties.stellarburgers.pages.MainPage;
import site.nomoreparties.stellarburgers.pages.PersonalAccountPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class PersonalPageTest extends BaseUiTest {
    private MainPage mainPage;
    private PersonalAccountPage personalAccountPage;
    private LoginPage loginPage;


    @Before
    public void openPage() {
        open("https://stellarburgers.nomoreparties.site/");
        mainPage = new MainPage();
        loginPage = new LoginPage();
        personalAccountPage = new PersonalAccountPage();
        mainPage.clickSignInButton();
        assertEquals("Вход", loginPage.getLoginTitleText());
        loginPage.userLogin(email, password);
        assertEquals("Оформить заказ", personalAccountPage.getCheckoutButtonText());
    }

    @After
    public void clearBrowserStorage() {
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("Переход по клику на Личный кабин")
    public void loginByButtonPersonalAccountTest() {
        mainPage.clickPersonalPageButton();
        assertEquals("Профиль", personalAccountPage.getProfileLinkText());
    }

    @Test
    @DisplayName("Переход по клику на Конструктов")
    @Description("Переход на главную страницу по клику на Конструктор")
    public void clickOnCnstructorTest() {
        mainPage.clickPersonalPageButton();
        personalAccountPage.clickConstructorLink();
        assertEquals("Соберите бургер", mainPage.getTitleCollectBurger());
    }

    @Test
    @DisplayName("Переход по логотипу")
    @Description("Переход на главную страницу по клику на логотип")
    public void clickOnLogoFromPersonalAccountPageTest() {
        mainPage.clickPersonalPageButton();
        personalAccountPage.clickLogoStellarBurgers();
        assertEquals("Соберите бургер", mainPage.getTitleCollectBurger());
    }

    @Test
    @DisplayName("Выход из системы")
    @Description("Выход из системы после авторизации")
    public void userLogoutTest() {
        mainPage.clickPersonalPageButton();
        personalAccountPage.clickLogoutLink();
        assertEquals("Вход", loginPage.getLoginTitleText());

    }

}
