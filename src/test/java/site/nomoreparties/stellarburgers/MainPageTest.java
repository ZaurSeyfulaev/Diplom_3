package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class MainPageTest {
    private MainPage mainPage;

    @Before
    public void openPage() {
        open("https://stellarburgers.nomoreparties.site");
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
        assertEquals(false, mainPage.checkSelectedButSection());
        mainPage.clickBunMenuSection();
        assertEquals(true, mainPage.checkSelectedButSection());
    }

    @Test
    @DisplayName("Выбор секции Соусы")
    @Description("Проверка перехода к секции Соусы при выборе")
    public void saucesSelectedSectionShodBeDisplayedTest() {
        mainPage = new MainPage();
        assertEquals(false, mainPage.checkSelectedSaucesSection());
        mainPage.clickSaucesMenuSection();
        assertEquals(true, mainPage.checkSelectedSaucesSection());
    }

    @Test
    @DisplayName("Выбор секции Начинки")
    @Description("Проверка перехода к секции Начинки при выборе")
    public void fillingSelectedSectionShodBeDisplayedTest() {
        mainPage = new MainPage();
        assertEquals(false, mainPage.checkSelectedFillingSection());
        mainPage.clickFillingsMenuSection();
        assertEquals(true, mainPage.checkSelectedFillingSection());
    }
}
