package day08;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05 extends TestBase {
    @Test
    public void name() {
        //"http://demo.guru99.com/test/delete_customer.php" adresine gidin
        driver.get("http://demo.guru99.com/test/delete_customer.php");

       //Customer ID kismina 1111 girin
        WebElement customerId=driver.findElement(By.xpath("//input[@name='cusid']"));
        customerId.sendKeys("1111");
        threadSleep(2);

        //submit tusuna basin
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        threadSleep(2);

        //alerti kapatin ve mesajini alin
                Alert alert=driver.switchTo().alert();
                String alert1=alert.getText();
        System.out.println(alert1);
                alert.accept();
                threadSleep(2);

        //alerti kapatin ve mesajini alin
        String alert2=alert.getText();
        System.out.println(alert2);
        alert.accept();
        threadSleep(2);
    }
}
