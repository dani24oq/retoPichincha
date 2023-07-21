IDE: Intellij

Framework: Selenium, Maven
TestRunner: TestNG
Reports: Extent Reports

Execution Steps:

1. Extent report objects are initialized.
2. Set Up for the testing framework is performed (driver load and landing page initialized)
3. Testing start
4. Extent test is created, and name and description are set
5. On the landing page the system will find the first two items able to be added and will add them to the cart using the "Add to cart button"
6. Click on the black "item(s)" button
7. Click on the "View Cart" link
8. On the Cart page, take a screenshot (the screenshot will be saved in the "test-output" folder)
9. Click on the "Checkout" button
10. On the Checkout page, Checkout Options section, select the "Guest Checkout" option
11. Click on Continue
12. On the Billing Details section, set all the mandatory fields
13. Click on Continue
14. On the Delivery Method section, click on Continue
15. On the Payment Method, click on the "Terms & Conditions" checkbox
16. Click on Continue
17. On the Confirm Section, click on Confirm Order
18. On the Success page, get the text "Your order has been placed!" and compare it to the expected text
19. Reports are generated with the test information (you will get a screenshot if the test fail), test report will be saved in the "test-output" folder
20. Browser will close
21. Report object´s information is cleaned

