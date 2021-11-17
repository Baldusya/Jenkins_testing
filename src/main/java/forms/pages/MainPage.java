package forms.pages;

import aquality.selenium.elements.interfaces.IButton;
import forms.BaseForm;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {
    private static final String PAGE_LOC = "//p[contains(text(), 'Hi and welcome to User Inyerface')]";
    private final IButton btnNextPage = getElementFactory().getButton(By.cssSelector(".start__link"), "buttonNextPage");

    public MainPage() {
        super(By.xpath(PAGE_LOC), "heading");
    }

    public Boolean mainPageTextIsDisplayed() {
        return this.state().isDisplayed();
    }

    public void clickForNextPage() {
        btnNextPage.click();
    }
}
