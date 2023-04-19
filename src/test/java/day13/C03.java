package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C03 extends TestBase {
    /*
        - https://demoqa.com/select-menu sitesine gidin
        - multiple <select> elementini locate edin
        - getOptions(), getFirstSelectedOption(), getAllSelected() methodlarini kullanmak adina:
	    * Farkli secimler yaparak methodlarinizi kullanin ve Assertion yapmayi unutmayin
                */
    @Test
    public void test(){

//        - https://demoqa.com/select-menu sitesine gidin
        driver.get("https://demoqa.com/select-menu");

//        - multiple <select> elementini locate edin
        WebElement options=driver.findElement(By.id("cars"));


//        - getOptions(), getFirstSelectedOption(), getAllSelected() methodlarini kullanmak adina:
        Select select=new Select(options);
        List<WebElement> optionsList=select.getOptions();
        WebElement volvo=driver.findElement(By.xpath("//option[@value='volvo']"));
        WebElement saab=driver.findElement(By.xpath("//option[@value='saab']"));
        WebElement opel=driver.findElement(By.xpath("//option[@value='opel']"));
        WebElement audi=driver.findElement(By.xpath("//option[@value='audi']"));

        for (WebElement w: optionsList){
            if (!(w.getText().equals("Saab") || w.getText().equals("Audi")) ){
continue;
            }
                w.click();

            threadSleep(2);
        }

        //1.yol
        Assert.assertTrue(volvo.isSelected());
        Assert.assertTrue(saab.isSelected());
        Assert.assertTrue(opel.isSelected());
        Assert.assertTrue(audi.isSelected());

//2.yol
        Assert.assertFalse(select.getOptions().get(0).isSelected());
        Assert.assertTrue(select.getOptions().get(1).isSelected());


//	    * Farkli secimler yaparak methodlarinizi kullanin ve Assertion yapmayi unutmayin
//2.secenek
        for (WebElement w: optionsList){
            if (w.getText().equals("Saab") || w.getText().equals("Audi") ){
                continue;
            }
            w.click();

            threadSleep(2);
        }
    }
}
