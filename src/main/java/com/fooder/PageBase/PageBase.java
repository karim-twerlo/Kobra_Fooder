package com.fooder.PageBase;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PageBase {
    public static WebDriver driver;
    public PageBase(WebDriver driver){
        this.driver = driver;
    }
    private static By language = By.xpath("//span[@class='selected-language mx-50 font-small-2']");
    public static void clickOnelement(By by){
        waitForVisibilityOfElement(by);
        driver.findElement(by).click();

    }
    public static void waitForVisibilityOfElement(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    public static Boolean assertElementDisplayed(By by){
        waitForVisibilityOfElement(by);
        return driver.findElement(by).isDisplayed();
    }
    public static void scrollToElement(WebElement element){
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});" , element);
    }
    public static void scrollToElement(By element){
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});" , driver.findElement(element));
    }
    public static Boolean checkForLocalization(By by , String Eng , String arb){
        scrollToElement(language);
        scrollToElement(by);
        waitForVisibilityOfElement(by);
        if(driver.findElement(language).getText().contains("English")){
           return driver.findElement(by).getText().contains(arb);
        } else  {
           return driver.findElement(by).getText().contains(Eng);
        }


    }

    public static Boolean checkForLocalization(By by , String Eng , String arb , By languageLocation){
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
    public static void clickOnElementUsingJavaScript(By by){
        waitForVisibilityOfElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].dispatchEvent(new Event('click'));", driver.findElement(by));
    }
    public static void sendTextToInputField(String text , By by){
        waitForVisibilityOfElement(by);
        clearInputField(by);
        driver.findElement(by).sendKeys(text);
    }
    public static void clearInputField(By by){
        driver.findElement(by).clear();
    }
    public static void doubleClickOnAnElement(By by){
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(by)).perform();
    }
    public static void validateErrorMessage(By inputField , By secondInput , By Message){
        scrollToElement(inputField);
        clickOnelement(inputField);
        clickOnelement(secondInput);
        Assert.assertTrue(assertElementDisplayed(Message));
    }
    public static void clickOnElementIdUsingJS(String id){
        WebElement CheckboxElement = driver.findElement(By.id(id));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", CheckboxElement);
        try{
            Thread.sleep(200);
        }catch (Exception e){
            e.getStackTrace();
        }
    }public static void clickOnElementXpathUsingJS(String xpath){
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.getStackTrace();
        }
        WebElement svgElement = driver.findElement(By.xpath(xpath));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", svgElement);
    }



}
