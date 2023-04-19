package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
/*
 https://the-internet.herokuapp.com/upload adresine gidin
 logo.jpeg dosyasını yükleyin(uopload)
 "File Uploaded!" textinin görüntülendiğini test edin
 */
public class C06 extends TestBase {
    @Test
    public void test(){
//    https://the-internet.herokuapp.com/upload adresine gidin
        driver.get("https://the-internet.herokuapp.com/upload");

//    logo.jpeg dosyasını yükleyin(uopload)
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        threadSleep(2);

        chooseFile.sendKeys(System.getProperty("user.home")+"/Desktop/logo.jpeg");
        threadSleep(2);

        driver.findElement(By.id("file-submit")).click();

//    "File Uploaded!" textinin görüntülendiğini test edin
WebElement logoText=driver.findElement(By.id("uploaded-files"));
assertDisplayedWebelement(logoText);

//2.yol
String actualText= findByXpathString("//h3[text()='File Uploaded!']");
        String expectedText="File Uploaded!";
asserTextContainsAssertTrue(actualText, expectedText);

    }
}
