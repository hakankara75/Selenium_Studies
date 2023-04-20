package day14;

import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/*
 Techproeducation sayfasina gidelim
        sayfanin resmini alalim
        Sonra amazon sayfasına gidelim
        Amazon sayfasının ekran görüntüsünü alalım
 */
public class C01 extends TestBase {

    @Test
    public void test() {
        extentTest=extentReports.createTest("ExtentTest","Test Raporu");
        ExtentTest test = extentReports.createTest("testName", "testDescription");
        //Techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
               extentTest.info("techproeducation.com sayfasına gidildi");

        //sayfanin handle degerini alalim
        String w1Handle=driver.getWindowHandle();
        extentTest.info("Sayfanın handle degerini alindi");

        //sayfanin resmini alalim
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/screenshot" + tarih + ".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.info("Sayfanın resmi alindi");

        //Sonra amazon sayfasına gidelim
        driver.get("https://amazon.com");
        extentTest.info("https://amazon.com sayfasına gidildi");

        //Amazon sayfasının ekran görüntüsünü alalım

        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //sayfanin handle degerini alalim
        String wHandle=driver.getWindowHandle();
        extentTest.info("Sayfanın handle degerini alindi");

        extentTest.pass("test sonlandırıldı");
        extentReports.flush();
    }
}
