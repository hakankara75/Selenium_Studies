package day5;


import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
public class Deneme {
    static WebDriver driver;
    @BeforeClass
    public static void launchBrw(){

        driver=new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://automationexercise.com");
    }
    @AfterClass
    public static void closeBrw() throws InterruptedException {
        Thread.sleep(2000);
        //driver.close();
    }
    @Test
    public void t1_homePage(){
        WebElement homePage=driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());
    }
    @Test
    public void t2_login() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        Thread.sleep(1000);
        WebElement text1=driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(text1.isDisplayed());
    }
    @Test
    public void t3_emailPsw() throws InterruptedException {
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("password12@gmail.com");
        driver.findElement(By.xpath("//*[@data-qa='login-password']")).sendKeys("password12");
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();
    }
    @Test
    public  void t4_accSucc(){
        WebElement text2= driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(text2.isDisplayed());
    }
    @Test
    public void t5_loggout(){
        driver.findElement(By.xpath("//*[@href='/logout']")).click();
    }
    @Test
    public void t6_backLoginPage(){
        WebElement text1=driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(text1.isDisplayed());
    }
}
