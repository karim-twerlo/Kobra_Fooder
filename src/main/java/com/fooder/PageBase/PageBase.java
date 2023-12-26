package com.fooder.PageBase;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.spec.ECField;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageBase {
    public WebDriver driver;
    public PageBase(WebDriver driver){
        this.driver = driver;
    }
    public By language = By.xpath("//span[@class='selected-language mx-50 font-small-2']");
    public By myAccount = By.xpath("//a[@id='menu-drop']//*[name()='svg']");
    public By logout = By.xpath("//a[@class='dropdown-item logout-color']");
    public By Success_Message = By.xpath("//p[text()='تم إنشاء السجل.' or text()='The record has been created.']") ;
    public By Linked_Success_Message = By.xpath("//p[text()='تم ربط السجلات.' or text()='The records have been linked.']") ;
    public By Unlinked_Success_Message = By.xpath("//p[text()='تم إلغاء ربط السجل.' or text()='The record has been unlinked.']") ;
    public By Success_Update_Message = By.xpath("//p[text()='تم تحديث السجل.' or text()='The record has been updated.']");
    public By Confirm_Delete_Message = By.xpath("//p[text()='تم حذف السجل.' or text()='The record has been deleted.']");

    public void backToLoinScreen(){
        scrollToElement(myAccount);
        clickOnelement(myAccount);
        clickOnelement(logout);
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.getStackTrace();
        }
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));

    }
    public void clickOnelement(By by){
        waitForVisibilityOfElement(by);
        driver.findElement(by).click();

    }
    public void waitForVisibilityOfElement(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    public void waitForVisibilityOfWebElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(element));
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
    public void scrollUp(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -500);");
    }
    public void scrollToEndOfScreen(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
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
    public void sendTextWithotClear(String text , By by){
        waitForVisibilityOfElement(by);
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
        System.out.println("+201" + formattedNumber);

        return "+201" + formattedNumber;
    }
    public void validateSuccessMessage(){
        Assert.assertTrue(assertElementDisplayed(Success_Message));
        waitForInVisibilityOfElement(Success_Message);

    }
    public void validateUpdateMessage(){
        try {
            Assert.assertTrue(assertElementDisplayed(Success_Update_Message));
            waitForInVisibilityOfElement(Success_Update_Message);
        }catch (Exception e){
            e.getStackTrace();
        }

    }
    public void validateLinkedSuccessMessage(){
        Assert.assertTrue(assertElementDisplayed(Linked_Success_Message));
        waitForInVisibilityOfElement(Linked_Success_Message);

    }
    public void validateUnLinkedSuccessMessage(){
        Assert.assertTrue(assertElementDisplayed(Unlinked_Success_Message));
        waitForInVisibilityOfElement(Unlinked_Success_Message);

    }
    public void validateDeletedMessage(){
        Assert.assertTrue(assertElementDisplayed(Confirm_Delete_Message));
        waitForInVisibilityOfElement(Confirm_Delete_Message);

    }
    public static String generateRandomDigits(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length should be greater than 0");
        }

        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10); // Generates a random digit (0 to 9)
            stringBuilder.append(digit);
        }

        return stringBuilder.toString();
    }
    public  void selectEnglish(){
        clickOnelement(language);
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.getStackTrace();
        }
    }
    public  int extractAndConvertToInt(String input) {
        String[] parts = input.split("\\D+");

        for (String part : parts) {
            if (!part.isEmpty()) {
                try {
                    return Integer.parseInt(part);
                } catch (NumberFormatException e) {
                    System.err.println("Error: Part is not a valid integer.");
                    return 0;
                }
            }
        }
        System.err.println("Error: No numeric value found in the input.");
        return 0;
    }
    public  int getCurrentHour() {
        LocalTime currentTime = LocalTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH");
        String formattedHour = currentTime.format(formatter);
        int currentHour = Integer.parseInt(formattedHour);
        System.out.println(currentHour);
        return currentHour;
    }
    public  int nextDay() {
        LocalDate today = LocalDate.now();
        LocalDate nextDay = today.plusDays(1);
        int nextDayAsInt = nextDay.getDayOfMonth();
        System.out.println("Next day as an integer: " + nextDayAsInt);
        return nextDayAsInt;
    }
    public  double extractNumber(String input) {
        Pattern pattern = Pattern.compile("\\n([\\d.]+) SAR");
        Matcher matcher = pattern.matcher(input);

        // Find the first match in the input text
        if (matcher.find()) {
            // Extract the matched value and convert it to a double
            String matchedValue = matcher.group(1);
            return Double.parseDouble(matchedValue);
        } else {
            // Handle the case where no match is found
            System.out.println("No value found in the input text: " + input);
            return 0.0; // Or throw an exception, depending on your requirements
        }
    }

    public  void refreshDriver(String  url) {
        try {
            driver.navigate().refresh();
            Thread.sleep(6000);
            waitForPageToLoad(url);
            Thread.sleep(6000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private  void waitForPageToLoad(String url) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
