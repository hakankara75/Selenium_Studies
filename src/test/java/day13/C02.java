package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C02 extends TestBase {
    /*
	- https://demoqa.com/select-menu sitesine gidin
	- <select> elementini locate edin
	- <select> elementinin seceneklerini yazdirin
	- Sirasiyla selectByIndex, selectByValue, selectByVisibleText methodlarini kullanarak;
	    * Yellow (index)
	    * Purple (value)
	    * Black  (text)
	    seceneklerini secin
	 */

    @Test
    public void test() {

//	- https://demoqa.com/select-menu sitesine gidin
        driver.get("https://demoqa.com/select-menu");

//	- <Old Style Select Menu> elementini locate edin
        WebElement oldMenu = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(oldMenu);

//	- <Old Style Select Menu> elementinin seceneklerini yazdirin
        List<WebElement> options = select.getOptions();
                options.forEach(t-> System.out.println(t.getText()));

//	- Sirasiyla selectByIndex, selectByValue, selectByVisibleText methodlarini kullanarak seceneklerini secin;
//	    * Yellow (index)
        select.selectByIndex(3);
        threadSleep(2);

//	    * Purple (value)
        select.selectByValue("4");
        threadSleep(2);

//	    * Black  (text)
        select.selectByVisibleText("Black");
        threadSleep(2);

    }
}
