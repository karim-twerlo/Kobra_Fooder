package com.fooder.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class P015EditOptionsPage extends P014CreateOptions {
    public P015EditOptionsPage(WebDriver driver) {
        super(driver);
    }

    private final By Edit_Product_basic_info = By.xpath("//button[normalize-space()='Edit' or contains(text(),'تعديل')]");
    private final By Deactivate_Product = By.xpath("//button[@type='button']");
    private final By ProductActiveStatus = By.xpath("(//div[@class='badge font-small-1 font-weight-bolder mx-50 badge-light-success'])[1]");
    private final By ProductInActiveStatus = By.xpath("(//div[@class='badge font-small-1 font-weight-bolder mx-50 badge-light-warning'])[1]");
    private final By EditProductTitle = By.xpath("//span[@class='text-primary font-weight-bolder mx-1 font-small-4 d-none d-sm-block']");
    private final By Custom_Price_Title = By.xpath("//p[normalize-space()='Custom Price' or contains(text(),'سعر مخصص')]");
    private final By Custom_Price_Explanation = By.xpath(" //h5[contains(text(),'حدد سعرًا مختلفًا لخيار التعديل هذا في الفروع التي تحددها هنا.') or contains(text(),'Set a different price for this modifier option in the branches you select here.')]");
    private final By  Select_Branch_CTA = By.xpath("//button[@class='btn btn-primary ng-star-inserted' and (normalize-space()='Select branches' or contains(text(),'حدد الفروع'))]");
    private final By Select_Branch_Dropdown = By.xpath("//input[@type='text']");
    private final By Input_Price = By.xpath("//input[@placeholder='Enter the price' or @placeholder='أدخل السعر']");
    private final By Price_Error_Message = By.xpath("//span[normalize-space()='Price is required' or contains(text(),'السعر مطلوب')]");
    private final By Branches_Error_Message = By.xpath("//span[normalize-space()='At least one branch is required' or contains(text(),'مطلوب فرع واحد على الأقل')]");
    private final By Save_Custom_Price_Section = By.xpath("//span[normalize-space()='Save' or contains(text(),'حفظ')]");


    private void checkEditProductScreen(String index){
        Assert.assertTrue(assertElementDisplayed(Crete_CTA));
        By optionEditIcon = By.xpath("//tbody/tr[" + index + "]/td[7]/a[1]//*[name()='svg']");
        scrollToElement(optionEditIcon);
        clickOnelement(optionEditIcon);
        Assert.assertTrue(assertElementDisplayed(Edit_Product_basic_info));
        Assert.assertTrue(checkForLocalization(Deactivate_Product,"Deactivate","تعطيل"));
        Assert.assertTrue(checkForLocalization(Edit_Product_basic_info,"Edit","تعديل"));
        Assert.assertTrue(assertElementDisplayed(ProductActiveStatus));
        Assert.assertTrue(checkForLocalization(ProductActiveStatus,"Active","نشط"));
        Assert.assertTrue(checkForLocalization(EditProductTitle,"Edit Modifier Option","تعديل خيار المعدل"));
    }
    public void checkDeactivateProduct(String index){
        selectOptionTOEditIt(index);
        checkEditProductScreen(index);
        deactivateOption();
    }
    private void selectOptionTOEditIt(String index){
        if(!driver.findElement(Groups).isDisplayed()) {
            validateMenuItems();
            validateOptionScreen();
        }else {
            scrollToElement(Options);
            clickOnelement(Options);

            By OptionEditIcon = By.xpath("//tbody/tr[" + index + "]/td[7]/a[1]//*[name()='svg']");
            Assert.assertTrue(assertElementDisplayed(OptionEditIcon));
        }
    }
    private void deactivateOption(){
        clickOnelement(Deactivate_Product);
        validateUpdateMessage();
        Assert.assertTrue(checkForLocalization(ProductInActiveStatus,"Inactive","غير نشط"));
        Assert.assertTrue(checkForLocalization(Deactivate_Product,"Activate","تفعيل"));
    }
    public void checkEditOption(String index , String Modifier_Name , String Branch_Name){
        selectOptionTOEditIt(index);
        checkEditProductScreen(index);
        editCustomPriceSection(Branch_Name);
    }

    private void validateCustomPriceSection(){
        scrollToElement(Custom_Price_Title);
        Assert.assertTrue(assertElementDisplayed(Custom_Price_Explanation));
        Assert.assertTrue(assertElementDisplayed(Select_Branch_CTA));
        clickOnelement(Select_Branch_CTA);
        Assert.assertTrue(assertElementDisplayed(Select_Branch_Dropdown));
        Assert.assertTrue(assertElementDisplayed(Input_Price));
        validateErrorMessage(Select_Branch_Dropdown,Input_Price,Branches_Error_Message);
        validateErrorMessage(Input_Price,Select_Branch_Dropdown,Price_Error_Message);

    }
    private void fillCustomPriceForm(String Branch_Name ){
        SelectBranch(Branch_Name);
        sendTextToInputField("10",Input_Price);
        clickOnelement(Save_Custom_Price_Section);
        validateLinkedSuccessMessage();
    }
    private void SelectBranch(String text){
        clickOnelement(Select_Branch_Dropdown);
        By optionLocator = By.xpath("//div[@role='option' and contains(text(), ' " + text + " ')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
        optionElement.click();

    }
    private void editCustomPriceSection(String Branch_Name){
        validateCustomPriceSection();
        fillCustomPriceForm(Branch_Name);
    }
}

