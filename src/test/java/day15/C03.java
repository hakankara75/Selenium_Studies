package day15;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C03 extends TestBase {
    /*
    1. Launch browser
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
    @Test
    public void name() throws InterruptedException {
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        WebElement element = driver.findElement(By.xpath("//body"));
        assertTrue(element.isDisplayed());

//        4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

//        5. Fill email, password and click 'Login' button
        WebElement element1 = driver.findElement(By.xpath("//input[@type='email']"));
        Actions actions = new Actions(driver);
        actions.sendKeys(element1, "pass1@gmail.com", Keys.TAB).sendKeys("pass1", Keys.ENTER).perform();

//        6. Verify 'Logged in as username' at top
        String logged = driver.findElement(By.xpath("//b[text()='pass1']")).getText();

//        7. Add products to cart
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement firstProduct = driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]"));
        actions.moveToElement(firstProduct).perform();
        Thread.sleep(2000);
        firstProduct.click();

//        8. Click 'Cart' button
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();

//        9. Verify that cart page is displayed
        WebElement cartPage = driver.findElement(By.xpath("//li[@class='active']"));
        assertTrue(cartPage.isDisplayed());

//        10. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

//        11. Verify Address Details and Review Your Order
        String actualAddress = driver.findElement(By.xpath("(//li[text()='Mr. q q'])[1]")).getText();
        String expectedAddress = "Mr. q q";
        assertTrue(expectedAddress.equals(actualAddress));

        String actualBillingAddress = driver.findElement(By.xpath("(//li[text()='Mr. q q'])[2]")).getText();
        String expectedBillingAddress = "Mr. q q";
        assertTrue(expectedBillingAddress.equals(actualBillingAddress));

//        12. Enter description in comment text area and click 'Place Order'
        WebElement description = driver.findElement(By.xpath("//textarea[@class='form-control']"));
        actions.moveToElement(description).perform();

        actions.sendKeys(description, "sldfgsşldfghşsdlf").perform();

//        13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
//        14. Click 'Pay and Confirm Order' button
//        15. Verify success message 'Your order has been placed successfully!'
//        16. Click 'Delete Account' button
//        17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    }
}
