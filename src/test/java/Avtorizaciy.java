import Driver.Chrome;
import Page.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.testng.AssertJUnit.fail;

public class Avtorizaciy {
        private PageAvtorizaciy pageAvt_y;
        private LogOut logout;
        private Tabs tab;
        private Chrome driver;
        private PageRegistraciy pageReg;
        private ConnectDB cdb;
        private StringBuffer verificationErrors = new StringBuffer();
        @DataProvider (name = "testData1")
        public static Object[][] testData1() {
                return new Object[][] {
                        new Object[] {"autotestosbb@gmail.ru", "111111", "Користувач не знайдений."},
                        new Object[] {"autotestosbb@gmail.com", "Rfhyfdfk", "Помилка паролю."},
                };
        }
        @DataProvider (name = "testData2")
        public static Object[][] testData2() {
            return new Object[][]{
                    new Object[]{"autotestosbb@gmail.com", "111111", "http://192.168.1.65:3000/head#/osbb/new"}, //https://osbb365.com/head#/osbb/new
            };
        }
        @BeforeTest
        public void setUp() throws SQLException {
            driver = new Chrome();
            driver.setDriver();
            pageAvt_y = PageFactory.initElements(driver.driver, PageAvtorizaciy.class);
            logout = PageFactory.initElements(driver.driver, LogOut.class);
          //  tab = PageFactory.initElements(driver.driver, Tabs.class);
            pageReg = PageFactory.initElements(driver.driver, PageRegistraciy.class);
            cdb = new ConnectDB();
            pageReg.Reg();
           // pageAvt_y.avtorizaciy.click();
            //tab.tab(1);
        }
    @Test (dataProvider = "testData1")
    public void Login_negativ(String login, String password, String msg) {
           try {

            pageAvt_y.login.clear();
            pageAvt_y.login.sendKeys(login);

            pageAvt_y.password.clear();
            pageAvt_y.password.sendKeys(password);

            pageAvt_y.button.click();
            pageAvt_y.getMessage();
            pageAvt_y.close_msg.click();
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        //Assert.assertTrue("Нет сообщения о не правильном пароле или не тот текст", pageAvt_y.getMessage().equals(msg));
        Assert.assertTrue(pageAvt_y.getMessage().equals(msg));
           //assertTrue(pageAvt_y.getMessage().equals(msg));
    }
    @Test (dataProvider = "testData2")
    public void Login_positive(String login, String password, String url){
        try {
            pageAvt_y.login.clear();
            pageAvt_y.login.sendKeys(login);

            pageAvt_y.password.clear();
            pageAvt_y.password.sendKeys(password);

            pageAvt_y.button.click();
            logout.exit.getText();

        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        System.out.println(driver.driver.getCurrentUrl());
        Assert.assertTrue(driver.driver.getCurrentUrl().equals(url));
        System.out.println(logout.exit.getText().trim());
        Assert.assertTrue(logout.exit.getText().trim().equals("Вийти"));
    }
    @AfterTest
    public void tearDown() {
        cdb.executeUpdate("delete from users where login = 'autotestosbb@gmail.com'");
        driver.driver.quit();
        String verificationErrorString = verificationErrors.toString();
        System.out.println("1212="+verificationErrorString);
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
    }

