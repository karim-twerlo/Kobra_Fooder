package com.fooder.testCases;

import com.fooder.Pages.*;
import com.fooder.testBase.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.fooder.testBase.ReadProperties.*;
import static com.fooder.testBase.ReadProperties.Branch_Name_Localized;

public class M016LiverOrderTest extends BaseTest {
    P002DashBoardPage dashboard;
    P001WelcomePage wlcPage;
    P016LiveOrder liveOrder;


    @BeforeClass
    public void initiateObject() {
        dashboard = new P002DashBoardPage(driver);
        wlcPage = new P001WelcomePage(driver);
        liveOrder = new P016LiveOrder(driver);

    }
    @Test
    public void TC_01validateLiveOrdersAllScenarios(){
        wlcPage.loginWithValidateData(username, password);
        liveOrder.checkLiveOrderCreation(Client_Name,Client_Mobile,Branch_Name , Category_Name,Product_name , 1 , false , true , true);
        liveOrder.checkLiveOrderCreation(Client_Name,Client_Mobile,Branch_Name , Category_Name,Product_name , 2 , false , false , false);
        liveOrder.checkLiveOrderCreation(Client_Name,Client_Mobile,Branch_Name , Category_Name,Product_name , 3 , true , true , false);
        liveOrder.checkLiveOrderCreation(Client_Name,Client_Mobile,Branch_Name , Category_Name,Product_name , 4 , true , false ,false);
        dashboard.backToLoinScreen();
    }



}
