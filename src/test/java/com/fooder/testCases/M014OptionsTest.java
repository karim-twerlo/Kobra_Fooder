package com.fooder.testCases;

import com.fooder.Pages.*;
import com.fooder.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.fooder.testBase.ReadProperties.*;
import static com.fooder.testBase.ReadProperties.Branch_Name_Localized;

public class M014OptionsTest extends BaseTest {
    P002DashBoardPage dashboard;
    P001WelcomePage wlcPage;
    P010CreateProduct product;
    P012EditProduct editProduct;
    P014CreateOptions option;


    @BeforeClass
    public void initiateObject() {
        dashboard = new P002DashBoardPage(driver);
        wlcPage = new P001WelcomePage(driver);
        product = new P010CreateProduct(driver);
        editProduct = new P012EditProduct(driver);
        option = new P014CreateOptions(driver);

    }


    @Test
    public void TC_02validateCreateOption(){
        wlcPage.loginWithValidateData(username, password);
        option.validateProductCreation(Modifier_Name,Option_tax_Group,Option_costing_Method,Option_name,Option_localized_name,
                Option_calories,Option_price,Option_sku,false);

        dashboard.backToLoinScreen();
    }
}

