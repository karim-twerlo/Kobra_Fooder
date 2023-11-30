package com.fooder.Pages;

import com.fooder.PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P004BranchesPage extends PageBase {
    public P004BranchesPage(WebDriver driver) {
        super(driver);
    }
    private final By Crete_Branch_CTA = By.xpath("//button[contains(text(),'إنشاء') or normalize-space()='Create']");
    private final By Create_Branch_Title_Text = By.xpath("//span[@class='text-primary font-weight-bolder mx-1 font-small-4']");
    private final By Back_Arrow = By.xpath("//a[@class='btn btn-outline-primary p-25']//*[name()='svg']");
    private final By Basic_Info = By.xpath("//h5[normalize-space()='Basic Information' or contains(text(),'معلومات اساسية')]");
    private final By Input_Branch_Name = By.xpath("//input[@placeholder='Enter branch name' or @placeholder='أدخل أسم الفرع']");
    private final By Branch_Name_Title = By.xpath("//div[2]//div[1]//label[1]");
    private final By Input_Branch_Name_Localized = By.xpath("//input[@placeholder='Enter branch name localized' or @placeholder='أدخل أسم الفرع المترجم']");
    private final By Branch_Name_Localized_Title = By.xpath("//div[3]//div[1]//label[1]");
    private final By Input_Contact_Name = By.xpath("//input[@placeholder='Enter contact name' or @placeholder='أدخل أسم جهة الاتصال']");
    private final By Contact_Name_Title = By.xpath("//label[contains(text(), 'Contact Name') or contains(text(), 'أسم جهة الاتصال')]/span");
    private final By Input_Contact_Number = By.xpath("//input[@placeholder='أدخل رقم الاتصال' or @placeholder='Enter contact number']");
    private final By Contact_Number_Title = By.xpath("//label[contains(text(), 'Contact Number') or contains(text(), 'رقم الاتصال')]/span");
    private final By Location_Info = By.xpath("//h5[normalize-space()='Location Information' or contains(text(),'معلومات الموقع')]");
    private final By Input_Location = By.xpath("//input[@placeholder='أدخل الموقع' or @placeholder='Enter the location']");
    private final By City_Input = By.xpath("//input[@placeholder='أدخل المدينة' or @placeholder='Enter the city']");
    private final By State_Input = By.xpath("//input[@placeholder='أدخل المحافظة' or @placeholder='Enter the state']");
    private final By Country_Input = By.xpath("//input[@placeholder='أدخل الدولة' or @placeholder='Enter the Country']");
    private final By Location_Title = By.xpath("//label[contains(text(), 'Location') or contains(text(), 'موقع')]/span");
    private final By City_Title = By.xpath("//label[contains(text(), 'City') or contains(text(), 'مدينة')]/span");
    private final By State_Title = By.xpath("//label[contains(text(), 'State') or contains(text(), 'ولاية')]/span");
    private final By Country_Title = By.xpath("//label[contains(text(), 'Country') or contains(text(), 'دولة')]/span");
    private final By Input_Search_Map = By.xpath("//input[@placeholder='Search location' or @placeholder='موقع البحث']");
    private final By Success_Message = By.xpath("//p[text()='تم إنشاء السجل.' or text()='The record has been created.']") ;
    private final By DeleteIcon = By.xpath("(//*[name()='svg'][@class='icon-lg icon-danger'])[1]");
    private final By Confirm_Deleting = By.xpath("//button[@class='btn btn-danger mx-1']/span[contains(text(),' Yes, delete it! ') or contains(text(),'نعم ، إحذفها!')]");
    private final By Confirm_Delete_Message = By.xpath("//p[text()='تم حذف السجل.' or text()='The record has been deleted.']");

    public void checkBranchCreation(String Branch_Name_Localized , String Branch_Name ,String Contact_Name ,
                                    String Contact_Number, String Location , String City , String state , String Country , String MapSearch){
        checkBranchesOpenSuccessfully();
        checkBasicInformationOfBranchDisplayed();
        insertLocationData( Location , City , state , Country , MapSearch);
        insertBasicInformation(Branch_Name_Localized , Branch_Name , Contact_Name , Contact_Number);
        Assert.assertTrue(assertElementDisplayed(Success_Message));
//        clickOnelement(Back_Arrow);

    }
    private void checkBranchesOpenSuccessfully(){
        waitForVisibilityOfElement(Crete_Branch_CTA);
        clickOnelement(Crete_Branch_CTA);
        waitForVisibilityOfElement(Create_Branch_Title_Text);
    }
    private void checkBasicInformationOfBranchDisplayed(){
        Assert.assertTrue(assertElementDisplayed(Create_Branch_Title_Text));
        Assert.assertTrue(assertElementDisplayed(Basic_Info));
        Assert.assertTrue(assertElementDisplayed(Back_Arrow));
        Assert.assertTrue(assertElementDisplayed(Input_Branch_Name));
        Assert.assertTrue(assertElementDisplayed(Branch_Name_Title));
        Assert.assertTrue(driver.findElement(Branch_Name_Title).getText().contains("*"));
        Assert.assertTrue(assertElementDisplayed(Input_Branch_Name_Localized));
        Assert.assertTrue(driver.findElement(Branch_Name_Localized_Title).getText().contains("*"));
        Assert.assertTrue(assertElementDisplayed(Input_Contact_Name));
        Assert.assertTrue(driver.findElement(Contact_Name_Title).getText().contains("*"));
        Assert.assertTrue(assertElementDisplayed(Input_Contact_Number));
        Assert.assertTrue(driver.findElement(Contact_Number_Title).getText().contains("*"));
    }
    private void checkInformationOfLocationDisplayed(){
        Assert.assertTrue(assertElementDisplayed(Location_Info));
        Assert.assertTrue(assertElementDisplayed(Input_Location));
        Assert.assertTrue(driver.findElement(Location_Title).getText().contains("*"));
        Assert.assertTrue(assertElementDisplayed(City_Input));
        Assert.assertTrue(driver.findElement(City_Title).getText().contains("*"));
        Assert.assertTrue(assertElementDisplayed(Country_Input));
        Assert.assertTrue(driver.findElement(Country_Title).getText().contains("*"));
        Assert.assertTrue(assertElementDisplayed(State_Input));
        Assert.assertTrue(driver.findElement(State_Title).getText().contains("*"));
    }
    private void insertLocationData(String Location , String City , String state , String Country , String MapSearch){
        checkInformationOfLocationDisplayed();
        sendTextToInputField(Location , Input_Location);
        sendTextToInputField(City , City_Input);
        sendTextToInputField(state , State_Input);
        sendTextToInputField(Country , Country_Input);
        scrollToElement(Input_Search_Map);
        sendTextToInputField(MapSearch , Input_Search_Map);
    }
    private void insertBasicInformation(String Branch_Name_Localized , String Branch_Name ,String Contact_Name , String Contact_Number){
        checkBasicInformationOfBranchDisplayed();
        sendTextToInputField(Branch_Name,Input_Branch_Name);
        sendTextToInputField(Branch_Name_Localized , Input_Branch_Name_Localized);
        sendTextToInputField(Contact_Name,Input_Contact_Name);
        sendTextToInputField(Contact_Number,Input_Contact_Number);
        driver.findElement(Input_Search_Map).sendKeys(Keys.ENTER);
        ////button[@type="submit"]

    }
    public void deleteBranch(){
        waitForVisibilityOfElement(DeleteIcon);
        clickOnelement(DeleteIcon);
        Assert.assertTrue(assertElementDisplayed(Confirm_Deleting));
        clickOnelement(Confirm_Deleting);
        Assert.assertTrue(assertElementDisplayed(Confirm_Delete_Message));

    }
    
}
