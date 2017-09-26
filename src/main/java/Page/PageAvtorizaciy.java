package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Admin on 04.04.2017.
 */
public class PageAvtorizaciy {
    WebDriver driver;
    private Tabs tab;
    private PageRegistraciy pageReg;

    @FindBy(xpath ="//a[contains(@class, 'md-button md-ink-ripple')][last()-2]")
    public WebElement avtorizaciy;

    @FindBy(name = "email")
    public WebElement login;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(id = "login-button")
    public WebElement  button;

    @FindBy(className = "toast-message")//div[contains(@class, 'toast-message')]
    public WebElement  msg;

    @FindBy(xpath ="//button[contains(@class, 'toast-close-button ng-scope')]")
    public WebElement close_msg;

    //конструктор класса для передачи драйвера селениума
    public PageAvtorizaciy(WebDriver b) {
        this.driver = b;
    }

    public void avtoriz(){
        tab = PageFactory.initElements(driver, Tabs.class);
        pageReg = PageFactory.initElements(driver, PageRegistraciy.class);
        pageReg.Reg();
        //avtorizaciy.click();
        //tab.tab(1);
        login.sendKeys("autotestosbb@gmail.com");
        password.sendKeys("111111");
        button.click();
    }

    public String getMessage(){
        return msg.getText();
    }

}
