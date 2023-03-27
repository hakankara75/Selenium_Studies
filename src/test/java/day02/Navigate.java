package day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigate {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize();

        // "https://www.amazon.com" adresine gidin.
        driver.get("https://www.amazon.com");

        // "https://www.facebook.com" adresine gidin.
        driver.navigate().to("https://www.facebook.com"); //onceki siteye donmek istersek navigate kullanilmali
        Thread.sleep(2000);// 2 saniye bekler

        // amazon a geri donun
        driver.navigate().back(); // amazona doner
        Thread.sleep(2000);// 2 saniye bekler

        //facebook a donun
        driver.navigate().forward(); //facebook a gider
        Thread.sleep(2000);// 2 saniye bekler

        //kapatin
        driver.close();


    }
}
