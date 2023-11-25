package com.fooder.Pages;

import com.fooder.PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WelcomePage extends PageBase {
    public WelcomePage(WebDriver driver) {
        super(driver);
    }
    private By Fooder_Logo = By.cssSelector("img[alt='brand-logo']");
    private By contact_label = By.cssSelector("label[for='contact']");
    public void validateLogo(){
        waitForVisibilityOfElement(Fooder_Logo);
        Assert.assertTrue(driver.findElement(Fooder_Logo).isDisplayed());
    }
    public void validateContactLabel(){
        Assert.assertTrue(checkForLocalization(contact_label , "WhatsApp Number","رقم الواتس اب"));
    }
}
