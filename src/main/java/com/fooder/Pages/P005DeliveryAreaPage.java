package com.fooder.Pages;

import com.fooder.PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P005DeliveryAreaPage extends PageBase {
    public P005DeliveryAreaPage(WebDriver driver) {
        super(driver);
    }
    private final By deliveryAreaNameLabel = By.xpath("//label[contains(text(),'اسم منطقة التسليم') or contains(text(),'Delivery Area Name')]");
    private final By deliveryAreaNameInput = By.xpath("//input[@placeholder='أدخل أسم منطقة التسليم' or contains(@placeholder, 'Enter delivery area name')]");
    private final By deliveryAreaNameRequiredMessage = By.xpath("//div[contains(text(),'أسم منطقة التوصيل مطلوب') or contains(text(),'Delivery area name is required')]");

    private final By deliveryFeesLabel = By.xpath("//label[contains(text(),'رسوم التوصيل') or contains(text(),'Delivery Fees* SAR')]");
    private final By deliveryFeesInput = By.xpath("//input[@placeholder='أدخل رسوم التوصيل' or contains(@placeholder, 'Enter delivery fees')]");
    private final By deliveryFeesRequiredMessage = By.xpath("//div[contains(text(),'مطلوب رسوم التوصيل') or contains(text(),'Delivery fees is required')]");

    private final By deliveryDistanceLabel = By.xpath("//label[contains(text(),'مسافة التسليم') or contains(text(),'Delivery Distance* KM')]");
    private final By deliveryDistanceInput = By.xpath("//input[@placeholder='أدخل مسافة التسليم' or contains(@placeholder, 'Enter delivery distance')]");
    private final By deliveryDistanceRequiredMessage = By.xpath("//div[contains(text(),'مسافة التوصيل مطلوبة') or contains(text(),'Delivery distance is required')]");

    private final By extraDistanceFeesInput = By.xpath("//input[@placeholder='أدخل رسوم المسافة الإضافية' or contains(@placeholder, 'Enter extra distance fees')]");
    private final By extraDistanceFeesLabel = By.xpath("//label[contains(text(),'رسوم المسافة الإضافية') or contains(text(),'Extra Distance Fees* SAR')]");
    private final By extraDistanceFeesRequiredMessage = By.xpath("//div[contains(text(),'مطلوب رسوم المسافة الإضافية') or contains(text(),'Extra distance fees is required')]");

    private final By deliveryAreaTypeLabel = By.xpath("//label[contains(text(),'نوع منطقة التسليم') or contains(text(),'Delivery Area Type*')]");
    private final By deliveryAreaTypeRequiredMessage = By.xpath("//div[contains(text(),'نوع منطقة التوصيل مطلوب') or contains(text(),'Delivery area type is required')]");
    private final By deliveryAreaTypeInput = By.xpath("//input[@aria-autocomplete='list']");

    private final By submit = By.xpath("//button[@type='submit']");
    private final By Success_Message = By.xpath("//p[text()='تم إنشاء السجل.' or text()='The record has been created.']") ;

    private void validateDeliveryAreaElements(){
        waitForVisibilityOfElement(deliveryAreaNameLabel);
        Assert.assertTrue(assertElementDisplayed(deliveryAreaNameLabel));
        Assert.assertTrue(assertElementDisplayed(deliveryDistanceLabel));
        Assert.assertTrue(assertElementDisplayed(deliveryFeesLabel));
        Assert.assertTrue(assertElementDisplayed(extraDistanceFeesLabel));
        scrollToElement(deliveryAreaTypeLabel);
        Assert.assertTrue(assertElementDisplayed(deliveryAreaTypeLabel));
    }
    private void insertDeliveryAreaData(String deliveryAreaName , String deliveryDistance ,String deliveryFees , String extraDistanceFees , String  deliveryAreaType){
        selectInput(deliveryAreaTypeInput ,deliveryAreaType );
        driver.findElement(deliveryAreaTypeInput).sendKeys(Keys.ENTER);
        selectInput(deliveryDistanceInput ,deliveryDistance );
        selectInput(deliveryFeesInput ,deliveryFees );
        selectInput(extraDistanceFeesInput ,extraDistanceFees );
        selectInput(deliveryAreaNameInput ,deliveryAreaName );

    }
    private void selectInput(By by , String text){
        scrollToElement(by);
        sendTextToInputField(text , by);
    }
    private void submitDeliveryArea(){
        scrollToElement(submit);
        clickOnelement(submit);
    }
    public void checkDeliveryAreaCreationFunctionality(String deliveryAreaName , String deliveryDistance ,String deliveryFees , String extraDistanceFees , String  deliveryAreaType){
        validateDeliveryAreaElements();
        insertDeliveryAreaData(deliveryAreaName,deliveryDistance,deliveryFees,extraDistanceFees,deliveryAreaType);
        submitDeliveryArea();
        Assert.assertTrue(assertElementDisplayed(Success_Message));


    }
    public void checkErrorMessageForEachInputField(){
        waitForVisibilityOfElement(deliveryAreaNameLabel);
        validateErrorMessage(deliveryAreaTypeInput , deliveryDistanceInput , deliveryAreaTypeRequiredMessage);
        validateErrorMessage(deliveryFeesInput , deliveryAreaNameInput , deliveryFeesRequiredMessage);
        validateErrorMessage(deliveryAreaNameInput , deliveryDistanceInput , deliveryAreaNameRequiredMessage);
        validateErrorMessage(deliveryDistanceInput , extraDistanceFeesInput , deliveryDistanceRequiredMessage);
        validateErrorMessage(extraDistanceFeesInput , deliveryDistanceInput , extraDistanceFeesRequiredMessage);

    }
}
