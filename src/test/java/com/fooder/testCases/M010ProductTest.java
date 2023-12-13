package com.fooder.testCases;

import com.fooder.Pages.*;
import com.fooder.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.fooder.testBase.ReadProperties.*;

public class M010ProductTest extends BaseTest {
    P002DashBoardPage dashboard;
    P001WelcomePage wlcPage;
    P010CreateProduct product;


    @BeforeClass
    public void initiateObject() {
        dashboard = new P002DashBoardPage(driver);
        wlcPage = new P001WelcomePage(driver);
        product = new P010CreateProduct(driver);

    }
    @Test
    public void TC_01validateCreateProduct(){
        wlcPage.loginWithValidateData(username, password);
        product.validateProductCreation(Category_Name,Product_tax_Group,Product_costing_Method,Product_name,Product_desc,
                Product_descLocalized,Product_localized_name,Product_calories,Product_price,Product_sku,Product_prepTime,false);
        dashboard.backToLoinScreen();
    }


}
