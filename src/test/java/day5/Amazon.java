package day5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Amazon {
    WebDriver driver;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //    -Amazon sayfasına gidelim
        driver.get("http://amazon.com");

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {

//-Arama Kutusundaki Dropdown menuyu yazdıralım
        //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        //            başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
        ////            Not: Select Class'ı kullanalım

        WebElement dropDown= driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select select=new Select(dropDown);
        List<WebElement> liste=select.getOptions();
        liste.forEach(t-> System.out.println(t.getText()));
        for(int i=1; i<6 ; i++){
            WebElement dropDown1= driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
            Select select1=new Select(dropDown1);
            select1.selectByIndex(i);
            driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
            System.out.println(i+". sayfa başlığı = " + driver.getTitle());
            Thread.sleep(3000);
            driver.navigate().back();

    }
}
}