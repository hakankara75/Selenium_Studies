package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
/*
2. Navigate to url 'http://automationexercise.com'
3. Click on 'Products' button
4. Verify user is navigated to ALL PRODUCTS page successfully
5. Click on 'View Product' button
6. Verify 'Write Your Review' is visible
7. Enter name, email and review
8. Click 'Submit' button
9. Verify success message 'Thank you for your review.'
 */
public class C08 extends TestBase {
    @Test
    public void test() {
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Click on 'Products' button
        findByXpathClick("//a[@href='/products']");

//        4. Verify user is navigated to ALL PRODUCTS page successfully
pageDown();
threadSleep(2);
String actualAll=findByXpathString("//h2[text()='All Products']");
String expectedAll="ALL PRODUCTS";
asserTextContainsAssertTrue(actualAll,expectedAll);

//        5. Click on 'View Product' button
        pageDown();
        pageDown();
        threadSleep(3);
        findByXpathClick("//a[@href='/product_details/5']");

//        6. Verify 'Write Your Review' is visible
arrowDown();
String actualWrite=findByXpathString("//a[@href='#reviews']");
String expectedWrite="WRITE YOUR REVIEW";
asserTextContainsAssertTrue(actualWrite, expectedWrite);

//        7. Enter name, email and review
        arrowDown();arrowDown();
        WebElement name= driver.findElement(By.id("name"));
        name.sendKeys("Hakan");

        WebElement email= driver.findElement(By.id("email"));
        email.sendKeys("Hakan@hakan.com");

        WebElement review= driver.findElement(By.id("review"));
        review.sendKeys("Hakan@hakan.com");
        threadSleep(2);

//        8. Click 'Submit' button
        pageDown();
        threadSleep(2);
        driver.findElement(By.id("button-review")).click();

//        9. Verify success message 'Thank you for your review.'
        String a=findByXpathString("//span[@style='font-size: 20px;']");
        String b="Thank you for your review.";
        asserTextContainsAssertTrue(a, b);

        //2.yol
                WebElement message= findXpathWebelement("//span[@style='font-size: 20px;']");
        assertDisplayedWebelement(message);

    }
}
