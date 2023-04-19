package day13;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

/*
Navigate to "https://facebook.com/"
Click to "Yeni Hesap Oluştur"
//Fill the "Adın"
//Fill the "Soyadın"
//Fill the "Cep telefonu numarası"
//Fill the "Yeni şifre"
 //Select the "Doğum Tarihi"
  //Select the "Ay"
     //Select the "Yıl"
    //Select the "Cinsiyet"
    //Click the "Kaydol"
 */
public class C07 extends TestBase {
    @Test
    public void test() {
        Faker faker = new Faker();
        Faker.instance();
        // Navigate to "https://facebook.com/"
        driver.get("https://facebook.com/");

        //Click to "Yeni Hesap Oluştur"
        findByXpathClick("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']");

        //Fill the "Adın"
        WebElement name = findXpathWebelement("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]");
        name.sendKeys(faker.name().firstName());

        //Fill the "Soyadın"
        WebElement surName = findXpathWebelement("(//input[@class='inputtext _58mg _5dba _2ph-'])[2]");
        surName.sendKeys(faker.name().firstName());

        //Fill the "Cep telefonu numarası"
        WebElement cellPhone = findXpathWebelement("(//input[@class='inputtext _58mg _5dba _2ph-'])[3]");
        cellPhone.sendKeys(faker.phoneNumber().cellPhone());

        //Fill the "Yeni şifre"
        WebElement password = findXpathWebelement("(//input[@type='password'])[2]");
        password.sendKeys(faker.internet().password());

        //Select the "Doğum Tarihi"
        WebElement day = findByIdWebelement("day");
        Select select = new Select(day);
        select.selectByValue("14");

        //Select the "Ay"
        WebElement month = findByIdWebelement("month");
        select = new Select(month);
        select.selectByValue("7");

        //Select the "Yıl"
        WebElement year = findByIdWebelement("year");
        select = new Select(year);
        select.selectByValue("2000");

        //Select the "Cinsiyet"
        findByXpathClick("(//label[@class='_58mt'])[2]");

        //Click the "Kaydol"
        findByXpathClick("(//button[@type='submit'])[2]");


    }
}
