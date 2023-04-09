package day10;

import org.junit.Test;
import utilities.TestBase;

/*
2. Navigate to url 'http://automationexercise.com'
3. Verify that categories are visible on left side bar
4. Click on 'Women' category
5. Click on any category link under 'Women' category, for example: Dress
6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
7. On left side bar, click on any sub-category link of 'Men' category
8. Verify that user is navigated to that category page
 */
public class C05 extends TestBase {

    @Test
    public void test() {
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //        3. Verify that categories are visible on left side bar
        pageDown();
        String categories = findByXpathString("//h2[text()='Category']");
        String expectedResult= "CATEGORY";
        asserTextContainsAssertTrue(categories,expectedResult);

//4. Click on 'Women' category
        arrowDown();arrowDown();arrowDown();
findByXpathClick("//a[@href='#Women']");

//5. Click on any category link under 'Women' category, for example: Dress
        findByXpathClick("//a[@href='/category_products/7']");

//6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
String actualWomenProducts=findByXpathString("//h2[text()='Women - Saree Products']");
        System.out.println(actualWomenProducts);
String expectedWomenProducts= "WOMEN - SAREE PRODUCTS";
asserTextContainsAssertTrue(actualWomenProducts,expectedWomenProducts);

//            7. On left side bar, click on any sub-category link of 'Men' category
findByXpathClick("//a[@href='#Men']");
findByXpathClick("//a[@href='/category_products/3']");

//8. Verify that user is navigated to that category page
        String actualMenProducts=findByXpathString("//h2[text()='Men - Tshirts Products']");
        String expectedMenProducts= "MEN - TSHIRTS PRODUCTS";
        asserTextContainsAssertTrue(actualMenProducts,expectedMenProducts);

    }
}