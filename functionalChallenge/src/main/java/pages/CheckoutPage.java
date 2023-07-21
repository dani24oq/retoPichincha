package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private final WebDriver driver;
    private final By guestCheckoutRadioBtn = By.xpath("//input[@value='guest']");
    private final By step1ContinueBtn = By.id("button-account");
    private final By firstNameField = By.id("input-payment-firstname");
    private final By lastNameField = By.id("input-payment-lastname");
    private final By emailField = By.id("input-payment-email");
    private final By telephoneField = By.id("input-payment-telephone");
    private final By address1Field = By.id("input-payment-address-1");
    private final By cityField = By.id("input-payment-city");
    private final By postCodeField = By.id("input-payment-postcode");
    private final By countrySelector = By.id("input-payment-country");
    private final By regionSelector = By.id("input-payment-zone");
    private final By step2ContinueBtn = By.id("button-guest");
    private final By step4ContinueBtn = By.id("button-shipping-method");
    private final By termsAndConditionsCbox = By.name("agree");
    private final By step5ContinueBtn = By.id("button-payment-method");
    private final By confirmOrderBtn = By.id("button-confirm");

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectGuestCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOfAllElementsLocatedBy(guestCheckoutRadioBtn), ExpectedConditions.elementToBeClickable(guestCheckoutRadioBtn)));
        driver.findElement(guestCheckoutRadioBtn).click();
        driver.findElement(step1ContinueBtn).click();
    }

    public void setBillingDetails(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(firstNameField));
        driver.findElement(firstNameField).sendKeys("False Name");
        driver.findElement(lastNameField).sendKeys("False Lastname");
        driver.findElement(emailField).sendKeys("testing@user.com");
        driver.findElement(telephoneField).sendKeys("123456789");
        driver.findElement(address1Field).sendKeys("False Street 123");
        driver.findElement(cityField).sendKeys("False City");
        driver.findElement(postCodeField).sendKeys("123456");
        Select countryDropDown= new Select(driver.findElement(countrySelector));
        countryDropDown.selectByVisibleText("Colombia");
        Select regionDropDown = new Select(driver.findElement(regionSelector));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        regionDropDown.selectByVisibleText("Valle del Cauca");
        driver.findElement(step2ContinueBtn).click();
    }

    public void setDeliveryMethod(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOfAllElementsLocatedBy(step4ContinueBtn), ExpectedConditions.elementToBeClickable(step4ContinueBtn)));
        driver.findElement(step4ContinueBtn).click();
    }

    public void setPaymentMethod(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOfAllElementsLocatedBy(step5ContinueBtn), ExpectedConditions.elementToBeClickable(step5ContinueBtn)));
        driver.findElement(termsAndConditionsCbox).click();
        driver.findElement(step5ContinueBtn).click();
    }

    public SuccessPage confirmOrder(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOfAllElementsLocatedBy(confirmOrderBtn), ExpectedConditions.elementToBeClickable(confirmOrderBtn)));
        driver.findElement(confirmOrderBtn).click();
        return new SuccessPage(driver);
    }



}
