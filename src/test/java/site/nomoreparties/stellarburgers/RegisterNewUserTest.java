package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.LoginPage;
import site.nomoreparties.stellarburgers.pages.RegisterPage;
import site.nomoreparties.stellarburgers.valuegenerator.UserDataGenerator;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class RegisterNewUserTest extends BaseUiTest {
    private UserDataGenerator userDataGenerator;
    private RegisterPage registerPage;
    private LoginPage loginPage;

    @Before
    public void openPage() {
        open("https://stellarburgers.nomoreparties.site/register");
    }

    @After
    public void clearBrowserStorage() {
        Selenide.clearBrowserLocalStorage();
    }


    @Test
    @DisplayName("Регистрация пользователя")
    @Description("Все параметры корректны. Успешная регистрация")
    public void userShouldBeRegisterTest() {
        registerPage = new RegisterPage();
        loginPage = new LoginPage();
        userDataGenerator = new UserDataGenerator();
        registerPage.registerNewUser(
                userDataGenerator.getRandomName(5),
                userDataGenerator.getRandomEmail(5),
                userDataGenerator.getPassword(6));
        assertEquals("Вход", loginPage.getLoginTitleText());
    }

    @Test
    @DisplayName("Регистрация пользователя")
    @Description("Длина пароля менше допустимой длины. Ошибка регистрации")
    public void shouldBeInvalidPasswordMessageTest() {
        registerPage = new RegisterPage();
        userDataGenerator = new UserDataGenerator();
        registerPage.registerNewUser(
                userDataGenerator.getRandomName(5),
                userDataGenerator.getRandomEmail(5),
                userDataGenerator.getPassword(5));
        assertEquals("Некорректный пароль", registerPage.getInvalidPasswordMessage());

    }
}
