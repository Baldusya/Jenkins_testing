package forms;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;
import utils.DataGenerator;

import java.util.List;

public class FirstGameCardForm extends BaseForm {
    private static final String CARD_LOC = ".login-form__container";
    private final ITextBox txbPassword = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Choose Password']"), "txbPassword");
    private final ITextBox txbEmail = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Your email']"), "txbEmail");
    private final ITextBox txbDomain = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Domain']"), "txbDomain");
    private final IButton btnOtherDropdown = getElementFactory().getButton(By.cssSelector(".dropdown__opener"), "buttonOther");
    private final String btnsDomainXpath = "//div[contains(@class,'dropdown__list-item')]";
    private final IButton btnNext = getElementFactory().getButton(By.xpath("//a[contains(@class,'button--secondary')]"), "Next button");
    private final ICheckBox chbTerms = getElementFactory().getCheckBox(By.className("checkbox__box"), "checkboxTerms");


    public FirstGameCardForm() {
        super(By.cssSelector(CARD_LOC), "firstCard");
    }

    public Boolean cardIsDisplayed() {
        return this.state().isDisplayed();
    }

    public void setPassword(String password) {
        txbPassword.clearAndType(password);
    }

    public void setEmail() {
        txbEmail.clearAndType(DataGenerator.getRandomEmail());
    }

    public void setDomainFirstPart() {
        txbDomain.clearAndType(DataGenerator.generateRandomDomainName());
    }

    public void selectDomainSecondPart() {
        btnOtherDropdown.click();
        List<IButton> btnsSelectDomain = getElementFactory().findElements(By.xpath(btnsDomainXpath), ElementType.BUTTON);
        btnsSelectDomain.get((int) (btnsSelectDomain.size() * Math.random())).click();
    }

    public void clickBtnNext() {
        btnNext.click();
    }

    public void checkTerms() {
        chbTerms.check();
    }
}
