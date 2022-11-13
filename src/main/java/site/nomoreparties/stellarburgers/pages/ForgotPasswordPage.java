package site.nomoreparties.stellarburgers.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage {
    private SelenideElement loginLink = $(byXpath(".//a[text()='Войти']"));

    public void clickLoginLink() {
        loginLink.click();
    }
}
