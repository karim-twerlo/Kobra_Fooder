package com.fooder.testCases;

import com.fooder.Pages.DashBoardPage;
import com.fooder.Pages.SettingsDashboarddPage;
import com.fooder.Pages.WelcomePage;
import com.fooder.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class M003DashboardSettingsTest extends BaseTest {
    SettingsDashboarddPage settings;
    DashBoardPage dashboard;
    WelcomePage wlcPage;

    @BeforeClass
    public void initiateObject() {
        dashboard = new DashBoardPage(driver);
        wlcPage = new WelcomePage(driver);
        settings= new SettingsDashboarddPage(driver);
    }
    @Test
    public void validateSettingsItems(){
        wlcPage.loginWithValidateData(username,password);
        dashboard.openSettingsMenu();
        settings.checkSettingsMenuItems();
    }
}
