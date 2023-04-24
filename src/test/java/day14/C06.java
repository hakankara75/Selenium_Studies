package day14;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class C06 extends TestBase {
    /*
	- https://demoqa.com/select-menu sitesine gidin
	- Multiple select yapabileceginiz <select> elementini locate edin
	- Birden fazla secim yapip secimlerinizi DOGRULAyin
	 */
    @Test
    public void name() {
//	- https://demoqa.com/select-menu sitesine gidin
        driver.get("https://demoqa.com/select-menu");

//	- Multiple select yapabileceginiz <select> elementini locate edin
        WebElement webElement=driver.findElement(By.id("cars"));

//	- Birden fazla secim yapip secimlerinizi DOGRULAyin
        Select select= new Select(webElement);
        select.selectByValue("volvo");
        select.selectByIndex(1);
        select.selectByVisibleText("Audi");

        assertTrue(driver.findElement(By.xpath("//option[@value='volvo']")).isSelected());
        assertTrue(driver.findElement(By.xpath("//option[@value='saab']")).isSelected());
        assertTrue(driver.findElement(By.xpath("//option[@value='audi']")).isSelected());
        assertFalse(driver.findElement(By.xpath("//option[@value='opel']")).isSelected());






    }
}
