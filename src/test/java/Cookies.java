import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import java.time.Duration;

public class Cookies {
    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Before
    public void setUp() {
        driver.get("http://www.google.com");
    }

    @Test
    public void test01() {
        driver.findElement(By.xpath("//div[text()='Alles accepteren']")).click(); // cookies icin aldigim locate
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("The God Father", Keys.ENTER);
    }

    @Test
    public void test02() {
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Lord of the Rings", Keys.ENTER);
    }

    @Test
    public void test03() {

        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Kill Bill", Keys.ENTER);
    }

    @After
    public void tearDown() {
        String [] sonuc = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        System.out.println("Arama Sonuc Sayısı = "+sonuc[1]);
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }
}
