package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class C05 extends TestBase {

    @Test
    public void name() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver sayfasına gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

// 'Check Checkbox after 10 seconds' butonuna tikla
        driver.findElement(By.id("checkbox")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//input[@type='checkbox']")));

// 'checkbox' butonunun tiklandigini test edin.
assertTrue(driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected());

    }
}
