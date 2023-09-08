package day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Amazon {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //amazon sitesine gidin
        driver.get("https:www.amazon.com");

        //arama kutusuna "nutella" yazin
        WebElement amazon=driver.findElement(By.id("twotabsearchtextbox"));
        amazon.sendKeys("nutella"+ Keys.ENTER);

        //sonucu yazdirin
        WebElement sonuc=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("Sonuc: " +sonuc.getText());
        Thread.sleep(2000);
        //kapat
        driver.close();




    }
}
