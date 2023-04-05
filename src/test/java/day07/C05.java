package day07;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C05 extends TestBase {
    @Test
    public void name() {

        driver.get("https://www.w3schools.com/");
        Set<Cookie> cookies = driver.manage().getCookies();
        int totalCookieCount = cookies.size();
        System.out.println(totalCookieCount);
        System.out.println(cookies);

        System.out.println("##################### after removing all cookie ##########################");
        //To remove all cookies
        driver.manage().deleteAllCookies();
        System.out.println("After removing all cookie: " + cookies + " the total: " + cookies.size());

        System.out.println("##################### the title ##########################");
        System.out.println(driver.getTitle());
    }
}
