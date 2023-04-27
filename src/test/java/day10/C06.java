package day10;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

/*
2. Navigate to url 'http://automationexercise.com'
3. Click on 'Products' button
4. Verify that Brands are visible on left side bar
5. Click on any brand name
6. Verify that user is navigated to brand page and brand products are displayed
7. On left side bar, click on any other brand link
8. Verify that user is navigated to that brand page and can see products
 */
public class C06 extends TestBase {
    @Test
    public void test() {
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Click on 'Products' button
        findByXpathClick("//a[@href='/products']");

//        4. Verify that Brands are visible on left side bar
        pageDown();

        threadSleep(3);
        String actualBrands = findByXpathString("//h2[text()='Brands']");
        String expectedBrands = "BRANDS";
        assertTextContainsAssertTrue(actualBrands, expectedBrands);
        pageDown();

//        5. Click on any brand name
        pageDown();
        threadSleep(2);
        findByXpathClick("//a[@href='/brand_products/Kookie Kids']");

//        6. Verify that user is navigated to brand page and brand products are displayed
        threadSleep(2);
        arrowDown();
        String actualBrand = findByXpathString("//h2[@class='title text-center']");
        String expectedBrand = "BRAND - KOOKIE KIDS PRODUCTS";
        assertTextContainsAssertTrue(actualBrand, expectedBrand);


//        7. On left side bar, click on any other brand link
        arrowDown();
        arrowDown();
        threadSleep(2);
              findByXpathClick("//a[@href='/brand_products/Babyhug']");
        threadSleep(2);

//        8. Verify that user is navigated to that brand page and can see products
        arrowDown();
        arrowDown();
        threadSleep(2);
        String actualBabyhug = findByXpathString("//h2[text()='Brand - Babyhug Products']");
        String expectedBabyhug = "BRAND - BABYHUG PRODUCTS";
        assertTextContainsAssertTrue(actualBabyhug, expectedBabyhug);

       arrowDown();
        threadSleep(2);

        WebElement image = findXpathWebelement("//img[@src='/get_product_picture/11']");
        assertDisplayedWebelement(image);
    }
}
