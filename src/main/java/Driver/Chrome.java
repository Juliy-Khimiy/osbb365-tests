package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
/**
 * Created by Admin on 27.03.2017.
 */
public class Chrome {
    public WebDriver driver;

    public void setDriver() {
        //this.driver = driver;
    System.setProperty("webdriver.chrome.driver", "c:\\Program Files (x86)\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://192.168.1.65:3000/#/");
    //return  driver;
}

//переключение между вкладками
/*public void tab(int num_tab) {
    ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
    driver.switchTo().window(tabs2.get(num_tab).toString());
    //driver.switchTo().window(tabs2.get(0).toString());
    //driver.close();
    //driver.switchTo().window(tabs2.get(1).toString());
}*/
}
