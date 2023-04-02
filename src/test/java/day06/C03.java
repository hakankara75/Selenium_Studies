package day06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());



        //4. Click on 'Products' button
driver.findElement(By.xpath("//a[@href='/products']")).click();
Thread.sleep(2000);


//5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement html= driver.findElement(By.xpath("//html"));
        Assert.assertTrue(html.isDisplayed());

        //6. The "all products" is visible
        WebElement list=driver.findElement(By.xpath("//div[@class='features_items']"));
Assert.assertTrue(list.isDisplayed());

//7. Click on 'View Product' of first product
driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();

        //8. User is landed to product detail page
        WebElement detail= driver.findElement(By.xpath("//body"));
Assert.assertTrue(detail.isDisplayed());

//9. Verify that detail is visible: product name, category, price, availability, condition, brand
        WebElement prodName= driver.findElement(By.xpath("//h2[.='Blue Top']"));
        Assert.assertTrue(prodName.isDisplayed());

        WebElement category= driver.findElement(By.xpath("//p[.='Category: Women > Tops']"));
        Assert.assertTrue(category.isDisplayed());

        WebElement price= driver.findElement(By.xpath("//span[.='Rs. 500']"));
        Assert.assertTrue(price.isDisplayed());

        WebElement availability= driver.findElement(By.xpath("//b[.='Availability:']"));
        Assert.assertTrue(availability.isDisplayed());

        WebElement condition= driver.findElement(By.xpath("//b[.='Condition:']"));
        Assert.assertTrue(condition.isDisplayed());

        WebElement brand= driver.findElement(By.xpath("//b[.='Brand:']"));
        Assert.assertTrue(brand.isDisplayed());


    }
}
