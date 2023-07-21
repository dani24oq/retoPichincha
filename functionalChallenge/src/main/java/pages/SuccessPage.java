package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SuccessPage {

    private final WebDriver driver;
    private final By successMsg = By.cssSelector("div#content > h1");

    public SuccessPage(WebDriver driver){
        this.driver = driver;
    }

    public String getSuccessMsgText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.titleIs("Your order has been placed!"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(successMsg));
        return driver.findElement(successMsg).getText();
    }


}
