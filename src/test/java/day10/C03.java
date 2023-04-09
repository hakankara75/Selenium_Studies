package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

/*
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Signup / Login' button
5. Fill email, password and click 'Login' button
6. Verify 'Logged in as username' at top
7. Add products to cart
8. Click 'Cart' button
9. Verify that cart page is displayed
10. Click Proceed To Checkout
11. Verify Address Details and Review Your Order
12. Enter description in comment text area and click 'Place Order'
13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
14. Click 'Pay and Confirm Order' button
15. Verify success message 'Your order has been placed successfully!'
16. Click 'Delete Account' button
17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
 */
public class C03 extends TestBase {
    @Test
    public void test() {
        // "http://automationexercise.com" sitesine git
        driver.get("https://automationexercise.com");

//        3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());

//        4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

//        5. Fill email, password and click 'Login' button
        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("ab@yhaoo.com");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("ab");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

//        6. Verify 'Logged in as username' at top
        String logged = findByXpathString("//b[text()='ab']");
        String memberName = "ab";
        asserTextContainsAssertTrue(logged, memberName);

//        7. Add products to cart
        pageDown();
        threadSleep(3);
        driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click();
        pageDown();
        threadSleep(3);
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();

//        8. Click 'Cart' button
        pageUp();
        pageUp();
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();

//        9. Verify that cart page is displayed
        WebElement cartPage = driver.findElement(By.id("cart_items"));
        assertDisplayedWebelement(cartPage);

//        10. Click Proceed To Checkout
        findByXpathClick("//a[@class='btn btn-default check_out']");

//        11. Verify Address Details and Review Your Order
        String address = findByXpathString("(//h2[@class='heading'])[1]");
        String addr = "Address Details";
        asserTextContainsAssertTrue(address, addr);

        pageDown();
        String order = findByXpathString("(//h2[@class='heading'])[2]");
        String ord = "Review Your Order";
        asserTextContainsAssertTrue(order, ord);

//        12. Enter description in comment text area and click 'Place Order'
        pageDown();
        WebElement textArea = findXpathWebelement("//textarea[@class='form-control']");
        textArea.sendKeys("Hakan");

        findByXpathClick("//a[@href='/payment']");

//        13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        WebElement name = findXpathWebelement("//input[@class='form-control']");
        name.sendKeys("Hakan");

        WebElement number = findXpathWebelement("//input[@class='form-control card-number']");
        number.sendKeys("555");

        pageDown();

        WebElement cvc = findXpathWebelement("//input[@class='form-control card-cvc']");
        cvc.sendKeys("555");

        WebElement expiration = findXpathWebelement("//input[@class='form-control card-expiry-month']");
        expiration.sendKeys("5");

        WebElement year = findXpathWebelement("//input[@class='form-control card-expiry-year']");
        year.sendKeys("2025");


//        14. Click 'Pay and Confirm Order' button
        driver.findElement(By.id("submit")).click();

//        15. Verify success message 'Your order has been placed successfully!'
                WebElement message = findXpathWebelement("(//div[@class='alert-success alert'])[2]");
        assertDisplayedWebelement(message);

//        16. Click 'Delete Account' button
        findByXpathClick("//a[@href='/delete_account']");

//        17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        String deleted = findByXpathString("//b[text()='Account Deleted!']");
        String messageText = "ACCOUNT DELETED!";
        asserTextContainsAssertTrue(deleted, messageText);

    }
}
