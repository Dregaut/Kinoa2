package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class Test {

    WebDriver driver;


    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "/Users/alexprokopenko/Documents/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://pixeltest.kindev.net/login");

    }

    @org.testng.annotations.Test(priority = 1)
    public void logoPresence(){
        boolean logotest = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[1]/button")).isDisplayed();
        Assert.assertEquals(logotest, true);

    }
    @org.testng.annotations.Test(priority = 2)
    public void loginTest(){

        WebElement input = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        input.click();
        input.sendKeys("a.prokopenko@kinoa.io");
        WebElement input2 = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        input2.click();
        input2.sendKeys("12345678");


        WebElement input3 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[1]/form/button/span[1]"));
        input3.click();

        boolean element = driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div/div[2]/div[3]/div[2]")).isDisplayed();

        Assert.assertEquals(element, true);

    }
    @org.testng.annotations.Test(priority = 3)

    public void registrationTest(){
        throw  new SkipException("Skip this test");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();

    }

}
