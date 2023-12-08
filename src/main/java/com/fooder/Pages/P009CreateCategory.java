package com.fooder.Pages;

import com.fooder.PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P009CreateCategory extends PageBase {
    public P009CreateCategory(WebDriver driver) {
        super(driver);
    }
    private final By Menu = By.xpath("(//span[@class='menu-title text-truncate mx-75' and contains(text(),'Menu') or contains(text(),'القائمة')])[2]");
    private final By Category = By.xpath(" //span[contains(text(),'الفئات') or normalize-space()='Category']");
    private final By Create_Category = By.xpath("//a[contains(text(), 'Create category') or contains(text(), 'إنشاء فئة')]");
    private final By Recorder_Category = By.xpath("//button[contains(text(),'إعادة ترتيب الفئة') or normalize-space()='Reorder category']");
    private final By Edit_Icon= By.xpath("//a[@class='btn btn-icon btn-flat-secondary']//*[name()='svg']");
    private final By Header_Date = By.xpath("//th[contains(text(),'تاريخ الإنشاء') or contains(text(),'Created Date')]");
    private final By Header_Action = By.xpath("//th[contains(text(),'الإجراء') or contains(text(),'Action')]");
    private final By Header_Description = By.xpath("//th[contains(text(),'وصف') or contains(text(),'Description')]");
    private final By Header_Name = By.xpath("//th[contains(text(),'الأسم') or contains(text(),'Name')]");
   private final By Input_Category_Name = By.xpath(" //input[@id='category-name']");
   private final By Input_Localized_Category_Name = By.xpath("//input[@id='category-name-localized']");
    private final By Input_Category_Desc = By.xpath("//textarea[@id='category-desc']");
    private final By Input_Localized_Category_Desc = By.xpath("//textarea[@id='category-desc-localized']");
    private final By Label_Category_Name = By.xpath("//label[@for='category-name']");
    private final By Label_Localized_Category_Desc = By.xpath("//label[@for='category-desc-localized']");
    private final By Label_Localized_Category_Name = By.xpath("//label[@for='category-name-localized']");
    private final By Label_Category_Desc = By.xpath("//label[@for='category-desc']");
    private final By Error_Message_Name = By.xpath("//span[contains(text(),'الأسم مطلوب') or contains(text(),'Name is required')]");
    private final By Error_Message_Localized_Name  = By.xpath("//span[contains(text(),'الأسم المترجم مطلوب') or contains(text(),'Localized name is required')]");
    private final By Submit_Category_Creation = By.xpath("//span[@class='mx-50 align-middle']");
    private final By Success_Message = By.xpath("//p[text()='تم إنشاء السجل.' or text()='The record has been created.']") ;
    private final By Success_Update_Message = By.xpath("//p[text()='تم تحديث السجل.' or text()='The record has been updated.']");

//    Edit =
    private final By Edit_Category = By.xpath("//button[contains(text(),'تعديل') or normalize-space()='Edit']");
    public void checkCreateCategory(String name , String localizedName , String desc , String localizedDesc ,Boolean IsEnglish){
        if(IsEnglish){
            selectEnglish();
        }
        validateMenuItems();
        validateCategoryScreen();
        validateCategoryCreationForm();
        validateErrorMessages();
        fillCategoryForm(name, desc , localizedName ,localizedDesc);
        clickOnelement(Submit_Category_Creation);
        Assert.assertTrue(assertElementDisplayed(Success_Message));

    }
    public void checkEditCategory(String name , String localizedName , String desc , String localizedDesc ,Boolean IsEnglish , String CategoryIndex){
        if(IsEnglish){
            selectEnglish();
        }
        validateMenuItems();
        validateCategoryScreen();
        selectCategoryToEdit(CategoryIndex);
        fillCategoryForm(name, desc , localizedName ,localizedDesc);
        clickOnelement(Submit_Category_Creation);
        Assert.assertTrue(assertElementDisplayed(Success_Update_Message));

    }
    private void selectCategoryToEdit(String CategoryIndex){
        driver.findElement(By.xpath("//tbody/tr[" + CategoryIndex + "]/td[4]/a[1]//*[name()='svg']")).click();
        clickOnelement(Edit_Category);
    }
    private void selectEnglish(){
        clickOnelement(language);
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.getStackTrace();
        }
    }
    private void validateMenuItems(){
        scrollToElement(Menu);
        waitForVisibilityOfElement(Menu);
        clickOnelement(Menu);
        validateEachItem(Category);
    }
    private void validateEachItem(By by){
        scrollToElement(by);
        Assert.assertTrue(assertElementDisplayed(by));
    }
    private void validateCategoryScreen(){
        clickOnelement(Category);
        Assert.assertTrue(assertElementDisplayed(Create_Category));
        Assert.assertTrue(assertElementDisplayed(Recorder_Category));
        Assert.assertTrue(assertElementDisplayed(Edit_Icon));
        Assert.assertTrue(assertElementDisplayed(Header_Action));
        Assert.assertTrue(assertElementDisplayed(Header_Name));
        Assert.assertTrue(assertElementDisplayed(Header_Date));
        Assert.assertTrue(assertElementDisplayed(Header_Description));
    }
    private void validateCategoryCreationForm(){
        clickOnelement(Create_Category);
        Assert.assertTrue(assertElementDisplayed(Input_Category_Desc));
        Assert.assertTrue(assertElementDisplayed(Input_Category_Name));
        Assert.assertTrue(assertElementDisplayed(Input_Localized_Category_Desc));
        Assert.assertTrue(assertElementDisplayed(Input_Localized_Category_Name));

        Assert.assertTrue(assertElementDisplayed(Label_Category_Desc));
        Assert.assertTrue(checkForLocalization(Label_Category_Desc ,"Description","وصف"));

        Assert.assertTrue(assertElementDisplayed(Label_Category_Name));
        Assert.assertTrue(driver.findElement(Label_Category_Name).getText().contains("*"));
        Assert.assertTrue(checkForLocalization(Label_Category_Name ,"Name","الأسم"));

        Assert.assertTrue(assertElementDisplayed(Label_Localized_Category_Desc));
        Assert.assertTrue(checkForLocalization(Label_Localized_Category_Desc ,"Description Localized","الوصف مترجم"));

        Assert.assertTrue(assertElementDisplayed(Label_Localized_Category_Name));
        Assert.assertTrue(driver.findElement(Label_Localized_Category_Name).getText().contains("*"));
        Assert.assertTrue(checkForLocalization(Label_Localized_Category_Name ,"Name Localized","الأسم مترجم"));
//
    }
    private void validateErrorMessages(){
        validateErrorMessage(Label_Localized_Category_Name, Label_Category_Name , Error_Message_Localized_Name);
        validateErrorMessage(Label_Category_Name , Label_Localized_Category_Name , Error_Message_Name);
    }
    private void fillCategoryForm(String name , String Desc , String LocalizedName , String LocalizedDesc){
        sendTextToInputField(name,Input_Category_Name);
        sendTextToInputField(Desc,Input_Category_Desc);
        sendTextToInputField(LocalizedName,Input_Localized_Category_Name);
        sendTextToInputField(LocalizedDesc,Input_Localized_Category_Desc);
    }


}
