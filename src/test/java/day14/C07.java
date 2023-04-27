package day14;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C07 extends TestBase {
    /*
	Go to URL: https://the-internet.herokuapp.com/dropdown
	Create method selectByIndexTest and Select Option 1 using index .
	Create method selectByValueTest Select Option 2 by value.
	Create method selectByVisibleTextTest Select Option 1 value by visible text.
	Create method printAllTest Print all dropdown value.
	Verify the dropdown has Option 2 text.
	Create method printFirstSelectedOptionTest Print first selected option.
	Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
	 */

    @Test
    public void name() {

//	Go to URL: https://the-internet.herokuapp.com/dropdown
        driver.get("https://the-internet.herokuapp.com/dropdown");

//	Create method selectByIndexTest and Select Option 1 using index .
        WebElement webElement = driver.findElement(By.id("dropdown"));
        webElement.click();

        selectByIndexTest(webElement, 1);
        threadSleep(2);

//	Create method selectByValueTest Select Option 2 by value.
        selectByValueTest(webElement, "2");
        threadSleep(2);

//	Create method selectByVisibleTextTest Select Option 1 value by visible text.
        selectByVisibleTextTesst(webElement, "Option 1");
        threadSleep(2);

//	Create method printAllTest Print all dropdown value.
        List<WebElement> list = driver.findElements(By.id("dropdown"));
        list.forEach(t -> System.out.println(t.getText()));


//	Verify the dropdown has Option 2 text.
        for (WebElement w : list) {
            String str = w.getText();
            assertTextContainsAssertTrue(str, "Option 2");
        }

//	Create method printFirstSelectedOptionTest Print first selected option.
        printFirstSelectedOptionTest("//option[@value='1']");

//	Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
        List<WebElement> webElements = driver.findElements(By.id("dropdown"));
        int size = webElements.size();
        int expectedSize = 3;
        if (expectedSize != size) {

            System.out.println("Expected Is Not Equal Actual");
        }
    }

    public Select selectByIndexTest(WebElement webElement, int index){
        Select select=new Select(webElement);
        select.selectByIndex(index);
return select;
    }

    public Select selectByValueTest(WebElement webElement, String str){
        Select select=new Select(webElement);
        select.selectByValue(str);
        return select;
    }

    public Select selectByVisibleTextTesst(WebElement webElement,String str){
        Select select=new Select(webElement);
        select.selectByVisibleText(str);
        return select;
    }

    public void printAllTest( String str){
      List <WebElement> list= (List<WebElement>) driver.findElement(By.id(str));
       list.forEach(t-> System.out.println(t.getText()));

    }

    public void printFirstSelectedOptionTest(String str){
        String webElement= driver.findElement(By.xpath(str)).getText();
            System.out.println(webElement);


    }
}
