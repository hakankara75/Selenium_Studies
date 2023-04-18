package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C03 extends TestBase {
    /*
    https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
    //"Click me, to open an alert after 5 seconds" butonuna basalım
    //Çıkan alert'i kapatalım
     */
    @Test
    public void name() throws InterruptedException {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver sayfasına gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

//"Click me, to open an alert after 5 seconds" butonuna basalım
        WebElement button=driver.findElement(By.id("alert"));
        button.click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

//Çıkan alert'i kapatalım
        switchAlertAccept();


    }
}
