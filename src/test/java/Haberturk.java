import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
public class Haberturk {
    public static void main(String[] args) throws InterruptedException {
        // driver a baglan
        System.setProperty("webdriver.google.driver", "src/resorcues/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        //ekrani maximize yap
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //haberturk sitesine baglan
        driver.get("https://www.haberturk.com/");
        Thread.sleep(5000);
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@src=\'https://im.haberturk.com/assets/images/icon/icon-search-white.svg\']"));
        aramaKutusu.click();
        // absolute xpath   WebElement hbr=driver.findElement(new By.ByXPath("/html/body/header/div[1]/div[1]/div/div[3]/ul/li[3]/span"));
        //xpath-->//tagismi[@attribute="value"]

        //canli yayin haber ekranini kapatin
        Thread.sleep(5000);
        WebElement canliYayinKapat = driver.findElement(By.xpath("//button[.='Kapat']"));
        canliYayinKapat.click();

        //arama kutusuna iftar saatleri yazip aratin
        WebElement aramaKutusuYaz = driver.findElement(By.id("headerSearchInput"));
        aramaKutusuYaz.sendKeys("iftar saatleri" + Keys.ENTER);
        Thread.sleep(5000);

        //ilk sayfaya geri donun
        driver.navigate().back();

        //arama kutusunu acin, icini temizleyin
        WebElement aramaKutusuAc = driver.findElement(By.xpath("//*[@src=\'https://im.haberturk.com/assets/images/icon/icon-search-white.svg\']"));
        aramaKutusuAc.click();
        Thread.sleep(5000);
        WebElement aramaKutusuTemizle = driver.findElement(By.id("headerSearchInput"));
        aramaKutusuTemizle.clear();
        Thread.sleep(5000);
        driver.close();
    }
}
