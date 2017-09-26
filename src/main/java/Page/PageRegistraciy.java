package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by Admin on 24.03.2017.
 */
public class PageRegistraciy {

    WebDriver driver;
    private Tabs tab;
    private StringBuffer verificationErrors = new StringBuffer();

    @FindBy (xpath = "//a[contains(@ui-sref, 'login') ]")
    public WebElement registraciy;

    @FindBy(xpath = "//input[@ng-model='login.UserData.RegisterData.email']")
    public WebElement login_for_registraciy;

    @FindBy(xpath = "//input[@ng-model='login.UserData.RegisterData.password']")
    public WebElement password_for_registraciy;

    @FindBy(xpath = "//input[@ng-model='login.UserData.RegisterData.passwordConfirm']")
    public WebElement passwordConfirm_for_registraciy;

    @FindBy(id = "register-button-step-2")
    public WebElement  registr_next;

    @FindBy(name = "role")
    public WebElement role;

    @FindBy(xpath = "//md-option[@value='head']")
    public WebElement  role_glava;

    @FindBy(xpath = "//md-option[@value='tenant']")
    public WebElement  role_jitel;

    @FindBy(name = "lastName")
    public WebElement lastName;

    @FindBy(name = "firstName")
    public WebElement firstName;

    @FindBy(name = "patronymic")
    public WebElement otchestvo;

    @FindBy(id = "register-tenant-back-twice")
    public WebElement  registr_back;

    @FindBy(id = "register-button-head")
    public WebElement  registr_for_glava;

    @FindBy( xpath = "//button[contains(@class, 'toast-close-button ng-scope')]")
    public WebElement close_msg;

    @FindBy( xpath ="//input[@autocomplete='username']")
    public WebElement lg_email;

    @FindBy( xpath ="//*[@id='identifierNext']")
    public WebElement next_lg_email;

    @FindBy( xpath ="//input[@autocomplete='current-password']")
    public WebElement ps_email;

    @FindBy( xpath ="//*[@id='passwordNext']")
    public WebElement next_ps_email;

    @FindBy( xpath ="//*[@id=':37']/span")
    public WebElement email;

    @FindBy( xpath ="//a[contains(@href, '192.168.1.65:3000')]")
    public WebElement active_acount;

    @FindBy( xpath ="//div[contains(@class, 'toast-message')]")
    public WebElement msg_reg;
    /*@FindBy(xpath ="/html/head/title")
    public WebElement title_page;
*/

    //конструктор класса для передачи драйвера селениума
    public PageRegistraciy(WebDriver d){
        this.driver = d;
    }
    public void Reg() {
        tab = PageFactory.initElements(driver, Tabs.class);
        registraciy.click();
        tab.tab(1);
        login_for_registraciy.sendKeys("autotestosbb@gmail.com");
        password_for_registraciy.sendKeys("111111");
        passwordConfirm_for_registraciy.sendKeys("111111");
        registr_next.click();
        try { Thread.sleep(1000); } catch (Error e) {
            verificationErrors.append(e.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        role.click();
        role_glava.click();
        lastName.sendKeys("Авто");
        firstName.sendKeys("Тест");
        otchestvo.sendKeys("ОСББ");
        registr_for_glava.click();
        //if (pageReg.msg_reg.isEnabled())
        Assert.assertTrue(msg_reg.getText().equals("На Вашу електронну поштову адресу надіслано інформацію для підтвердження Вашого облікового запису."));
        close_msg.click();							//На Вашу електронну поштову адресу надіслано інформацію для підтвердження Вашого облікового запису.
        tab.goToTab("https://accounts.google.com");
        lg_email.sendKeys("autotestosbb");
        try {Thread.sleep(1000); } catch (Error e) {
            verificationErrors.append(e.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        next_lg_email.click();
        ps_email.sendKeys("autotestosbb1");
        try {Thread.sleep(1000); } catch (Error e) {
            verificationErrors.append(e.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        next_ps_email.click();
        try {Thread.sleep(5000); } catch (Error e) {
            verificationErrors.append(e.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tab.goToTab("https://mail.google.com/mail/#inbox");
        email.click();
        active_acount.click();
        tab.tab(2);
        try {Thread.sleep(5000);  } catch (Error e) {
            verificationErrors.append(e.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //  System.out.println(driver.driver.getTitle()+"1");
        Assert.assertEquals("ОСББ·365",driver.getTitle());
   /* registraciy.click();
    login_for_registraciy.sendKeys("yul56709081@yandex.ru");
    password_for_registraciy.sendKeys("111111");
    passwordConfirm_for_registraciy.sendKeys("111111");
    registr_next.click();
    role.click();
    role_glava.click();
    lastName.sendKeys("hgkjuhluj");
    firstName.sendKeys("cghdfh");
    otchestvo.sendKeys("afaerq");
    registr_for_glava.click();*/
}



}
