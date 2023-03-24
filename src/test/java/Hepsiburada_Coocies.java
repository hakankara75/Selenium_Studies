import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.TreeMap;

public class Hepsiburada_Coocies {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.google.driver", "src/resorcues/drivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        //hepsiburada sitesini acip maximize yap
        driver.get("https://www.hepsiburada.com");
        driver.manage().window().maximize();

        Thread.sleep(10000);

        //arama kutusuna iphone yazıp aratin
        WebElement aramakutusu = driver.
                findElement(By.xpath("//input[@class='theme-IYtZzqYPto8PhOx3ku3c']"));
        aramakutusu.sendKeys("iphone" + Keys.ENTER);

        Thread.sleep(5000);

        //kapatin
        driver.close();

/* 2.yol
//    WebElement search=driver.findElement(By.className("theme-PWhtyMC28ov8fuPKvrog"));
//       search.click();
//
//        //xpath-->//tagismi[@attribute="value"]
//       search= driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/div[5]/div/div/div/div/div[2]/div[2]/div/div/div/div/div/div/div[1]/div[2]/input"));
//       search.click();
//        search.sendKeys("isenikam şar"+ Keys.ENTER);
//        search.submit();
 */
    }
}
