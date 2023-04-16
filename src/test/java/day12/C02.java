package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C02 extends TestBase {
    /*
    2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Scroll down page to bottom
5. Verify 'SUBSCRIPTION' is visible
6. Scroll up page to top
7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
     */
    @Test
    public void test(){

//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        WebElement homePage= findXpathWebelement("//html");
        assertTrue(homePage.isDisplayed());

//        4. Scroll down page to bottom
        Actions actions = new Actions(driver);
        WebElement subscription = driver.findElement(By.xpath("//h2[text()='Subscription']"));
        actions.scrollToElement(subscription).perform();
        threadSleep(2);

//        5. Verify 'SUBSCRIPTION' is visible
       assertTrue(subscription.isDisplayed());

//        6. Scroll up page to top
        //try-catch alttan açılıp kapanan reklamı kapatmak icin shadow root (closed)
        try {
            driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
            driver.findElement(By.xpath("//path[@stroke='#FAFAFA']")).click();
            Thread.sleep(2000);
        }catch (Exception s){

        }
        driver.findElement(By.xpath("//a[@id='scrollUp']")).click();

//        7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        WebElement verifyText= findXpathWebelement("(//h2[text()='Full-Fledged practice website for Automation Engineers'])[1]");
        assertTrue(verifyText.isDisplayed());
    }
}
