package day06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01 extends TestBase {
@Test
    public void test1() throws InterruptedException {
// "http://automationexercise.com" sitesine git
    driver.get("http://automationexercise.com");

    //3. Verify that home page is visible successfully
    WebElement homepage=driver.findElement(By.xpath("//html"));
    Assert.assertTrue(homepage.isDisplayed());

    //4. Click on 'Contact Us' button
    driver.findElement(By.xpath("//a[@href='/contact_us']")).click();
    Thread.sleep(2000);

    //5. Verify 'GET IN TOUCH' is visible
    WebElement getText=driver.findElement(By.xpath("//h2[text()='Get In Touch']"));
    Assert.assertTrue(getText.isDisplayed());

    //6. Enter name, email, subject and message
    driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("user");
    driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("user@gmail.com");
    driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("konu");
    driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("selam");

    //7. Upload file
   WebElement upload= driver.findElement(By.xpath("//input[@name='upload_file']"));
     upload.sendKeys("C:\\Users\\HakanBatirhan\\Desktop\\text.txt");

    //8. Click 'Submit' button
    driver.findElement(By.xpath("//input[@data-qa='submit-button']")).submit();

    //9. Click OK button
    Thread.sleep(2000);
    driver.switchTo().alert().accept();

    //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
WebElement message=driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
Assert.assertTrue(message.isDisplayed());

//11. Click 'Home' button and verify that landed to home page successfully
    driver.findElement(By.xpath("//i[@class='fa fa-angle-double-left']")).click();
    WebElement homepageEnd=driver.findElement(By.xpath("//html"));
    Assert.assertTrue(homepageEnd.isDisplayed());
    }
}
