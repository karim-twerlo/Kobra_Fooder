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
        liveOrder.checkLiveOrderScreen();
        liveOrder.checkLiveOrderCreation("fawzydriver" ,Client_Location ,"karim","1270020414","34015MoonValley","29539category","35606Chicken","55036Option", 1 ,Client_Notes, false , true ,false, false);
        liveOrder.checkLiveOrderCreation("fawzydriver" ,Client_Location ,"karim","1270020414","34015MoonValley","29539category","35606Chicken","55036Option", 1 ,Client_Notes, false , false ,true, false);
        liveOrder.checkLiveOrderCreation("fawzydriver" ,Client_Location ,"karim","1270020414","34015MoonValley","29539category","35606Chicken","55036Option", 1 ,Client_Notes, true , true ,true, false);
        liveOrder.checkLiveOrderCreation("fawzydriver" , Client_Location ,"karim","1270020414","34015MoonValley","29539category","35606Chicken","55036Option", 1 ,Client_Notes, true , false ,false, false);
        dashboard.backToLoinScreen();
    }



}
