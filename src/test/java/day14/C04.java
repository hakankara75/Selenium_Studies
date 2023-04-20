package day14;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import utilities.TestBase;

import java.io.*;

public class C04  {

     /*
Bir "NÜFUS" sütunu oluşturup başkent nüfuslarını excel doyasına yazınız:
(D.C: 712816, Paris: 2161000, London: 8982000, Ankara: 5663000 ...)
 */

    @Test
    public void test() throws IOException {
        //dosyayi al
        Workbook workbook= WorkbookFactory.create(new FileInputStream("src/test/java/resources/Capitals.xlsx"));

        //1.satir 3. sutuna gel ve sutun olustur
        Sheet sheet=workbook.getSheet("Sheet1");
        Cell cell=sheet.getRow(0).createCell(2);


//Bir "NÜFUS" sütunu oluşturup başkent nüfuslarını excel doyasına yazınız:
        cell.setCellValue("NUFUS");

//(D.C: 712816, Paris: 2161000, London: 8982000, Ankara: 5663000 ...)
        sheet.getRow(1).createCell(2).setCellValue(33465468);
        sheet.getRow(2).createCell(2).setCellValue(73735753);
        sheet.getRow(3).createCell(2).setCellValue(72527527);
        sheet.getRow(4).createCell(2).setCellValue(37575468);
        sheet.getRow(5).createCell(2).setCellValue(335265468);
        sheet.getRow(6).createCell(2).setCellValue(78250001);
        sheet.getRow(7).createCell(2).setCellValue(445786782);
        sheet.getRow(8).createCell(2).setCellValue(987864008);
        sheet.getRow(9).createCell(2).setCellValue(43212490);
        sheet.getRow(10).createCell(2).setCellValue(1578811);
        sheet.getRow(11).createCell(2).setCellValue(7867733);
        sheet.getRow(12).createCell(2).setCellValue(585798738);

        FileOutputStream fileOutputStream=new FileOutputStream("src/test/java/resources/Capitals.xlsx");
        workbook.write(fileOutputStream);

    }
}
