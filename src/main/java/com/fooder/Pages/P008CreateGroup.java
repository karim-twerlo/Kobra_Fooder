package com.fooder.Pages;

import com.fooder.PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P008CreateGroup extends PageBase {
    public P008CreateGroup(WebDriver driver) {
        super(driver);
    }
    private final By Menu = By.xpath("(//span[@class='menu-title text-truncate mx-75' and contains(text(),'Menu') or contains(text(),'القائمة')])[2]");
    private final By Groups = By.xpath(" //span[contains(text(),'القوائم') or normalize-space()='Groups']");
    private final By Crete_CTA = By.xpath("//a[@routerlink='create']");
    private final By Category = By.xpath(" //span[contains(text(),'الفئات') or normalize-space()='Category']");
    private final By Products = By.xpath(" //span[contains(text(),'المنتجات') or normalize-space()='Products']");
    private final By Modifiers = By.xpath(" //span[contains(text(),'المعدلات') or normalize-space()='Modifiers']");
    private final By Options = By.xpath(" //span[contains(text(),'الخيارات') or normalize-space()='Options']");
    private final By Edit_Icon= By.xpath("//a[@class='btn btn-icon btn-flat-secondary']//*[name()='svg']");
    private final By Default = By.xpath("//td[@class='d-flex align-items-center']");
    private final By Products_Link = By.xpath("//button[@class='btn btn-link']");
    private final By Default_Badge = By.xpath("//div[@class='badge badge-light-dark mx-50']");
    private final By Crete_Group = By.xpath("//span[@class='text-primary font-weight-bolder mx-1 font-small-4']");

    private final By Name_Label = By.xpath("//label[@for='name']");
    private final By Name_Input = By.xpath("//input[@id='name']");
    private final By Name_Localized_Label = By.xpath("//label[@for='name-localized']");
    private final By Name_Localized_Input = By.xpath("//input[@id='name-localized']");
    private final By Submit_Creation = By.xpath("//span[@class='mx-50 align-middle']");
    private final By Name_Error_Message = By.xpath("//span[normalize-space()='Name is required' or contains(text(),'الأسم مطلوب')]");
    private final By Name_Localized_Error_Message = By.xpath("//span[normalize-space()='Localized name is required' or contains(text(),'الأسم المترجم مطلوب')]");
    private final By Success_Message = By.xpath("//p[text()='تم إنشاء السجل.' or text()='The record has been created.']") ;

    private void validateErrorMessages(){
        validateErrorMessage(Name_Input, Name_Localized_Input , Name_Error_Message);
        validateErrorMessage(Name_Localized_Input , Name_Input , Name_Localized_Error_Message);
    }
    private void validateMenuItems(){
        scrollToElement(Menu);
        waitForVisibilityOfElement(Menu);
        clickOnelement(Menu);
        validateEachItem(Options);
        validateEachItem(Modifiers);
        validateEachItem(Products);
        validateEachItem(Category);
        validateEachItem(Groups);

    }
    private void validateEachItem(By by){
        scrollToElement(by);
        Assert.assertTrue(assertElementDisplayed(by));
    }
    private void validateGroupsScreen(){
        clickOnelement(Groups);
        Assert.assertTrue(assertElementDisplayed(Crete_CTA));
//        Assert.assertTrue(assertElementDisplayed(Edit_Icon));
//        Assert.assertTrue(assertElementDisplayed(Default));
//        Assert.assertTrue(assertElementDisplayed(Default_Badge));
//        Assert.assertTrue(assertElementDisplayed(Products_Link));
//        Assert.assertTrue(checkForLocalization(Products_Link,"Products (0)","منتجات (0)"));
//        Assert.assertTrue(checkForLocalization(Default_Badge,"Default" ,"إفتراضي"));
    }
    public void checkGroupCreation(String name ,String localizedName){
        validateMenuItems();
        validateGroupsScreen();
        validateCreteGroupScreen();
        validateErrorMessages();
        fillFormAndSubmit(name, localizedName);
    }
    private void validateCreteGroupScreen(){
        clickOnelement(Crete_CTA);
        waitForVisibilityOfElement(Crete_Group);
        validateEachItem(Crete_Group);
        Assert.assertTrue(checkForLocalization(Crete_Group,"Create Group" , "إنشاء مجموعة"));
        validateEachItem(Name_Input);
        validateEachItem(Name_Label);
        validateEachItem(Name_Localized_Input);
        validateEachItem(Name_Localized_Label);
    }
    private void fillFormAndSubmit(String name , String localized_name){
        sendTextToInputField(name , Name_Input);
        sendTextToInputField(localized_name , Name_Localized_Input);
        clickOnelement(Submit_Creation);
        Assert.assertTrue(assertElementDisplayed(Success_Message));
    }



}
