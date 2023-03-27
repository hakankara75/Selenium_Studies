package day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class BestBuy {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //bestbuy sitesine git
        driver.get("https:www.bestbuy.com");

        //cookies cikarsa kabul et

        //sayfada kac buton bulundugunu yazdiri
        List<WebElement> button=driver.findElements(By.tagName("button"));
        System.out.println(button.size());

        //button uzerindeki yazilari yazdirin
        for (WebElement w:button){
            System.out.println(w.getText());
        }

        driver.close();
    }
}
