package day09;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.tethering.model.Accepted;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

/*
Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Products' button
5. Hover over first product and click 'Add to cart'
6. Click 'Continue Shopping' button
7. Hover over second product and click 'Add to cart'
8. Click 'View Cart' button
9. Verify both products are added to Cart
10. Verify their prices, quantity and total price
 */
public class C06 extends TestBase {
    @Test
    public void test1() {
//        Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
       WebElement homePage= driver.findElement(By.xpath("//html"));
        assertTrue(homePage.isDisplayed());

//        Click 'Products' button
       driver.findElement(By.xpath("//a[@href='/products']")).click();
threadSleep(4);

//5. Hover over first product and click 'Add to cart'
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement firstProduct = driver.findElement(By.xpath("//a[@data-product-id='1']"));
               actions.moveToElement(firstProduct).perform();
        threadSleep(4);
        firstProduct.click();

//6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();

//7. Hover over second product and click 'Add to cart'
        WebElement secondProduct = driver.findElement(By.xpath("//a[@data-product-id='2']"));
actions.moveToElement(secondProduct);
threadSleep(4);
secondProduct.click();

//8. Click 'View Cart' button
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();

//9. Verify both products are added to Cart
        WebElement firstProduct1 = driver.findElement(By.xpath("//a[@href='/product_details/1']"));
        WebElement secondProduct1 = driver.findElement(By.xpath("//a[@href='/product_details/2']"));
        assertTrue(firstProduct1.isDisplayed());
        assertTrue(secondProduct1.isDisplayed());

//10. Verify their prices, quantity and total price
        WebElement firstPrice = driver.findElement(By.xpath("(//td[@class='cart_price'])[1]"));
        WebElement firstQuantity = driver.findElement(By.xpath("(//button[@class='disabled'])[1]"));
        WebElement firstTotal = driver.findElement(By.xpath("(//p[@class='cart_total_price'])[1]"));
        WebElement secondtPrice = driver.findElement(By.xpath("(//td[@class='cart_price'])[2]"));
        WebElement secondQuantity = driver.findElement(By.xpath("(//button[@class='disabled'])[2]"));
        WebElement secondTotal = driver.findElement(By.xpath("(//p[@class='cart_total_price'])[2]"));

        assertTrue(firstPrice.isDisplayed());
        assertTrue(firstQuantity.isDisplayed());
        assertTrue(firstTotal.isDisplayed());
        assertTrue(secondtPrice.isDisplayed());
        assertTrue(secondQuantity.isDisplayed());
        assertTrue(secondTotal.isDisplayed());
    }
    }
