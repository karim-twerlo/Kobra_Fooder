package com.fooder.testCases;

import com.fooder.Pages.*;
import com.fooder.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.fooder.testBase.ReadProperties.*;

public class M009CreateCategoryTest extends BaseTest {
    P008CreateGroup group ;
    P003P001SettingsDashboardPage settings;
    P002DashBoardPage dashboard;
    P001WelcomePage wlcPage;
    P007CreateRolesPage role;
    P004BranchesPage branch;
    P005DeliveryAreaPage deliveryArea;
    P006EditBranchPage editBranch;
    P009CreateCategory category;


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
        category = new P009CreateCategory(driver);

    }
    @Test(groups = "Category")
    public void validateCreateCategory(){
        wlcPage.loginWithValidateData(username, password);
        category.checkCreateCategory(Category_Name ,Category_localizedName , Category_description , Category_localizedDescription , false);

    }
    @Test(groups = "Category")
    public void validateEditCategory(){
        wlcPage.loginWithValidateData(username, password);
        category.checkEditCategory(Category_Name ,Category_localizedName , Category_description , Category_localizedDescription , false , "1");

    }
    @Test
    public void validateE22ETillCategory(){
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
        editBranch.checkOrderScheduling();
        role.createRole( Role_name_m ,   Role_password_m ,  Role_email_m ,  Role_m ,Branch_Name_Localized);
        role.createRole( Role_name_l ,   Role_password_l ,  Role_email_l ,  Role_l ,Branch_Name_Localized);
        role.createRole( Role_name_c ,   Role_password_c ,  Role_email_c ,  Role_c ,Branch_Name_Localized);
        settings.checkBranchesSettings();
//        settings.checkBranchesSettings();
        branch.deleteBranch();
        category.checkEditCategory(Category_Name ,Category_localizedName , Category_description , Category_localizedDescription , false , "1");

    }
}
