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
    private final By Zoho_chat_Home = By.xpath("//span[@class='zohohc-7163ec77ec zohohc-31dc758684']");
    private final By Language_Zoho = By.xpath("//div[@class='zohohc-763e08d653']");
    private final By Zoho_Close = By.id("zohohc-asap-web-closemain");
    private final By sign_up  = By.xpath("//a[@href='/onboarding']");
    private final By Register_SubTitle = By.xpath("//p[@class='onboarding__subtitle']");
    private final By Country = By.xpath("//img[@alt='country']");
    private final By CountryCode = By.xpath("//span[@class='phoneInput-country_code']");
    private final By Phone_code = By.xpath("//span[@class='phoneInput-number_dialCode']");
    private final By SearchCountriesBar = By.xpath("//input[@placeholder='أبحث' or @placeholder='Search']");
    private final By Countries_List = By.xpath("//button[@type='button']");
    private final By Egypt_Country = By.xpath("//span[contains(text(),'Egypt (‫مصر‬‎)')]");
    private final By Forget_Password_Page_Title = By.xpath("//span[contains(text(),'Please enter the contact associated with your cont') or contains(text(),'الرجاء إدخال جهة الاتصال المرتبطة بجهة الاتصال الخ')]");
    private final By My_Acc_Icon = By.xpath("//a[@id='menu-drop']//*[name()='svg']");
    private final By Number_Field = By.xpath("//*[@type='tel']");
    private final By Password_Field = By.xpath("//*[@type='password']");
    private final By Login = By.xpath("//button[@type='submit']");
    private final By Error_Message = By.xpath("//p[text()='بيانات العميل غير صالحة' or text()='Invalid credentials']");
    private final By Empty_Number_Error_Message = By.xpath("//span[contains(text(),'رقم الواتساب مطلوب') or contains(text(),'WhatsApp number is required')]");
    private final By Empty_Password_Error_Message = By.xpath("//span[contains(text(),'كلمة المرور مطلوبة') or contains(text(),'Password is required')]");
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
        Assert.assertTrue(checkForLocalization(Zoho_chat_Home ,
                "Home","الرئيسية",Language_Zoho));
        clickOnelement(Zoho_Close);
    }
    public void checkSignUpLinkOpenSuccessfully(String URL){
        Assert.assertTrue(checkForLocalization(sign_up ,
                "Sign up","اشتراك"));
        clickOnelement(sign_up);
        Assert.assertTrue(assertElementDisplayed(Register_SubTitle));
        Assert.assertTrue(driver.getCurrentUrl().contains("onboarding"));
        driver.get(URL);
        Assert.assertTrue(assertElementDisplayed(password_Label));
    }
    /**/

    private void checkCountryDisplayed()   {
        Assert.assertTrue(assertElementDisplayed(Country));
    }
    private void checkCountryCodeDisplayed(){
        Assert.assertTrue(assertElementDisplayed(CountryCode));
        Assert.assertTrue(driver.findElement(CountryCode).getText().length()==2);
    }
    public void checkCountryAndCountryCode(){
        checkCountryDisplayed();
        checkCountryCodeDisplayed();
        checkPhoneCode();
    }
    private void checkPhoneCode(){
        Assert.assertTrue(assertElementDisplayed(Phone_code));
    }
    private void openCountries(){
        clickOnelement(Countries_List);
    }
    public void checkCountriesOPen(){
        openCountries();
        Assert.assertTrue(assertElementDisplayed(SearchCountriesBar));
    }
    public void searchForEgypt(){
        checkCountriesOPen();
        clickOnelement(SearchCountriesBar);
        sendTextToInputField("egy",SearchCountriesBar);
    }
    public void selectEgypt(){
        searchForEgypt();
        clickOnelement(Egypt_Country);
    }
    public void checkEgyptSelected(){
        selectEgypt();
        Assert.assertTrue(assertElementDisplayed(CountryCode));
        Assert.assertTrue(driver.findElement(CountryCode).getText().contains("EG"));
    }
    public void checkForgetPasswordJourney(String URL){
        checkForgetPasswordLabelText();
        clickOnelement(Forget_password_label);
        Assert.assertTrue(assertElementDisplayed(Forget_Password_Page_Title));
        Assert.assertTrue(driver.getCurrentUrl().contains("forgot-password"));
        driver.get(URL);
        Assert.assertTrue(assertElementDisplayed(password_Label));
    }
    public void loginWithValidateData(String username , String password){
        checkEgyptSelected();
        sendTextToInputField(username,Number_Field);
        sendTextToInputField(password, Password_Field);
        clickOnelement(Login);
        Assert.assertTrue(assertElementDisplayed(My_Acc_Icon));
        Assert.assertTrue(driver.getCurrentUrl().contains("business"));
    }
    public void loginWithInValidPassword(String username){
        checkEgyptSelected();
        sendTextToInputField(username,Number_Field);
        sendTextToInputField("111111111", Password_Field);
        clickOnelement(Login);
        Assert.assertTrue(assertElementDisplayed(Error_Message));
        Assert.assertTrue(checkForLocalization(Error_Message,"Invalid credentials","بيانات العميل غير صالحة"));
    }
    public void checkErrorMessageForInvalidNumberOrPassword(){
        clickOnelement(Number_Field);
        clickOnelement(Password_Field);
        Assert.assertTrue(assertElementDisplayed(Empty_Number_Error_Message));
        clickOnelement(Number_Field);
        Assert.assertTrue(assertElementDisplayed(Empty_Password_Error_Message));

    }
}
