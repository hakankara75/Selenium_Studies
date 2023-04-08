package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    public void test1() {
        Actions actions = new Actions(driver);
        // "http://automationexercise.com" sitesine git
        driver.get("https://automationexercise.com");

//        3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());

//        4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

//        5. Fill email, password and click 'Login' button
        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("email@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("email@gmail.com");

        threadSleep(100);
//        6. Verify 'Logged in as username' at top
        WebElement logged = driver.findElement(By.xpath("//input[@name='password']"));

//        7. Add products to cart
//        8. Click 'Cart' button
//        9. Verify that cart page is displayed
//        10. Click Proceed To Checkout
//        11. Verify Address Details and Review Your Order
//        12. Enter description in comment text area and click 'Place Order'
//        13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
//        14. Click 'Pay and Confirm Order' button
//        15. Verify success message 'Your order has been placed successfully!'
//        16. Click 'Delete Account' button
//        17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    }
}
