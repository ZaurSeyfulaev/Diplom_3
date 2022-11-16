package site.nomoreparties.stellarburgers.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    private SelenideElement loginButton = $(byXpath("//button[text()='Войти']"));
    private SelenideElement loginTitle = $(byText("Вход"));

    public String getLoginTitleText() {
        return loginTitle.getText();
    }

    public void userLogin(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
