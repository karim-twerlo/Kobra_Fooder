package com.fooder.Pages;

import com.fooder.PageBase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class P006EditBranchPage extends PageBase {
    P004BranchesPage branch = new P004BranchesPage(driver) ;
    public P006EditBranchPage(WebDriver driver) {
        super(driver);
    }
    private  int index = 1; // Initialize index
    private  int plus_index = 1 ;

    private final By Edit_Basic_Info = By.xpath("//a[@class='btn btn-icon btn-flat-secondary']//*[name()='svg']");
    private final By Edit_Branch_Title = By.xpath("//span[@class='text-primary font-weight-bolder mx-1 font-small-4 d-none d-sm-block']");
    private final By Edit_CTA = By.xpath("//button[@class='btn btn-primary' and (contains(text(),'تعديل') or contains(text(),'update'))]");
    private final By Submit_Update_Branch = By.xpath("//button[@type='submit']");
    private final By ORDER_TYPE_ELEMENT = By.xpath("//p[normalize-space()='Order Type' or contains(text(),'نوع الطلب')]");
    private final By Location_Info = By.xpath("//h5[normalize-space()='Location Information' or contains(text(),'معلومات الموقع')]");

    private final By PICK_UP_LABEL = By.xpath("//p[normalize-space()='Pickup' or contains(text(),'الإستلام من الفرع')]");
    private final By DELIVERY_LABEL = By.xpath("//p[normalize-space()='Delivery' or contains(text(),'التوصيل')]");
    private final By  DINE_IN_LABEL= By.xpath("//p[normalize-space()='Dine in' or contains(text(),'التناول في الفرع')]");
    private final By  DRIVE_THRU_LABEL= By.xpath("//p[normalize-space()='Car Pickup' or contains(text(),'الطلب من المركبة')]");
    private final By  PICKUP_TOGGLE= By.xpath("//label[@for='pick_up']");
    private final By  DELIVERY_TOGGLE= By.xpath("//label[@for='delivery']");
    private final By  DINE_IN_TOGGLE= By.xpath("//label[@for='dine_in']");
    private final By CAR_PICKUP_TOGGLE = By.xpath("//label[@for='drive_thru']");

    private final By Payment_Methods = By.xpath("//p[normalize-space()='Payment Methods' or contains(text(),'نوع الطلب')]");
    private final By Online_LABEL = By.xpath("//p[normalize-space()='Online' or contains(text(),'الدفع الالكتروني')]");
    private final By Cash_LABEL = By.xpath("//p[normalize-space()='Cash' or contains(text(),'نقدي')]");
    private final By  Card_LABEL= By.xpath("//p[normalize-space()='Card' or contains(text(),'بطاقة دفع')]");
    private final By  Apple_Pay_LABEL= By.xpath("//p[normalize-space()='Apple Pay' or contains(text(),'دفع أبل')]");
    private final By  Online_TOGGLE= By.xpath("//label[@for='online']");
    private final By  Cash_TOGGLE= By.xpath("//label[@for='cash']");
    private final By  Card_TOGGLE= By.xpath("//label[@for='card']");
    private final By Apple_Pay_TOGGLE = By.xpath("//label[@for='apple_pay']");
    private final By Edit_Branch_Operation = By.xpath("(//button[@class='btn btn-primary ng-star-inserted' and (contains(text(),'تعديل') or contains(text(),'update'))])[1]");
    private final By Branch_Operations = By.xpath("//p[normalize-space()='Branch Operation' or contains(text(),'تشغيل الفرع')]");
    private final By MINIMUM_CART_LABEL = By.xpath("//label[contains(text(),'الحد الأدنى لقيمة سلة التسوق') or contains(text(),'Minimum Cart Value* (SAR)')]");
    private final By MAXIMUM_CASH_LABEL = By.xpath("//label[contains(text(),'الحد الأقصى للنقد المقبول') or contains(text(),'Maximum Cash Accepted* (SAR)')]");
    private final By AVERAGE_PREPARATION_TIME_LABEL = By.xpath("//label[contains(text(),'الحد الأقصى للنقد المقبول') or contains(text(),'Average Preparation Time* (Minute(s))')]");
    private final By AVERAGE_CANCELLATION_TIME_LABEL = By.xpath("//label[contains(text(),'متوسط ​​وقت الإلغاء') or contains(text(),'Average Cancellation Time* (Minute(s))')]");
    private final By MAXIMUM_CASH_INPUT = By.xpath("//input[@placeholder='أدخل الحد الأقصى للنقد المقبول' or @placeholder='Enter maximum cash accepted']");
    private final By MINIMUM_CART_INPUT = By.xpath("//input[@placeholder='أدخل الحد الأدنى لقيمة سلة التسوق' or @placeholder='Enter minimum cart value']");
    private final By Cancellation_Time_INPUT = By.xpath("//input[@id='cancellation_time']");
    private final By Preparation_Time_INPUT = By.xpath("//input[@id='preparation_time']");
    private final By Edit_Branch_Timing = By.xpath("(//button[@class='btn btn-primary ng-star-inserted' and (contains(text(),'تعديل') or contains(text(),'update'))])[2]");
    private final By Branch_Timing = By.xpath("//p[contains(text(),'توقيت الفرع') or normalize-space()='Branch Timing']");

    private final By sunday_Toggle = By.cssSelector("div.custom-control.custom-switch.custom-switch-success.my-50 input#SUNDAY");
    private final By monday_Toggle = By.xpath("//label[@for='MONDAY']");
    private final By tuesday_Toggle = By.xpath("//label[@for='TUESDAY']");
    private final By wednesday_Toggle = By.xpath("//label[@for='WEDNESDAY']");
    private final By thursday_Toggle = By.xpath("//label[@for='THURSDAY']");
    private final By friday_Toggle = By.xpath("//label[@for='FRIDAY']");
    private final By saturday_Toggle = By.xpath("//label[@for='SATURDAY']");
    private final By Update_Time_Configuration = By.xpath("//button[@type='submit']");
    private final By Order_Scheduling = By.xpath("//p[contains(text(),'جدولة الطلب') or contains(text(),'Order Scheduling')]");
    private final By Accept_ASAP_orders_Toggle = By.xpath("//label[@for='asap']");
    private final By Accept_pre_orders_Toggle = By.xpath("//label[@for='accept-pre']");
    private final By Accept_Pre_In_Day = By.xpath("//label[@for='accept-pre-in-day']");
    private final By Max_Days_In_Advance = By.xpath("//label[contains(text(),'الحد الأقصى من الأيام مقدما') or contains(text(),'Max days in advance')]");
    private final By Slot_Length = By.xpath("//label[contains(text(),'المدة الزمنية') or contains(text(),'Slot length')]");





    public void clickToEditBranch(){
        waitForVisibilityOfElement(Edit_Basic_Info);
        clickOnelement(Edit_Basic_Info);
        waitForVisibilityOfElement(Edit_Branch_Title);
        Assert.assertTrue(checkForLocalization(Edit_Branch_Title , "Edit Branch" , "تحرير الفرع"));
        Assert.assertTrue(driver.getCurrentUrl().contains("edit"));
    }
    public void editBasicInfoOfBranch(String localized_name , String newLocalizedName){
        scrollToElement( By.xpath("//a[@id='menu-drop']"));
        By name = By.xpath("//h4[@class='mb-2' and text()='" + localized_name + "']");
        Assert.assertTrue(assertElementDisplayed(name));
        scrollToElement(Edit_Branch_Title);
        clickOnelement(Edit_CTA);
        waitForVisibilityOfElement(Location_Info);
        branch.insertBranchLocalizedName(newLocalizedName);
        scrollToElement(Submit_Update_Branch);
        clickOnelement(Submit_Update_Branch);
        validateUpdateMessage();
    }
    private void validateOrderTypeSection(){
        scrollToElement(ORDER_TYPE_ELEMENT);
        Assert.assertTrue(assertElementDisplayed(ORDER_TYPE_ELEMENT));
        Assert.assertTrue(assertElementDisplayed(PICKUP_TOGGLE));
        Assert.assertTrue(assertElementDisplayed(DELIVERY_LABEL));
        Assert.assertTrue(assertElementDisplayed(DELIVERY_TOGGLE));
        Assert.assertTrue(assertElementDisplayed(DINE_IN_LABEL));
        Assert.assertTrue(assertElementDisplayed(DINE_IN_TOGGLE));
        Assert.assertTrue(assertElementDisplayed(PICK_UP_LABEL));
        Assert.assertTrue(assertElementDisplayed(DRIVE_THRU_LABEL));
        Assert.assertTrue(assertElementDisplayed(CAR_PICKUP_TOGGLE));
    }
    private void enableToggle(By by){
        scrollToElement(by);
        clickOnelement(by);
        validateUpdateMessage();
        try{
            Thread.sleep(4000);
        }catch (Exception e){
            e.getStackTrace();
        }
    }
    public void EnableOrderTypeSections(){
        validateOrderTypeSection();
        enableToggle(DELIVERY_TOGGLE);
        enableToggle(PICKUP_TOGGLE);
        enableToggle(DINE_IN_TOGGLE);
        enableToggle(CAR_PICKUP_TOGGLE);
    }
    private void validatePaymentMethodsSection(){
        scrollToElement(Payment_Methods);
        Assert.assertTrue(assertElementDisplayed(Cash_LABEL));
        Assert.assertTrue(assertElementDisplayed(Cash_TOGGLE));
        Assert.assertTrue(assertElementDisplayed(Card_LABEL));
        Assert.assertTrue(assertElementDisplayed(Card_TOGGLE));
        Assert.assertTrue(assertElementDisplayed(Apple_Pay_LABEL));
        Assert.assertTrue(assertElementDisplayed(Apple_Pay_TOGGLE));
        Assert.assertTrue(assertElementDisplayed(Online_LABEL));
        Assert.assertTrue(assertElementDisplayed(Online_TOGGLE));
        Assert.assertTrue(assertElementDisplayed(Payment_Methods));
    }
    public void EnablePaymentMethodsSections(){
        validatePaymentMethodsSection();
        enableToggle(Online_TOGGLE);
        enableToggle(Cash_TOGGLE);
        enableToggle(Card_TOGGLE);
        enableToggle(Apple_Pay_TOGGLE);

    }
    public void editBranchOperations(String Mini_Card_Value , String Average_Cancellation_Time, String Max_Cash_Value , String Average_Preparation_Time){
        scrollToElement(Branch_Operations);
        waitForVisibilityOfElement(Branch_Operations);
        scrollToElement(Edit_Branch_Operation);
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.getStackTrace();
        }
        clickOnelement(Edit_Branch_Operation);
        waitForVisibilityOfElement(Branch_Operations);
        validateBranchOperationItems();
        fillManageOperationsSection( Mini_Card_Value ,  Average_Cancellation_Time,  Max_Cash_Value ,  Average_Preparation_Time);
        clickOnelement(Submit_Update_Branch);
        validateUpdateMessage();    }
    private void validateBranchOperationItems(){
        Assert.assertTrue(assertElementDisplayed(MINIMUM_CART_INPUT));
        Assert.assertTrue(assertElementDisplayed(MAXIMUM_CASH_INPUT));
        Assert.assertTrue(checkForLocalization(MINIMUM_CART_LABEL , "SAR" , "ر.س"));
        Assert.assertTrue(driver.findElement(MINIMUM_CART_LABEL).getText().contains("*"));
        Assert.assertTrue(assertElementDisplayed(MAXIMUM_CASH_LABEL));
        Assert.assertTrue(checkForLocalization(MAXIMUM_CASH_LABEL , "SAR" , "ر.س"));
        Assert.assertTrue(driver.findElement(MINIMUM_CART_LABEL).getText().contains("*"));
        Assert.assertTrue(assertElementDisplayed(Cancellation_Time_INPUT));
        Assert.assertTrue(assertElementDisplayed(Preparation_Time_INPUT));
        Assert.assertTrue(assertElementDisplayed(AVERAGE_CANCELLATION_TIME_LABEL));
        Assert.assertTrue(checkForLocalization(AVERAGE_CANCELLATION_TIME_LABEL , "Minute(s)" , "الدقائق"));
        Assert.assertTrue(driver.findElement(MINIMUM_CART_LABEL).getText().contains("*"));
        Assert.assertTrue(assertElementDisplayed(AVERAGE_PREPARATION_TIME_LABEL));
        Assert.assertTrue(driver.findElement(MINIMUM_CART_LABEL).getText().contains("*"));

    }
    private void fillManageOperationsSection(String Mini_Card_Value , String Average_Cancellation_Time, String Max_Cash_Value , String Average_Preparation_Time){
        sendTextToInputField(Max_Cash_Value, MAXIMUM_CASH_INPUT);
        sendTextToInputField(Mini_Card_Value , MINIMUM_CART_INPUT);
        sendTextToInputField(Average_Preparation_Time , Preparation_Time_INPUT);
        sendTextToInputField(Average_Cancellation_Time , Cancellation_Time_INPUT);
    }

    public  void setHourAndMinute(Boolean needExtraTime) {
        By Start_Hour = By.xpath("(//input[@placeholder='HH'])[" + index + "]");
        By End_Hour = By.xpath("(//input[@placeholder='HH'])[" + (index + 1) + "]");
        By Start_Minute = By.xpath("(//input[@placeholder='MM'])[" + index + "]");
        By End_Minute = By.xpath("(//input[@placeholder='MM'])[" + (index + 1) + "]");


        // Set initial hours and minutes
        sendTextToInputField("00", Start_Hour);
        sendTextToInputField("23", End_Hour);
        sendTextToInputField("00", Start_Minute);
        sendTextToInputField("59", End_Minute);

        if (needExtraTime) {
            driver.findElement(By.xpath("(//div[@class='col p-0 ng-star-inserted']//button[@class='btn btn-icon btn-flat-primary ng-star-inserted'])[" + plus_index + "]")).click();
            plus_index = plus_index - 2 ;
            incrementIndex(2);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.getStackTrace();
            }

            setHourAndMinute(false);

            decrementIndex(2);
        }

        // Increment index for the next set of hours and minutes
        incrementIndex(2);
        plus_index = plus_index + 1 ;
    }

    private  void incrementIndex(int value) {
        index += value;
    }

    private  void decrementIndex(int value) {
        index -= value;
    }

    public void branchTimingSection(){
          scrollToElement(Branch_Timing);
          waitForVisibilityOfElement(Branch_Timing);
          clickOnelement(Edit_Branch_Timing);
          setTimeForEachDay();
          scrollToElement(Update_Time_Configuration);
          clickOnelement(Update_Time_Configuration);
          validateUpdateMessage();

  }
  private void setTimeForEachDay(){
      openTimingToggle("SUNDAY" ,sunday_Toggle , false  );
      openTimingToggle("MONDAY" , monday_Toggle , false );
      openTimingToggle("TUESDAY" , tuesday_Toggle , true );
      openTimingToggle("WEDNESDAY" , wednesday_Toggle , false );
      openTimingToggle("THURSDAY" , thursday_Toggle , false );
      openTimingToggle("FRIDAY" , friday_Toggle , false );
      openTimingToggle("SATURDAY" , saturday_Toggle , false );
  }
    private  void openTimingToggle(String id , By by , Boolean needExtraTime ){
        scrollToElement(by);
        clickOnElementIdUsingJS(id);
        setHourAndMinute(needExtraTime);

    }

    public void checkOrderScheduling(){
        scrollToElement(Order_Scheduling);
        Assert.assertTrue(assertElementDisplayed(Order_Scheduling));
//        enableToggle(Accept_ASAP_orders_Toggle);
        enableToggle(Accept_pre_orders_Toggle);
        waitForVisibilityOfElement(Accept_Pre_In_Day);
        scrollToElement(Accept_ASAP_orders_Toggle);
        Assert.assertTrue(assertElementDisplayed(Accept_Pre_In_Day));
        enableToggle(Accept_Pre_In_Day);
        Assert.assertTrue(assertElementDisplayed(Max_Days_In_Advance));
        Assert.assertTrue(assertElementDisplayed(Slot_Length));
        scrollToElement(Slot_Length);
        selectDays("29");
        selectHours("3");
        validateUpdateMessage();
    }
    private void selectDays(String number) {
        By days = By.xpath("//div[@class='d-flex flex-column p-2']//div[2]//div[1]//select[1]");
        waitForVisibilityOfElement(days);
        WebElement selectElement = driver.findElement(days);
        Select select = new Select(selectElement);
        select.selectByIndex(Integer.parseInt(number));
    }

    private void selectHours(String number) {
        By hours = By.xpath("//div[@class='row ng-star-inserted']//div[3]//div[1]//select[1]");
        waitForVisibilityOfElement(hours);
        WebElement selectElement = driver.findElement(hours);
        Select select = new Select(selectElement);
        select.selectByIndex(Integer.parseInt(number));
    }


}
