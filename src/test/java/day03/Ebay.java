package day03;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ebay {
    /*

   - Her sayfanın sayfa başlığını yazdıralım
   - sayfayı kapatalım

   */
    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }


    @Test
    public void test01() throws InterruptedException {
        //- ebay sayfasına gidiniz
        driver.get("https://www.ebay.com");
        // electronics bölümüne tıklayınız
        WebElement elektronics = driver.findElement(By.xpath("//a[@_sp='p2481888.m1379.l3250']"));
        elektronics.click();
        Thread.sleep(2000);
//- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım

        List<WebElement> images = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
        for (int i = 0; i < images.size(); i++) {

            List<WebElement> img = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
            img.get(i).click();
            driver.navigate().back();
        }
    }
}



