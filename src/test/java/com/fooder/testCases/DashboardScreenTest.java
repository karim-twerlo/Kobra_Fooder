package com.fooder.testCases;

import com.fooder.Pages.DashBoardPage;
import com.fooder.Pages.WelcomePage;
import com.fooder.testBase.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DashboardScreenTest extends BaseTest {
    DashBoardPage dashboard = new DashBoardPage((WebDriver) driver);
    WelcomePage wlcPage = new WelcomePage((WebDriver) driver);

    @BeforeClass
    public void initiateObject() {
        dashboard = new DashBoardPage((WebDriver) driver);
        wlcPage = new WelcomePage(driver);
    }

    @Test
    public void validateDashboardLoadedSuccessfully() {
        wlcPage.loginWithValidateData(username , password);
        dashboard.checkDashboardLoadedSuccessfully();
    }
}