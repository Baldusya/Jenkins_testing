package forms.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import forms.BaseForm;
import forms.FirstGameCardForm;
import forms.SecondGameCardForm;
import forms.ThirdGameCardForm;
import org.openqa.selenium.By;


public class GamePage extends BaseForm {
    private final IButton btnHideHelp = getElementFactory().getButton(By.cssSelector(".help-form__send-to-bottom-button"), "buttonHideHelp");
    private final ITextBox helpTextField = getElementFactory().getTextBox(By.className("help-form__text-area"), "helpTextField");
    private final IButton btnNotCookies = getElementFactory().getButton(By.cssSelector(".button--transparent"), "btnNotCookies");
    private final ITextBox txbCookiesText = getElementFactory().getTextBox(By.cssSelector(".cookies__message"), "txbCookiesText");
    private final ITextBox txbTimer = getElementFactory().getTextBox(By.cssSelector(".timer"), "timer");
    private static final String TIMER_TIME = "00:00:00";

    public GamePage() {
        super(By.cssSelector(".timer"), "timer");
    }

    public FirstGameCardForm getFirstForm() {
        return new FirstGameCardForm();
    }

    public SecondGameCardForm getSecondForm() {
        return new SecondGameCardForm();
    }

    public ThirdGameCardForm getThirdForm() {
        return new ThirdGameCardForm();
    }

    public void clickForHidingHelp() {
        btnHideHelp.click();
    }

    public Boolean helpIsHiding() {
        helpTextField.state().waitForNotDisplayed();
        return !helpTextField.state().isDisplayed();
    }

    public void clickByNoCookies() {
        btnNotCookies.click();
    }

    public Boolean cookiesIsHiding() {
        txbCookiesText.state().waitForNotDisplayed();
        return !txbCookiesText.state().isDisplayed();
    }

    public Boolean doesTheTimerStartFromZero() {
        return txbTimer.state().isDisplayed() && txbTimer.getText().equals(TIMER_TIME);
    }
}
