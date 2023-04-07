package day08;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;
/*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and already registered email address
7. Click 'Signup' button
8. Verify error 'Email Address already exist!' is visible
 */
public class C06 extends TestBase {
    @Test
    public void name() {
        driver.get("https://www.singaporeair.com/en_UK/tr/home#/book/bookflight");
        //driver.switchTo().alert().dismiss();

        driver.manage().deleteAllCookies();

        WebElement element=driver.findElement(By.xpath("//a[@href='/en_UK/tr/plan-travel/']"));
        Actions select=new Actions(driver);
        select.contextClick(element).perform();
        System.out.println();

        WebElement element1=driver.findElement(By.xpath("//a[@href='/en_UK/tr/ppsclub-krisflyer/']"));

}
}
