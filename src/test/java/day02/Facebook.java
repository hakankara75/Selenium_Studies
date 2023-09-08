package day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Facebook {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //facebook a git
        driver.get("https:www.facebook.com");

        //email gir
        WebElement email=driver.findElement(By.xpath("//input[@placeholder='E-posta veya Telefon Numarası']"));
        email.sendKeys("gskşlsfggs");

        //sifre gir
        WebElement sifre=driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy _9npi']"));
        sifre.sendKeys("098435tol34thj3k3");

        //"giriş yap" a bas
        driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']")).click();

        //sonuc yazisini al
        WebElement sonuc=driver.findElement(By.xpath("//div[@class='_9ay7']"));
        String expectedSonuc="Girdiğin e-posta veya cep telefonu numarası bir hesaba bağlı değil. Hesabını bul ve giriş yap.";
        String actualSonuc=sonuc.getText();
        if (actualSonuc.equals(expectedSonuc))
            System.out.println("Test PASSED");
        else
            System.out.println("Test FAILED");
        driver.close();
    }
}
