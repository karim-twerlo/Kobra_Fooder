package com.fooder.testBase;

import com.fooder.Utilities.ExtentReportManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static Utilities.PropertiesLoader.readEnvFile;
import static com.fooder.Utilities.ExtentReportManager.*;
import static com.fooder.testBase.ReadProperties.URL;

public class BaseTest {

    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void startDriverSession(@Optional("chrome") String browser) {
        try {
            initializeDriver(browser);
            startReporting();
        } catch (Exception e) {
            throw new RuntimeException("Failed to start WebDriver session", e);
        }
    }

    private void initializeDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        configureDriver();
    }

    private void configureDriver() {
        driver.manage().window().maximize();
        driver.get(URL);
    }



    @BeforeMethod(alwaysRun = true)
    public void beforMethod(Method method) throws IOException {
       beforeMethod(method);
    }
    @AfterMethod(alwaysRun = true)
    public void takeScreenShot(ITestResult result) throws IOException, InterruptedException {
        takeScreenshot(result,driver);
        System.out.println("screenshot captured");
    }
    @AfterClass(alwaysRun = true)
        public void tearDown(){
            if (driver != null){
                driver.quit();
            }
            flushReport();
        System.out.println("Report path is here:  " + reportName );

        }
    }

