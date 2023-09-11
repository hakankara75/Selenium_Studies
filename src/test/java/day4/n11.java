package day4;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class n11 {
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
        // driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        // "https://www.n11.com/" adresine gidin
        driver.get("https://www.n11.com/");

        //cerezi reddedin
        Thread.sleep(2000);
        WebElement uyari= driver.findElement(By.xpath("//div[@id='myLocation-close-info']"));
        uyari.click();

        Thread.sleep(3000);
        WebElement cookies = driver.findElement(By.xpath("//button[@class='dn-slide-deny-btn'][1]"));
        cookies.click();

        //arama kutusuna pantolon kelimesi girip aratin
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='searchData']")).sendKeys("pantolon"+Keys.ENTER);

        //cikan sayfada ortadaki pantolona locate alip sag ve solundakini tiklayin.
        WebElement sabitNokta=driver.findElement(By.xpath("//img[@data-lazy='https://n11scdn.akamaized.net/a1/226_339/01/84/34/52/IMG-3460134112216113854.jpg']"));
        driver.findElement(with(By.tagName("img")).toRightOf(sabitNokta)).submit();
        Thread.sleep(2000);
        driver.navigate().back();

        Thread.sleep(2000);
        driver.findElement(with(By.tagName("img")).toLeftOf(sabitNokta)).submit();
        Thread.sleep(2000);
        driver.navigate().back();
    }
}
