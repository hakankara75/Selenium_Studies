package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {
    //TestBase class'indan obje olusturmanin onune gecilmesi icin abstract yapilabilir
//Orn: TestBase base=new TestBase();
//Bu class'a extend ettigimiz test classlarinda ulasabiliriz.
    protected static WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

    public static void threadSleep(int sleep) {
        try {
            Thread.sleep(sleep * 1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void xpath(String str){
        driver.findElement(By.xpath(str));
    }
    public void xpathClick(String str){
        driver.findElement(By.xpath(str)).click();
    }

    public void textContainsAssertTrue(String str, String atr){
        Assert.assertTrue(str.contains(atr));
    }

    public void switchAlertAccept(){
        driver.switchTo().alert().accept();
    }

    public void switchAlertDismiss(){
        driver.switchTo().alert().dismiss();
    }

    public void switchAlertSendKey(String str){
        driver.switchTo().alert().sendKeys(str);
    }

}
