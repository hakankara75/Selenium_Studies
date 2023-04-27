package day10;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
/*
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Add products to cart
5. Click 'Cart' button
6. Verify that cart page is displayed
7. Click 'X' button corresponding to particular product
8. Verify that product is removed from the cart
 */
public class C04 extends TestBase {
    @Test
    public void test(){
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        WebElement verify=findXpathWebelement("//html");
               assertDisplayedWebelement(verify);

//        4. Add products to cart
        pageDown();
        WebElement product=findXpathWebelement("(//a[@data-product-id='2'])[1]");
        threadSleep(3);
        product.click();

//        5. Click 'Cart' button
        pageUp();
        findByXpathClick("(//a[@href='/view_cart'])[1]");

//        6. Verify that cart page is displayed
        WebElement cartPage= findXpathWebelement("(//div[@class='container'])[2]");
        assertDisplayedWebelement(cartPage);

//        7. Click 'X' button corresponding to particular product
WebElement x=findXpathWebelement("//a[@data-product-id='2']");
x.click();

//        8. Verify that product is removed from the cart
        String actualResult=findByXpathString("//b[text()='Cart is empty!']");
        String expectedResult="Cart is empty!";
        assertTextContainsAssertTrue(actualResult,expectedResult);





    }
}
