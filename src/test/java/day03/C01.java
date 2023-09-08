package day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class C01 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
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
    public void test01() {
driver.get("https://www.n11.com");
WebElement cookies= driver.findElement(By.xpath("//button[@class='dn-slide-deny-btn']"));
cookies.click();

        // çerezleri silmek için
        Set<Cookie> cook = driver.manage().getCookies();
        for (Cookie cookie : cook) {
            driver.manage().deleteCookie(cookie);
    }
}


}