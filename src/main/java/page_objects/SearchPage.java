package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {
    protected WebDriver driver;
    private final By chooseHowToSortGames = By.id("sort_by_trigger");
    private final By sortGamesInDescendingOrder = By.id("Price_DESC");
    private final By numberOfResultsForTheGameRequest = By.xpath("//a[@data-gpnav='item']");
    private final By searchGameInResultPage = By.cssSelector("span.label:nth-child(1)");
    private final By listOfFoundedGames = By.xpath("//div[@data-price-final]");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean searchResultsPageIsOpen() {
        return driver.findElement(searchGameInResultPage).isDisplayed();
    }

    public boolean listOfFoundGamesIsNotEmpty() {
        return driver.findElements(numberOfResultsForTheGameRequest).size() > 1;
    }

    public void sortGamesInDescendingOrderOfPrice() {
        driver.findElement(chooseHowToSortGames).click();
        driver.findElement(sortGamesInDescendingOrder).click();
    }

    public boolean gamesAreSortedCorrectly(String amount) {
        boolean flag = true;
        List<WebElement> webElementList = driver.findElements(listOfFoundedGames);
        List<String> gameList = new ArrayList<>();
        for (WebElement element : webElementList) {
            gameList.add(element.getText());
        }
        for (String element : gameList) {
            if (element.equals("Free") || element.equals("Free To Play")) {
                gameList.remove(element);
                gameList.add("$0.00");
            }
        }
        int count = Integer.parseInt(amount);
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (gameList.get(i).compareTo(gameList.get(j)) < 0) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }
        }
        return flag;
    }
}
