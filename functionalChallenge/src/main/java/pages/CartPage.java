package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private final WebDriver driver;
    private final By checkoutBtn = By.cssSelector("a.btn-primary");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public CheckoutPage clickCheckoutBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOfAllElementsLocatedBy(checkoutBtn), ExpectedConditions.elementToBeClickable(checkoutBtn)));
        driver.findElement(checkoutBtn).click();
        return new CheckoutPage(driver);
    }
}
