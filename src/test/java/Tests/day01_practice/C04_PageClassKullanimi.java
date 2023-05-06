package Tests.day01_practice;

import org.testng.annotations.Test;
import techproed.pages.FacebookPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import static org.testng.Assert.assertTrue;

/*
     facebook anasayfaya gidin
     kullanıcı email kutusuna rastgele bir isim yazın
     kullanıcı sifre kutusuna rastgele bir password yazın
     giris yap butonuna tıklayın
     "girdigin sifre yanlıs" yazı elementinin, gorunur oldugunu test edin
     sayfayı kaptın
 */
public class C04_PageClassKullanimi {
    @Test
    public void testName() {
        // facebook anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        // kullanıcı email kutusuna rastgele bir isim yazın
        FacebookPage facebookPage=new FacebookPage();
        facebookPage.emailKutusu.sendKeys(ConfigReader.getProperty("email"));

        // kullanıcı sifre kutusuna rastgele bir password yazın
        facebookPage.passwordKutusu.sendKeys(ConfigReader.getProperty("facebookPassword"));
        ReusableMethods.bekle(3);

        // giris yap butonuna tıklayın
        facebookPage.girisYapButonu.click();

        // "girdigin sifre yanlıs" yazı elementinin, gorunur oldugunu test edin
        assertTrue(facebookPage.uyariYazisi.isDisplayed());
        // sayfayı kaptın
        Driver.closeDriver();
    }

}
