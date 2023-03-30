package day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02 {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
            driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
       //http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
       driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        //Add Element butonuna 100 defa basınız
        WebElement addButton=driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        for (int i = 0; i < 100; i++) {
            WebElement add=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
            add.click();
        }
        Thread.sleep(2000);

        //100 defa basıldığını test ediniz
        List<WebElement> deleteButtons= driver.findElements(By.xpath("//button[@class='added-manually']"));
        int elemanCount=deleteButtons.size();
        if (elemanCount==100)
            System.out.println("Test PASSED");
        else
            System.out.println("Test FAILED");
        Thread.sleep(2000);

        //- 90 defa delete butonuna basınız
        WebElement deleteCancel=driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));

        for (int i = 0; i < 90; i++) {
            WebElement delete=driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
            delete.click();
        }
        Thread.sleep(2000);

        //- 90 defa basıldığını doğrulayınız
        List<WebElement> deleteButtonList = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        int kalanDeleteButton = deleteButtonList.size()-90;
        Assert.assertEquals(kalanDeleteButton,deleteButtonList.size());
        Thread.sleep(2000);
        }

}
