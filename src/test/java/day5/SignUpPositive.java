package day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class SignUpPositive {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        //      3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//html[@lang='en']"));
        assertTrue(homePage.isDisplayed());

//      4. Click on 'Signup / Login' button
        WebElement login = driver.findElement(By.xpath("//a[@href='/login']"));
        login.click();

//      5. Verify 'Login to your account' is visible
        WebElement text = driver.findElement(By.xpath("//h2[.='Login to your account']"));
        assertTrue(text.isDisplayed());

//      6. Enter correct email address and password
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("password@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        password.sendKeys("123456");

//      7. Click 'login' button
        WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginButton.click();

//      8. Verify that 'Logged in as username' is visible
        WebElement textIsVisible = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        assertTrue(textIsVisible.isDisplayed());

//      9. Click 'Delete Account' button
        WebElement delete = driver.findElement(By.xpath("//a[@style='color:brown;']"));
        delete.click();

//      10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement account = driver.findElement(By.xpath("//b[.='Account Deleted!']"));
        assertTrue(account.isDisplayed());

    }
}
