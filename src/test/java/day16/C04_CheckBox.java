package day16;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_CheckBox extends TestBase{
    @Test
    public void name() {
        driver.get("http://www.automationpractice.pl/index.php");
        driver.findElement(By.xpath("//a[@title='Women']")).click();
        driver.findElement(By.xpath("//input[@id='layered_category_4']")).click();
        driver.close();

    }
}
