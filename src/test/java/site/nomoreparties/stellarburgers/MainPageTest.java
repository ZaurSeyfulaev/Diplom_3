package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.*;
import static site.nomoreparties.stellarburgers.constant.Urls.URL_MAIN_PAGE;

public class MainPageTest {
    private MainPage mainPage;

    @Before
    public void openPage() {
        open(URL_MAIN_PAGE);
    }

    @After
    public void refreshPage() {
        Selenide.refresh();
    }

    @Test
    @DisplayName("Выбор секции Булки")
    @Description("Проверка перехода к секции Булки при выборе")
    public void bunSelectedSectionShodBeDisplayedTest() {
        mainPage = new MainPage();
        mainPage.clickFillingsMenuSection();
        assertFalse(mainPage.checkSelectedButSection());
        mainPage.clickBunMenuSection();
        assertTrue(mainPage.checkSelectedButSection());
    }

    @Test
    @DisplayName("Выбор секции Соусы")
    @Description("Проверка перехода к секции Соусы при выборе")
    public void saucesSelectedSectionShodBeDisplayedTest() {
        mainPage = new MainPage();
        assertFalse(mainPage.checkSelectedSaucesSection());
        mainPage.clickSaucesMenuSection();
        assertTrue(mainPage.checkSelectedSaucesSection());
    }

    @Test
    @DisplayName("Выбор секции Начинки")
    @Description("Проверка перехода к секции Начинки при выборе")
    public void fillingSelectedSectionShodBeDisplayedTest() {
        mainPage = new MainPage();
        assertFalse(mainPage.checkSelectedFillingSection());
        mainPage.clickFillingsMenuSection();
        assertTrue(mainPage.checkSelectedFillingSection());
    }
}
