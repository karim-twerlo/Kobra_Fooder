package com.fooder.testCases;

import com.fooder.Pages.*;
import com.fooder.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.fooder.testBase.ReadProperties.*;

public class M005DeliveryAreaTest extends BaseTest {
    P003P001SettingsDashboardPage settings;
    P002DashBoardPage dashboard;
    P001WelcomePage wlcPage;
    P004BranchesPage branch;
    P005DeliveryAreaPage deliveryArea;

    @BeforeClass
    public void initiateObject() {
        dashboard = new P002DashBoardPage(driver);
        wlcPage = new P001WelcomePage(driver);
        settings= new P003P001SettingsDashboardPage(driver);
        branch = new P004BranchesPage(driver);
        deliveryArea = new P005DeliveryAreaPage(driver);
    }
    @Test
    public void TC_001validateDeliveryAreaCreation(){
        wlcPage.loginWithValidateData(username, password);
        dashboard.openSettingsMenu();
        settings.checkBranchesSettings();
        branch.checkBranchCreation(Branch_Name_Localized,Branch_Name,Contact_Name , Contact_Number
                ,Location , City , state , Country ,MapSearch );
        deliveryArea.checkErrorMessageForEachInputField();
        deliveryArea.checkDeliveryAreaCreationFunctionality(deliveryAreaName,deliveryDistance,deliveryFees,extraDistanceFees ,deliveryAreaType );
        settings.checkBranchesSettings();
        branch.deleteBranch();

    }

}
