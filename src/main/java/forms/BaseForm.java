package forms;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class BaseForm extends Form {

    protected BaseForm(By locator, String name) {
        super(locator, name);
    }
}
