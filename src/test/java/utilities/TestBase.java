package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.interactions.Actions;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class TestBase {
    //TestBase class'indan obje olusturmanin onune gecilmesi icin abstract yapilabilir
//Orn: TestBase base=new TestBase();
//Bu class'a extend ettigimiz test classlarinda ulasabiliriz.
    protected static WebDriver driver;
    protected static ExtentReports extentReports; //Extent Report icin: Raporlamayı başlatır
    protected static ExtentHtmlReporter extentHtmlReporter;//Extent Report icinÇ Raporu HTML formatında düzenler
    protected static ExtentTest extentTest;//Extent Report icin: Tüm test aşamalarında extentTest objesi ile bilgi ekleriz

    @Before
    public void setUp() throws Exception {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Extent Report icin asagisi
        //----------------------------------------------------------------------------------------
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/reports/extentReport_" + tarih + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);
        //Raporda gözükmesini istediğimiz bilgiler için
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Hakan");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");
        extentTest = extentReports.createTest("ExtentTest", "Test Raporu");

    }

    @After
    public void tearDown() throws Exception {
        extentReports.flush(); //Extent Report icin
        Thread.sleep(3000);
        //driver.quit();
    }

    public static void threadSleep(int sleep) {
        try {
            Thread.sleep(sleep * 1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public WebElement findXpathWebelement(String str) {
        WebElement w = driver.findElement(By.xpath(str));
        return w;
    }

    public void assertTextContainsAssertTrue(String str, String atr) {
        assertTrue(str.contains(atr));
    }

    public void switchAlertAccept() {
        driver.switchTo().alert().accept();
    }

    public void switchAlertDismiss() {
        driver.switchTo().alert().dismiss();
    }

    public void switchAlertSendKey(String str) {
        driver.switchTo().alert().sendKeys(str);
    }

    public String findByXpathString(String str) {
        String location = driver.findElement(By.xpath(str)).getText();
        return location;
    }

    public void findByXpathClick(String str) {
        driver.findElement(By.xpath(str)).click();
    }

    public void findByIdClick(String str) {
        driver.findElement(By.id(str)).click();
    }

    public WebElement findByIdWebelement(String str) {
        WebElement w = driver.findElement(By.id(str));
        return w;
    }

    public void pageDown() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    public void pageUp() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).perform();
    }

    public void arrowDown() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    }

    public void arrowUp() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_UP).perform();
    }

    public void assertDisplayedWebelement(WebElement a) {
        assertTrue(a.isDisplayed());
    }

    public void scrollToElement(String str) {
        WebElement bottom = driver.findElement(By.xpath(str));
        Actions actions = new Actions(driver);
        actions.scrollToElement(bottom).perform();
        //bu kod locati alinan elemana kadar sayfayi asagi goturur
    }

    public static void tumSayfaScreenShoot() {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/screenshot" + tarih + ".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //WebElement ScreenShot
    public static void webElementScreenShoot(WebElement element) {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/webElementScreenshot" + tarih + ".png";
        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void switchToWindow(int sayi) {
        List<String> tumWindowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tumWindowHandles.get(sayi));
    }

    //SwitchToWindow2
    public static void window(int sayi) {
        driver.switchTo().window(driver.getWindowHandles().toArray()[sayi].toString());
    }
    //bu metot ile herhangi bir webelemente JavascriptExecutor kullanarak tiklayabilirim
    public void clickByJavaScript(WebElement webElement){
        JavascriptExecutor jse= (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();", webElement);

    }

    public void scrollIntoViewByJavaScript(WebElement webElement){
        JavascriptExecutor jse=(JavascriptExecutor) driver;//Casting
        jse.executeScript("arguments[0].scrollIntoView(true);",webElement);

    }

    //bu metot ile sayfayi en alta kaydirabilirim
    public void scrollEndByJavaScript(){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    //bu metot ile sayfayi en yukari kaydirabilirim
    public void scrollTopByJavaScript(){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
    }

    public void typeWithJavaScript(WebElement webElement, String str){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value', '"+str+"')", webElement);
    }

    //bu metot ile attribute degerleri ile texti alabilirim
    public String getValueByJavaScript(String id, String attributeName){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        String string= js.executeScript("return document.getElementById('"+id+"')."+attributeName+"").toString();
        System.out.println(string);
        return string;
        //        NOT: document.querySelector("p").value;  -> TAG KULLANILABILIR
//             document.querySelector(".example").value; -> CSS DEGERI KULLANILABILIR
//             document.querySelector("#example").value; -> CSS DEGERI KULLANILABILIR
    }

}
