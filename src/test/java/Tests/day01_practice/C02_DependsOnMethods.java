package Tests.day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

/*
 test01 isimli bir test methodu olusturunuz. Ve amazona gidiniz
 test02 isimli bir test methodu olusturunuz. Ve arama motoruna "Nutella" Yazıp aratın
 test03 isimli bir test methodu olusturunuz. Ve sonuc yazısının "Nutella" icerdigini test edelim
 test02 isimli test methodunu, test01'e baglayınız.
 test03 isimli test methodunu, test02'ye baglayınız.
*/
public class C02_DependsOnMethods {
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public void afterClass() {
        //driver.quit();
    }

    @Test
    public void test01() {
        //    test01 isimli bir test methodu olusturunuz. Ve amazona gidiniz
        driver.get("https://amazon.com");
        }

    @Test(dependsOnMethods = "test01")
    public void test02() {
        //    test02 isimli bir test methodu olusturunuz. Ve arama motoruna "Nutella" Yazıp aratın
        //    test02 isimli test methodunu, test01'e baglayınız.
        WebElement webElement= driver.findElement(By.id("twotabsearchtextbox"));
        webElement.sendKeys("Nutella", Keys.ENTER);

    }
    @Test(dependsOnMethods= "test02")
    public void test03 (){
        //    test03 isimli bir test methodu olusturunuz. Ve sonuc yazısının "Nutella" icerdigini test edelim
        //    test03 isimli test methodunu, test02'ye baglayınız.

       WebElement webElement= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        assertTrue(webElement.getText().contains("Nutella"));

    }



}
