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
    @Test
    public void validateLogo(){
        welcPage.validateLogo();
    }
    @Test(dependsOnMethods = "validateLogo")
    public void validateLogo2(){
        welcPage.validateContactLabel();
    }
}
