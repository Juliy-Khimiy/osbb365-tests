package Page;

import Driver.Chrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.*;
import java.util.List;
import java.io.FileWriter;
/**
 * Created by Admin on 04.04.2017.
 */
public class PageNewOSBB {
    private StringBuffer verificationErrors = new StringBuffer();
    private Chrome driver;

    //навигация
    @FindBy(xpath = "//button[contains(@class, 'md-primary md-raised md-button ng-scope md-ink-ripple')]")
    public WebElement next;

    @FindBy(xpath = "//button[contains(@ng-click, 'OsbbNew.selectedIndexTabsStepsRegister')]")
    public WebElement back;

    @FindBy(xpath = "//button[contains(@ng-click, 'OsbbNew.onNextStepButtonClickEvent')]")
    public WebElement next_page; //button[@class='md-button ng-scope md-ink-ripple'][2]

    //адрес
    @FindBy(name = "osbbName")
    public WebElement osbbName;

    @FindBy(name = "autocompleteRegion")
    public WebElement oblast;

    @FindBy(xpath = "//div[@class='md-virtual-repeat-offsetter']//li[@class='ng-scope'][3]")
    public WebElement serch_oblast;

    @FindBy(name = "autocompleteCity")
    public WebElement city;

    @FindBy(xpath = "//ul[@id='ul-8']/li[@class='ng-scope'][5]")
    public WebElement serch_City;

    @FindBy(name = "autocompleteStreet")
    public WebElement street;

    @FindBy(xpath = "//div[@class='md-virtual-repeat-offsetter']/ul[@id='ul-9']/li[@class='ng-scope'][2]")
    public WebElement serch_Street;

    @FindBy(name = "house")
    public WebElement house;

    @FindBy(className = "dx-texteditor-input")
    public WebElement period;

    @FindBy(xpath = "//input[@id='input_6']")
    public WebElement pfone;

    //услуги и тарифы
    @FindBy(xpath = "//md-select-value[@id='select_value_label_11']")
    public WebElement select_uslug;

    @FindBy(xpath = "//md-option[@id='select_option_17']")
    public WebElement usluga_musor;

    @FindBy(xpath = "//div/div[contains(@class, 'layout-align-space-between-center layout-row')]/button[contains(@class, 'md-icon-button')]")
    public WebElement add_uslug;

    @FindBy(xpath = "//tbody/tr[@class='dx-row dx-data-row dx-row-lines dx-edit-row dx-row-inserted']//a[@class='dx-link'][1]")
    public WebElement save;

    @FindBy(xpath = "//tbody/tr[@class='dx-row dx-data-row dx-row-lines dx-edit-row dx-row-inserted']//a[@class='dx-link'][2]")
    public WebElement cencel;

    @FindBy(xpath = "(//div[@class='dx-datagrid-content'])[1]//tr[1]/td[4]/a[1]")
    public WebElement change;

    @FindBy(xpath = "(//div[@class='dx-datagrid-content'])[1]//tr[1]/td[4]/a[2]")
    public WebElement delete;

    @FindBy(xpath = "//md-select[@ng-model= 'OsbbNew.selectedServiceOsbb']")
    public WebElement clic_select_uslug_for_tarif;

    @FindBy(xpath = "//md-select-menu[@class='_md']/md-content[@class='_md']/md-option[contains(@id,'select_option')][1]")
    public WebElement select_uslug_for_tarif;

    @FindBy(xpath = "//button[@id='osn-md-button-add-row-to-tariffs-grid']")
    public WebElement add_uslug_for_tarif;

    @FindBy(xpath = "//div[contains(@class, 'dx-texteditor dx-texteditor-empty dx-widget dx-numberbox')]/div[contains(@class, 'dx-texteditor-container')]/input[contains(@class, 'dx-texteditor-input')]")
    public WebElement add_tarif;

    @FindBy(xpath = "//td[contains(@class, 'dx-command-edit')]//md-icon[contains(@title, 'Зберегти')]")
    public WebElement save_add_tarif;

    //схема дома
    @FindBy(xpath = "//div[@class='md-toolbar-tools']/div[@class='ng-scope layout-align-center-center layout-row']//input[contains(@id,'input')]")
    public WebElement count_podezd;

    @FindBy(xpath = "//md-card[@class='osn-card ng-scope _md'][1]//button[@class='md-button md-ink-ripple']")
    public WebElement edit;

    @FindBy(xpath = "//md-card[@class='osn-card ng-scope _md']")
    public List<WebElement> listPod;

    @FindBy(xpath = "//md-dialog[contains(@id,'dialogContent')]//md-input-container[contains(@class,'md-input-')][1]/input[contains(@id,'input') and not(ancestor::div[contains(@style,'visibility: hidden')])]")
    public WebElement etaj;

    @FindBy(xpath = "//md-dialog[contains(@id,'dialogContent')]//md-input-container[contains(@class,'md-input-')][2]/input[contains(@id,'input') and not(ancestor::div[contains(@style,'visibility: hidden')])]")
    public WebElement kv;

    @FindBy(xpath = "//md-dialog[contains(@id,'dialogContent')]//button[contains(@class,'md-icon-button')and not(ancestor::div[contains(@style,'visibility: hidden')])]")
    public WebElement closedWindowsEditPodezd;

    //параметры квартир
    @FindBy(xpath = "//input[@class='dropify-event']")
    public WebElement import_param_kv;

    @FindBy(xpath = "//tr[1]//div[contains(@class,'align-space-between')]/md-menu[contains(@class,'md-menu')]/button[contains(@class,'md-button')]")
    public List<WebElement> list_param;

