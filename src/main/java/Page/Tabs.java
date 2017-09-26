package Page;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

/**
 * Created by Admin on 16.06.2017.
 */
public class Tabs {
    WebDriver driver;

    //конструктор класса для передачи драйвера селениума
    public Tabs(WebDriver b) {
        this.driver = b;
    }

    //переключение между вкладками
    public void tab(int num_tab) {
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(num_tab).toString());
    }

    //закрытие вкладки и переключение на другую вкладку
    public void tab_close(int num_tab_close, int num_tab) {
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(num_tab_close).toString());
        driver.close();
        driver.switchTo().window(tabs2.get(num_tab).toString());
    }
    //переход по адресу в активной вкладке
    public void goToTab(String goTo)
    { driver.navigate().to(goTo);}
}


