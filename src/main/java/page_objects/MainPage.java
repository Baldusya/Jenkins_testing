package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class MainPage {
    protected WebDriver driver;
    private final By inputSearchBy = By.id("store_nav_search_term");
    private final By uniqueElementBy = By.className("home_page_gutter_giftcard");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean openPage() {
        return driver.findElement(uniqueElementBy).isEnabled()
                && Objects.equals(driver.getCurrentUrl(), "https://store.steampowered.com/");
    }

    public void searchGame(String game) {
        driver.findElement(inputSearchBy).click();
        driver.findElement(inputSearchBy).sendKeys(game);
        driver.findElement(inputSearchBy).sendKeys(Keys.ENTER);
    }
}
