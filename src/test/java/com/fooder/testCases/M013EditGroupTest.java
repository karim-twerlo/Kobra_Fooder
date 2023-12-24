package com.fooder.testCases;

import com.fooder.Pages.*;
import com.fooder.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.fooder.testBase.ReadProperties.*;

public class M013EditGroupTest extends BaseTest {
    P008CreateGroup group ;
    P003P001SettingsDashboardPage settings;
    P002DashBoardPage dashboard;
    P001WelcomePage wlcPage;
    P007CreateRolesPage role;
    P004BranchesPage branch;
    P005DeliveryAreaPage deliveryArea;
    P006EditBranchPage editBranch;
    P013EditGrop editGroup;


    @BeforeClass
    public void initiateObject() {
        dashboard = new P002DashBoardPage(driver);
        wlcPage = new P001WelcomePage(driver);
        settings= new P003P001SettingsDashboardPage(driver);
        role = new P007CreateRolesPage(driver);
        deliveryArea = new P005DeliveryAreaPage(driver);
        editBranch = new P006EditBranchPage(driver);
        branch = new P004BranchesPage(driver);
        group = new P008CreateGroup(driver);
        editGroup = new P013EditGrop(driver);

    }
    @Test(groups = "group")
    public void TC_002validateEditGroup(){
        wlcPage.loginWithValidateData(username, password);
        group.checkGroupCreation(Group_Name,Group_Localized_Name);
        editGroup.validateEditGroup(Product_name , true);
        dashboard.backToLoinScreen();

    }

    @Test(groups = "group")
    public void TC_001validateDefaultGroup(){
        wlcPage.loginWithValidateData(username, password);
        editGroup.validateDefaultGroup();
        dashboard.backToLoinScreen();

    }

}
