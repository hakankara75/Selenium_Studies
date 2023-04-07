package day09;
/*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. Enter product name in search input and click search button
7. Verify 'SEARCHED PRODUCTS' is visible
8. Verify all the products related to search are visible
 */

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02 extends TestBase {
    @Test
    public void test() {
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());

//        4. Click on 'Products' button
        WebElement products = driver.findElement(By.xpath("//a[@href='/products']"));
        products.click();
        threadSleep(2);

//        5. Verify user is navigated to ALL PRODUCTS page successfully
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement urun1 = driver.findElement(By.xpath("(//img[@alt='ecommerce website products'])[1]"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(urun1.isDisplayed());
        threadSleep(1);

        WebElement urun2 = driver.findElement(By.xpath("(//img[@alt='ecommerce website products'])[34]"));
        Assert.assertTrue(urun2.isDisplayed());
        threadSleep(1);

//        6. Enter product name in search input and click search button
        WebElement searchButton = driver.findElement(By.id("search_product"));
        searchButton.sendKeys("Half Sleeves");

        driver.findElement(By.id("submit_search")).click();

//        7. Verify 'SEARCHED PRODUCTS' is visible

        WebElement searchedProduct = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(searchedProduct.isDisplayed());
        threadSleep(2);

//        8. Verify all the products related to search are visible
        WebElement searchedProductVisible = driver.findElement(By.xpath("//img[@src='/get_product_picture/12']"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(searchedProductVisible.isDisplayed());


    }
}
