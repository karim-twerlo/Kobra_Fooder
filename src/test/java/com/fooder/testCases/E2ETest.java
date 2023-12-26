package com.fooder.testCases;

import com.fooder.Pages.*;
import com.fooder.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.fooder.testBase.ReadProperties.*;

public class E2ETest extends BaseTest {
    P002DashBoardPage dashboard;
    P001WelcomePage wlcPage;
    P016LiveOrder liveOrder;
    P003P001SettingsDashboardPage settings;
    P004BranchesPage branch;
    P005DeliveryAreaPage deliveryArea;
    P006EditBranchPage editBranch ;
    P007CreateRolesPage role;
    P009CreateCategory category;
    P013EditGrop editGroup;
    P008CreateGroup group;
    P010CreateProduct product;
    P012EditProduct editProduct;
    P014CreateOptions option;
    P015EditOptionsPage editOption;
    P017DeliveryManagement delivery;
    P011CreateModifiers modifier;

    @BeforeClass
    public void initiateObject() {
        dashboard = new P002DashBoardPage(driver);
        wlcPage = new P001WelcomePage(driver);
        liveOrder = new P016LiveOrder(driver);
        settings= new P003P001SettingsDashboardPage(driver);
        branch = new P004BranchesPage(driver);
        deliveryArea = new P005DeliveryAreaPage(driver);
        editBranch = new P006EditBranchPage(driver);
        role = new P007CreateRolesPage(driver);
        category = new P009CreateCategory(driver);
        group = new P008CreateGroup(driver);
        editGroup = new P013EditGrop(driver);
        product = new P010CreateProduct(driver);
        editProduct = new P012EditProduct(driver);
        option = new P014CreateOptions(driver);
        editOption = new P015EditOptionsPage(driver);
        delivery = new P017DeliveryManagement(driver);
        modifier = new P011CreateModifiers(driver);

    }
    @Test
    public void TC_01E2EFromLoginTillCreateOrder(){
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
        settings.checkBranchesSettings();
        role.createRole( Role_name_m ,   Role_password_m ,  Role_email_m ,  Role_m ,Branch_Name_Localized);
        role.createRole( Role_name_l ,   Role_password_l ,  Role_email_l ,  Role_l ,Branch_Name_Localized);
        role.createRole( Role_name_c ,   Role_password_c ,  Role_email_c ,  Role_c ,Branch_Name_Localized);
        delivery.checkCreateDelivery(Driver_Name, Branch_Name);
        settings.checkBranchesSettings();
        category.checkCreateCategory(Category_Name ,Category_localizedName , Category_description , Category_localizedDescription , false);
        editGroup.validateDefaultGroup();
        modifier.checkModifierCreation(Modifier_Name ,Modifier_Localized_Name ,Modifier_Reference );

        option.validateProductCreation(Modifier_Name,Option_tax_Group,Option_costing_Method,Option_name,Option_localized_name,
                Option_calories,Option_price,Option_sku,false);
        editOption.checkEditOption("1",New_Modifier_Name,Branch_Name_Localized);
        product.validateProductCreation(Category_Name,Product_tax_Group,Product_costing_Method,Product_name,Product_desc,
                Product_descLocalized,Product_localized_name,Product_calories,Product_price,Product_sku,Product_prepTime,false);
        editProduct.checkEditProduct("1",Modifier_Name,Branch_Name_Localized);
        group.checkGroupCreation(Group_Name,Group_Localized_Name);
        editGroup.validateEditGroup(Product_name , true);
        liveOrder.checkLiveOrderCreation("fawzydriver" ,Client_Location ,"karim","1270020414","34015MoonValley","29539category","35606Chicken","55036Option", 1 ,Client_Notes, false , true ,false, false);
        liveOrder.checkLiveOrderCreation("fawzydriver" ,Client_Location ,"karim","1270020414","34015MoonValley","29539category","35606Chicken","55036Option", 1 ,Client_Notes, false , false ,true, false);
        liveOrder.checkLiveOrderCreation("fawzydriver" ,Client_Location ,"karim","1270020414","34015MoonValley","29539category","35606Chicken","55036Option", 1 ,Client_Notes, true , true ,true, false);
        liveOrder.checkLiveOrderCreation("fawzydriver" , Client_Location ,"karim","1270020414","34015MoonValley","29539category","35606Chicken","55036Option", 1 ,Client_Notes, true , false ,false, false);

    }


    

}
