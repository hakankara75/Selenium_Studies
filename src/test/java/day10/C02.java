package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C02 extends TestBase {
    /*
    2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Signup / Login' button
5. Fill all details in Signup and create account
6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
7. Verify ' Logged in as username' at top
8. Add products to cart
9. Click 'Cart' button
10. Verify that cart page is displayed
11. Click Proceed To Checkout
12. Verify Address Details and Review Your Order
13. Enter description in comment text area and click 'Place Order'
14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
15. Click 'Pay and Confirm Order' button
16. Verify success message 'Your order has been placed successfully!'
17. Click 'Delete Account' button
18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
     */
    @Test
    public void test1() {
        Actions actions=new Actions(driver);
        // "http://automationexercise.com" sitesine git
        driver.get("https://automationexercise.com");

//        3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());

//        4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

//        5. Fill all details in Signup and create account
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

//        6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement accountIsVisible= driver.findElement(By.xpath("//b[text()='Account Created!']"));
        Assert.assertTrue(accountIsVisible.isDisplayed());

        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

//        7. Verify ' Logged in as username' at top

        String accountName= driver.findElement(By.xpath("//b[text()='pass1']")).getText();
        Assert.assertTrue(accountName.contains("pass1"));

//        8. Add products to cart
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        threadSleep(3);
        driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click();

//        9. Click 'Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

//        10. Verify that cart page is displayed
        WebElement cartPage= driver.findElement(By.xpath("//li[@class='active']"));
        Assert.assertTrue(cartPage.isDisplayed());

//        11. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

//        12. Verify Address Details and Review Your Order
        String addres= driver.findElement(By.xpath("//h2[text()='Address Details']")).getText();
        actions.sendKeys(Keys.PAGE_DOWN);

        String review= driver.findElement(By.xpath("//h2[text()='Review Your Order']")).getText();

        Assert.assertTrue(addres.contains("Address Details"));
        Assert.assertTrue(review.contains("Review Your Order"));

//        13. Enter description in comment text area and click 'Place Order'
        WebElement description= driver.findElement(By.xpath("//textarea[@class='form-control']"));
        description.sendKeys("Hakan");
        driver.findElement(By.xpath("//a[@href='/payment']")).click();

//        14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        WebElement card= driver.findElement(By.xpath("//input[@name='name_on_card']"));
        card.sendKeys("Hakan");

        WebElement cardNumber= driver.findElement(By.xpath("//input[@name='card_number']"));
        cardNumber.sendKeys("Hakan");
        actions.sendKeys(Keys.PAGE_DOWN);

        WebElement cvc= driver.findElement(By.xpath("//input[@name='cvc']"));
        cvc.sendKeys("Hakan");

        WebElement expiration= driver.findElement(By.xpath("//input[@name='expiry_month']"));
        expiration.sendKeys("Hakan");

        WebElement year= driver.findElement(By.xpath("//input[@name='expiry_year']"));
        year.sendKeys("Hakan");

//        15. Click 'Pay and Confirm Order' button
        driver.findElement(By.id("submit")).click();

//        16. Verify success message 'Your order has been placed successfully!'
        WebElement message = driver.findElement(By.xpath("((//div[@class='col-md-4'])[2]//div[@class='col-md-12 form-group'])[1]"));
//        WebElement message = driver.findElement(By.xpath("//div[@class='col-md-12 form-group hide']"));


//      JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement message = (WebElement) js.executeScript("return document.querySelector('col-md-12 form-group')");
        Assert.assertTrue(message.isDisplayed());

//        17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

//        18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        String verify = driver.findElement(By.xpath("//b[text()='Account Deleted!']")).getText();
        Assert.assertTrue(verify.contains("ACCOUNT DELETED!"));
    }

}
