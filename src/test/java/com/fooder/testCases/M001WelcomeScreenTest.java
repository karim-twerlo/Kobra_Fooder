package com.fooder.testCases;

import com.fooder.Pages.WelcomePage;
import com.fooder.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class M001WelcomeScreenTest extends BaseTest {
    WelcomePage welcPage;
    @BeforeClass
    public void initiateObject(){
        welcPage = new WelcomePage(driver);
    }
    @Test(groups = "welcome")
    public void TC_Welcome01_validateFooderLogoDisplayed(){
        welcPage.checkFooderLogo();
    }
    @Test(groups = "welcome")
    public void TC_Welcome02_validateSubTitleText(){
        welcPage.checkSubTitleText();
    }
    @Test(groups = "welcome")
    public void TC_Welcome03_validateLoginToYourAccSubTitleText(){
        welcPage.checkLoginToYourAccountSubTitleText();
    }

    @Test(groups = "welcome")
    public void TC_Welcome04_validateContactLabelText(){
        welcPage.checkContactLabelText();
    }
    @Test(groups = "welcome")
    public void TC_Welcome05_validatePasswordLabelText(){
        welcPage.checkPasswordLabelText();
    }
    @Test(groups = "welcome")
    public void TC_Welcome06_validateForgetPasswordLabelText(){
        welcPage.checkForgetPasswordLabelText();
    }
    @Test (groups = "welcome")
    public void TC_Welcome07_validateZohoDisplayed(){
        welcPage.checkZohoDisplayed();
    }
    @Test(groups = "welcome")
    public void TC_Welcome08_validateZohoOpenSuccessfully(){
        welcPage.checkZohoOpenSuccessfully();
    }
    @Test(groups = "welcome")
    public void TC_Welcome12_validateSignUpScreenOpenSuccessfully(){
        welcPage.checkSignUpLinkOpenSuccessfully(URL);
    }
    @Test(groups = "welcome")
    public void TC_Welcome09_validateCountryAndCountryCode(){
        welcPage.checkCountryAndCountryCode();
    }
    @Test(groups = "welcome")
    public void TC_Welcome10_validateEgyptAfterSelecting(){
        welcPage.checkEgyptSelected();
    }
    @Test(groups = "welcome")
    public void TC_Welcome11_ValidateForgetPasswordJourney(){
        welcPage.checkForgetPasswordJourney(URL);
    }
    @Test(groups = "login" )
    public void TC_Welcome15_ValidateLoginWithValidData(){
        welcPage.loginWithValidateData(username,password);
    }
    @Test(groups = "login")
    public void TC_Welcome14_validateLoginWithInvalidDataInput(){
        welcPage.loginWithInValidPassword(username);
    }
    @Test(groups = "login")
    public void TC_Welcome13_validateLoginWithInvalidNumberOrPassword(){
        welcPage.checkErrorMessageForInvalidNumberOrPassword();
    }

}
