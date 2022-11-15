package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.client.UserClient;
import site.nomoreparties.stellarburgers.pages.LoginPage;
import site.nomoreparties.stellarburgers.pages.RegisterPage;
import site.nomoreparties.stellarburgers.pojo.UserRequest;
import site.nomoreparties.stellarburgers.valuegenerator.UserDataGenerator;

import static com.codeborne.selenide.Selenide.open;
import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static site.nomoreparties.stellarburgers.constant.Urls.URL_REGISTER_PAGE;

public class RegisterNewUserTest extends BaseUiTest {
    private UserDataGenerator userDataGenerator;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private String userEmail;
    private String userPassword;
    private UserClient userClient;
    private UserRequest userRequest;
    private String token;

    @Before
    public void openPage() {
        open(URL_REGISTER_PAGE);
        userClient = new UserClient();
        userRequest = new UserRequest();
    }

    @After
    public void clearBrowserStorage() {
        userRequest.setEmail(userEmail);
        userRequest.setPassword(userPassword);
        token = userClient.userLogin(userRequest)
                .extract()
                .path("accessToken");
        if (token != null) {
            userClient.deleteUser(token)
                    .assertThat()
                    .statusCode(SC_ACCEPTED)
                    .body("success", equalTo(true));

        }
        Selenide.clearBrowserLocalStorage();
    }


    @Test
    @DisplayName("Регистрация пользователя")
    @Description("Все параметры корректны. Успешная регистрация")
    public void userShouldBeRegisterTest() {
        registerPage = new RegisterPage();
        loginPage = new LoginPage();
        userDataGenerator = new UserDataGenerator();
        userEmail = userDataGenerator.getRandomEmail(5);
        userPassword = userDataGenerator.getPassword(6);
        registerPage.registerNewUser(
                userDataGenerator.getRandomName(5),
                userEmail,
                userPassword);
        System.out.println(Selenide.localStorage().getItem("token"));
        assertEquals("Вход", loginPage.getLoginTitleText());
    }

    @Test
    @DisplayName("Регистрация пользователя")
    @Description("Длина пароля менше допустимой длины. Ошибка регистрации")
    public void shouldBeInvalidPasswordMessageTest() {
        registerPage = new RegisterPage();
        userDataGenerator = new UserDataGenerator();
        userEmail = userDataGenerator.getRandomEmail(5);
        userPassword = userDataGenerator.getPassword(5);
        registerPage.registerNewUser(
                userDataGenerator.getRandomName(5),
                userEmail,
                userPassword);
        assertEquals("Некорректный пароль", registerPage.getInvalidPasswordMessage());

    }
}
