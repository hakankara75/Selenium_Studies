package day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class SignUp {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        // driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        //Verify that home page is visible successfully
        WebElement a = driver.findElement(By.xpath("//html"));
        assertTrue(a.isDisplayed());


        //Click on 'Signup / Login' button
        WebElement signUp = driver.findElement(By.xpath("//a[@href='/login']"));
        signUp.click();
        Thread.sleep(2000);

        //Verify 'New User Signup!' is visible
        WebElement signUpText = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        assertTrue(signUpText.isDisplayed());

        //Enter name and email address
        WebElement name = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        name.sendKeys("user");


        WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys("password@gmail.com");


        //Click 'Signup' button
        WebElement signUpEnter = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signUpEnter.click();


        //Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement information = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        Assert.assertTrue(information.isDisplayed());

        //Fill details: Title, Name, Email, Password, Date of birth
        WebElement mr = driver.findElement(By.xpath("//input[@id='id_gender1']"));
        if (!mr.isSelected())
            mr.click();

        WebElement name1 = driver.findElement(By.xpath("//input[@id='name']"));
        name1.clear();
        name1.sendKeys("user");

        WebElement eMail = driver.findElement(By.xpath("//input[@value='password@gmail.com'][1]"));

        WebElement surName = driver.findElement(By.xpath("//input[@id='password']"));
        surName.sendKeys("123456");

        WebElement date = driver.findElement(By.xpath("//select[@id='days']"));
        Select date1 = new Select(date);
        date1.selectByValue("11");

        WebElement month = driver.findElement(By.xpath("//select[@id='months']"));
        Select month1 = new Select(month);
        month1.selectByValue("3");

        WebElement year = driver.findElement(By.xpath("//select[@id='years']"));
        Select year1 = new Select(year);
        year1.selectByVisibleText("2000");
        Thread.sleep(2000);


        //Select checkbox 'Sign up for our newsletter!'
        WebElement check = driver.findElement(By.xpath("//label[@for='newsletter']"));
        if (!check.isSelected())
            check.click();
        Thread.sleep(2000);

        //           Select checkbox 'Receive special offers from our partners!'
        WebElement check1 = driver.findElement(By.xpath("//label[@for='optin']"));
        if (!check1.isSelected())
            check1.click();

        Thread.sleep(2000);

//           12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstName = driver.findElement(By.xpath("//input[@id='first_name']"));
        firstName.sendKeys("user");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='last_name']"));
        lastName.sendKeys("useroglu");

        WebElement company = driver.findElement(By.xpath("//input[@id='company']"));
        company.sendKeys("userogluAS");

        WebElement address1 = driver.findElement(By.xpath("//input[@id='address1']"));
        address1.sendKeys("Beypazari");

        WebElement address2 = driver.findElement(By.xpath("//input[@id='address2']"));
        address2.sendKeys("Ankara");

        WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
        Select tr = new Select(country);
        country.sendKeys("India");

        //State, City, Zipcode, Mobile Number
        WebElement state = driver.findElement(By.xpath("//input[@id='state']"));
        state.sendKeys("Delhi");

        WebElement city = driver.findElement(By.xpath("//input[@id='city']"));
        city.sendKeys("NewDelhi");

        WebElement zip = driver.findElement(By.xpath("//input[@id='zipcode']"));
        zip.sendKeys("2346578");

        WebElement tel = driver.findElement(By.xpath("//input[@id='mobile_number']"));
        tel.sendKeys("768735378");
        Thread.sleep(2000);

//           13. Click 'Create Account button'
        WebElement button = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        button.click();
        Thread.sleep(3000);

//           14. Verify that 'ACCOUNT CREATED!' is visible

        WebElement accountIs = driver.findElement(By.xpath("//h2[@data-qa='account-created']"));
        assertTrue(accountIs.isDisplayed());
        Thread.sleep(3000);
//           15. Click 'Continue' button
        WebElement clickButton = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
        clickButton.click();
        Thread.sleep(3000);
//           16. Verify that 'Logged in as username' is visible
        WebElement loggText = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        assertTrue(loggText.isDisplayed());
        Thread.sleep(3000);

//           17. Click 'Delete Account' button
        WebElement delete = driver.findElement(By.xpath("//a[@style='color:brown;']"));
        delete.click();

        Thread.sleep(3000);
//           18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement deleteAcc = driver.findElement(By.xpath("//b[.='Account Deleted!']"));
        assertTrue(deleteAcc.isDisplayed());
        WebElement contin = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
        contin.click();
    }
}
