package day06;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04 extends TestBase {
    @Test
    public void test() {
//        -http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");
        threadSleep(2);

//        -Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        findByXpathClick("//button[@class='btn btn-danger']");

//        -Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        System.out.println(driver.switchTo().alert().getText());
        switchAlertAccept();

//-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        driver.findElement(By.xpath("//a[@href='#CancelTab']")).click();
        driver.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();

//                -Çıkan alert'te iptal butonuna basınız

        switchAlertDismiss();

//-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        driver.findElement(By.xpath("//a[@href='#Textbox']")).click();
        driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();


//        -Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        switchAlertSendKey("Hakan");
        switchAlertAccept();

//        -Çıkan mesajı konsola yazdırınız
        String message = driver.findElement(By.xpath("//p[@id='demo1']")).getText();
        System.out.println(message);

// -Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        assertTextContainsAssertTrue(message, "Hello Hakan How are you today");


    }
}
