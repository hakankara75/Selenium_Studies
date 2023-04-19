package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class C04 extends TestBase {
    //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver sayfasına gidelim
    //"Enable button after 10 seconds" butonuna basalım
    //Butonun tıklanabilir olduğunu test edin
    @Test
    public void name() {


    https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
    driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

    //"Enable button after 10 seconds" butonuna basalım
        driver.findElement(By.id("enable-button")).click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("disable")));

       //Butonun tıklanabilir olduğunu test edin
        assertTrue(driver.findElement(By.id("disable")).isDisplayed());


    }
}
