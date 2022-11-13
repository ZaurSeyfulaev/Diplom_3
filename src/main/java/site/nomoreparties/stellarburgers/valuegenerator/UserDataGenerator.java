package site.nomoreparties.stellarburgers.valuegenerator;

import org.apache.commons.lang3.RandomStringUtils;

public class UserDataGenerator {


    public String getRandomName(int characterCount) {
        return RandomStringUtils.randomAlphabetic(characterCount)
                .toLowerCase();
    }

    public String getRandomEmail(int characterCount) {
        return String.format("%s@yandex.ru", RandomStringUtils.randomAlphabetic(characterCount))
                .toLowerCase();
    }

    public String getPassword(int characterCount) {
        return RandomStringUtils.randomAlphabetic(characterCount);
    }
}