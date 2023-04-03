package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03 extends TestBase {
    /*

    https://nunzioweb.com/ sitesine git
    sitenin gorunur oldugunu test et
//soldaki photo page tıklayın
//ana sayfaya geri donun

     */


    @Test
    public void test(){
        //https://nunzioweb.com/ sitesine git
       driver.get("https://nunzioweb.com/");

        //sitenin gorunur oldugunu test et
                WebElement  page= driver.findElement(By.xpath("//html"));
        Assert.assertTrue(page.isDisplayed());

//soldaki photo page tıklayın
        WebElement main=driver.findElement(By.xpath("(//td[@onmouseover='cellover1(this)'])[8]"));
        main.click();
        threadSleep(2);

        //ana sayfaya geri donun
        driver.navigate().back();
        threadSleep(2);

        //"A television show that Nunzio always liked was" yazan kisimda play tusuna basin
        driver.switchTo().frame()
        WebElement play=driver.findElement(By.xpath("//button[@title='Play/Pause'])[1]"));
        play.click();
        threadSleep(2);

    }
}
