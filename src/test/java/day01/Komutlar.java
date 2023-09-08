package day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class Komutlar {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.google.driver", "src/resorcues/drivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));


        driver.get("https://www.hepsiburada.com"); //verilen adresteki siteyi acar
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //sayfanin tum web elementlerinin acilmasi
        //icin verilen surede bekler. site acilmazsa hata verir.


        driver.manage().window().maximize();        //acilan pencereyi maksimum buyukluge getirir
        driver.manage().window().minimize();        //acilan pencereyi simge durumuna getirir

        Thread.sleep(3000);     //yeni isleme gecmeden once verilen surede bekleme yapar
        driver.manage().window().fullscreen();        //acilan pencereyi tam ekran getirir

        String baslik1 = driver.getTitle(); //Sayfanın başlığını string olarak getirir.

        driver.manage().window().setSize(new Dimension(800, 600)); //ekran olculerini istenen ayara getirir
        Dimension olcu = driver.manage().window().getSize(); //ekran olculerini alir

        System.out.println(olcu.getHeight()); //ekran yukseklik olcusunu verir
        System.out.println(olcu.getWidth()); //ekran genislik olcusunu verir

        driver.manage().window().setPosition(new Point(100, 300)); //pencereyi ekranda istenen konuma tasir
        Point pozisyon = driver.manage().window().getPosition();
        System.out.println(pozisyon);

        driver.navigate().refresh(); //sayfayi yeniler
        String urlGetir=driver.getCurrentUrl();
        System.out.println(urlGetir);

        driver.navigate().to("https://www.haberturk.com/");
        driver.navigate().back(); //bir onceki sayfaya doner
        Thread.sleep(2000);
        driver.get("https://www.linkedin.com/");
        driver.navigate().forward();
        driver.navigate().to("https://gelecegiyazanlar.turkcell.com.tr/user/login"); //yeni sayfa acar
        driver.navigate().forward();
        Thread.sleep(2000);
//driver.quit(); //acik tum browserlari kapatir
        driver.close(); //calisan, acik pencereyi kapatir.


    }
}
