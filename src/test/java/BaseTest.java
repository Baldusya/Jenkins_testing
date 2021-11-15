import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.logging.Logger;

public class BaseTest {
    protected Logger logger = AqualityServices.getLogger();
    protected ApiApplicationRequest request = new ApiApplicationRequest();
}
