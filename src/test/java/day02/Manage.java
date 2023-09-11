package day02;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Manage {
    public static void main(String[] args) {

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //getSize
        driver.manage().window().getSize(); //sayfanin olculerini verir 1050x832

        //getPosition
        driver.manage().window().getPosition(); //sayfanin pozisyonunu verir. sol alt koseden olcer

        //setPosition
        driver.manage().window().setPosition(new Point(15,15)); //pozisyonu ayarlar

        //setSize
        driver.manage().window().setSize(new Dimension(90,600)); //olcuyu ayarlar

        //implicitlyWait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //calisma suresini bekletme. sayfa acilmesini bekler
        //bu surede sayfa acilmazsa hata verir.


        //


    }
}
