package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;
/*
Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Add products to cart
5. Click 'Cart' button
6. Verify that cart page is displayed
7. Click Proceed To Checkout
8. Click 'Register / Login' button
9. Fill all details in Signup and create account
10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
11. Verify ' Logged in as username' at top
12.Click 'Cart' button
13. Click 'Proceed To Checkout' button
14. Verify Address Details and Review Your Order
15. Enter description in comment text area and click 'Place Order'
16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
17. Click 'Pay and Confirm Order' button
18. Verify success message 'Your order has been placed successfully!'
19. Click 'Delete Account' button
20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
 */
public class C01 extends TestBase {
    @Test
    public void test1() {
// "http://automationexercise.com" sitesine git
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());

//4. Add products to cart
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();

        WebElement first= driver.findElement(By.xpath("//a[@data-product-id='4']"));
        threadSleep(3);
        first.click();



//        5. Click 'Cart' button
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();
//        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();
//        driver.findElement(By.xpath("//a[@data-product-id='4']")).click();

//        6. Verify that cart page is displayed
        WebElement cartPage= driver.findElement(By.xpath("//div[@class='table-responsive cart_info']"));
        Assert.assertTrue(cartPage.isDisplayed());

//        7. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

//        8. Click 'Register / Login' button
        driver.findElement(By.xpath("//u[text()='Register / Login']")).click();

//        9. Fill all details in Signup and create account
        WebElement name= driver.findElement(By.xpath("//input[@type='text']"));
        name.sendKeys("pass1");

        WebElement email= driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys("pass1@gmail.com");

        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        driver.findElement(By.id("uniform-id_gender1")).click();

        WebElement pass= driver.findElement(By.id("password"));
        pass.sendKeys("pass1");

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement days= driver.findElement(By.id("days"));
       Select select=new Select(days);
       select.selectByIndex(5);

        WebElement months= driver.findElement(By.id("months"));
        new Select(months);
        select.selectByIndex(6);

        WebElement years= driver.findElement(By.id("years"));
        new Select(years);
        select.selectByIndex(12);

        WebElement first_name= driver.findElement(By.id("first_name"));
        first_name.sendKeys("pass");

        WebElement last_name= driver.findElement(By.id("last_name"));
        last_name.sendKeys("pass1");

        WebElement country= driver.findElement(By.id("country"));
        new Select(country);
        select.selectByIndex(3);

        WebElement company= driver.findElement(By.id("company"));
        company.sendKeys("AAAAAAA");

        WebElement address1= driver.findElement(By.id("address1"));
        address1.sendKeys("AAAAAAA");

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement state= driver.findElement(By.id("state"));
        state.sendKeys("India");

        WebElement city= driver.findElement(By.id("city"));
        city.sendKeys("Ardahan");

        WebElement zipcode= driver.findElement(By.id("zipcode"));
        zipcode.sendKeys("45468");

        WebElement mobile_number= driver.findElement(By.id("mobile_number"));
        mobile_number.sendKeys("3576879");

        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

//        10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement accountIsVisible= driver.findElement(By.xpath("//b[text()='Account Created!']"));
        Assert.assertTrue(accountIsVisible.isDisplayed());

        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

//        11. Verify ' Logged in as username' at top
        WebElement logged= driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(logged.isDisplayed());

//        12.Click 'Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

//        13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

//        14. Verify Address Details and Review Your Order
        WebElement verifyAddreess= driver.findElement(By.xpath("//h3[text()='Your delivery address']"));
        Assert.assertTrue(verifyAddreess.isDisplayed());

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement verifyOrder= driver.findElement(By.xpath("//h2[text()='Review Your Order']"));
        Assert.assertTrue(verifyOrder.isDisplayed());

//        15. Enter description in comment text area and click 'Place Order'
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        threadSleep(2);
        driver.findElement(By.xpath("//a[@href='/payment']")).click();

//        16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        WebElement cardName= driver.findElement(By.xpath("//input[@name='name_on_card']"));
        cardName.sendKeys("sfhhhhg");

        WebElement cardNumber= driver.findElement(By.xpath("//input[@name='card_number']"));
        cardNumber.sendKeys("346874354");

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement cvc= driver.findElement(By.xpath("//input[@name='cvc']"));
        cvc.sendKeys("325");

        WebElement expMonth= driver.findElement(By.xpath("//input[@name='expiry_month']"));
        expMonth.sendKeys("12");

        WebElement expYear= driver.findElement(By.xpath("//input[@name='expiry_year']"));
        expYear.sendKeys("2025");

//        17. Click 'Pay and Confirm Order' button
        driver.findElement(By.id("submit")).click();

//        18. Verify success message 'Your order has been placed successfully!'

        WebElement SiparisMsj2 = driver.findElement(By.xpath("//div[@class='alert-success alert']"));
        Assert.assertTrue(SiparisMsj2.isDisplayed());

//        19. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

//        20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement delete= driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        Assert.assertTrue(delete.isDisplayed());
    }
}
