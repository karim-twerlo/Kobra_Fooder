package com.fooder.testCases;

import com.fooder.Pages.P002DashBoardPage;
import com.fooder.Pages.P001WelcomePage;
import com.fooder.testBase.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.fooder.testBase.ReadProperties.password;
import static com.fooder.testBase.ReadProperties.username;

public class M002DashboardScreenTest extends BaseTest {
    P002DashBoardPage dashboard = new P002DashBoardPage((WebDriver) driver);
    P001WelcomePage wlcPage = new P001WelcomePage((WebDriver) driver);

    @BeforeClass
    public void initiateObject() {
        dashboard = new P002DashBoardPage((WebDriver) driver);
        wlcPage = new P001WelcomePage(driver);
    }

    @Test
    public void validateDashboardLoadedSuccessfully() {
        wlcPage.loginWithValidateData(username , password);
        dashboard.checkDashboardLoadedSuccessfully();
    }
}