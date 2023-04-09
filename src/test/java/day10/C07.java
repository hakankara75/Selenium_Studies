package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
/*
2. Navigate to url 'http://automationexercise.com'
3. Click on 'Products' button
4. Verify user is navigated to ALL PRODUCTS page successfully
5. Enter product name in search input and click search button
6. Verify 'SEARCHED PRODUCTS' is visible
7. Verify all the products related to search are visible
8. Add those products to cart
9. Click 'Cart' button and verify that products are visible in cart
10. Click 'Signup / Login' button and submit login details
11. Again, go to Cart page
12. Verify that those products are visible in cart after login as well
 */
public class C07 extends TestBase {
    @Test
    public void test(){
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

//        5. Enter product name in search input and click search button
WebElement search=driver.findElement(By.id("search_product"));
search.sendKeys("Half Sleeves Top Schiffli");
driver.findElement(By.id("submit_search")).click();

//        6. Verify 'SEARCHED PRODUCTS' is visible
threadSleep(2);
String actualSearch=findByXpathString("//h2[text()='Searched Products']");
String expectedSearch="SEARCHED PRODUCTS";
asserTextContainsAssertTrue(actualSearch,expectedSearch);

//        7. Verify all the products related to search are visible
        arrowDown();arrowDown();
        WebElement imageIsVisible=findXpathWebelement("//img[@src='/get_product_picture/12']");
        threadSleep(2);
        assertDisplayedWebelement(imageIsVisible);

//        8. Add those products to cart
        findByXpathClick("//a[@data-product-id='12']");

//        9. Click 'Cart' button and verify that products are visible in cart
arrowDown();
arrowDown();
threadSleep(2);
findByXpathClick("//u[text()='View Cart']");
        threadSleep(2);
     WebElement imageEnd=findXpathWebelement("//img[@src='get_product_picture/12']");
        assertDisplayedWebelement(imageEnd);

//        10. Click 'Signup / Login' button and submit login details
pageUp();
threadSleep(2);
findByXpathClick("(//a[@href='/login'])[1]");

//        11. Again, go to Cart page
driver.navigate().back();

//        12. Verify that those products are visible in cart after login as well
        pageDown();
        threadSleep(2);
        assertDisplayedWebelement(imageEnd);
    }
}
