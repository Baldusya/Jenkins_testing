package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class DataGenerator {
    private final static String EMAIL = RandomStringUtils.randomAlphabetic(8);

    public static String getRandomEmail() {
        return EMAIL;
    }

    public static String generateRandomPassword() {
        Random random = new Random();
        String rusLetters = "абвгдеёжзийклмнопрстуфхцчъыьэюя";

        return RandomStringUtils.randomAlphabetic(7) + EMAIL.substring(7) +
                RandomStringUtils.randomNumeric(1) + rusLetters.toUpperCase().charAt(random.nextInt(rusLetters.length()));
    }

    public static String generateRandomDomainName() {
        return RandomStringUtils.randomAlphabetic(4);
    }
}
