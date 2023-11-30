package com.fooder.Pages;

import com.fooder.PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P002DashBoardPage extends PageBase {

    public P002DashBoardPage(WebDriver driver) {
        super(driver);
    }
    private final By Small_Logo =By.xpath("//img[@class='menu-header__img']");
    private final By Toggle_Menu_Icon = By.xpath("//a[@class='nav-link modern-nav-toggle d-none d-xl-block']");
    private final By Down_Arrow = By.xpath("//div[@class='menu-header']//button[@class='menu-header__info']//*[name()='svg']");
    private final By Business_ID = By.xpath("//span[@class='font-weight-normal font-small-1']");
    private final By Settings_Icon = By.xpath("//div[@class='main-menu-content']//a[2]//*[name()='svg']");
    private final By Plus_Icon = By.xpath("//div[@class='d-flex align-items-center justify-content-between font-small-1 px-75']//a[1]//*[name()='svg']");
    private final By Correct_Sign = By.xpath("//a[@class='menu-header__link mt-50']//button[@class='menu-header__info']//*[name()='svg']");
    private final By Menu = By.xpath("(//span[@class='menu-title text-truncate mx-75' and contains(text(),'Menu') or contains(text(),'القائمة')])[2]");
    private final By Settings = By.xpath("(//span[@class='menu-title text-truncate mx-75' and contains(text(),'Settings') or contains(text(),'الإعدادات')])[1]");
    public void checkDashboardLoadedSuccessfully(){
        checkFirstSide();
        checkLogoDropdown();
        checkMenuLinks();
    }
    private void checkLogoDropdown(){
        Assert.assertTrue(checkForLocalization(Business_ID,"Business ID" , "معرف العمل"));
        Assert.assertTrue(assertElementDisplayed(Settings_Icon));
        Assert.assertTrue(assertElementDisplayed(Plus_Icon));
        Assert.assertTrue(assertElementDisplayed(Correct_Sign));
    }
    private void checkFirstSide(){
       scrollToElement(Small_Logo);
        Assert.assertTrue(assertElementDisplayed(Small_Logo));
        Assert.assertTrue(assertElementDisplayed(Toggle_Menu_Icon));
        scrollToElement(Down_Arrow);
        Assert.assertTrue(assertElementDisplayed(Down_Arrow));
        clickOnelement(Down_Arrow);
    }
    private By gitMenuLinksLocators(String English , String arabic){
        return By.xpath("//span[@class='menu-title text-truncate mx-75' and (text()='" + English + "' or text()='" + arabic +  "')]");
    }
    private void checkGetStarted(){
        Assert.assertTrue(assertElementDisplayed(gitMenuLinksLocators("Get started" , "هيا نبدأ")));
    }
    private void checkReports(){
        Assert.assertTrue(assertElementDisplayed(gitMenuLinksLocators("Reports" , "التقارير")));
    }
    private void checkAnalytics(){
        Assert.assertTrue(assertElementDisplayed(gitMenuLinksLocators("Analytics" , "التحليلات")));
    }
    private void checkOperations(){
        Assert.assertTrue(assertElementDisplayed(gitMenuLinksLocators("Operations" , "العمليات")));
    }
    private void checkReviews(){
        Assert.assertTrue(assertElementDisplayed(gitMenuLinksLocators("Reviews" , "المراجعات")));
    }
    private void checkMenu(){
        Assert.assertTrue(assertElementDisplayed(Menu));
        Assert.assertTrue(checkForLocalization(Menu,"Menu" , "القائمة"));
    }
    private void checkMarketing(){
        scrollToElement(gitMenuLinksLocators("Marketing" , "التسويق"));
        Assert.assertTrue(assertElementDisplayed(gitMenuLinksLocators("Marketing" , "التسويق")));
    }
    private void checkMessaging(){
        scrollToElement(gitMenuLinksLocators("Messaging" , "المراسلة"));
        Assert.assertTrue(assertElementDisplayed(gitMenuLinksLocators("Messaging" , "المراسلة")));
    }
    private void checkFooderSolutions(){
        scrollToElement(gitMenuLinksLocators("Fooder solutions" , "حلول فودر"));
        Assert.assertTrue(assertElementDisplayed(gitMenuLinksLocators("Fooder solutions" , "حلول فودر")));
    }
    private void checkSettings(){
        Assert.assertTrue(assertElementDisplayed(Settings));
        Assert.assertTrue(checkForLocalization(Settings,"Settings" , "الإعدادات"));
    }
    private void checkDashboard(){
        Assert.assertTrue(assertElementDisplayed(gitMenuLinksLocators("Dashboard" , "لوحة القيادة")));
    }
    private void checkLiveOrders(){
        Assert.assertTrue(assertElementDisplayed(gitMenuLinksLocators("Dashboard" , "لوحة القيادة")));
        clickOnelement(gitMenuLinksLocators("Live orders" , "الطلبات الحية"));
    }
    private void checkMenuLinks(){
        checkSettings();
        checkMenu();
        checkDashboard();
        checkAnalytics();
        checkGetStarted();
        checkReports();
        checkReviews();
        checkLiveOrders();
        checkMarketing();
        checkMessaging();
        checkFooderSolutions();
        checkOperations();

    }
    public void openSettingsMenu(){
        Assert.assertTrue(assertElementDisplayed(Settings));
        Assert.assertTrue(checkForLocalization(Settings,"Settings" , "الإعدادات"));
        clickOnelement(Settings);
    }

}
