import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import page_objects.MainPage;
import page_objects.SearchPage;
import util.PropertiesParser;

import java.util.HashMap;
import java.util.Map;

public class SteamTesting {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        PropertiesParser localization = new PropertiesParser();
        ChromeDriverManager.getInstance().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("intl.accept_languages", localization.localizationParse());
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(chromeOptions);
    }

    @Test(dataProvider = "test_game_data")
    public void test(String game, String gameAmount) {
        driver.get("https://store.steampowered.com/");
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.openPage());
        mainPage.searchGame(game);
        SearchPage searchPage = new SearchPage(driver);
        Assert.assertTrue(searchPage.searchResultsPageIsOpen());
        Assert.assertTrue(searchPage.listOfFoundGamesIsNotEmpty());
        searchPage.sortGamesInDescendingOrderOfPrice();
        Assert.assertTrue(searchPage.gamesAreSortedCorrectly(gameAmount));
    }

    @DataProvider(name = "test_game_data")
    private Object[][] testGameData() {
        PropertiesParser inputData = new PropertiesParser();
        Object[][] gameData = new Object[2][2];
        gameData[0][0] = inputData.inputDataParse("game1");
        gameData[0][1] = inputData.inputDataParse("game_amount1");
        gameData[1][0] = inputData.inputDataParse("game2");
        gameData[1][1] = inputData.inputDataParse("game_amount2");
        return gameData;
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
