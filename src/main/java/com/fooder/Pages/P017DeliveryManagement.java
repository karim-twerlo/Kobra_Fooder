package com.fooder.Pages;

import com.fooder.PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class P017DeliveryManagement extends PageBase {
    public P017DeliveryManagement(WebDriver driver) {
        super(driver);
    }

    /**
     * //div[3]//div[1]//label[1]
     */
    private final By delivery_management_from_menu = By.xpath("//span[normalize-space()='Delivery management' or contains(text(),'إدارة التوصيل')]");
    private final By create_driver = By.xpath("//a[normalize-space()='Create' or contains(text(),'إنشاء')]");
    private final By header_whatsapp = By.xpath("//th[normalize-space()='WhatsApp Number' or contains(text(),'رقم الواتس اب')]");
    private final By title_create_driver = By.xpath("(//span[@class='text-primary font-weight-bolder mx-1 font-small-4'])[1]");
    private final By label_driver_name = By.xpath("//label[@for='driver-name' or contains(text(),'الأسم')]");
    private final By label_mobile_number = By.xpath("//label[@for='driver-number' or contains(text(),'رقم الواتس اب')]");
    private final By label_branch_name = By.xpath("//div[3]//div[1]//label[1]");
    private final By input_driver_name = By.xpath("//input[@id='driver-name']");
    private final By input_mobile_number = By.xpath("//input[@id='driver-number']");
    private final By input_branch_name = By.xpath("//input[@aria-autocomplete='list']");
    private final By submit_driver_creation = By.xpath("//button[@type='submit']");
    P002DashBoardPage dashBoardPage;
    P003P001SettingsDashboardPage settingsDashboardPage;

    private void checkDeliverManagementScreen() {
        dashBoardPage = new P002DashBoardPage(driver);
        settingsDashboardPage = new P003P001SettingsDashboardPage(driver);
        if (!assertElementDisplayed(delivery_management_from_menu)) {
            dashBoardPage.openSettingsMenu();
        }
        settingsDashboardPage.checkNumberOfOrdersSettings();
        Assert.assertTrue(assertElementDisplayed(header_whatsapp));
        Assert.assertTrue(assertElementDisplayed(create_driver));


    }

    private void checkCreateDriverScreen(String driverName, String driverWhatssAppNumber, String branchName) {
        clickOnelement(create_driver);
        Assert.assertTrue(assertElementDisplayed(title_create_driver));
        Assert.assertTrue(checkForLocalization(title_create_driver, "Create Driver", "إنشاء سائق"));
        checkEachLabel(label_driver_name);
        checkEachLabel(label_mobile_number);
        checkEachLabel(label_branch_name);
        fillDriverForm(driverName, driverWhatssAppNumber, branchName);
        scrollToElement(submit_driver_creation);
        clickOnelement(submit_driver_creation);
        validateSuccessMessage();

    }

    private void checkEachLabel(By by) {
        scrollToElement(by);
        Assert.assertTrue(assertElementDisplayed(by));
        Assert.assertTrue(driver.findElement(by).getText().contains("*"));
    }

    private void fillDriverForm(String driverName, String driverWhatssAppNumber, String branchName) {
        sendTextToInputField(driverName, input_driver_name);
        sendTextToInputField(driverWhatssAppNumber, input_mobile_number);
        SelectBranch(branchName);
    }

    private void SelectBranch(String text) {
        clickOnelement(input_branch_name);
        By optionLocator = By.xpath("//div[@role='option' and contains(text(), ' " + text + " ')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
        optionElement.click();
        clickOnelement(input_mobile_number);

    }

    public void checkCreateDelivery(String driverName,  String branchName) {
        checkDeliverManagementScreen();
        checkCreateDriverScreen(driverName, generateRandomNumber(), branchName);
    }


}
