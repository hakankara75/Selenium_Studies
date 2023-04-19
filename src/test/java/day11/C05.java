package day11;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
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

import static org.junit.Assert.assertTrue;

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
    ExtentReports extentReports;
    ExtentHtmlReporter extentHtmlReporter;
    ExtentTest extentTest;

    @Test
    public void test() throws IOException {

        extentTest=extentReports.createTest("ExtentTest","Test Raporu");
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

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        WebElement webElement = findXpathWebelement("//button[@class='btn btn-dark btn-lg btn-block rounded-0 text-left']");
        Actions actions = new Actions(driver);
        actions.scrollToElement(webElement).perform();
        threadSleep(2);
        extentTest.info("Sayfa Browsers bölümü görünene kadarasagi indirildi");

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        webElement.click();
        threadSleep(2);
        pageDown();
        findByXpathClick("//a[@href='https://chromedriver.chromium.org/']");
        extentTest.info("Browser bölümünden Chrome driver bölümündeki documentation linkine  tiklandi");


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
        threadSleep(3);
        driver.findElement(By.xpath("//td/a[@href='/112.0.5615.49/chromedriver_win32.zip']"));
        extentTest.info("Açılan pencerede chromedriver'i indirildi");


        //Driver'in indiğini doğrulayalım
        String driverPath = System.getProperty("user.home") + "Downloads/chromedriver_win32";
        boolean isExist = Files.exists(Paths.get(driverPath));
        assertTrue(isExist);
        extentTest.info("Driver'in indiğini doğrulandi");

        //İndirmiş olduğumuz dosyayı silelim
        Files.delete(Path.of(driverPath));
        extentTest.info("Indirilen dosya silindi");


        //Silindiğini doğrulayalım
        assertTrue(isExist);
        extentTest.info("Dosyanin silindigi doğrulandi");


    }
}
