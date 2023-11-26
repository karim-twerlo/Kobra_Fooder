package com.fooder.Pages;

import com.fooder.PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WelcomePage extends PageBase {
    public WelcomePage(WebDriver driver) {
        super(driver);
    }
    private final By Fooder_Logo = By.cssSelector("img[alt='brand-logo']");
    private final By contact_label = By.cssSelector("label[for='contact']");
    private final By password_Label = By.cssSelector("label[for='password']");
    private final By Forget_password_label = By.xpath("//a[@href='/auth/forgot-password']");
    private final By Sub_Title_Text = By.xpath("//h1[@class='title mb-1']");
    private final By Login_To_Your_Acc_Sub_Title = By.xpath("//p[@class='subtitle']");
    private final By Zoho_chat_bot = By.id("zohohc-asap-web-launcherbox");
    private final By Zoho_chat_Home = By.xpath("//span[@class='zohohc-c4e6cc89c5 zohohc-36bf2072ee']");
    private final By Language_Zoho = By.xpath("//div[@class='zohohc-0afe37d1a4']");

    public void checkFooderLogo(){
        waitForVisibilityOfElement(Fooder_Logo);
        Assert.assertTrue(driver.findElement(Fooder_Logo).isDisplayed());
    }
    public void checkSubTitleText(){
        Assert.assertTrue(checkForLocalization(Sub_Title_Text ,
                "Welcome Back to Fooder!","مرحبًا بك مرة أخرى في فودر"));
    }
    public void checkContactLabelText(){
        Assert.assertTrue(checkForLocalization(contact_label ,
                "WhatsApp Number","رقم الواتس اب"));
    }
    public void checkPasswordLabelText(){
        Assert.assertTrue(checkForLocalization(password_Label ,
                "Password","كلمة المرور"));
    }
    public void checkForgetPasswordLabelText(){
        Assert.assertTrue(checkForLocalization(Forget_password_label ,
                "Forgot Password?","هل نسيت كلمة السر؟"));
    }
    public void checkLoginToYourAccountSubTitleText(){
        Assert.assertTrue(checkForLocalization(Login_To_Your_Acc_Sub_Title ,
                "Sign in to your account","تسجيل الدخول إلى حسابك"));
    }
    public void checkZohoDisplayed(){
        Assert.assertTrue(assertElementDisplayed(Zoho_chat_bot));
    }
    public void checkZohoOpenSuccessfully(){
        clickOnelement(Zoho_chat_bot);
        Assert.assertTrue(assertElementDisplayed(Zoho_chat_Home));
        System.out.println("**** " + driver.findElement(Language_Zoho).getText());
        Assert.assertTrue(checkForLocalization(Zoho_chat_Home ,
                "Home","الرئيسية",Language_Zoho));
    }
}
