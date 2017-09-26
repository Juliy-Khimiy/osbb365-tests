package Page;

import Driver.Chrome;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Admin on 03.04.2017.
 */
public class LogOut {
    private Chrome driver;
    @FindBy (xpath = "/html/body/md-content/md-content/div/md-whiteframe/div/button/span")
    public WebElement exit;
}
