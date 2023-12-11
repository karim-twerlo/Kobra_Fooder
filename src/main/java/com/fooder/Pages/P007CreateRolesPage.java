package com.fooder.Pages;

import com.fooder.PageBase.PageBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class P007CreateRolesPage extends PageBase {
    public P007CreateRolesPage(WebDriver driver) {
        super(driver);
    }
    private final By Create = By.xpath("//a[@class='btn btn-primary']");
    private final By BusinessSettings = By.xpath("(//span[@class='menu-title text-truncate mx-75' and contains(text(),'Settings') or contains(text(),'الإعدادات')])[2]");
    private final By Users = By.xpath("//li[contains(@class, 'nav-item') and contains(@class, 'has-sub') and contains(@class, 'open')]//ul[contains(@class, 'menu-content')]//li//span[contains(@class, 'menu-title') and contains(@class, 'text-truncate') and contains(@class, 'mx-75') and (contains(text(), 'المستخدمون') or contains(text(), 'Users'))]");
    private final By Contact = By.xpath("//label[contains(text(),'رقم الاتصال') or @for='contact']");
    private final By Email = By.xpath("//label[contains(text(),'كلمة المرور') or @for='email']");
    private final By Name = By.xpath("//label[contains(text(),'الأسم بالكامل') or @for='name']");
    private final By Password = By.xpath("//label[contains(text(),'كلمة المرور') or @for='password']");
    private final By Input_name = By.xpath( "//input[@id='name']");
    private final By Input_contact = By.xpath( "//input[@id='contact']");
    private final By Input_email = By.xpath( "//input[@id='email']");
    private final By Input_password = By.xpath( "//input[@id='password']");
    private final By Branches = By.xpath("//ng-select[@formcontrolname='branches']");
    private final By Roles = By.xpath("//ng-select[@formcontrolname='roles' and contains(@class, 'ng-select-single')]");
    private final By fullNameErrorMessage = By.xpath("//div[contains(text(),'Full name is required') or contains(text(),'الأسم بالكامل مطلوب')]");
    private final By contactNumberErrorMessage = By.xpath("//span[normalize-space()='Contact Number is required' or contains(text(),'رقم الإتصال مطلوب')]");
    private final By emailAddressErrorMessage = By.xpath("//div[contains(text(),'Email address is required') or contains(text(),'مطلوب عنوان البريد الإلكتروني')]");
    private final By passwordErrorMessage = By.xpath("//span[normalize-space()='Password is required' or contains(text(),'كلمة المرور مطلوبة')]");
    private final By branchErrorMessage = By.xpath("//div[contains(text(),'At least one branch is required') or contains(text(),'مطلوب فرع واحد على الأقل')]");
    private final By userRoleErrorMessage = By.xpath("//div[contains(text(),'User role is required') or contains(text(),'دور المستخدم مطلوب')]");
    private final By CreateRole = By.xpath("//button[@type='submit']");

    public void createRole(String Role_name  , String Role_password , String Role_email , String Role , String Branch){
        checkUserCreation();
        clickOnelement(Create);
        Assert.assertTrue(driver.getCurrentUrl().contains("create"));
        checkRoleForm();
        checkErrorMessagesForBasicInfo();
        fillForm( Role_name ,   generateRandomNumber() ,  Role_password ,  Role_email ,  Role ,  Branch);
        waitForVisibilityOfElement(CreateRole);
        clickOnelement(CreateRole);
        validateSuccessMessage();

    }
    private void checkUserCreation(){
        scrollToElement(BusinessSettings);
        waitForVisibilityOfElement(BusinessSettings);
        scrollToElement(Users);
        Assert.assertTrue(assertElementDisplayed(Users));
        clickOnelement(Users);
        Assert.assertTrue(assertElementDisplayed(Create));
    }
    private void checkRoleForm(){
        waitForVisibilityOfElement(Email);
        Assert.assertTrue(assertElementDisplayed(Password));
        Assert.assertTrue(assertElementDisplayed(Contact));
        Assert.assertTrue(assertElementDisplayed(Name));
        Assert.assertTrue(driver.findElement(Email).getText().contains("*"));
        Assert.assertTrue(driver.findElement(Password).getText().contains("*"));
        Assert.assertTrue(driver.findElement(Name).getText().contains("*"));
        Assert.assertTrue(driver.findElement(Contact).getText().contains("*"));
        Assert.assertTrue(assertElementDisplayed(Branches));
        Assert.assertTrue(assertElementDisplayed(Roles));

    }
    private void fillForm(String name , String contact , String password , String email , String Role , String Branch){
        sendTextToInputField(name , Input_name);
        sendTextToInputField(contact , Input_contact);
        sendTextToInputField(password , Input_password);
        sendTextToInputField(email , Input_email);
        SelectRole(Role);
        SelectBranch(Branch);
    }
    private void checkErrorMessagesForBasicInfo(){
        validateErrorMessage(Input_name , Input_contact , fullNameErrorMessage);
        validateErrorMessage(Input_contact , Input_password , contactNumberErrorMessage);
        validateErrorMessage(Input_password , Input_email , passwordErrorMessage);
        validateErrorMessage(Input_email , Input_name , emailAddressErrorMessage);
        validateErrorMessage(Roles , Branches , userRoleErrorMessage);
        validateErrorMessage(Branches , Input_email , branchErrorMessage);
    }
    private void SelectRole(String text){
        clickOnelement(Roles);
        String optionText = "";
        switch (text) {
            case "Manager": {
                optionText = SetLocalization(text, "مدير");
                break;
            }
            case "Leader": {
                optionText = SetLocalization(text, "قائد");
                break;
            }
            case "Cashier":{
                optionText = SetLocalization(text, "أمين الصندوق");
                break;
            }
            default:
                System.out.println("invalid role");

        }


        By optionLocator = By.xpath("//div[@role='option' and contains(text(), ' " + optionText + " ')]");

        // Wait for the option to be visible and clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));

        // Click on the option to select it
        optionElement.click();


    }
    private void SelectBranch(String text){
        clickOnelement(Branches);

        By optionLocator = By.xpath("//div[@role='option' and contains(text(), ' " + text + " ')]");

        // Wait for the option to be visible and clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));

        // Click on the option to select it
        optionElement.click();


    }
//



}
