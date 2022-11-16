package site.nomoreparties.stellarburgers.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PersonalAccountPage {

    private SelenideElement checkoutButton = $(byXpath(".//button[text()='Оформить заказ']"));
    private SelenideElement profileLink = $(byXpath("//a[text()='Профиль']"));
    private SelenideElement constructorLink = $(byXpath(".//p[text()='Конструктор']"));
    private SelenideElement logoStellarBurgers = $(byXpath("//div/a/*[name()='svg']"));
    private SelenideElement logoutLink = $(byXpath("//button[text()='Выход']"));

    public String getCheckoutButtonText() {
        return checkoutButton.getText();
    }


    public void clickConstructorLink() {
        constructorLink.click();
    }

    public void clickLogoStellarBurgers() {
        logoStellarBurgers.click();
    }

    public void clickLogoutLink() {
        logoutLink.click();
    }

    public String getProfileLinkText() {
        return profileLink.getText();
    }
}
