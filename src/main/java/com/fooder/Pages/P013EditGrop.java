package com.fooder.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class P013EditGrop extends P008CreateGroup{
    public P013EditGrop(WebDriver driver) {
        super(driver);
    }
    private  int index = 1; // Initialize index

    private final By Edit_Basic_Info = By.xpath("//button[normalize-space()='Edit' or contains(text(),'تعديل')]");
    private final By Make_It_Default = By.xpath("//span[normalize-space()='Make it default' or contains(text(),'اجعله افتراضيًا')]");
    private final By Operation_Timing = By.xpath("//p[normalize-space()='Group Operation' or contains(text(),'توقيت المجموعة')]");
    private final By Default_Badge = By.xpath("//div[@class='badge badge-light-dark mx-50 ng-star-inserted']");
    private final By sunday_Toggle = By.cssSelector("div.custom-control.custom-switch.custom-switch-success.my-50 input#SUNDAY");
    private final By monday_Toggle = By.xpath("//label[@for='MONDAY']");
    private final By tuesday_Toggle = By.xpath("//label[@for='TUESDAY']");
    private final By wednesday_Toggle = By.xpath("//label[@for='WEDNESDAY']");
    private final By thursday_Toggle = By.xpath("//label[@for='THURSDAY']");
    private final By friday_Toggle = By.xpath("//label[@for='FRIDAY']");
    private final By saturday_Toggle = By.xpath("//label[@for='SATURDAY']");
    private final By Update_Time_Configuration = By.xpath("//button[@type='submit']");
    private final By Deactivate_Badge = By.xpath("//div[@class='badge badge-light-dark mx-50 ng-star-inserted']");
    private final By Select_Products = By.xpath("//button[normalize-space()='Select products' or contains(text(),'حدد المنتجات')]");
    private final By Product_Message = By.xpath("//h5[contains(text(),'Add products to this menu group to appear to this ') or contains(text(),'أضف منتجات إلى مجموعة القائمة هذه لتظهر في مجموعة ')]");
    private final By Products_Section_Title = By.xpath("//p[normalize-space()='Products' or contains(text(),'منتجات')]");
    private final By Products_Input_List = By.xpath("//input[@aria-autocomplete='list']");
    private final By Save_Product = By.xpath("//div[@class='col-12']//span[@class='mx-50 align-middle'][normalize-space()='Save' or contains(text(),'حفظ')]");
    private final By Select_Branch = By.xpath("//span[normalize-space()='Select branches' or contains(text(),'حدد الفروع')]");
   private final By Save_Branches_Options = By.xpath("(//button[@type='submit'])[2]");
    public void validateEditGroup(String text , Boolean allBranches){
        if (! driver.findElement(Groups).isDisplayed()) {
            validateMenuItems();
        }else {
            clickOnelement(Groups);
        }
        validateGroupsScreen();
        validateInternalEditScreen("1");
        branchTimingSection();
        editProductSection(text);
        selectBranch(0 , allBranches);
    }
    public void validateDefaultGroup(){
        validateMenuItems();
        validateGroupsScreen();
        validateInternalEditScreen("1");
        checkDefaultGroup();
    }


    private void validateInternalEditScreen(String index){
        By branchEditIcon = By.xpath("//tbody/tr[" + index + "]/td[5]/a[1]//*[name()='svg']");
        scrollToElement(branchEditIcon);
        clickOnelement(branchEditIcon);
        Assert.assertTrue(assertElementDisplayed(Edit_Basic_Info));
        Assert.assertTrue(assertElementDisplayed(Make_It_Default));
        scrollToElement(Operation_Timing);
        Assert.assertTrue(assertElementDisplayed(Operation_Timing));
    }
    public void checkDefaultGroup(){
        clickOnelement(Make_It_Default);
        validateUpdateMessage();
        Assert.assertTrue(assertElementDisplayed(Default_Badge));
    }
    public void branchTimingSection(){
        scrollToElement(Operation_Timing);
        waitForVisibilityOfElement(Operation_Timing);
        setTimeForEachDay();
        scrollToElement(Update_Time_Configuration);
        clickOnelement(Update_Time_Configuration);
        validateUpdateMessage();

    }
    private void setTimeForEachDay(){
        openTimingToggle("SUNDAY" ,sunday_Toggle);
        openTimingToggle("MONDAY" , monday_Toggle );
        openTimingToggle("TUESDAY" , tuesday_Toggle  );
        openTimingToggle("WEDNESDAY" , wednesday_Toggle  );
        openTimingToggle("THURSDAY" , thursday_Toggle );
        openTimingToggle("FRIDAY" , friday_Toggle  );
        openTimingToggle("SATURDAY" , saturday_Toggle  );
    }
    private  void openTimingToggle(String id , By by ){
        scrollToElement(by);
        clickOnElementIdUsingJS(id);
        setHourAndMinute();

    }
    public  void setHourAndMinute() {
        By Start_Hour = By.xpath("(//input[@placeholder='HH'])[" + index + "]");
        By End_Hour = By.xpath("(//input[@placeholder='HH'])[" + (index + 1) + "]");
        By Start_Minute = By.xpath("(//input[@placeholder='MM'])[" + index + "]");
        By End_Minute = By.xpath("(//input[@placeholder='MM'])[" + (index + 1) + "]");

        sendTextToInputField("05", Start_Hour);
        sendTextToInputField("12", End_Hour);
        sendTextToInputField("00", Start_Minute);
        sendTextToInputField("30", End_Minute);

        incrementIndex(2);
    }
    private  void incrementIndex(int value) {
        index += value;
    }
    private void validateSelectProductSection(){
        scrollToElement(Products_Section_Title);
        Assert.assertTrue(assertElementDisplayed(Select_Products));
        Assert.assertTrue(assertElementDisplayed(Product_Message));
    }
    private void selectFromNgList(String text , By by){
        scrollToElement(by);
        clickOnelement(by);
        By optionLocator = By.xpath("//div[@role='option' and contains(text(), ' " + text + " ')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
        optionElement.click();

    }
    private void editProductSection(String text){
        validateSelectProductSection();
        clickOnelement(Select_Products);
        selectFromNgList(text , Products_Input_List);
        clickOnelement(myAccount);
        scrollToElement(Save_Product);
        clickOnelement(Save_Product);
        validateLinkedSuccessMessage();

    }
    private void selectBranch(int branchIndex , Boolean allBranches){
        scrollToElement(Select_Branch);
        Assert.assertTrue(assertElementDisplayed(Select_Branch));
        clickOnelement(Select_Branch);
        checkOptionBox("pick_up" ,  branchIndex  , allBranches);
        checkOptionBox("delivery" ,  branchIndex , allBranches);
        checkOptionBox("dine_in" ,  branchIndex , allBranches);
        checkOptionBox("drive_thru" ,  branchIndex , allBranches);
        clickOnelement(Save_Branches_Options);
        validateUpdateMessage();
    }
    private void checkOptionBox(String Option , int branch_Number , Boolean isAll){
        List<WebElement> checkboxElements = driver.findElements(By.cssSelector("input[type='checkbox'][value='" + Option + "']"));
        if(isAll){
            for (int i = 0; i < checkboxElements.size() - 1; i++)  {
                scrollToEndOfScreen();
                checkboxElements.get(i).click();
            }
            scrollUp();
        }else {
            try {
                Thread.sleep(200);
            }catch (Exception e){
                e.getStackTrace();
            }
            checkboxElements.get(branch_Number).click();
        }
    }


}

