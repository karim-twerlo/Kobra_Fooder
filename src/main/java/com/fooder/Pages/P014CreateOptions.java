package com.fooder.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class P014CreateOptions extends P008CreateGroup {
    public P014CreateOptions(WebDriver driver) {
        super(driver);
    }
    private final By Label_Name = By.xpath("//label[@for='name']");
    private final By Label_Name_Localized = By.xpath("//label[@for='name-localized']");
    private final By Label_Price = By.xpath("//label[@for='price']");
    private final By Label_SKU = By.xpath("//label[@for='sku']");
    private final By Label_Calories = By.xpath("//label[@for='calories']");
    private final By Label_Costing_Method = By.xpath("//label[normalize-space()='Costing Method' or contains(text(),'طريقة حساب التكاليف')]");
    private final By Label_Tax_Group = By.xpath("//label[normalize-space()='Tax Group' or contains(text(),'المجموعة الضريبية')]");
    private final By Label_Modifier = By.xpath("//label[normalize-space()='Modifier' or contains(text(),'المعدل')]");
    private final By Submit_Product_Creation = By.xpath("//button[@type='submit']");
    private final By Input_Name = By.xpath("//input[@id='name']");
    private final By Input_Name_Localized = By.xpath("//input[@id='name-localized']");
    private final By Input_Price = By.xpath("//input[@id='price']");
    private final By Input_SKU = By.xpath("//input[@id='sku']");
    private final By Input_Calories = By.xpath("//input[@id='calories']");
    private final By Input_Costing_Method = By.xpath("(//input[@type='text'])[5]");
    private final By Input_Tax_Group = By.xpath("(//input[@type='text'])[6]");
    private final By Input_Modifiers_List = By.xpath("(//input[@type='text'])[3]");
    private final By Name_Error_Message = By.xpath("//span[normalize-space()='Name is required' or contains(text(),'الأسم مطلوب')]");
    private final By Localized_Name_Error_Message = By.xpath("//span[normalize-space()='Localized name is required' or contains(text(),'الأسم المترجم مطلوب')]");
    private final By Price_Error_Message = By.xpath("//span[normalize-space()='Price is required' or contains(text(),'السعر مطلوب')]");
    private final By Modifier_Error_Message = By.xpath("//span[normalize-space()='Modifier is required' or contains(text(),'المعدل مطلوب')]");

    private void checkCreateOption(){
        validateMenuItems();
        validateOptionScreen();
        validateCreateOptionsScreen();
    }
    private void validateOptionScreen(){
        clickOnelement(Options);
        Assert.assertTrue(assertElementDisplayed(Crete_CTA));
    }
    private void validateCreateOptionsScreen(){
        clickOnelement(Crete_CTA);
    }
    public void validateProductCreation(String ModifierName ,String tax_Group , String costing_Method , String name ,
                                        String localized_name , String calories , String price , String sku , Boolean IsEnglish){
        if(IsEnglish){
            selectEnglish();
        }
        checkCreateOption();
        validateModifierFormScreenLabels();
        validateModifierFormScreenInputs();
        validateMandatoryFields();
        fillModifierForm(ModifierName ,tax_Group ,costing_Method,name,localized_name,calories,price,sku + generateRandomDigits(3));
        submitModifierCreation();
    }
    private void validateModifierFormScreenLabels(){
        validateEachItem(Label_Name);
        validateEachItem(Label_Name_Localized);
        validateEachItem(Label_SKU);
        validateEachItem(Label_Calories);
        validateEachItem(Label_Price);
        validateEachItem(Label_Costing_Method);
        validateEachItem(Label_Tax_Group);
        validateEachItem(Label_Modifier);
    }
    private void validateModifierFormScreenInputs(){
        validateEachItem(Input_Name);
        validateEachItem(Input_Name_Localized);
        validateEachItem(Input_SKU);
        validateEachItem(Input_Calories);
        validateEachItem(Input_Price);
        validateEachItem(Input_Costing_Method);
        validateEachItem(Input_Tax_Group);
    }
    private void validateMandatoryFields(){
        validateErrorMessage(Input_Name , Input_Name_Localized ,Name_Error_Message);
        validateErrorMessage(Input_Name_Localized , Input_Price ,Localized_Name_Error_Message);
        validateErrorMessage(Input_Price , Input_SKU ,Price_Error_Message);
        validateErrorMessage(Input_Modifiers_List , Input_Price ,Modifier_Error_Message);
    }
    private void fillModifierForm(String ModifierName ,String tax_Group , String costing_Method , String name ,
                                  String localized_name , String calories , String price , String sku ){
        selectFromNgListTaxGroup(tax_Group ,Input_Tax_Group );
        selectFromNgListCostingMethod(costing_Method ,Input_Costing_Method );
        sendTextToInputField(name , Input_Name);
        sendTextToInputField(localized_name , Input_Name_Localized);
        sendTextToInputField(calories , Input_Calories);
        sendTextToInputField(price , Input_Price);
        sendTextToInputField(sku , Input_SKU);
        selectFromNgList(ModifierName , Input_Modifiers_List);



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
    private void submitModifierCreation(){
        scrollToElement(Submit_Product_Creation);
        clickOnelement(Submit_Product_Creation);
        validateSuccessMessage();
    }
    private void selectFromNgList(String text , By by){
        scrollToElement(by);
        clickOnelement(by);
        By optionLocator = By.xpath("//div[@role='option' and contains(text(), ' " + text + " ')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
        optionElement.click();

    }
}
