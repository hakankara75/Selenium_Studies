package day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

import static org.junit.Assert.assertTrue;

/*
https://demoqa.com/ url'ine gidin.
Alerts, Frame & Windows Butonuna click yap
""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
New Tab butonunun görünür olduğunu doğrula
New Tab butonuna click yap
Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
İlk Tab'a geri dön
New Tab butonunun görünür olduğunu doğrula

 */
public class C02 extends TestBase {
    @Test
    public void name() {

//https://demoqa.com/ url'ine gidin.
    driver.get("https://demoqa.com/");

//Alerts, Frame & Windows Butonuna click yap
        arrowDown();
        arrowDown();
        threadSleep(2);
driver.findElement(By.xpath("(//div[@class='card-body'])[3]")).click();

//""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
assertTrue(driver.findElement(By.xpath("//div[text()='Please select an item from left to start practice.']")).isDisplayed());

//Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        threadSleep(2);
        driver.findElement(By.xpath("(//li[@id='item-0'])[3]")).click();

//New Tab butonunun görünür olduğunu doğrula
assertTrue(driver.findElement(By.xpath("//button[@id='tabButton']")).isDisplayed());

//New Tab butonuna click yap
        //String sayfa1=driver.getWindowHandle();
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();

//Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        //Set<String> sayfalar= driver.getWindowHandles();
        switchToWindow(1);
        assertTrue(driver.findElement(By.id("sampleHeading")).isDisplayed());
        threadSleep(2);

//İlk Tab'a geri dön
        switchToWindow(0);

////New Tab butonunun görünür olduğunu doğrula
assertTrue(driver.findElement(By.xpath("//button[@id='tabButton']")).isDisplayed());

}
  }