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
    public void TC_01validateLiveOrder(){
        wlcPage.loginWithValidateData(username, password);
        liveOrder.checkLiveOrderCreation("karim_twerlo","1270020414",Branch_Name , Category_Name,Product_name , 4 , true , true);
//        dashboard.backToLoinScreen();
    }



}
