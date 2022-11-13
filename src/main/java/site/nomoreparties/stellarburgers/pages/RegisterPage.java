package site.nomoreparties.stellarburgers.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class RegisterPage extends BasePage {
    private SelenideElement registerButton = $(byText("Зарегистрироваться"));

    private SelenideElement invalidPasswordMessage = $(byText("Некорректный пароль"));

    private SelenideElement loginLink = $(byXpath(".//a[text()='Войти']"));

    public void clickergisterButton() {
        registerButton.click();
    }

    public void registerNewUser(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickergisterButton();
    }


    public String getInvalidPasswordMessage() {
        return invalidPasswordMessage.getText();
    }

    public void clickLoginLink() {
        loginLink.click();
    }
}
