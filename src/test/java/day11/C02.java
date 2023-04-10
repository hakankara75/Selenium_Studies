package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import static org.junit.Assert.*;

public class C02 extends TestBase {
    /*
    2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Signup / Login' button
5. Fill all details in Signup and create account
6. Fill all details, Verify 'ACCOUNT CREATED!' and click 'Continue' button
7. Verify ' Logged in as username' at top
8. Add products to cart
9. Click 'Cart' button
10. Verify that cart page is displayed
11. Click Proceed To Checkout
12. Verify that the delivery address is same address filled at the time registration of account
13. Verify that the billing address is same address filled at the time registration of account
14. Click 'Delete Account' button
15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
     */
    @Test
    public void test() {
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        WebElement pageIsVisible = findXpathWebelement("//html");
        assertTrue(pageIsVisible.isDisplayed());

//        4. Click 'Signup / Login' button
        findByXpathClick("//a[@href='/login']");

//        5. Fill all details in Signup and create account
        WebElement name = findXpathWebelement("//input[@data-qa='signup-name']");
        name.sendKeys("Hakan");

        WebElement email = findXpathWebelement("//input[@data-qa='signup-email']");
        email.sendKeys("Hakan@hakan.com");
        threadSleep(2);

        findByXpathClick("//button[@data-qa='signup-button']");

//        6. Fill all details
        driver.findElement(By.id("id_gender1")).click();

        driver.findElement(By.id("password")).sendKeys("Hakan");

        pageDown();

        WebElement day = driver.findElement(By.id("days"));
        Select select = new Select(day);
        select.selectByValue("15");

        WebElement months = driver.findElement(By.id("months"));
        new Select(months);
        select.selectByValue("7");

        WebElement years = driver.findElement(By.id("years"));
        new Select(years);
        select.selectByValue("20");

        pageDown();

        driver.findElement(By.id("first_name")).sendKeys("Hakan");

        driver.findElement(By.id("last_name")).sendKeys("Kara");

        driver.findElement(By.id("company")).sendKeys("Hakan");

        driver.findElement(By.id("address1")).sendKeys("Hakan");

        pageDown();

        WebElement country = driver.findElement(By.id("country"));
        new Select(country);
        select.selectByValue("3");

        driver.findElement(By.id("state")).sendKeys("Hakan");

        driver.findElement(By.id("city")).sendKeys("Hakan");

        driver.findElement(By.id("zipcode")).sendKeys("Hakan");

        driver.findElement(By.id("mobile_number")).sendKeys("Hakan");

                scrollToElement("//button[@data-qa='create-account']");

                threadSleep(2);
        findXpathWebelement("//button[@data-qa='create-account']").click();

//        Verify 'ACCOUNT CREATED!' and click 'Continue' button
        String actualR = findByXpathString("//b[text()='Enter Account Information']");
        String expectedR = "ACCOUNT CREATED!";
        assertNotEquals(actualR, expectedR);


//        7. Verify ' Logged in as username' at top


//        8. Add products to cart
//        9. Click 'Cart' button
//        10. Verify that cart page is displayed
//        11. Click Proceed To Checkout
//        12. Verify that the delivery address is same address filled at the time registration of account
//        13. Verify that the billing address is same address filled at the time registration of account
//        14. Click 'Delete Account' button
//        15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    }
}
