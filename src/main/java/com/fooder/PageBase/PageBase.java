package com.fooder.PageBase;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.spec.ECField;
import java.time.Duration;
import java.util.Random;

public class PageBase {
    public WebDriver driver;
    public PageBase(WebDriver driver){
        this.driver = driver;
    }
    public By language = By.xpath("//span[@class='selected-language mx-50 font-small-2']");
    public By myAccount = By.xpath("//a[@id='menu-drop']//*[name()='svg']");
    public By logout = By.xpath("//a[@class='dropdown-item logout-color']");
    public By Success_Message = By.xpath("//p[text()='تم إنشاء السجل.' or text()='The record has been created.']") ;
    public By Success_Update_Message = By.xpath("//p[text()='تم تحديث السجل.' or text()='The record has been updated.']");
    public By Confirm_Delete_Message = By.xpath("//p[text()='تم حذف السجل.' or text()='The record has been deleted.']");

    public void backToLoinScreen(){
        scrollToElement(myAccount);
        clickOnelement(myAccount);
        clickOnelement(logout);
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));

    }
    public void clickOnelement(By by){
        waitForVisibilityOfElement(by);
        driver.findElement(by).click();

    }
    public void waitForVisibilityOfElement(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    public void waitForInVisibilityOfElement(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    public Boolean assertElementDisplayed(By by){
        waitForVisibilityOfElement(by);
        return driver.findElement(by).isDisplayed();
    }
    public void scrollToElement(WebElement element){
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});" , element);
    }
    public void scrollToElement(By element){
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});" , driver.findElement(element));
    }
    public Boolean checkForLocalization(By by , String Eng , String arb){
        scrollToElement(language);
        scrollToElement(by);
        waitForVisibilityOfElement(by);
        if(driver.findElement(language).getText().contains("English")){
           return driver.findElement(by).getText().contains(arb);
        } else  {
           return driver.findElement(by).getText().contains(Eng);
        }


    }

    public String SetLocalization(String Eng , String arb){
        scrollToElement(language);
        if(driver.findElement(language).getText().contains("English")){
            return arb;
        } else  {
            return Eng;
        }


    }

    public Boolean checkForLocalization(By by , String Eng , String arb , By languageLocation){
//        System.out.println("you can change to:  " + driver.findElement(languageLocation).getText());
//        System.out.println("here is the current text:  " + driver.findElement(by).getText());
        scrollToElement(languageLocation);
        scrollToElement(by);
        waitForVisibilityOfElement(by);
        if(driver.findElement(languageLocation).getText().contains("English")){
            return driver.findElement(by).getText().contains(arb);
        } else  {
            return driver.findElement(by).getText().contains(Eng);
        }

    }
    public void clickOnElementUsingJavaScript(By by){
        waitForVisibilityOfElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].dispatchEvent(new Event('click'));", driver.findElement(by));
    }
    public void sendTextToInputField(String text , By by){
        waitForVisibilityOfElement(by);
        clearInputField(by);
        driver.findElement(by).sendKeys(text);
    }
    public void clearInputField(By by){
        driver.findElement(by).clear();
    }
    public void doubleClickOnAnElement(By by){
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(by)).perform();
    }
    public void validateErrorMessage(By inputField , By secondInput , By Message){
        scrollToElement(inputField);
        clickOnelement(inputField);
        clickOnelement(secondInput);
        Assert.assertTrue(assertElementDisplayed(Message));
    }
    public void clickOnElementIdUsingJS(String id){
        WebElement CheckboxElement = driver.findElement(By.id(id));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", CheckboxElement);
        try{
            Thread.sleep(200);
        }catch (Exception e){
            e.getStackTrace();
        }
    }public void clickOnElementXpathUsingJS(String xpath){
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.getStackTrace();
        }
        WebElement svgElement = driver.findElement(By.xpath(xpath));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", svgElement);
    }
    public void selectByIndexFromDropDownList(By by , String index){
        WebElement selectElement = driver.findElement(by);
        Select select = new Select(selectElement);
        select.selectByIndex(Integer.parseInt(index));
    }
    public void sendKeysWithJs(By by , String text){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].value = arguments[1];", driver.findElement(by), text);
    }
    public String generateRandomNumber() {
        Random random = new Random();

        // First digit can be 0, 1, 2, or 5
        int firstDigit = random.nextInt(3);  // Generates a random number between 0 and 2
        String formattedNumber = String.valueOf(firstDigit);

        // Rest of the digits (8 digits in total)
        for (int i = 0; i < 8; i++) {
            int digit = random.nextInt(10);  // Generates a random number between 0 and 9
            formattedNumber += digit;
        }
        System.out.println(formattedNumber);

        return formattedNumber;
    }
    public void validateSuccessMessage(){
        Assert.assertTrue(assertElementDisplayed(Success_Message));
        waitForInVisibilityOfElement(Success_Message);

    }
    public void validateUpdateMessage(){
        Assert.assertTrue(assertElementDisplayed(Success_Update_Message));
        waitForInVisibilityOfElement(Success_Update_Message);

    }
    public void validateDeletedMessage(){
        Assert.assertTrue(assertElementDisplayed(Confirm_Delete_Message));
        waitForInVisibilityOfElement(Confirm_Delete_Message);

    }




}
