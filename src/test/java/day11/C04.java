package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C04 extends TestBase {
    /*
    2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Add products to cart
5. Click 'Cart' button
6. Verify that cart page is displayed
7. Click Proceed To Checkout
8. Click 'Register / Login' button
9. Fill all details in Signup and create account
10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
 11. Verify 'ACCOUNT CREATED!' at top
12.Click 'Continue' button
12.Click 'Cart' button
13. Click 'Proceed To Checkout' button
14. Verify Address Details and Review Your Order
15. Enter description in comment text area and click 'Place Order'
16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
17. Click 'Pay and Confirm Order' button
18. Verify success message 'Your order has been placed successfully!'
19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
20. Click 'Continue' button
21. Click 'Delete Account' button
22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
     */
    @Test
    public void test() {
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//html"));
        assertTrue(homePage.isDisplayed());

//        4. Add products to cart
        Actions actions = new Actions(driver);
        WebElement product = driver.findElement(By.xpath("//img[@src='/get_product_picture/8']"));
        actions.scrollToElement(product).perform();
        arrowDown();
        threadSleep(3);
        driver.findElement(By.xpath("(//a[@data-product-id='5'])[2]")).click();


//        5. Click 'Cart' button
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

//        6. Verify that cart page is displayed
        threadSleep(2);
        WebElement cartPage = driver.findElement(By.xpath("//div[@class='breadcrumbs']"));
        assertTrue(cartPage.isDisplayed());

//        7. Click Proceed To Checkout
        findByXpathClick("//a[@class='btn btn-default check_out']");

//        8. Click 'Register / Login' button
        threadSleep(2);
        findByXpathClick("//u[text()='Register / Login']");

//        9. Fill all details in Signin and create account
        findXpathWebelement("//input[@name='name']").sendKeys("Hakan");
        findXpathWebelement("//input[@email='email']").sendKeys("Hakan@hakan.com");
        threadSleep(2);
        findByXpathString("//button[@data-qa='signup-button']");

//        10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("password")).sendKeys("Hakan");
        WebElement company = driver.findElement(By.id("company"));
        threadSleep(2);
        actions.scrollToElement(company);
        actions.scrollToElement(company);

        WebElement days = driver.findElement(By.id("days"));
        Select select = new Select(days);
        select.selectByIndex(10);

        WebElement months = driver.findElement(By.id("months"));
        new Select(months);
        select.selectByIndex(8);

        WebElement years = driver.findElement(By.id("years"));
        new Select(years);
        select.selectByIndex(1999);

        driver.findElement(By.id("first_name")).sendKeys("Hakan");
        driver.findElement(By.id("last_name")).sendKeys("Hakan");
        driver.findElement(By.id("company")).sendKeys("Hakan");
        driver.findElement(By.id("address1")).sendKeys("Hakan");
        driver.findElement(By.id("address1")).sendKeys("Hakan");

        WebElement country = driver.findElement(By.id("country"));
        new Select(country);
        select.selectByIndex(3);
        threadSleep(2);

        WebElement mobile_number = driver.findElement(By.id("mobile_number"));
        actions.scrollToElement(mobile_number).perform();

        driver.findElement(By.id("state")).sendKeys("state");
        driver.findElement(By.id("city")).sendKeys("city");
        driver.findElement(By.id("zipcode")).sendKeys("zipcode");
        mobile_number.sendKeys("state");

        findByXpathClick("//button[@data-qa='create-account']");

//        11. Verify 'ACCOUNT CREATED!' at top
        threadSleep(2);
        WebElement accountText=findXpathWebelement("//b[text()='Account Created!']");
        assertTrue(accountText.isDisplayed());

//        12.Click 'Continue' button
        threadSleep(2);
findByXpathClick("//a[@data-qa='continue-button']");

//        12.Click 'Cart' button
        threadSleep(2);
        findByXpathClick("(//a[@href='/view_cart'])[1]");


//        13. Click 'Proceed To Checkout' button
threadSleep(2);
findByXpathClick("//a[@class='btn btn-default check_out']");

//        14. Verify Address Details and Review Your Order
threadSleep(2);
WebElement address= findXpathWebelement("//h2[text()='Address Details']");
assertTrue(address.isDisplayed());

        WebElement order= findXpathWebelement("//h2[text()='Review Your Order']");
actions.scrollToElement(order);
        assertTrue(order.isDisplayed());

//        15. Enter description in comment text area and click 'Pay and Confirm Order'
WebElement textArea= findXpathWebelement("//textarea[@name='message']");
        actions.scrollToElement(textArea);
        textArea.sendKeys("Hakan");
        threadSleep(2);
        findByXpathClick("//a[@href='/payment']");

//        16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
findXpathWebelement("//input[@name='name_on_card']").sendKeys("Hakan");
findXpathWebelement("//input[@name='card_number']").sendKeys("Hakan");
findXpathWebelement("//input[@name='cvc']").sendKeys("333");
findXpathWebelement("//input[@name='expiry_month']").sendKeys("12");
findXpathWebelement("//input[@name='expiry_year']").sendKeys("2000");
threadSleep(2);

//        17. Click 'Pay and Confirm Order' button
        driver.findElement(By.id("submit")).click();

//        18. Verify success message 'Your order has been placed successfully!'
        WebElement alert = driver.findElement(By.xpath("//div[@class='alert-success alert']"));
        Assert.assertTrue(alert.isDisplayed());

//        19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
findByXpathClick("//a[@href='/download_invoice/0']");
Actions dosya=actions.sendKeys(System.getProperty("user.home")+"/Downloads/invoice.txt");



//        20. Click 'Continue' button
//        21. Click 'Delete Account' button
//        22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    }
}
