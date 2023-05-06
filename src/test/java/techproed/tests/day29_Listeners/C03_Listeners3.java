package techproed.tests.day29_Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import static org.testng.Assert.assertTrue;

public class C03_Listeners3 {
    @Test
    public void test1() {
        Driver.getDriver().get(ConfigReader.getProperty("techproeducation_Url"));
        Reporter.log("Techproeducation sayfasina gidildi");//Listener kullanilirsa bu da yazdirilir

        Driver.getDriver().findElement(By.xpath("//*[class='dsfgsdg']"));//yanlis locate aldik. fail almak icin
        Reporter.log("Elementin locati alindi");//Listener kullanilirsa bu da yazdirilir

    }

    @Test
    public void test2() {
        Driver.getDriver().get(ConfigReader.getProperty("amazon_Url"));
        Reporter.log("Amazon sayfasina gidildi");//Listener kullanilirsa bu da yazdirilir
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        Reporter.log("Elementin locati alindi, iphone kelimesi gonderildi, arandi");//Listener kullanilirsa bu da yazdirilir

    }

    @Test
    public void test3() {
        BlueRentalPage blueRentalPage=new BlueRentalPage();
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalAcar_Url"));
        Reporter.log("BlueRentaAcar sayfasina gidildi");//Listener kullanilirsa bu da yazdirilir
        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys("hakan@gmail.com", Keys.TAB, "123456",Keys.ENTER);
        Reporter.log("Email girildi, password girildi");//Listener kullanilirsa bu da yazdirilir



    }
}
