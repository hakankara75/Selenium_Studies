package day07;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04 extends TestBase {
/*     https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
 ikinci emojiye tıklayın
 tüm ikinci emoji öğelerini tıklayın
 parent iframe e geri donun
 formu doldurun,(Formu istediğiniz metinlerle doldurun)
 apply button a basiniz
  */
@Test
    public void test1(){
    // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
    driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

// ikinci emojiye tıklayın

    driver.switchTo().frame(1);
    driver.findElement(By.xpath("//a[@href='#nature']")).click();

// tüm ikinci emoji öğelerini tıklayın
    driver.findElement(By.xpath("//div[@class='mdl-tabs__panel is-active']")).click();

// parent iframe e geri donun
    driver.switchTo().parentFrame();

// formu doldurun,(Formu istediğiniz metinlerle doldurun)
    driver.findElement(By.xpath("//input[@id='text']")).sendKeys("<cömcön");
    driver.findElement(By.xpath("//input[@id='smiles']")).sendKeys("kahkf");
    driver.findElement(By.xpath("//input[@id='nature']")).sendKeys("mehvzvmet");
    driver.findElement(By.xpath("//input[@id='food']")).sendKeys("önkAJF");
    driver.findElement(By.xpath("//input[@id='activities']")).sendKeys("JCBAK");
    driver.findElement(By.xpath("//input[@id='places']")).sendKeys("bkscba");
    driver.findElement(By.xpath("//input[@id='objects']")).sendKeys("VKVL");
    driver.findElement(By.xpath("//input[@id='symbols']")).sendKeys("kjbK");
    driver.findElement(By.xpath("//input[@id='flags']")).sendKeys("KAKHBFKB");
    driver.findElement(By.xpath("//input[@id='hide']")).sendKeys("mbjgFJ");
    driver.findElement(By.xpath("//input[@id='active']")).sendKeys("KJBbk");
threadSleep(3);
// apply button a basiniz
    driver.findElement(By.xpath("//button[@id='send']")).click();
}

}
