package day5;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SignUpNegative {

    WebDriver driver;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        //driver.close();
    }

    @Test
    public void test() throws InterruptedException {
//        3. Verify that home page is visible successfully
        WebElement html=driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(html.isDisplayed());

//        4. Click on 'Signup / Login' button
        WebElement signup=driver.findElement(By.xpath("//a[@href='/login']"));
        signup.click();

//        5. Verify 'Login to your account' is visible
        WebElement login=driver.findElement(By.xpath("//h2[.='Login to your account']"));
        Assert.assertTrue(login.isDisplayed());
        Thread.sleep(2000);

//        6. Enter incorrect email address and password
                WebElement email=driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("sgsh@gmail.com");

        WebElement password=driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        password.sendKeys("4333363");

//        7. Click 'login' button
        WebElement loginButton=driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginButton.click();
        Thread.sleep(2000);

//        8. Verify error 'Your email or password is incorrect!' is visible
        WebElement text=driver.findElement(By.xpath("//p[@style='color: red;']"));
Assert.assertTrue(text.isDisplayed());

    }
}
