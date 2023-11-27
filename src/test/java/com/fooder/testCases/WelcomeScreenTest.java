package com.fooder.testCases;

import com.fooder.Pages.WelcomePage;
import com.fooder.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WelcomeScreenTest extends BaseTest {
    WelcomePage welcPage;
    @BeforeClass
    public void initiateObject(){
        welcPage = new WelcomePage(driver);
    }
    @Test(priority = 0)
    public void validateFooderLogoDisplayed(){
        welcPage.checkFooderLogo();
    }
    @Test(dependsOnMethods ="validateFooderLogoDisplayed" )
    public void validateSubTitleText(){
        welcPage.checkSubTitleText();
    }
    @Test(dependsOnMethods ="validateFooderLogoDisplayed" )
    public void validateLoginToYourAccSubTitleText(){
        welcPage.checkLoginToYourAccountSubTitleText();
    }

    @Test(dependsOnMethods = "validateFooderLogoDisplayed")
    public void validateContactLabelText(){
        welcPage.checkContactLabelText();
    }
    @Test(dependsOnMethods = "validateFooderLogoDisplayed")
    public void validatePasswordLabelText(){
        welcPage.checkPasswordLabelText();
    }
    @Test(dependsOnMethods = "validatePasswordLabelText")
    public void validateForgetPasswordLabelText(){
        welcPage.checkForgetPasswordLabelText();
    }
    @Test (dependsOnMethods = "validateForgetPasswordLabelText")
    public void validateZohoDisplayed(){
        welcPage.checkZohoDisplayed();
    }
    @Test(dependsOnMethods = "validateZohoDisplayed")
    public void validateZohoOpenSuccessfully(){
        welcPage.checkZohoOpenSuccessfully();
    }
    @Test(dependsOnMethods = "validateZohoOpenSuccessfully")
    public void validateSignUpScreenOpenSuccessfully(){
        welcPage.checkSignUpLinkOpenSuccessfully();
    }

}
