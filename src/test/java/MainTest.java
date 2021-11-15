import forms.pages.GamePage;
import forms.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DataGenerator;


public class MainTest extends BaseTest {

    @Test
    public void gameTest() {
        logger.info("First test case");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.mainPageTextIsDisplayed(), "main page text is not displayed");
        mainPage.clickForNextPage();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.getFirstForm().cardIsDisplayed(), "first card is not displayed");
        gamePage.getFirstForm().setPassword(DataGenerator.generateRandomPassword());
        gamePage.getFirstForm().setEmail();
        gamePage.getFirstForm().setDomainFirstPart();
        gamePage.getFirstForm().selectDomainSecondPart();
        gamePage.getFirstForm().checkTerms();
        gamePage.getFirstForm().clickBtnNext();
        logger.info("Open second card");
        Assert.assertTrue(gamePage.getSecondForm().cardIsDisplayed(), "second card is not displayed");
        gamePage.getSecondForm().uploadAndConfirmImage();
        gamePage.getSecondForm().pickThreeRandomInterests();
        gamePage.getSecondForm().clickNextBtn();
        logger.info("Open third card");
        Assert.assertTrue(gamePage.getThirdForm().cardIsDisplayed(), "third card is not displayed");
    }

    @Test
    public void helpFormTest() {
        logger.info("Second test case");
        MainPage mainPage = new MainPage();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(mainPage.mainPageTextIsDisplayed(), "main page text is not displayed");
        mainPage.clickForNextPage();
        gamePage.clickForHidingHelp();
        Assert.assertTrue(gamePage.helpIsHiding(), "help is not hide");
    }

    @Test
    public void cookiesTest() {
        logger.info("Third test case");
        MainPage mainPage = new MainPage();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(mainPage.mainPageTextIsDisplayed(), "main page text is not displayed");
        mainPage.clickForNextPage();
        gamePage.clickByNoCookies();
        Assert.assertTrue(gamePage.cookiesIsHiding(), "cookies is not hide");
    }

    @Test
    public void timerTest() {
        logger.info("Fourth test case");
        MainPage mainPage = new MainPage();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(mainPage.mainPageTextIsDisplayed(), "main page text is not displayed");
        mainPage.clickForNextPage();
        Assert.assertTrue(gamePage.doesTheTimerStartFromZero(), "timer is not starting from zero");
    }
}

