package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

import static org.junit.Assert.assertTrue;

public class C07 extends TestBase {
    /*
    2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'View Product' for any product on home page
5. Verify product detail is opened
6. Increase quantity to 4
7. Click 'Add to cart' button
8. Click 'View Cart' button
9. Verify that product is displayed in cart page with exact quantity
     */
    @Test
    public void test1() {
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        WebElement homePage= driver.findElement(By.xpath("//body"));
        assertTrue(homePage.isDisplayed());
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

//        4. Click 'View Product' for any product on home page
        threadSleep(3);
        WebElement viewPrd=driver.findElement(By.xpath("//a[@href='/product_details/3']"));
        viewPrd.click();

//        5. Verify product detail is opened
        WebElement detail= driver.findElement(By.xpath("//h2[.='Sleeveless Dress']"));
        assertTrue(detail.isDisplayed());

//        6. Increase quantity to 4
        WebElement increase= driver.findElement(By.id("quantity"));
        actions.moveToElement(increase);
        threadSleep(3);
        increase.sendKeys("4",Keys.TAB,Keys.ENTER);
        Dimension firstQuantity=increase.getSize();
        System.out.println(firstQuantity);

//        7. Click 'Add to cart' button
        driver.findElement(By.xpath("//button[@class='btn btn-default cart']")).click();

//        8. Click 'View Cart' button
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();

//        9. Verify that product is displayed in cart page with exact quantity
                WebElement exactQuantity=driver.findElement(By.xpath("//button[@class='disabled']"));
        Assert.assertTrue(exactQuantity.isDisplayed());

    }
}
