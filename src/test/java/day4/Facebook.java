package day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Facebook {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        // driver.close();
    }

    @Test
    public void test() throws InterruptedException {

//    -https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

//-Cookies’i kabul edin

//-“Create an Account” button’una basin
        WebElement kayit=driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        kayit.click();

//-“radio buttons” elementlerini locate edin
        driver.findElement(By.xpath("//select[@name='birthday_day']"));
        driver.findElement(By.xpath("//select[@name='birthday_month']"));
        driver.findElement(By.xpath("//select[@name='birthday_year']"));
        Thread.sleep(2000);
        WebElement cinsiyet1 = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement cinsiyet2 = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement custom = driver.findElement(By.xpath("(//input[@type='radio'])[3]"));

//-Secili degilse cinsiyet butonundan size uygun olani secin
       if (!cinsiyet2.isSelected()){
           cinsiyet2.click();
       }
    }
}
