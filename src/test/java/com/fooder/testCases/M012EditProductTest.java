package com.fooder.testCases;

import com.fooder.Pages.P001WelcomePage;
import com.fooder.Pages.P002DashBoardPage;
import com.fooder.Pages.P010CreateProduct;
import com.fooder.Pages.P012EditProduct;
import com.fooder.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.fooder.testBase.ReadProperties.*;

public class M012EditProductTest extends BaseTest {
    P002DashBoardPage dashboard;
    P001WelcomePage wlcPage;
    P010CreateProduct product;
    P012EditProduct editProduct;


    @BeforeClass
    public void initiateObject() {
        dashboard = new P002DashBoardPage(driver);
        wlcPage = new P001WelcomePage(driver);
        product = new P010CreateProduct(driver);
        editProduct = new P012EditProduct(driver);

    }
    @Test
    public void TC_01validateDeactivateProduct(){
        wlcPage.loginWithValidateData(username, password);
        product.validateProductCreation(Category_Name,Product_tax_Group,Product_costing_Method,Product_name,Product_desc,
                Product_descLocalized,Product_localized_name,Product_calories,Product_price,Product_sku,Product_prepTime,false);
        editProduct.checkDeactivateProduct("1");
//        dashboard.backToLoinScreen();
    }

    @Test
    public void TC_0validateEditProduct(){
        wlcPage.loginWithValidateData(username, password);
        product.validateProductCreation(Category_Name,Product_tax_Group,Product_costing_Method,Product_name,Product_desc,
                Product_descLocalized,Product_localized_name,Product_calories,Product_price,Product_sku,Product_prepTime,false);
        editProduct.checkEditProduct("1");
//        dashboard.backToLoinScreen();
    }
}
