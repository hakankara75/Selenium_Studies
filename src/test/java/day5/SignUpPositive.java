package day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class SignUpPositive {
    static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

    }

    @AfterClass
    public static void after() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);

    }

    @Test
    public void test() throws InterruptedException {
        //      3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//html[@lang='en']"));
        assertTrue(homePage.isDisplayed());
    }
    @Test
    public void test1() throws InterruptedException {
//      4. Click on 'Signup / Login' button
        WebElement login = driver.findElement(By.xpath("//a[@href='/login']"));
        login.click();
    }
    @Test
    public void test2() throws InterruptedException {
//      5. Verify 'Login to your account' is visible
        WebElement text = driver.findElement(By.xpath("//h2[.='Login to your account']"));
        assertTrue(text.isDisplayed());
    }
    @Test
    public void test3() throws InterruptedException {
//      6. Enter correct email address and password
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("password12@gmail.com");
    }
    @Test
    public void test4() throws InterruptedException {
        WebElement password = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        password.sendKeys("password12");
    }
    @Test
    public void test5() throws InterruptedException {
//      7. Click 'login' button
        WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginButton.click();
    }
    @Test
    public void test6() throws InterruptedException {
//      8. Verify that 'Logged in as username' is visible
        WebElement textIsVisible = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        assertTrue(textIsVisible.isDisplayed());
    }
    @Test
    public void test7() throws InterruptedException {
//      9. Click 'Delete Account' button
        WebElement delete = driver.findElement(By.xpath("//a[@style='color:brown;']"));
        delete.click();
    }
    @Test
    public void test8() throws InterruptedException {
//      10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement account = driver.findElement(By.xpath("//b[.='Account Deleted!']"));
        assertTrue(account.isDisplayed());

    }
}
