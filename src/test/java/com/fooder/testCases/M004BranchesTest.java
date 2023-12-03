package com.fooder.testCases;

import com.fooder.Pages.P002DashBoardPage;
import com.fooder.Pages.P003P001SettingsDashboardPage;
import com.fooder.Pages.P001WelcomePage;
import com.fooder.Pages.P004BranchesPage;
import com.fooder.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.fooder.testBase.ReadProperties.*;

public class M004BranchesTest extends BaseTest {
    P003P001SettingsDashboardPage settings;
    P002DashBoardPage dashboard;
    P001WelcomePage wlcPage;
    P004BranchesPage branch;

    @BeforeClass
    public void initiateObject() {
        dashboard = new P002DashBoardPage(driver);
        wlcPage = new P001WelcomePage(driver);
        settings= new P003P001SettingsDashboardPage(driver);
        branch = new P004BranchesPage(driver);
    }

    @Test(groups = "createBranch")
    public void TC_001ValidateAllFlowsOFBranchCreatedSuccessfully() {
        wlcPage.loginWithValidateData(username, password);
        dashboard.openSettingsMenu();
        settings.checkBranchesSettings();
        branch.checkCreateBranchesOpenSuccessfully();
        branch.checkBackArrowFunctionality();
        settings.checkBranchesSettings();
        branch.checkCreateBranchesOpenSuccessfully();
        branch.checkErrorMessagesForBranchesScreen();
        settings.checkBranchesSettings();
        branch.checkBranchCreation(Branch_Name_Localized,Branch_Name,Contact_Name , Contact_Number
        ,Location , City , state , Country ,MapSearch );
        settings.checkBranchesSettings();
        branch.deleteBranch();
    }

    @Test(groups = "createBranch")
    public void TC_002ValidateBackArrowFunctionality(){
        settings.checkBranchesSettings();
        branch.checkCreateBranchesOpenSuccessfully();
        branch.checkBackArrowFunctionality();
        settings.checkBranchesSettings();
    }
    @Test(groups = "createBranch")
    public void TC_003validateErrorMessagesForBranchesScreen(){
        settings.checkBranchesSettings();
        branch.checkCreateBranchesOpenSuccessfully();
        branch.checkErrorMessagesForBranchesScreen();
        settings.checkBranchesSettings();
    }

}
