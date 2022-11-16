package site.nomoreparties.stellarburgers.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {

    private SelenideElement personalPageButton = $(byText("Личный Кабинет"));
    private SelenideElement signInButton = $(byXpath(".//button[text() = 'Войти в аккаунт'] "));
    private SelenideElement titleCollectBurger = $(byText("Соберите бургер"));

    private SelenideElement bunMenuSection = $(byXpath("//span[text()='Булки']"));
    private SelenideElement saucesMenuSection = $(byXpath("//span[text()='Соусы']"));
    private SelenideElement fillingsMenuSection = $(byXpath("//span[text()='Начинки']"));

    private SelenideElement selectedBunsSection = $(byXpath("//div[contains(@class, 'tab_tab_type_current__2BEPc')]/span[text()='Булки']"));
    private SelenideElement selectedSaucesSection = $(byXpath("//div[contains(@class, 'tab_tab_type_current__2BEPc')]/span[text()='Соусы']"));
    ;
    private SelenideElement selectedFillingsSection = $(byXpath("//div[contains(@class, 'tab_tab_type_current__2BEPc')]/span[text()='Начинки']"));
    ;


    public void clickPersonalPageButton() {
        personalPageButton.click();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public String getTitleCollectBurger() {
        return titleCollectBurger.getText();
    }

    public void clickBunMenuSection() {
        bunMenuSection.click();
    }

    public void clickSaucesMenuSection() {
        saucesMenuSection.click();
    }

    public void clickFillingsMenuSection() {
        fillingsMenuSection.click();
    }

    public boolean checkSelectedButSection() {
        return selectedBunsSection.isDisplayed();
    }

    public boolean checkSelectedSaucesSection() {
        return selectedSaucesSection.isDisplayed();
    }

    public boolean checkSelectedFillingSection() {
        return selectedFillingsSection.isDisplayed();
    }
}
