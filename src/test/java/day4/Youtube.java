package day4;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Youtube {
    WebDriver driver;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        1)https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {

//                => Sayfa başlığının “YouTube” oldugunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "YouTube";
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void test1() throws InterruptedException {

//                => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement image = driver.findElement(By.xpath("//yt-icon[@id='logo-icon']"));
        Assert.assertTrue(image.isDisplayed());
    }
    @Test
    public void test2() throws InterruptedException {
//○Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement search = driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(search.isEnabled());
    }
    @Test
    public void test3() throws InterruptedException {
//○wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle=driver.getTitle();
        String expectedTitle="youtube";
        boolean a=actualTitle.equals(expectedTitle);
        Assert.assertFalse(a);

    }


}
