package com.fooder.testCases;

import com.fooder.Pages.P001WelcomePage;
import com.fooder.Pages.P002DashBoardPage;
import com.fooder.Pages.P010CreateProduct;
import com.fooder.Pages.P011CreateModifiers;
import com.fooder.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.fooder.testBase.ReadProperties.*;

public class M011ModifierTest extends BaseTest {
    P002DashBoardPage dashboard;
    P001WelcomePage wlcPage;
    P010CreateProduct product;
    P011CreateModifiers modifier;


    @BeforeClass
    public void initiateObject() {
        dashboard = new P002DashBoardPage(driver);
        wlcPage = new P001WelcomePage(driver);
        product = new P010CreateProduct(driver);
        modifier = new P011CreateModifiers(driver);


    }
    @Test
    public void TC_001validateModifierCreation(){
        wlcPage.loginWithValidateData(username, password);
        modifier.checkModifierCreation(Modifier_Name ,Modifier_Localized_Name ,Modifier_Reference );
        dashboard.backToLoinScreen();
    }
    @Test
    public void TC_003validateEditModifier(){
        wlcPage.loginWithValidateData(username, password);
        modifier.checkModifierCreation(Modifier_Name ,Modifier_Localized_Name ,Modifier_Reference);
        modifier.EditModifier(New_Modifier_Name , New_Modifier_Localized_Name , New_Modifier_Reference);
        dashboard.backToLoinScreen();
    }
    @Test
    public void TC_002validateDeActivateModifier(){
        wlcPage.loginWithValidateData(username, password);
        modifier.checkModifierCreation(Modifier_Name ,Modifier_Localized_Name ,Modifier_Reference);
        modifier.DeActivateModifier();
        dashboard.backToLoinScreen();
    }
}
