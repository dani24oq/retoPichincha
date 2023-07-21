package test;

import base.BaseTests;
import org.testng.annotations.Test;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class ChallengeTests extends BaseTests {

    @Test
    public void challengeTest() throws IOException {
        extentTest = extent.createTest("Purchase Test Banco Pichincha", "Perform a complete purchase process for two items");
        landingPage.addingTwoProductsToTheCart();
        var cart = landingPage.viewTheCart();
        var checkout = cart.clickCheckoutBtn();
        checkout.selectGuestCheckout();
        checkout.setBillingDetails();
        checkout.setDeliveryMethod();
        checkout.setPaymentMethod();
        var success = checkout.confirmOrder();
        assertEquals(success.getSuccessMsgText(), "Your order has been placed!", "Your order was not placed!");
    }
}
