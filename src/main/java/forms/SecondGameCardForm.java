package forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import org.openqa.selenium.By;
import utils.UploadImageUtility;

import java.util.List;

public class SecondGameCardForm extends BaseForm {
    private static final String CARD_LOC = "avatar-and-interests__form";
    private final IButton btnUploadImage = getElementFactory().getButton(By.className("avatar-and-interests__upload-button"), "btnUploadImage");
    private final IButton btnNext = getElementFactory().getButton(By.xpath("//button[text()='Next']"), "btnNext");
    private final ILabel unSelectAllLabel = getElementFactory().getLabel(By.xpath("//label[@for='interest_unselectall']"), "unselect All Label");
    private final List<ILabel> allInterestsLabel = AqualityServices.getElementFactory()
            .findElements(By.xpath("//label[contains(@for,'interest_')]"), ElementType.LABEL);

    public SecondGameCardForm() {
        super(By.className(CARD_LOC), "secondCard");
    }

    public Boolean cardIsDisplayed() {
        return this.state().isDisplayed();
    }

    public void uploadAndConfirmImage() {
        btnUploadImage.click();
        UploadImageUtility.uploadFile("image_for_download.jpg");
    }

    public void pickThreeRandomInterests() {
        unSelectAllLabel.state().waitForClickable();
        unSelectAllLabel.click();
        allInterestsLabel.removeIf(label -> label.getAttribute("for").equals("interest_selectall")
                || label.getAttribute("for").equals("interest_unselectall"));
        for (int i = 0; i < 3; i++) {
            int randomLabel = (int) (allInterestsLabel.size() * Math.random());
            allInterestsLabel.get(randomLabel).click();
            allInterestsLabel.remove(allInterestsLabel.get(randomLabel));
        }
    }

    public void clickNextBtn() {
        btnNext.click();
    }
}
