package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C06 extends TestBase {
    /*
    Go to URL: "https://www.n11.com/"
    Click "Daha Sonra"
    Scroll to bottom of page
    Reject the cookies where showed with bottom of page
    Click to scroll up button
    Go to "Spor Outdoor" and show menu
    Click to "Su Sporları"
    Click to "Konum Seç"
Select to "Bitlis"
Select to "Güroymak"
Click to "Konum Seç"
         */
    @Test
    public void test() throws InterruptedException {
        //Go to URL: "https://www.n11.com/"
        driver.get("https://www.n11.com/");

        //Click "Daha Sonra"
        driver.findElement(By.xpath("(//button[text()='Daha Sonra'])[1]")).click();



//Reject the cookies where showed with bottom of page
        SearchContext sc = driver.findElement(By.xpath("//efilli-layout-n11[@class='efilli-layout-n11']")).getShadowRoot();
/* SearchContext, Java Selenium'da bir interface'dir. Bu interface, web sayfalarındaki elementleri bulmak için kullanılan
 yöntemlerin çoğunu tanımlar.
 Yani, WebElement'ler ve WebDriver'lar gibi elementleri bulmak için kullanabileceğiniz tüm yöntemleri içerir.
 getShadowRoot() yöntemi, bir WebElement öğesinin Shadow DOM'unu döndürür. Bu yöntem, bir web sayfasındaki bir
 öğenin Shadow DOM'unu aramak için kullanılır. Eğer öğenin bir Shadow DOM'u yoksa, null değeri döndürür.*/
        WebElement rejectButton = sc.findElement(By.className("banner__reject-button"));
        rejectButton.click();

        //Scroll to bottom of page
        Actions actions = new Actions(driver);
        WebElement cepTelefonu = driver.findElement(By.xpath("(//a[@title='Cep Telefonu'])[2]"));
                actions.scrollToElement(cepTelefonu).build().perform();
        Thread.sleep(2000);

        //Click to scroll up button
        driver.findElement(By.id("btnScrollTop")).click();
        Thread.sleep(2000);

        // Go to "Spor Outdoor" and show menu
        WebElement element=driver.findElement(By.xpath("(//li[@class='catMenuItem'])[7]"));
        actions.moveToElement(element).perform();
        Thread.sleep(2000);

        //Click to "Su Sporları"
        driver.findElement(By.xpath("//img[@src='https://n11scdn.akamaized.net/a1/70/22/06/23/61/51/71/79/52/58/24/01/41/33679029720136331959.png']")).click();
        Thread.sleep(2000);

        //Click to "Konum Seç"
        driver.findElement(By.xpath("//span[@class='checkbox-switch-slider']")).click();

        //Select to "Bitlis"
        WebElement il=driver.findElement(By.id("headerMyLocationCityId"));
        il.click();
        Select select=new Select(il);
        select.selectByValue("2513");

        //Select to "Güroymak"
        WebElement ilce=driver.findElement(By.id("headerMyLocationDistrictId"));
        ilce.click();
        select.selectByIndex(4);

        //Click to "Konum Seç"
        driver.findElement(By.xpath("headerSetMyLocationBtn")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//label[@for='local-special-checkbox']")).click();


    }
}
