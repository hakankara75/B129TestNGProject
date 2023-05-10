package techproed.tests.day01_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.utilities.TestBase;

import static org.testng.Assert.assertTrue;

/*
"https://amazon.com" sayfasına gidiniz
 Title'in "Amazon" icerdigini test edin
Arama kutusunun erisilebilir oldugunu test edin
 Arama kutusuna nutella yazıp aratın
 Sonuc yazısının gorunur oldugunu test edin
 Sonuc yazısının "Nutella" icerdigini test edin
 test islemlerini softAsser ile yapınız ve hatalar icin mesaj versin

 */
public class C03_SoftAssert extends TestBase {
    @Test
    public void test01() {
        //    test01 isimli bir test methodu olusturunuz. Ve amazona gidiniz
        // "https://amazon.com" sayfasına gidiniz
        driver.get("https://amazon.com");

        // Title'in "Amazon" icerdigini test edin
        String amazonTitle= driver.getTitle();
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertTrue(amazonTitle.contains("Amazon"), "title amazon icermiyor");
        //hata verirse 2."" işareti içine konsola yazacagi mesaji verdim

        // Arama kutusunun erisilebilir oldugunu test edin
        WebElement webElement= driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(webElement.isEnabled());

        // Arama kutusuna nutella yazıp aratın
        webElement.sendKeys("nutella"+ Keys.ENTER);

        // Sonuc yazısının gorunur oldugunu test edin
        WebElement sonucYazisi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYazisi.isEnabled(), "arama kutusu goruntulenemedi");

        // Sonuc yazısının "Nutella" icerdigini test edin
        softAssert.assertTrue(sonucYazisi.getText().contains("Nutella"), "sonuc yazisi Nutella icermiyor");

        // test islemlerini softAsser ile yapınız ve hatalar icin mesaj versin
        softAssert.assertAll(); //hata varsa bize bildirmesi icin kod. bu olmazsa hepsi pass gorunur, hata mesaji yazmaz

    }
}
