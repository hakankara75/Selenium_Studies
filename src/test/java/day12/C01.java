package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C01 extends TestBase {
    /*
    2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Scroll down page to bottom
5. Verify 'SUBSCRIPTION' is visible
6. Click on arrow at bottom right side to move upward
7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
     */
    @Test
    public void test() throws InterruptedException {
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//html"));
        assertTrue(homePage.isDisplayed());

//        4. Scroll down page to bottom
        Actions actions = new Actions(driver);
        WebElement subscription = driver.findElement(By.xpath("//h2[text()='Subscription']"));
        actions.scrollToElement(subscription).perform();

//        5. Verify 'SUBSCRIPTION' is visible
        assertTrue(subscription.isDisplayed());

//        6. Click on arrow at bottom right side to move upward
       //alttan açılıp kapanan reklamı kapatmak icin shadow root (closed)
            driver.get("https://automationexercise.com/");
            driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
            driver.findElement(By.xpath("//path[@stroke='#FAFAFA']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='scrollUp']")).click();

//        7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen

        WebElement text = driver.findElement(By.xpath("//h2[text()='Full-Fledged practice website for Automation Engineers']"));
        assertTrue(text.isDisplayed());

    }
}
