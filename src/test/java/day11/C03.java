package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C03 extends TestBase {
    /*
    -https://jqueryui.com/slider/#colorpicker adrese gidiniz
    -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
    -Sarı olduğunu test edelim
     */
    @Test
    public void test() {
//        -https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");

//        -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız


        driver.switchTo().frame(0);
        Actions actions = new Actions(driver);
        WebElement two = findXpathWebelement("//div[@id='green']/span");
        threadSleep(2);
        actions.moveToElement(two).clickAndHold().moveByOffset(-165, 0).release().build().perform();

        String actualRedResult = findXpathWebelement("//div[@style='background-color: rgb(255, 0, 60);']").
                getCssValue("background-color");
        String expectedRedResult = "rgba(255, 0, 60, 1)";
        assertEquals(actualRedResult, expectedRedResult);
        threadSleep(2);

//                -Sarı olduğunu test edelim
        actions.moveToElement(two).clickAndHold().moveByOffset(330, 0).release().build().perform();
        String actualYellowesult = findXpathWebelement("//div[@style='background-color: rgb(255, 255, 60);']").
                getCssValue("background-color");
        String expectedYellowResult = "rgba(255, 255, 60, 1)";
        assertEquals(actualYellowesult, expectedYellowResult);
        threadSleep(2);


    }
}
