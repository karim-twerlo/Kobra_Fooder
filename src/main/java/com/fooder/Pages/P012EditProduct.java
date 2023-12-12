package com.fooder.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class P012EditProduct extends P010CreateProduct{
    public P012EditProduct(WebDriver driver) {
        super(driver);
    }
    String currentDir = System.getProperty("user.dir");
    String coverPath = currentDir + "//images//cover.jpg";
    String profilePath = currentDir + "//images//profile.jpg";
    private final By Edit_Product_basic_info = By.xpath("//button[normalize-space()='Edit' or contains(text(),'تعديل')]");
    private final By Deactivate_Product = By.xpath("//button[@type='button']");
    private final By ProductActiveStatus = By.xpath("(//div[@class='badge font-small-1 font-weight-bolder mx-50 badge-light-success'])[1]");
    private final By ProductInActiveStatus = By.xpath("(//div[@class='badge font-small-1 font-weight-bolder mx-50 badge-light-warning'])[1]");
    private final By EditProductTitle = By.xpath("//span[@class='text-primary font-weight-bolder mx-1 font-small-4 d-none d-sm-block']");
    private final By Profile_Image = By.xpath("(//a[@class='btn btn-light p-3 text-muted photo-manager__btn photo-manager__btn--image ng-star-inserted'])[1]");
    private final By Cover_Image = By.xpath("(//a[@class='btn btn-light p-3 text-muted photo-manager__btn photo-manager__btn--cover ng-star-inserted'])[1]");
    private final By Cover = By.xpath("//label[normalize-space()='Cover' or contains(text(),'الغلاف')]");
    private final By Profile = By.xpath("//label[normalize-space()='Photo' or contains(text(),'الصورة')]");
    private final By Cover_Size = By.xpath("//div[contains(text(),'Max of 5 MB, at least 450 x 250 pixels.') or contains(text(),'بحد أقصى 5 ميجابايت ، على الأقل 450 × 250 بكسل.')]");
    private final By Profile_Size = By.xpath("//div[contains(text(),'550 x 440')]");
    private final By Update_Basic_Info = By.xpath("//span[@class='mx-50 align-middle']");
    private final By Add_Modifier_Message = By.xpath("//h5[contains(text(),'Add modifiers to this product and configure the mi') or contains(text(),'أضف المُعدِّلات إلى هذا المنتج وقم بتكوين الحد الأ')]");
    private final By Add_Modifier_Title = By.xpath("//p[normalize-space()='Modifiers' or contains(text(),'المعدلات')]");
    private final By Add_Modifier_CTA = By.xpath("//button[normalize-space()='Add Modifier' or contains(text(),'إضافة معدل')]");
    private final By Modifiers_List = By.xpath("(//label[1] | //*[contains(text(),'قائمة المعدلات')])[1]");
    private final By Input_Modifiers_List = By.xpath("//input[@type='text']");
    private final By Modifiers_Error_Message = By.xpath("//span[normalize-space()='At least one modifier is required' or @class='ng-star-inserted']");
    private final By Save_Modifiers = By.xpath("//button[@type='submit']");
    private final By Delete_Modifier_Icon = By.xpath("//tbody/tr[1]/td[5]/button[2]//*[name()='svg']");
    private void checkEditProductScreen(String index){
        Assert.assertTrue(assertElementDisplayed(Create_Product));
        By branchEditIcon = By.xpath("//tbody/tr[" + index + "]/td[8]/a[1]//*[name()='svg']");
        scrollToElement(branchEditIcon);
        clickOnelement(branchEditIcon);
        Assert.assertTrue(assertElementDisplayed(Edit_Product_basic_info));
        Assert.assertTrue(checkForLocalization(Deactivate_Product,"Deactivate","تعطيل"));
        Assert.assertTrue(checkForLocalization(Edit_Product_basic_info,"Edit","تعديل"));
        Assert.assertTrue(assertElementDisplayed(ProductActiveStatus));
        Assert.assertTrue(checkForLocalization(ProductActiveStatus,"Active","نشط"));
        Assert.assertTrue(checkForLocalization(EditProductTitle,"Edit Product","تحرير المنتج"));
    }
    public void checkDeactivateProduct(String index){
        selectProductTOEditIt(index);
        checkEditProductScreen(index);
        checkDeactivateProduct();
    }
    private void selectProductTOEditIt(String index){
        if(!driver.findElement(Products_From_Menu).isDisplayed()) {
            openProductsScreen();
        }else {
            scrollToElement(Products_From_Menu);
            clickOnelement(Products_From_Menu);
            By branchEditIcon = By.xpath("//tbody/tr[" + index + "]/td[8]/a[1]//*[name()='svg']");
            Assert.assertTrue(assertElementDisplayed(branchEditIcon));
        }
    }
    private void checkDeactivateProduct(){
        clickOnelement(Deactivate_Product);
        validateUpdateMessage();
        Assert.assertTrue(checkForLocalization(ProductInActiveStatus,"Inactive","غير نشط"));
        Assert.assertTrue(checkForLocalization(Deactivate_Product,"Activate","تفعيل"));
    }
    public void checkEditProduct(String index , String Modifier_Name){
        selectProductTOEditIt(index);
        checkEditProductScreen(index);
        editBasicInfo();
        editModifiersSection(Modifier_Name);
    }
    private void editBasicInfo(){
        clickOnelement(Edit_Product_basic_info);
        Assert.assertTrue(assertElementDisplayed(Label_Name));
        validateProductFormScreenInputs();
        validateProductFormScreenLabels();
        validateImagesSection();
        checkUploadPhotos();
        scrollToElement(Update_Basic_Info);
        clickOnelement(Update_Basic_Info);
        validateUpdateMessage();
    }
    private void validateImagesSection(){
        validateEachElement(Profile);
        validateEachElement(Profile_Image);
        validateEachElement(Profile_Size);
        validateEachElement(Cover);
        validateEachElement(Cover_Image);
        validateEachElement(Cover_Size);
    }
    private void validateEachElement(By by){
        scrollToElement(by);
        Assert.assertTrue(assertElementDisplayed(by));
    }
    private void checkUploadPhotos(){
        scrollToElement(Cover_Image);
        WebElement fileInput = driver.findElement(By.id("product-cover"));
        fileInput.sendKeys(coverPath);
        validateUpdateMessage();
        scrollToElement(Profile_Image);
        WebElement fileInput2 = driver.findElement(By.id("product-image"));
        fileInput2.sendKeys(profilePath);
        validateUpdateMessage();

    }
    private void editModifiersSection(String ModifierName){
        scrollToElement(Add_Modifier_Title);
        Assert.assertTrue(assertElementDisplayed(Add_Modifier_Message));
        addModifier(ModifierName);
        clickOnelement(Delete_Modifier_Icon);
        validateUnLinkedSuccessMessage();
        addModifier(ModifierName);
    }
    private void addModifier(String ModifierName){
        clickOnelement(Add_Modifier_CTA);
        Assert.assertTrue(driver.findElement(Modifiers_List).getText().contains("*"));
        validateErrorMessage(Input_Modifiers_List ,myAccount ,Modifiers_Error_Message);
        selectFromNgList(ModifierName , Input_Modifiers_List);
        scrollToElement(Save_Modifiers);
        clickOnelement(Save_Modifiers);
        validateLinkedSuccessMessage();
    }
}
