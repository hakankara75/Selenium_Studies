package day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class Google {

    static WebDriver driver;
    String godF;
    String lordR;
    String killB;
    HashMap<String ,String> list=new HashMap<>();


    @BeforeClass
    public static void beforeClass() {
        //    -BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void afterClass() throws InterruptedException {
        Thread.sleep(3000);
     // driver.close();
    }

    @Before
    public void setUp() throws InterruptedException {
        //-Before methodunda http://www.google.com adresine gidin

        driver.get("http://www.google.com");
        Thread.sleep(2000);
    }

    @After
    public void tearDown() {
        System.out.println(list);
    }

    @Test
    public void test() throws InterruptedException {
//-arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
        WebElement search = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        search.sendKeys("The God Father");
        search.submit();
        Thread.sleep(2000);


        WebElement god=driver.findElement(By.xpath("//a[@class='spell_orig']"));
        godF= god.getText();
        list.put(godF, sonucKac());
        Thread.sleep(2000);
    }

    @Test
    public void test1() throws InterruptedException {
//-arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
        WebElement search = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        search.sendKeys("Lord of the Rings");
        search.submit();
        Thread.sleep(2000);


        WebElement sonuc = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String text = sonuc.getText();
        String yazdir = text.trim().replaceAll("\\D", "");

        WebElement lord=driver.findElement(By.xpath("//span[@class='yKMVIe']"));
        lordR= lord.getText();
        list.put(lordR, sonucKac());
        Thread.sleep(2000);
    }

    @Test
    public void test2() throws InterruptedException {
//-arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
        WebElement search = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        search.sendKeys("Kill Bill");
        search.submit();
        Thread.sleep(2000);

        WebElement sonuc = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String text = sonuc.getText();
        String yazdir = text.trim().replaceAll("\\D", "");

        WebElement kill=driver.findElement(By.xpath("//span[@class='yKMVIe']"));
        killB= kill.getText();
        list.put(killB, sonucKac());
        Thread.sleep(2000);
    }

public String sonucKac(){
    WebElement sonuc = driver.findElement(By.xpath("//div[@id='result-stats']"));
    String text = sonuc.getText();
    String yazdir = text.trim().replaceAll("\\D", "");
        return yazdir;
}
//-NOT: Çıkan sonuç sayılarını After methodunda yazdırınız
//-AfterClass ile kapatın

}