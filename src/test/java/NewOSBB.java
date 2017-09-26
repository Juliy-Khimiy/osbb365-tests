import Driver.Chrome;
import Page.ConnectDB;
import Page.PageAvtorizaciy;
import Page.PageNewOSBB;
import Page.PageRegistraciy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLException;

/**
 * Created by Admin on 03.04.2017.
 */
public class NewOSBB {
    private PageAvtorizaciy pageAvt;
    private PageRegistraciy pageReg;
    private PageNewOSBB pageNewOsbb;
    private Chrome driver;
    private ConnectDB cdb;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest
    public void setUp() throws SQLException {
        driver = new Chrome();
        cdb = new ConnectDB();
        driver.setDriver();
        pageReg = PageFactory.initElements(driver.driver, PageRegistraciy.class);
        pageAvt = PageFactory.initElements(driver.driver, PageAvtorizaciy.class);
        pageNewOsbb = PageFactory.initElements(driver.driver, PageNewOSBB.class);
        //pageReg.Reg();
        pageAvt.avtoriz();
    }

    @Test
    public void newOsbb() {
        try {
            pageNewOsbb.osbbName.sendKeys("Тест");
            pageNewOsbb.oblast.click();
            pageNewOsbb.serch_oblast.click();
            Thread.sleep(5000);
            pageNewOsbb.city.click();
            pageNewOsbb.serch_City.click();
            Thread.sleep(5000);
            pageNewOsbb.street.click();
            pageNewOsbb.serch_Street.click();
            pageNewOsbb.house.sendKeys("1а");
            pageNewOsbb.period.sendKeys("Березень 2017");
            pageNewOsbb.pfone.sendKeys("(067) 886-4948");
            pageNewOsbb.next_page.click();
            Thread.sleep(3000);
            //  driver.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            pageNewOsbb.select_uslug.click();
            pageNewOsbb.usluga_musor.click();
            pageNewOsbb.add_uslug.click();
            pageNewOsbb.save.click();
            pageNewOsbb.clic_select_uslug_for_tarif.click();
            pageNewOsbb.select_uslug_for_tarif.click();
            pageNewOsbb.add_uslug_for_tarif.click();
            pageNewOsbb.add_tarif.sendKeys("1");
            pageNewOsbb.save_add_tarif.click();
            pageNewOsbb.next_page.click();
            pageNewOsbb.count_podezd.isSelected();
            pageNewOsbb.count_podezd.clear();
            pageNewOsbb.count_podezd.sendKeys("3");
            pageNewOsbb.editPod(1);
            pageNewOsbb.editPod(2);
            pageNewOsbb.editPod(3);
            pageNewOsbb.next_page.click();
            pageNewOsbb.import_param_kv.sendKeys("d:\\создание ОСББ.xlsx");
            pageNewOsbb.selectParam(1, "1");
            pageNewOsbb.selectParam(2, "2");
            pageNewOsbb.selectParam(3, "3");
            pageNewOsbb.selectParam(4, "4");
            pageNewOsbb.selectParam(6, "6");
            pageNewOsbb.selectParam(7, "7");
            pageNewOsbb.selectParam(8, "8");
            pageNewOsbb.selectParam(9, "9");
     /*   pageNewOsbb.checkBox_for_import_param(2);
           Thread.sleep(1000);
        pageNewOsbb.checkBox_for_import_param(1);
            Thread.sleep(1000);
        pageNewOsbb.checkBox_for_import_param(2);*/
            pageNewOsbb.submit_import.click();
            Thread.sleep(1000);
            pageNewOsbb.save_import.click();
            pageNewOsbb.import_param_flat();
            pageNewOsbb.next_page.click();
            pageNewOsbb.import_param_kv.sendKeys("d:\\создание ОСББ.xlsx");
            pageNewOsbb.submit_import_saldo.click();
            Thread.sleep(1000);
            pageNewOsbb.save_import_saldo.click();
            pageNewOsbb.create_build.click();
            //Assert.assertTrue(pageNewOsbb.check.getText().equals("№ квартири") );
        } catch (Error e) {
            verificationErrors.append(e.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() {
        //Assert.assertEquals("Тест Авто", driver.driver.getTitle());
        /* работает не так как хочу. хочу проверить создалось ли осбб то есть ожидаемый результат запроса айдиха осбб,
        которую я сравниваю ассертом с налом и так как она не налосвкая иду дальше, в противном случае падает тест
        System.out.println("msg"+cdb.executeQuery("select id from osbb where userId=(select id from users where login='autotestosbb@gmail.com')"));
        Assert.assertFalse(cdb.executeQuery("select id from osbb where userId=(select id from users where login='autotestosbb@gmail.com')"), "null");*/
        //Assert.assertTrue(pageAvt_y.getMessage().equals("Користувач із такою електронною адресою вже існує."));
        cdb.executeUpdate("delete from osbb where userId=(select id from users where login='autotestosbb@gmail.com')");
        cdb.executeUpdate("delete from users where login = 'autotestosbb@gmail.com'");
        driver.driver.quit();
    }
}
