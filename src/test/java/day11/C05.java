package day11;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C05 extends TestBase {
    //https://www.selenium.dev/downloads/ adresine gidelim
    //Sayfanın resmini alalım
    //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
    //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
    //Documentation webelementinin resmini alalım
    //All versions available in Downloads altında Latest stable release olan linki tıklayalım
    //Açılan pencerede chromedriver'i indirelim
    //Driver'in indiğini doğrulayalım
    //İndirmiş olduğumuz dosyayı silelim
    //Silindiğini doğrulayalım
    //Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)


    @Test
    public void test() throws IOException {

        extentTest=extentReports.createTest("ExtentTest","Test Raporu");
        ExtentTest test = extentReports.createTest("testName", "testDescription");
        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");
        extentTest.info("Selenium sayfasına gidildi");

        //Sayfanın resmini alalım
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/screenshot" + tarih + ".png";
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        try {
            FileUtils.copyFile(takesScreenshot.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.info("Sayfanın resmi alindi");
        threadSleep(2);

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        WebElement webElement = findXpathWebelement("//button[@class='btn btn-dark btn-lg btn-block rounded-0 text-left']");
        Actions actions = new Actions(driver);
        actions.scrollToElement(webElement).perform();
        threadSleep(2);
        extentTest.info("Sayfa Browsers bölümü görünene kadarasagi indirildi");
        threadSleep(2);

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        webElement.click();
        threadSleep(2);
        pageDown();
        findByXpathClick("//a[@href='https://chromedriver.chromium.org/']");
        extentTest.info("Browser bölümünden Chrome driver bölümündeki documentation linkine  tiklandi");
        threadSleep(2);

        //yeni sayfaya geçtik
        String w1Handle=driver.getWindowHandle();
        extentTest.info("yeni sayfanın handle değeri alındı");
        threadSleep(2);

        //Documentation webelementinin resmini alalım
        webElement = findXpathWebelement("//span[text()='ChromeDriver Documentation']");
        try {
            FileUtils.copyFile(webElement.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.info("Documentation webelementinin resmi alindi");


        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        threadSleep(2);
        findByXpathClick("//span[text()='ChromeDriver 112.0.5615.49']");
        extentTest.info("All versions available in Downloads altında Latest stable release olan link tiklandi");


        //Açılan pencerede chromedriver'i indirelim
        Set<String> wHandles=driver.getWindowHandles();
        System.out.println(wHandles);
        //yeni sayfaya geçebilmek için ilk sayfanın handle değerini loop içinde sorgulatarak diğer sayfaya geçiş sağlıyoruz.
        for (String w:wHandles){
            if(!w.equals(w1Handle)){
                driver.switchTo().window(w);
                driver.findElement(By.xpath("//a[@href='/112.0.5615.49/chromedriver_win32.zip']")).click();

            }
        }
        extentTest.info("yeni sayfadan chrome driver indirildi");


        //Driver'in indiğini doğrulayalım
        threadSleep(10);
        String filePath = System.getProperty("user.home")+"/Downloads/chromedriver_win32.zip";
        boolean isExist = Files.exists(Path.of(filePath));
        Assert.assertTrue(isExist);
        extentTest.info("indirilen dosyanın varlığı doğrulandı");


        //silelim
        threadSleep(3);
        File indirilen=new File(filePath);
        indirilen.delete();
        extentTest.info("indirilen dosya silindi");

        //silindiği doğrulayalım
        threadSleep(3);
        Assert.assertFalse(Files.exists(Path.of(filePath)));
        extentTest.info("indirilen dosyanın silindiği doğrulandı");

        extentTest.pass("test sonlandırıldı");

        extentReports.flush();

    }
}
