package com.fooder.testCases;

import com.fooder.Pages.*;
import com.fooder.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.fooder.testBase.ReadProperties.*;

public class M009CreateCategory extends BaseTest {
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
}
