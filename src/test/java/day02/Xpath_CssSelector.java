package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class Xpath_CssSelector {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("chromeDriver", "src/source/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.n11.com");
        Thread.sleep(10000);



       WebElement kapat = driver.findElement(By.xpath("//*[@id='dengage-push-perm-slide']/div/div[2]/div/button[1]"));
        //WebElement kapat=driver.findElement(By.cssSelector("button[class='dn-slide-deny-btn']"));
        //WebElement kapat = driver.findElement(By.xpath("//button[text()='dn-slide-deny-btn'][1]")); //calismadi
        kapat.click();

        WebElement arama=driver.findElement(By.cssSelector("input[id='searchData']"));
        arama.click();

        arama.sendKeys("System.out.println(\" \");\n" +
                "        input= new Scanner(System.in);\n" +
                "        System.out.println(\"Lutfen ilk degerini giriniz\");\n" +
                "        int ilk=input.nextInt();\n" +
                "        System.out.println(\"Lutfen son degerini giriniz\");\n" +
                "        int son=input.nextInt();\n" +
                "        if (baslangic>bitis){\n" +
                "            System.out.println(\"verdiginiz deger bitis degerinden kucuk olmali\");\n" +
                "        }else {\n" +
                "            for (int i = ilk; i <=son ; i++) {\n" +
                "                if (i%2==0){\n" +
                "                    System.out.print(i+ \" \");\n" +
                "                }\n" +
                "            }\n" +
                "        }", Keys.ENTER);

        Thread.sleep(2000);

        System.out.println("========================================================================");
        System.out.println(driver.getPageSource()); //sayfanin kaynak kodalarini yazdirir. bunu str atip icinde kelime arariz
        String source= driver.getPageSource();
        System.out.println("========================================================================");

        System.out.println(driver.getWindowHandle());// hash degerini yazidir
        driver.close();
    }
}
