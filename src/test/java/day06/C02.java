package day06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02 extends TestBase {
    @Test
    public void test1(){
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement body=driver.findElement(By.xpath("//body"));
        Assert.assertTrue(body.isDisplayed());

        //4. Click on 'Test Cases' button
        driver.findElement(By.xpath("//a[@href='/test_cases']")).click();

        //5. Verify user is navigated to test cases page successfully
        WebElement testCase=driver.findElement(By.xpath("//html"));
        Assert.assertTrue(testCase.isDisplayed());


    }
}
