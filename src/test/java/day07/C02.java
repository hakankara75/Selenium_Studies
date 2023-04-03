package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.Assert.assertTrue;

public class C02  extends TestBase{
@Test
        public void test() throws InterruptedException {

		driver.get("http://spicejet.com/");

 Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath("//div[text()='About Us']"))).build().perform();

		Thread.sleep(3000);

		driver.findElement(By.linkText("Fleet")).click();
}
 }