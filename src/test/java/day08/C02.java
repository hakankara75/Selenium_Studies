package day08;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class C02 extends TestBase {

    @Test
    public void name() {
//"https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/" sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

        //Multi Selection menusunde choice 2 yi secin
       WebElement msMenu= driver.findElement(By.xpath("//input[@id='justAnInputBox']"));
       msMenu.click();
        driver.findElement(By.xpath("(//span[@data-id='10'])[1]")).click();
               threadSleep(3);

//Multi Selection With Cascade Option Select menusunde choice 2 3 u secin
        driver.findElement(By.xpath("//input[@id='justAnInputBox1']")).click();
        driver.findElement(By.xpath("(//span[@data-id='12'])[2]")).click();
        threadSleep(3);

//Single Selection menusunde choice 6 2 1 i secin
        driver.findElement(By.xpath("//input[@id='justAnotherInputBox']")).click();
        driver.findElement(By.xpath("(//span[@data-id='510'])[3]")).click();
        threadSleep(3);



    }
}
