package day08;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04 extends TestBase {
    @Test
    public void test() {
        // driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        //A yı B ye drag and drop yap
        WebElement a=driver.findElement(By.id("column-a"));
        WebElement b=driver.findElement(By.id("column-b"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(a,b).build().perform();
        threadSleep(2);

        //2. yol
        actions.clickAndHold(a).moveToElement(b).release().build().perform();
        threadSleep(2);

    }
}
