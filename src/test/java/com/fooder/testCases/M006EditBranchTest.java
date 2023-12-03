package com.fooder.testCases;

import com.fooder.Pages.*;
import com.fooder.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.fooder.testBase.ReadProperties.*;
import static com.fooder.testBase.ReadProperties.deliveryAreaType;

public class M006EditBranchTest extends BaseTest {
    P003P001SettingsDashboardPage settings;
    P002DashBoardPage dashboard;
    P001WelcomePage wlcPage;
    P004BranchesPage branch;
    P005DeliveryAreaPage deliveryArea;
    P006EditBranchPage editBranch ;

    @BeforeClass
    public void initiateObject() {
        dashboard = new P002DashBoardPage(driver);
        wlcPage = new P001WelcomePage(driver);
        settings= new P003P001SettingsDashboardPage(driver);
        branch = new P004BranchesPage(driver);
        deliveryArea = new P005DeliveryAreaPage(driver);
        editBranch = new P006EditBranchPage(driver);
    }
    @Test(groups = "editBranch")
    public void TC_001validateEditBranch(){
        wlcPage.loginWithValidateData(username, password);
        dashboard.openSettingsMenu();
        settings.checkBranchesSettings();
        branch.checkBranchCreation(Branch_Name_Localized,Branch_Name,Contact_Name , Contact_Number
                ,Location , City , state , Country ,MapSearch );
        deliveryArea.checkDeliveryAreaCreationFunctionality(deliveryAreaName,deliveryDistance,deliveryFees,extraDistanceFees ,deliveryAreaType );
        settings.checkBranchesSettings();
        editBranch.clickToEditBranch();
        editBranch.editBasicInfoOfBranch(Branch_Name_Localized , New_Branch_Name_Localized);
        editBranch.EnableOrderTypeSections();
        editBranch.EnablePaymentMethodsSections();
        editBranch.editBranchOperations(Mini_Card_Value ,  Average_Cancellation_Time,  Max_Cash_Value ,  Average_Preparation_Time);
        editBranch.branchTimingSection();
        settings.checkBranchesSettings();
        branch.deleteBranch();
    }
}
