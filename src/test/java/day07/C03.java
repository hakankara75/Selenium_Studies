package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class C03 extends TestBase {
    /*
https://nunzioweb.com/ sitesine git
 sitenin gorunur oldugunu test et
soldaki photo page tıklayın
ana sayfaya geri donun
"A television show that Nunzio always liked was" yazan kisimda play tusuna basin
 parent iframe e geri donun
Navigation menusunun elemanlarını yazdirin
How to Access Free Yahoo! Mail with Outlook linkini tiklayin
ilk sayfaya geri donun

     */


    @Test
    public void test() {
        //https://nunzioweb.com/ sitesine git
        driver.get("https://nunzioweb.com/");

        //sitenin gorunur oldugunu test et
        WebElement page = driver.findElement(By.xpath("//html"));
        Assert.assertTrue(page.isDisplayed());

//soldaki photo page tıklayın
        WebElement main = driver.findElement(By.xpath("(//td[@onmouseover='cellover1(this)'])[8]"));
        main.click();
        threadSleep(2);

        //ana sayfaya geri donun
        driver.navigate().back();
        threadSleep(2);

        //"A television show that Nunzio always liked was" yazan kisimda play tusuna basin
        driver.switchTo().frame(1);
        WebElement play = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
        play.click();
        threadSleep(5);

        // parent iframe e geri donun
        driver.switchTo().parentFrame();

        //Navigation menusunun elemanlarını yazdirin
        String menu = driver.findElement(By.xpath("//table[@class='mainmenu']")).getText();
        System.out.println(menu);

        //How to Access Free Yahoo! Mail with Outlook linkini tiklayin
        driver.findElement(By.xpath("//a[@title='How to Access Free Yahoo! Mail with Outlook']")).click();
        threadSleep(3);

        //ilk sayfaya geri donun
        List<String> windowHandleList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandleList.get(0));
        threadSleep(3);


    }
}
