package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class C01 extends TestBase {
    /*
    2. Navigate to url 'http://automationexercise.com'
3. Scroll to bottom of page
4. Verify 'RECOMMENDED ITEMS' are visible
5. Click on 'Add To Cart' on Recommended product
6. Click on 'View Cart' button
7. Verify that product is displayed in cart page
     */
    @Test
    public void test() {
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Scroll to bottom of page
        Actions actions = new Actions(driver);
        WebElement bottom = findXpathWebelement("//h2[text()='Subscription']");
        actions.scrollToElement(bottom).perform();
        //bu kod locati alinan elemana kadar sayfayi asagi goturur

//        4. Verify 'RECOMMENDED ITEMS' are visible
        WebElement actualRecomm = findXpathWebelement("//h2[text()='recommended items']");
        actions.scrollToElement(actualRecomm).perform();
        String actualRecommended = findByXpathString("//h2[text()='recommended items']");
        String expectedRecommended = "RECOMMENDED ITEMS";
        assertTextContainsAssertTrue(actualRecommended, expectedRecommended);

//        5. Click on 'Add To Cart' on Recommended product
        pageDown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-product-id='1'])[1]")));
       //yukaridaki kod clikleyecegimiz urun ekrana gelene kadar bekleme yapiyor
        element.click();


//        6. Click on 'View Cart' button
        threadSleep(2);
        findByXpathClick("//u[text()='View Cart']");

//        7. Verify that product is displayed in cart page
        String actualBlueTop = findByXpathString("//a[@href='/product_details/1']");
        String expectedBlueTop = "Blue Top";
        assertTextContainsAssertTrue(actualBlueTop, expectedBlueTop);


    }
}
