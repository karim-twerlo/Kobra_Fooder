package com.fooder.testCases;

import com.fooder.Pages.*;
import com.fooder.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.fooder.testBase.ReadProperties.*;

public class M017DeliveryManagementTest extends BaseTest {
    P003P001SettingsDashboardPage settings;
    P002DashBoardPage dashboard;
    P001WelcomePage wlcPage;
    P017DeliveryManagement delivery;

    @BeforeClass
    public void initiateObject() {
        dashboard = new P002DashBoardPage(driver);
        wlcPage = new P001WelcomePage(driver);
        settings= new P003P001SettingsDashboardPage(driver);
        delivery = new P017DeliveryManagement(driver);

    }
    @Test
    public void validateDeliveryCreation(){
        wlcPage.loginWithValidateData(username, password);
        dashboard.openSettingsMenu();
        delivery.checkCreateDelivery(Driver_Name, Branch_Name);
    }

}
//checkCreateDelivery