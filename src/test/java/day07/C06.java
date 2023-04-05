package day07;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06 extends TestBase {
    /*
    //"https://client.appen.com/sessions/new" sitesine gidin
        //email kismina email yazin
     //Continue tusuna basin
        //password girin
         //Sign In tusuna basin
     */
@Test
    public void test() {
//"https://client.appen.com/sessions/new" sitesine gidin
 driver.get("https://client.appen.com/sessions/new");

    //email kismina email yazin
WebElement emailField = driver.findElement(By.id("session_email"));
      emailField.sendKeys("fgsffgs@outlook.com");

//Continue tusuna basin
    driver.findElement(By.id("continue_button")).click();


    //password girin
    WebElement passwordField = driver.findElement(By.id("session_password"));
    passwordField.sendKeys("8$05KPICk7&oifbr");

    //Sign In tusuna basin
    driver.findElement(By.id("submit_button")).click();
    }
}
