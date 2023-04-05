package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

import static org.junit.Assert.*;

public class C01 extends TestBase {
    @Test
    public void name() {
        driver.get("https://amazon.com");
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie c : cookies) {
            System.out.println(c.getName() + " : " + c.getValue());
        }
        /*
        sp-cdn : "L5Z9:TR"
i18n-prefs : USD
ubid-main : 130-2820928-3153269
session-id-time : 2082787201l
skin : noskin
csm-hit : tb:s-0X04X5V3BZS59EZTDAS1|1680713491763&t:1680713492266&adb:adblk_no
session-id : 146-3355784-5216857
*/
        //"i18n-prefs" isimli cookies'in value sunu alin
        String c1 = driver.manage().getCookieNamed("ubid-main").getValue();
        System.out.println(c1);

        //cookies sayisinin 10'dan fazla olmadigini test edin
        int coockiesNum = cookies.size();
        Assert.assertFalse(coockiesNum > 10);

        //ismi session-id olan cookie degerinin 136-6880406-4800815 olmadigini test edin
        String sessionValue = driver.manage().getCookieNamed("ubid-main").getValue();
        System.out.println(sessionValue);
        assertNotEquals("131-4912151-3444417", sessionValue);

        //ismi session-id-time olan cookie degerinin 146-3355784-5216857 oldugunu test edin
        String sessionTimeValue= driver.manage().getCookieNamed("session-id-time").getValue();
                        assertEquals("2082787201l", sessionTimeValue);

        //ismi "katmer" ve degeri "hingal" olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie ekle=new Cookie("katmer", "hingal" );
        driver.manage().addCookie(ekle);

        //eklediginiz cookie'nin sayfaya eklendigini test edin
        int eklenmisSize= driver.manage().getCookies().size();
        assertTrue(coockiesNum<eklenmisSize);
        //2.yol
        Set<Cookie> eklenmisCookie=driver.manage().getCookies();
        for (Cookie c: eklenmisCookie){
            if (c.getName().equals("katmer"))
                System.out.println(c.getName()+ " name'i "+ c.getValue()+ " value'su ile eklenmis");
        }

        //ismi csm-hit olan cookie'yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("csm-hit");
        assertFalse(cookies.contains("csm-hit"));
        //2.yol
        int silinmisCookies=driver.manage().getCookies().size();
        assertEquals(1, eklenmisSize-silinmisCookies);

        //tum cookie'leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        int sil=driver.manage().getCookies().size();
        assertEquals(0, sil);
    }
}
