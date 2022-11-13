package site.nomoreparties.stellarburgers.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {
    private String baseLokator = "//label[text()='%s']/following::input[1]";

    /*Поскольку поля для ввода текста имеют одинаковую структуру и отличаются олько лэйблами
    делаю один метод для обработки всех полей в зависимости от введеного лэйбла
      */
    public void pasteTextIntoField(String fieldName, String text) {
        SelenideElement field = $(byXpath(String.format(baseLokator, fieldName)));
        field.setValue(text);
    }

    /*
    Поскольку поля встречаются на разных страницах  вывожу их чтобы не дублировать
     */
    public void setName(String name) {
        pasteTextIntoField("Имя", name);
    }

    public void setEmail(String email) {
        pasteTextIntoField("Email", email);
    }

    public void setPassword(String password) {
        pasteTextIntoField("Пароль", password);
    }
}