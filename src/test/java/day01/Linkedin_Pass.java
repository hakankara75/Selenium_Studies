package day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
public class Linkedin_Pass {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver(); // Tarayıcıyı başlat
  driver.get("https://www.linkedin.com/learning/18bc2131-d57e-36df-a69c-8384183bb5cf/kanban-ve-scrum?autoSkip=true&autoplay=true&resume=false");
        WebElement linkedinPass=  driver.findElement(By.id("ember577"));
      linkedinPass.submit();


    }
}
