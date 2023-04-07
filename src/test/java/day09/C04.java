package day09;
/*
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Scroll down to footer
5. Verify text 'SUBSCRIPTION'
6. Enter email address in input and click arrow button
7. Verify success message 'You have been successfully subscribed!' is visible
 */
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class C04 extends TestBase {
    @Test
    public void test1() {
// "http://automationexercise.com" sitesine git
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
WebElement homePage= driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());

//        4. Scroll down to footer
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,
                Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,
                Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

//        5. Verify text 'SUBSCRIPTION'
        WebElement subscription= driver.findElement(By.xpath("//h2[.='Subscription']"));
        Assert.assertTrue(subscription.isDisplayed());

        //        6. Enter email address in input and click arrow button
        WebElement email=driver.findElement(By.id("susbscribe_email"));
        email.sendKeys("klghjdlgh@gmail.com");

        WebElement arrowButton= driver.findElement(By.id("subscribe"));
        arrowButton.click();

//        7. Verify success message 'You have been successfully subscribed!' is visible
        WebElement message=driver.findElement(By.xpath("//*[text()='You have been successfully subscribed!']"));
                Assert.assertTrue(message.isDisplayed());
    }
}