    @FindBy(xpath = "//div[contains(@class,'ng-scope')]/button[contains(@class,'primary')]")
    public WebElement submit_import;

    @FindBy(xpath ="//md-dialog-actions/button[contains(@class, 'md-primary md-button ng-scope md-ink-ripple')]")
    public WebElement submit_import_saldo;

    @FindBy(xpath = "//div[contains(@id,'menu_container')]/md-menu-content")
    public List<WebElement> list_;

    @FindBy(xpath = "//md-checkbox[contains(@class,'ng-valid')]/div[@class='md-label']/span[@class='ng-scope']")
    public WebElement check_name_first_row;

    @FindBy(xpath = "//tr[1]/td[@class='osn-column ng-scope'][*]/div[contains(@class,'layout-align')]/md-checkbox[contains(@class,'md-primary')]/div[@class='md-container md-ink-ripple']")
    public List<WebElement> list_checkBox_first_row;

    @FindBy(xpath = "//button [contains(@ng-click, 'onSaveChangesInAccountsGridButtonEvent')]")
    public  WebElement save_import;

    @FindBy(xpath = "//button [contains(@ng-click, 'onSaveChangesInAccountsBalancesGridButtonEvent')]")
    public  WebElement save_import_saldo;

    @FindBy(xpath = "//div[@class='ng-scope ng-isolate-scope']//div[contains(@class,'layout-align-end-center')]/button[contains(@class,'md-button')and not(ancestor::div[contains(@style,'visibility: hidden')])][2]")
    public  WebElement cencel_import;

    @FindBy(xpath = "//div[@class='dx-page-sizes']/div[contains(@class,'dx-page-size')]")
    public List<WebElement> list_count_row_for_page;

    @FindBy(xpath = "//div[@dx-data-grid='OsbbNew.UI.PersonalAccountsGrid']//div[@class='dx-pages']/div[contains(@class,'dx-page')]")
    public List<WebElement> list_namber_page_for_page_import;

    @FindBy(xpath = "//tr[contains(@class,'dx-data-row')][*]/td[@class='dx-command-edit']")
    public List<WebElement> list_button_delete_for_page_import;

    @FindBy(xpath = "//md-tab-content[@id='tab-content-3']//table[contains(@class, 'dx-datagrid-table dx-datagrid-table-fixed')]/tbody/tr[contains(@class, 'dx-row dx-header-row')]")
    public List<WebElement> futer_param_flat;

    @FindBy(xpath = "//md-card[contains(@class, 'osn-personal-accounts-card')]//div[contains(@class, 'dx-visibility-change-handler')]//div[contains(@class, 'dx-scrollable-customizable-scrollbars dx-scrollable-both dx-scrollable-simulated dx-visibility-change-handler')]//div[contains(@class, 'dx-datagrid-content')]/table[contains(@class, 'dx-datagrid-table dx-datagrid-table-fixed')]")
    public List<WebElement> list_import_param_flat;

    @FindBy(xpath = "//button[@ng-click = 'OsbbNew.onSubmitDataForCreateOsbbEvent()']")
    public  WebElement create_build;

    public void writeUsingFileWriter(String data) {
        File file = new File("D:/OSBB.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void appendUsingFileWriter(String filePath, String text) {
        File file = new File(filePath);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file,true);
            fr.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
        public void import_param_flat () {
        int i = 0;
        String filePath = ("D:/OSBB.txt");
        writeUsingFileWriter(futer_param_flat.listIterator().next().getText()+"\n");
        WebElement namber_page = list_namber_page_for_page_import.get(0);
    for (i=1; i <=list_namber_page_for_page_import.size(); i++)
        {
            appendUsingFileWriter(filePath, list_import_param_flat.listIterator().next().getText()+"\n");
            if (( list_namber_page_for_page_import.listIterator().hasNext()!= false) && (i <list_namber_page_for_page_import.size()))
            {
                namber_page = list_namber_page_for_page_import.get(i);
                namber_page.click();
            }
        }
    }
    public void checkBox_for_import_param (int namber_check_box) {
        WebElement check =  list_checkBox_first_row.get(namber_check_box);
        check.click();
        if (check.isSelected()!= false) {
            System.out.println(check.getText().trim() + "1");
            Assert.assertTrue(check.getText().trim().equals("№ Квартири"));
        } else {
           /**  System.out.println(check.getTagName()+"2");
            System.out.println(check.getAttribute("style")+"3");
            System.out.println(check.getAttribute( "value")+"4");
            */
        }
    }
    public void editPod(int numberPod) throws InterruptedException {
        WebElement item = listPod.get(numberPod - 1);
        item = item.findElement(By.xpath(".//button[@class='md-button md-ink-ripple']"));
        item.click();
        Thread.sleep(2000);
        etaj.click();
        etaj.clear();
        etaj.sendKeys("5");
        kv.click();
        kv.clear();
        kv.sendKeys("3");
        closedWindowsEditPodezd.click();
        Thread.sleep(1000);
    }
    public void selectParam(int param, String selectis) throws InterruptedException {
        WebElement temp = list_param.get(param-1);
        temp.click();
        Thread.sleep(1000);
        WebElement temp1 = list_.get(param-1);
        temp1 = temp1.findElement(By.xpath("//md-menu-item[@class='ng-scope']["+selectis+"]/button[contains(@class,'md-button')and not(ancestor::div[contains(@style,'display: none')])]"));
        Thread.sleep(1000);
        temp1.click();
    }

}

