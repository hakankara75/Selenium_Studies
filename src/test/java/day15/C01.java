package day15;


import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import utilities.TestBase;

public class C01 extends TestBase {
    /*
    -İki tane test methodu oluşturalım
    -İlkinde masaüstünde java ile data.xlsx isimli bir dosya oluşturalım
    -Birinci satır birinci hücreye email ve ikinci hücreye password
    -ikinci satır birinci hücreye evren.techproed@gmail.com ve ikinci hücreye asdfgh yazdıralım
    -Dosyayı kaydedelim
    -İkinci methodda https://www.bluerentalcars.com/ adresine gidip
    -Excel dosyasından aldığımız kullanıcı bilgileri ile login olalım
    -Login olduğumuzu doğrulayalım
*/

    @Test
    public void name() throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sayfa1");

        // Yeni bir satır oluştur
        Row row = sheet.createRow(0);

        // Yeni bir hücre oluştur ve "email" yaz
        Cell cell = row.createCell(0);
        cell.setCellValue("email");

        // Yeni bir hücre oluştur ve "password" yaz
        Cell cell1 = row.createCell(1);
        cell1.setCellValue("password");

        //ikinci satır birinci hücreye evren.techproed@gmail.com ve ikinci hücreye asdfgh yazdıralım
        Row row1 = sheet.createRow(1);
        Cell cell2 = row1.createCell(0);
        cell2.setCellValue("evren.techproed@gmail.com");
        Cell cell3 = row1.createCell(1);
        cell3.setCellValue("asdfgh");

        // Dosyayı kaydet
        try (FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.home") + "/Desktop/data.xlsx")) {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void uyelikDogrula() throws Exception {
        //    -İkinci methodda https://www.bluerentalcars.com/ adresine gidip
        driver.get("https://www.bluerentalcars.com/");

//    -Excel dosyasından aldığımız kullanıcı bilgileri ile login olalım
        String userHome = System.getProperty("user.home"); //dosyanin kok kismini aldim
        String dosyaYolu = "/Desktop/data.xlsx"; //okunacak dosyanin yolunu aldim
        //Dosyayi al:
        FileInputStream fileInputStream = new FileInputStream(userHome + dosyaYolu);

        //FileInputStream objesini WorkBook (excel) dosyasi olarak aç
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //sayfayi ac
        Sheet sheet1 = workbook.getSheet("Sayfa1");

        //    data.xlsx dosyasından 1. satır 1. sutunundan email alalim
        String email = String.valueOf(sheet1.getRow(1).getCell(0));

        //    data.xlsx dosyasından 1. satır 2. sutunundan password alalim
        String password = String.valueOf(sheet1.getRow(1).getCell(1));

        //login butonuna tikladim
        findByXpathClick("//a[@href='/login']");

        //email ve password kisimlarina bilgi girdim
        findXpathWebelement("//input[@id='formBasicEmail']").sendKeys(email);
        findXpathWebelement("//input[@id='formBasicPassword']").sendKeys(password);

        //login butonunu tikladim
        findByXpathClick("//button[@class='btn btn-primary']");

        String userName = findByXpathString("//button[@id='dropdown-basic-button']");
        String expectedUserName = "Erol Evren";

        asserTextContainsAssertTrue(expectedUserName, userName);
    }
}
