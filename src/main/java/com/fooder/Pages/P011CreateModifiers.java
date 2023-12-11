package com.fooder.Pages;

import com.fooder.PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P011CreateModifiers extends PageBase {
    public P011CreateModifiers(WebDriver driver) {
        super(driver);
    }
    P009CreateCategory category = new P009CreateCategory(driver);
    private final By Modifiers_From_Menu = By.xpath("//span[normalize-space()='Modifiers' or contains(text(),'المعدلات')]");
    private final By CreateModifier = By.xpath("//a[normalize-space()='Create' or contains(text(),'إنشاء')]");
    private final By DeleteIcon = By.xpath("(//*[name()='svg'][@class='icon-lg icon-danger'])[1]");
    private final By Reference = By.xpath("//th[normalize-space()='Reference' or contains(text(),'مرجع')]");
    private final By Created_Date = By.xpath("//th[normalize-space()='Created Date' or contains(text(),'تاريخ الإنشاء')]");
    private final By CreateModifierTitle = By.xpath("//span[@class='text-primary font-weight-bolder mx-1 font-small-4']");
    private final By Input_Name = By.xpath("//input[@id='name']");
    private final By Input_Name_Localized = By.xpath("//input[@id='name-localized']");
    private final By Input_Reference = By.xpath("//input[@id='reference']");
    private final By Label_Name = By.xpath("//label[@for='name']");
    private final By Label_Name_Localized = By.xpath("//label[@for='name-localized']");
    private final By Label_Reference = By.xpath("//label[@for='reference']");
    private final By Name_Error_Message = By.xpath("//span[normalize-space()='Name is required' or contains(text(),'الأسم مطلوب')]");
    private final By Localized_Name_Error_Message = By.xpath("//span[normalize-space()='Localized name is required' or contains(text(),'الأسم المترجم مطلوب')]");
    private final By Submit_Creation_CTA = By.xpath("//span[@class='mx-50 align-middle']");
    private final By Edit_Icon = By.xpath("//a[@class='btn btn-icon btn-flat-secondary']//*[name()='svg']");
    private final By Edit_Modifier = By.xpath("//button[normalize-space()='Edit' or contains(text(),'تعديل')]");
    private final By Deactivate_Modifier = By.xpath("//button[@type='button']");
    private final By ModifierActiveStatus = By.xpath("(//div[@class='badge font-small-1 font-weight-bolder badge-light-success'])[1]");
    private final By ModifierInActiveStatus = By.xpath("(//div[@class='badge font-small-1 font-weight-bolder badge-light-warning'])[1]");
    private final By UpdateModifier = By.xpath("//span[@class='mx-50 align-middle']");
    private final By EditModifierTitle = By.xpath("//span[@class='text-primary font-weight-bolder mx-1 font-small-4']");



    private void openModifierScreen(){
        category.validateMenuItems();
        scrollToElement(Modifiers_From_Menu);
        Assert.assertTrue(assertElementDisplayed(Modifiers_From_Menu));
        clickOnelement(Modifiers_From_Menu);
        Assert.assertTrue(assertElementDisplayed(CreateModifier));
        Assert.assertTrue(assertElementDisplayed(Reference));
        Assert.assertTrue(assertElementDisplayed(Created_Date));
    }
    private void checkCreateModifierScreen(){
        clickOnelement(CreateModifier);
        Assert.assertTrue(checkForLocalization(CreateModifierTitle,"Create Modifier" ,"إنشاء معدل"));
        Assert.assertTrue(assertElementDisplayed(Input_Reference));
        Assert.assertTrue(checkForLocalization(Label_Name,"Name*" ,"الأسم*"));
        Assert.assertTrue(checkForLocalization(Label_Reference,"Reference" ,"مرجع"));
        Assert.assertTrue(checkForLocalization(Label_Name_Localized,"Name Localized*" ,"الأسم مترجم*"));
        checkMandatoryFieldsOfModifier();


    }
    private void checkMandatoryFieldsOfModifier(){
        Assert.assertTrue(driver.findElement(Label_Name).getText().contains("*"));
        Assert.assertTrue(driver.findElement(Label_Name_Localized).getText().contains("*"));
        validateErrorMessage(Input_Name,Input_Name_Localized,Name_Error_Message);
        validateErrorMessage(Input_Name_Localized,Input_Reference,Localized_Name_Error_Message);
    }

    public void checkModifierCreation(String name,String localized_Name , String reference ){
        openModifierScreen();
        checkCreateModifierScreen();
        fillModifierForm(name , localized_Name , reference);
        clickOnelement(Submit_Creation_CTA);
        validateSuccessMessage();
    }
    private void fillModifierForm(String name,String localized_Name , String reference){
        sendTextToInputField(name , Input_Name);
        sendTextToInputField(localized_Name , Input_Name_Localized);
        sendTextToInputField(reference , Input_Reference);
    }
    private void checkEditModifierScreen(){
        scrollToElement(Edit_Icon);
        clickOnelement(Edit_Icon);
        Assert.assertTrue(assertElementDisplayed(Edit_Modifier));
        Assert.assertTrue(checkForLocalization(Deactivate_Modifier,"Deactivate","تعطيل"));
        Assert.assertTrue(checkForLocalization(Edit_Modifier,"Edit","تعديل"));
        Assert.assertTrue(assertElementDisplayed(ModifierActiveStatus));
        Assert.assertTrue(checkForLocalization(ModifierActiveStatus,"Active","نشط"));
    }
    public void EditModifier(String new_modifier_name , String new_modifier_localized_name , String new_reference){
        checkEditModifierScreen();
        clickOnelement(Edit_Modifier);
        Assert.assertTrue(assertElementDisplayed(UpdateModifier));
        Assert.assertTrue(checkForLocalization(EditModifierTitle,"Edit Modifier","تعديل المعدل"));
        fillModifierForm(new_modifier_name,new_modifier_localized_name,new_reference);
        clickOnelement(UpdateModifier);
        validateUpdateMessage();
    }
    public void DeActivateModifier(){
        checkEditModifierScreen();
        clickOnelement(Deactivate_Modifier);
        validateUpdateMessage();
        Assert.assertTrue(checkForLocalization(ModifierInActiveStatus,"Inactive","غير نشط"));
        Assert.assertTrue(checkForLocalization(Deactivate_Modifier,"Activate","تفعيل"));
    }
}
