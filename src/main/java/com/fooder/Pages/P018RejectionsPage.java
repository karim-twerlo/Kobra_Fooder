package com.fooder.Pages;

import com.fooder.PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P018RejectionsPage extends PageBase {

    public P018RejectionsPage(WebDriver driver) {
        super(driver);
    }

    P002DashBoardPage dashBoardPage;
    P003P001SettingsDashboardPage settingsDashboardPage;
    private final By rejections = By.xpath("(//a[normalize-space()='Rejection' or contains(text(),'رسائل الرفض')])[1]");
    private final By Add_note = By.xpath("//button[normalize-space()='Add note' or contains(text(),'اضف ملاحظة')]");
    private final By input_note = By.xpath("//input[@placeholder='أدخل الموضوع محليا' or @placeholder='Enter the localized subject']");
    private final By input_localized_note = By.xpath("//input[@placeholder='Enter the subject' or @placeholder='أدخل الموضوع']");
    private final By update = By.xpath("(//span[@class='align-middle mx-50'])[1]");

    private void checkBusinessSettingsScreen() {
        dashBoardPage = new P002DashBoardPage(driver);
        settingsDashboardPage = new P003P001SettingsDashboardPage(driver);
        if (!assertElementDisplayed(settingsDashboardPage.BusinessSettings)) {
            dashBoardPage.openSettingsMenu();
        }
        settingsDashboardPage.checkBusinessSettings();

    }
    private void checkRejectionsScreen(){
        clickOnelement(rejections);
        Assert.assertTrue(assertElementDisplayed(Add_note));
        clickOnelement(Add_note);
        Assert.assertTrue(assertElementDisplayed(input_localized_note));
        Assert.assertTrue(assertElementDisplayed(input_note));
        fillRejectionNotes();
        clickOnelement(update);
        validateUpdateMessage();
    }
    private void fillRejectionNotes(){
        String rejection_note = generateRandomDigits(4) + "rejection note";
        sendTextToInputField(rejection_note,input_note);
        sendTextToInputField(rejection_note, input_localized_note);
    }
    public void checkRejectionNotes(){
        checkBusinessSettingsScreen();
        checkRejectionsScreen();
    }
}
