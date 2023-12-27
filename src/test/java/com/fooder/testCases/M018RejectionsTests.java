package com.fooder.testCases;

import com.fooder.Pages.*;
import com.fooder.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.fooder.testBase.ReadProperties.*;
import static com.fooder.testBase.ReadProperties.Branch_Name;

public class M018RejectionsTests extends BaseTest {
    P003P001SettingsDashboardPage settings;
    P002DashBoardPage dashboard;
    P001WelcomePage wlcPage;
    P018RejectionsPage rejections;

    @BeforeClass
    public void initiateObject() {
        dashboard = new P002DashBoardPage(driver);
        wlcPage = new P001WelcomePage(driver);
        settings= new P003P001SettingsDashboardPage(driver);
        rejections = new P018RejectionsPage(driver);

    }
    @Test
    public void validateDeliveryCreation(){
        wlcPage.loginWithValidateData(username, password);
        dashboard.openSettingsMenu();
        rejections.checkRejectionNotes();
    }
}
