package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

/*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
 */
public class C01 extends TestBase {
    @Test
    public void test1() {
// "http://automationexercise.com" sitesine git
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());

//4. Click on 'Signup / Login' button
        WebElement signUp = driver.findElement(By.xpath("//a[@href='/login']"));
        signUp.click();

//5. Verify 'New User Signup!' is visible
        WebElement newUser = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(newUser.isDisplayed());

//6. Enter name and already registered email address
        WebElement name = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        name.sendKeys("hakan");

        WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys("hakan@gmail.com");

//7. Click 'Signup' button
        WebElement signButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signButton.click();

//8. Verify error 'Email Address already exist!' is visible
        WebElement emailText = driver.findElement(By.xpath("//p[@style='color: red;']"));
        Assert.assertTrue(emailText.isDisplayed());


    }
}
