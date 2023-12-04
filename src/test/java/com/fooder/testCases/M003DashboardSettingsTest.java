package com.fooder.testCases;

import com.fooder.Pages.P002DashBoardPage;
import com.fooder.Pages.P003P001SettingsDashboardPage;
import com.fooder.Pages.P001WelcomePage;
import com.fooder.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.fooder.testBase.ReadProperties.password;
import static com.fooder.testBase.ReadProperties.username;

public class M003DashboardSettingsTest extends BaseTest {
    P003P001SettingsDashboardPage settings;
    P002DashBoardPage dashboard;
    P001WelcomePage wlcPage;

    @BeforeClass
    public void initiateObject() {
        dashboard = new P002DashBoardPage(driver);
        wlcPage = new P001WelcomePage(driver);
        settings= new P003P001SettingsDashboardPage(driver);
    }
    @Test(groups = "settingsItems")
    public void validateSettingsItems(){
        wlcPage.loginWithValidateData(username,password);
        dashboard.openSettingsMenu();
        settings.checkSettingsMenuItems();
    }
}
