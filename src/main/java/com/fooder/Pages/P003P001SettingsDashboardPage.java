package com.fooder.Pages;

import com.fooder.PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P003P001SettingsDashboardPage extends PageBase {
    public P003P001SettingsDashboardPage(WebDriver driver) {
        super(driver);
    }
    public final By BusinessSettings = By.xpath("(//span[@class='menu-title text-truncate mx-75' and contains(text(),'Business settings') or contains(text(),'الإعدادات')])[2]");
    private final By Profile = By.xpath("//a[@class='font-small-2 font-weight-bold nav-link active' and (contains(text(),'حساب تعريفي') or contains(text(),'Profile'))]");
    private final By MyAccount = By.xpath("//span[@class='menu-title text-truncate mx-75' and (contains(text(),'My account') or contains(text(),'حسابي'))]");
    private final By Email = By.xpath("//input[@id='email']");
    private final By Users = By.xpath("//span[@class='menu-title text-truncate mx-75' and (contains(text(),'Users') or contains(text(),'المستخدمون'))]");
    private final By Create = By.cssSelector(".btn.btn-primary[routerlink='create']");
    private final By Branches = By.xpath("//li[contains(@class, 'nav-item') and contains(@class, 'has-sub') and contains(@class, 'open')]//ul[contains(@class, 'menu-content')]//li//span[contains(@class, 'menu-title') and contains(@class, 'text-truncate') and contains(@class, 'mx-75') and (contains(text(), 'الفروع') or contains(text(), 'Branches'))]");
    private final By Branch_Name = By.xpath("//li[@class='active']//span[@class='menu-title text-truncate mx-75' and (contains(text(),'الفروع') or contains(text(),'Branches'))]");
    private final By Number_Of_Orders = By.xpath("//th[contains(text(),'عدد الطلبات') or normalize-space()='No. orders']");
    private final By DeliveryManagement = By.xpath("//span[@class='menu-title text-truncate mx-75' and (contains(text(),'Delivery management') or contains(text(),'إدارة التوصيل'))]");
    private final By SystemLogs = By.xpath("//span[@class='menu-title text-truncate mx-75' and (contains(text(),'System logs') or contains(text(),'سجلات النظام'))]");
    private final By ViewLogs = By.xpath("//th[@class='text-center']");
    public void checkSettingsMenuItems(){
        checkBusinessSettings();
        checkMyAccountSettings();
        checkMyUsersSettings();
        checkBranchesSettings();
        checkNumberOfOrdersSettings();
        checkSystemLogs();
    }
   public void checkBusinessSettings(){
        scrollToElement(BusinessSettings);
        Assert.assertTrue(assertElementDisplayed(BusinessSettings));
        clickOnelement(BusinessSettings);
        Assert.assertTrue(assertElementDisplayed(Profile));
    }
    private void checkMyAccountSettings(){
        scrollToElement(MyAccount);
        Assert.assertTrue(assertElementDisplayed(MyAccount));
        clickOnelement(MyAccount);
        Assert.assertTrue(assertElementDisplayed(Email));
        scrollToElement(Email);
    }
    private void checkMyUsersSettings(){
        scrollToElement(Users);
        Assert.assertTrue(assertElementDisplayed(Users));
        clickOnelement(Users);
        Assert.assertTrue(assertElementDisplayed(Create));
        scrollToElement(Create);
    }
    public void checkBranchesSettings(){
        waitForVisibilityOfElement(BusinessSettings);
        scrollToElement(Branches);
        Assert.assertTrue(assertElementDisplayed(Branches));
        clickOnelement(Branches);
//        Assert.assertTrue(assertElementDisplayed(Branch_Name));
//        scrollToElement(Branch_Name);
    }
    public void checkNumberOfOrdersSettings(){
        scrollToElement(DeliveryManagement);
        Assert.assertTrue(assertElementDisplayed(DeliveryManagement));
        clickOnelement(DeliveryManagement);
        Assert.assertTrue(assertElementDisplayed(Number_Of_Orders));
        scrollToElement(Number_Of_Orders);
    }
    private void checkSystemLogs(){
        scrollToElement(SystemLogs);
        Assert.assertTrue(assertElementDisplayed(SystemLogs));
        clickOnelement(SystemLogs);
        Assert.assertTrue(assertElementDisplayed(ViewLogs));
        scrollToElement(ViewLogs);


    }
}
