import Driver.Chrome;
import Page.ConnectDB;
import Page.PageAvtorizaciy;
import Page.PageRegistraciy;
import Page.Tabs;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLException;

/**
 * Created by Admin on 27.03.2017.
 */
public class Registraciy {
    private PageRegistraciy pageReg;
    private PageAvtorizaciy pageAvt_y;
    private Tabs tab;
    private ConnectDB cdb;
    private Chrome driver;
    private StringBuffer verificationErrors = new StringBuffer();
    @BeforeTest
    public void setUp() throws SQLException {
        driver = new Chrome();
        driver.setDriver();
        tab = PageFactory.initElements(driver.driver, Tabs.class);
        pageReg = PageFactory.initElements(driver.driver, PageRegistraciy.class);
        pageAvt_y = PageFactory.initElements(driver.driver, PageAvtorizaciy.class);
        cdb = new ConnectDB();
      //  cdb.executeQuery("SELECT * FROM users WHERE login = 'autotestosbb@gmail.com'");
    }

    @Test
    public void testReg () {
     pageReg.registraciy.click();
     tab.tab(1);
     pageReg.login_for_registraciy.sendKeys("autotestosbb@gmail.com");
     pageReg.password_for_registraciy.sendKeys("111111");
     pageReg.passwordConfirm_for_registraciy.sendKeys("111111");
     pageReg.registr_next.click();
        try { Thread.sleep(1000); } catch (Error e) {
            verificationErrors.append(e.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     pageReg.role.click();
     pageReg.role_glava.click();
     pageReg.lastName.sendKeys("Авто");
     pageReg.firstName.sendKeys("Тест");
     pageReg.otchestvo.sendKeys("ОСББ");
     pageReg.registr_for_glava.click();
     //if (pageReg.msg_reg.isEnabled())// чего упал? сообщение соответствует... я хз тут твоя логика...
     Assert.assertTrue(pageReg.msg_reg.getText().equals("На Вашу електронну поштову адресу надіслано інформацію для підтвердження Вашого облікового запису."));
     pageReg.close_msg.click();
     tab.goToTab("https://accounts.google.com");
     pageReg.lg_email.sendKeys("autotestosbb");
            try {Thread.sleep(1000); } catch (Error e) {
                verificationErrors.append(e.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
     pageReg.next_lg_email.click();
     pageReg.ps_email.sendKeys("autotestosbb1");
                try {Thread.sleep(1000); } catch (Error e) {
                    verificationErrors.append(e.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
     pageReg.next_ps_email.click();
                    try {Thread.sleep(5000); } catch (Error e) {
                        verificationErrors.append(e.toString());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
     tab.goToTab("https://mail.google.com/mail/#inbox");
     pageReg.email.click();
     pageReg.active_acount.click();
           tab.tab(2);
     try {Thread.sleep(5000);  } catch (Error e) {
           verificationErrors.append(e.toString());
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
      //  System.out.println(driver.driver.getTitle()+"1");
        Assert.assertEquals("ОСББ·365",driver.driver.getTitle());
          }
    @AfterTest
    public void tearDown() {
        cdb.executeUpdate("delete from users where login = 'autotestosbb@gmail.com'");
        driver.driver.quit();
        }
}
