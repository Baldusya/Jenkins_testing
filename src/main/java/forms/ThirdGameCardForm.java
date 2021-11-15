package forms;

import org.openqa.selenium.By;

public class ThirdGameCardForm extends BaseForm {
    private static final String CARD_LOC = "personal-details__form-table";

    public ThirdGameCardForm() {
        super(By.className(CARD_LOC), "thirdCard");
    }

    public Boolean cardIsDisplayed() {
        return this.state().isDisplayed();
    }

}
