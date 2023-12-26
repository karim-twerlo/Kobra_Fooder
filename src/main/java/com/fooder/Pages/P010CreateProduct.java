package com.fooder.Pages;

import com.fooder.PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class P010CreateProduct extends PageBase {
    public P010CreateProduct(WebDriver driver) {
        super(driver);
    }
    P009CreateCategory category = new P009CreateCategory(driver);
    public final By Products_From_Menu = By.xpath("//span[normalize-space()='Products' or contains(text(),'المنتجات')]");
    public final By Create_Product = By.xpath("//a[@routerlink='create']");
    public final By DeleteIcon = By.xpath("(//*[name()='svg'][@class='icon-lg icon-danger'])[1]");
    public final By Item = By.xpath("//th[normalize-space()='Item' or contains(text(),'العنصر')]");
    public final By SKU = By.xpath("//th[normalize-space()='SKU' or contains(text(),'الرمز')]");
    public final By Category = By.xpath("//th[normalize-space()='Category' or contains(text(),'فئة')]");
    public final By Price = By.xpath("//th[normalize-space()='Price' or contains(text(),'السعر')]");
    public final By Status = By.xpath("//th[normalize-space()='Status' or contains(text(),'الحالة')]");
    public final By Input_Name = By.xpath("//input[@id='name']");
    public final By Input_Name_Localized = By.xpath("//input[@id='name-localized']");
    public final By Input_Price = By.xpath("//input[@id='price']");
    public final By Input_SKU = By.xpath("//input[@id='sku']");
    public final By Input_Calories = By.xpath("//input[@id='calories']");
    public final By Input_Prep_Time = By.xpath("//input[@id='prep-time']");
    public final By Input_Category = By.xpath("(//input[@type='text'])[3]");
    public final By Input_Costing_Method = By.xpath("(//input[@type='text'])[5]");
    public final By Input_Tax_Group = By.xpath("(//input[@type='text'])[6]");
    public final By Input_Desc = By.xpath("//textarea[@id='desc']");
    public final By Input_Desc_Localized = By.xpath("//textarea[@id='desc-localized']");
    public final By Name_Error_Message = By.xpath("//div[normalize-space()='Name is required' or contains(text(),'الأسم مطلوب')]");
    public final By Localized_Name_Error_Message = By.xpath("//div[normalize-space()='Localized name is required' or contains(text(),'الأسم المترجم مطلوب')]");
    public final By Price_Error_Message = By.xpath("//div[normalize-space()='Price is required' or contains(text(),'السعر مطلوب')]");
    public final By Category_Error_Message = By.xpath("//div[normalize-space()='Category is required' or contains(text(),'إختيار القسم مطلوب')]");
    public final By Label_Name = By.xpath("//label[@for='name']");
    public final By Label_Name_Localized = By.xpath("//label[@for='name-localized']");
    public final By Label_Price = By.xpath("//label[@for='price']");
    public final By Label_SKU = By.xpath("//label[@for='sku']");
    public final By Label_Calories = By.xpath("//label[@for='calories']");
    public final By Label_Prep_Time = By.xpath("//label[@for='prep-time']");
    public final By Label_Category = By.xpath("//div[3]//div[1]//label[1]");
    public final By Label_Costing_Method = By.xpath("//label[normalize-space()='Costing Method' or contains(text(),'طريقة حساب التكاليف')]");
    public final By Label_Tax_Group = By.xpath("//label[normalize-space()='Tax Group' or contains(text(),'المجموعة الضريبية')]");
    public final By Label_Desc = By.xpath("//label[@for='desc']");
    public final By Label_Desc_Localized = By.xpath("//label[@for='desc-localized']");
    public final By Submit_Product_Creation = By.xpath("//button[@type='submit']");
    private void validateProductsScreen(){
       Assert.assertTrue(assertElementDisplayed(Item));
       Assert.assertTrue(assertElementDisplayed(SKU));
       Assert.assertTrue(assertElementDisplayed(Category));
       Assert.assertTrue(assertElementDisplayed(Price));
       Assert.assertTrue(assertElementDisplayed(Status));
//       Assert.assertTrue(assertElementDisplayed(DeleteIcon));
       Assert.assertTrue(assertElementDisplayed(Create_Product));

   }
    public void openProductsScreen(){
        if(!driver.findElement(Products_From_Menu).isDisplayed()) category.validateMenuItems();
       scrollToElement(Products_From_Menu);
       clickOnelement(Products_From_Menu);
       validateProductsScreen();
   }
    public void validateProductFormScreenInputs(){
       validateEachItem(Input_Category);
       validateEachItem(Input_Name);
       validateEachItem(Input_Name_Localized);
       validateEachItem(Input_Desc);
       validateEachItem(Input_Desc_Localized);
       validateEachItem(Input_SKU);
       validateEachItem(Input_Calories);
       validateEachItem(Input_Prep_Time);
       validateEachItem(Input_Price);
       validateEachItem(Input_Costing_Method);
       validateEachItem(Input_Tax_Group);
    }
    public void validateProductFormScreenLabels(){
        validateEachItem(Label_Category);
        validateEachItem(Label_Name);
        validateEachItem(Label_Name_Localized);
        validateEachItem(Label_Desc);
        validateEachItem(Label_Desc_Localized);
        validateEachItem(Label_SKU);
        validateEachItem(Label_Calories);
        validateEachItem(Label_Prep_Time);
        validateEachItem(Label_Price);
        validateEachItem(Label_Costing_Method);
        validateEachItem(Label_Tax_Group);
    }
    public void validateProductCreation(String category , String tax_Group , String costing_Method , String name , String desc , String descLocalized,
                                        String localized_name , String calories , String price , String sku , String prepTime , Boolean IsEnglish){
        if(IsEnglish){
            selectEnglish();
        }
        openProductsScreen();
        clickOnelement(Create_Product);
        validateProductFormScreenLabels();
        validateProductFormScreenInputs();
        validateMandatoryFields();
        fillProductForm(category ,tax_Group ,costing_Method,name,desc,descLocalized,localized_name,calories,price,sku + generateRandomDigits(3),prepTime);
        submitProductCreation();
   }
    private void validateEachItem(By by){
        scrollToElement(by);
        Assert.assertTrue(assertElementDisplayed(by));
    }
    private void validateMandatoryFields(){
       validateErrorMessage(Input_Name , Input_Name_Localized ,Name_Error_Message);
        validateErrorMessage(Input_Name_Localized , Input_Price ,Localized_Name_Error_Message);
        validateErrorMessage(Input_Price , Input_Category ,Price_Error_Message);
        validateErrorMessage(Input_Category , Input_Name ,Category_Error_Message);
    }
    public void selectFromNgList(String text , By by){
       scrollToElement(by);
        clickOnelement(by);
        By optionLocator = By.xpath("//div[@role='option' and contains(text(), ' " + text + " ')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
        optionElement.click();

    }
    private void selectFromNgListTaxGroup(String text , By by){
       scrollToElement(by);
        clickOnelement(by);
        String optionText = "";
        switch (text) {
            case "None": {
                optionText = SetLocalization(text, "لا أحد");
                break;
            }
            case "VAT": {
                optionText = SetLocalization(text, "ضريبة القيمة المضافة");
                break;
            }
            default:
                System.out.println("invalid role");
        }


        By optionLocator = By.xpath("//div[@role='option' and contains(text(), ' " + optionText + " ')]");

        // Wait for the option to be visible and clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));

        optionElement.click();


    }
    private void selectFromNgListCostingMethod(String text , By by){
       scrollToElement(by);
        clickOnelement(by);
        String optionText = "";
        switch (text) {
            case "Fixed Price": {
                optionText = SetLocalization(text, "سعر ثابت");
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
    private void fillProductForm(String category , String tax_Group ,String costing_Method , String name , String desc ,String descLocalized,
                                 String localized_name , String calories , String price , String sku , String prepTime){
       selectFromNgList(category ,Input_Category );
       selectFromNgListTaxGroup(tax_Group ,Input_Tax_Group );
       selectFromNgListCostingMethod(costing_Method ,Input_Costing_Method );
       sendTextToInputField(name , Input_Name);
       sendTextToInputField(desc , Input_Desc);
       sendTextToInputField(localized_name , Input_Name_Localized);
       sendTextToInputField(calories , Input_Calories);
       sendTextToInputField(price , Input_Price);
       sendTextToInputField(sku , Input_SKU);
       sendTextToInputField(prepTime , Input_Prep_Time);
       sendTextToInputField(descLocalized , Input_Desc_Localized);


    }
    private void submitProductCreation(){
       scrollToElement(Submit_Product_Creation);
       clickOnelement(Submit_Product_Creation);
       validateSuccessMessage();
    }
}
