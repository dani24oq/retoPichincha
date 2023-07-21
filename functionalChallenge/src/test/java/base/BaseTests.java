package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.LandingPage;
import utils.GetScreenShot;

import java.io.IOException;

public class BaseTests {

    private WebDriver driver;
    protected LandingPage landingPage;
    protected static ExtentReports extent; //Main report object
    protected static ExtentTest extentTest; //Will hold the information for every specific test
    protected static ExtentSparkReporter sparkReporter; //Newest HTML report builder

    @BeforeSuite
    public void reportingSetUp(){
        extent = new ExtentReports();
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\test-output");
        extent.attachReporter(sparkReporter);
        sparkReporter.config().setDocumentTitle("Banco Pichincha Test Report");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        sparkReporter.config().setEncoding("UTF-8");
    }

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://opencart.abstracta.us/");
        landingPage = new LandingPage(driver);
    }

    @AfterMethod
    public void getResults(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE){
            String runningMethod = result.getMethod().getMethodName();
            GetScreenShot.capture(driver, runningMethod);
            String screenshotPath = runningMethod + ".png";
            extentTest.log(Status.FAIL, result.getThrowable());
            extentTest.fail("Screenshot of the error above: " + extentTest.addScreenCaptureFromPath(screenshotPath));

        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, result.getName());
        } else {
            extentTest.log(Status.SKIP, result.getTestName());
        }
        driver.quit();
    }

    @AfterSuite
    public void cleaning(){
        extent.flush();
    }

}
