package day14;

import com.aventstack.extentreports.ExtentTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02 extends TestBase {
    /*       https://the-internet.herokuapp.com/tables sayfasına gidin
       Task 1 : Table1’i yazdırın
       Task 2 : 3. Satır verilerini yazdırın
       Task 3 : Son satirin verileri yazdırın
       Task 4 : 5. Sütun verilerini yazdırın
       Task 5 : Iki parametreli bir Java metodu oluşturalım: printData
       Parameter 1 = satır numarası
       Parameter 2 = sütun numarası
       printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.

     */
@Test
    public void test() {
    extentTest = extentReports.createTest("ExtentTest", "Test Raporu");
    ExtentTest test = extentReports.createTest("testName", "testDescription");
//         https://the-internet.herokuapp.com/tables sayfasına gidin
    driver.get("https://the-internet.herokuapp.com/tables");
    extentTest.info("https://the-internet.herokuapp.com/tables sayfasına gidildi");


//        Task 1 : Table1’i yazdırın
    String table1 = driver.findElement(By.id("table1")).getText();
    System.out.println("Table 1: ");
    System.out.println(table1);
    extentTest.info("Table1’i yazdirildi");

//        Task 2 : 3. Satır verilerini yazdırın
    List<WebElement> satir3List = driver.findElements(By.xpath("//table[@id='table1']//tr[3]/td"));
    satir3List.forEach(t -> System.out.println(t.getText()));
    extentTest.info("Table1 3. satir yazdirildi");

//        Task 3 : Son satirin verileri yazdırın
    List<WebElement> satir4List = driver.findElements(By.xpath("//table[@id='table1']//tr[4]/td"));
    satir4List.forEach(t -> System.out.println(t.getText()));
    extentTest.info("Table1 4. satir yazdirildi");

//        Task 4 : 5. Sütun verilerini yazdırın
    List<WebElement> sutun = driver.findElements(By.xpath("//table[@id='table1']//td[5]"));
    sutun.forEach(t -> System.out.println(t.getText()));
    extentTest.info("Table1 5.sutun yazdirildi");

    //        Parameter 1 = satır numarası
//        Parameter 2 = sütun numarası
//        printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.
    printData(2,3);
    extentTest.info("Parametreli veri yazdirildi");



    extentTest.pass("test sonlandırıldı");
    extentReports.flush();
}

//        Task 5 : Iki parametreli bir Java metodu oluşturalım: printData
    public void printData(int satir, int sutun) {


        WebElement belirliVeri = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + satir + "]/td[" + sutun + "]"));

        System.out.println(belirliVeri.getText());
    }




}




