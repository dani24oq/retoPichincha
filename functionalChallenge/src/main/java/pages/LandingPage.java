package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GetScreenShot;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class LandingPage {

    private final WebDriver driver;
    private final By addCartBtn = By.xpath("//button[contains(@onclick,'cart.add')]");
    private final By cartTotalBtn = By.xpath("//span[@id='cart-total']/parent::button");
    private final By viewCartLink = By.cssSelector("p.text-right > a:first-child");

    public LandingPage(WebDriver driver){
        this.driver = driver;
    }

    public void addingTwoProductsToTheCart(){
        List<WebElement> productsToAdd = driver.findElements(addCartBtn);
        for (int i = 0; i<2; i++){
            productsToAdd.get(i).click();
        }
    }

    public CartPage viewTheCart() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartTotalBtn), ExpectedConditions.elementToBeClickable(cartTotalBtn)));
        driver.findElement(cartTotalBtn).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(viewCartLink));
        driver.findElement(viewCartLink).click();
        GetScreenShot.capture(driver, "Cart View");
        return new CartPage(driver);
    }







}
