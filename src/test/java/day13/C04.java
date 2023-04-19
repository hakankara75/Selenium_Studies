package day13;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

/*
Masaüstünde "logo.jpeg" dosyası oluşturun.
Bu dosyanın varlığını doğrulayın.
*/
public class C04 extends TestBase {

    @Test
    public void test(){

//Masaüstünde "logo.jpeg" dosyası oluşturun.
boolean logo= Files.exists(Paths.get("C:\\Users\\Hakan Batirhan.DESKTOP-KA8SOKR\\Desktop"));

//Bu dosyanın varlığını doğrulayın.
        assertTrue(logo);

        //2.yol
  String userHome= System.getProperty("user.home"); //adresin herkesteki sabit kismini verir.
        boolean isExist= Files.exists(Paths.get(userHome+ "/Desktop/logo.jpeg"));

        assertTrue(isExist);

        //IDE'de dosya yolu
String userDirectory= System.getProperty("user.dir");
//IDE proje yolunu dinamik olarak verir
        boolean isExist1= Files.exists(Paths.get(userDirectory+"TestOutput/hakan.txt"));
        assertTrue(isExist1);
        boolean isExist2= Files.exists(Paths.get(userHome+ "TestOutput/logo.jpeg"));
        assertTrue(isExist2);


    }
}
