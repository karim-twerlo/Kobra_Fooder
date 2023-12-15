package com.fooder.testCases;

import com.fooder.Pages.*;
import com.fooder.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.fooder.testBase.ReadProperties.*;
import static com.fooder.testBase.ReadProperties.Branch_Name_Localized;

public class M015EditOptionsTest extends BaseTest {
    P002DashBoardPage dashboard;
    P001WelcomePage wlcPage;
    P014CreateOptions option;
    P015EditOptionsPage editOption;


    @BeforeClass
    public void initiateObject() {
        dashboard = new P002DashBoardPage(driver);
        wlcPage = new P001WelcomePage(driver);
        option = new P014CreateOptions(driver);
        editOption = new P015EditOptionsPage(driver);

    }
    @Test
    public void TC_01validateDeactivateProduct(){
        wlcPage.loginWithValidateData(username, password);
        option.validateProductCreation(Modifier_Name,Option_tax_Group,Option_costing_Method,Option_name,Option_localized_name,
                Option_calories,Option_price,Option_sku,false);
        editOption.checkDeactivateProduct("1");
        option.checkDeleteModifier();
        dashboard.backToLoinScreen();
    }

    @Test
    public void TC_02validateEditProduct(){
        wlcPage.loginWithValidateData(username, password);
        option.validateProductCreation(Modifier_Name,Option_tax_Group,Option_costing_Method,Option_name,Option_localized_name,
                Option_calories,Option_price,Option_sku,false);
        editOption.checkEditOption("1",New_Modifier_Name,Branch_Name_Localized);
        option.checkDeleteModifier();
        dashboard.backToLoinScreen();
    }

}
