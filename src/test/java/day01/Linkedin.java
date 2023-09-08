package day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Linkedin {
    public static void main(String[] args) throws InterruptedException {
        // driver a baglan
        System.setProperty("webdriver.google.driver", "src/resorcues/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        //ekrani maximize yap
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //linkedin sitesine baglan
        driver.get("https://www.linkedin.com/");
        WebElement kullaniciAdiGir = driver.findElement(By.id("session_key"));
        kullaniciAdiGir.submit();
        kullaniciAdiGir.sendKeys("gdgfsd@gmail.com");

        WebElement sifreGir =driver.findElement(By.id("session_password"));
        sifreGir.sendKeys(",kgG8790");
        sifreGir.submit();
        Thread.sleep(3000);
        WebElement telGir =driver.findElement(By.id("phone-input"));
        telGir.sendKeys("5555555555");
        telGir.submit();
        //driver.close();

        WebElement sonrakiVideoyuIzle = driver.findElement(By.id("ember735"));

    }
}
