package day16;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_SoftAssert extends TestBase {
    //Yeni bir Class Olusturun : C01_SoftAssert
//1. "http://zero.webappsecurity.com/" Adresine gidin
//2. Sign in butonuna basin
//3. Login kutusuna "username" yazin
//4. Password kutusuna "password" yazin
//5. Sign in tusuna basin
//6. Online banking menusu icinde Pay Bills sayfasina gidin
//7. "Purchase Foreign Currency" tusuna basin
//8. "Currency" drop down menusunden Eurozone'u secin
//9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
//10.soft assert kullanarak DropDown listesinin su secenekleri oldugunu test
//edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland
//(franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain
//(pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway
//(krone)","New Zealand (dollar)","Sweden (krona)","Singapore
//(dollar)","Thailand (baht)"
    @Test
    public void name() {
//Yeni bir Class Olusturun : C03_SoftAssert
//1. "http://zero.webappsecurity.com/" Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

//2. Sign in butonuna basin
findByXpathClick("//button[@id='signin_button']");

//3. Login kutusuna "username" yazin
        //4. Password kutusuna "password" yazin
        WebElement login=findXpathWebelement("//input[@id='user_login']");
        Actions actions=new Actions(driver);
        actions.sendKeys(login, "username", Keys.TAB).sendKeys("password", Keys.TAB).perform();

//5. Sign in tusuna basin
findByXpathClick("//input[@type='submit']");

//6. Online banking menusu icinde Pay Bills sayfasina gidin


//7. "Purchase Foreign Currency" tusuna basin
//8. "Currency" drop down menusunden Eurozone'u secin
//9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
//10.soft assert kullanarak DropDown listesinin su secenekleri oldugunu test
//edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland
//(franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain
//(pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway
//(krone)","New Zealand (dollar)","Sweden (krona)","Singapore
//(dollar)","Thailand (baht)"

    }
}
