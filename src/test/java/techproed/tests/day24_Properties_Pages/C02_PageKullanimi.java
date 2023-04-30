package techproed.tests.day24_Properties_Pages;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage_Locates;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_PageKullanimi {
/*
    https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim

    kullaniciAdi, kullaniciSifre, submitButton elementlerini bul
    Login Testini basarili oldugunu test et
    */
    @Test
    public void testName() {
//https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get(ConfigReader.getProperty("openSource_Url"));
        /*
            Yukardaki adress için 20 adet test methodu oluşturursak sonrasında yukardaki url'de bir değişiklik
        olduğunda bütün test methodlarından tek tek url düzeltmek yerine bir kere .properties dosyamdan
        url'li düzeltirim ve bu bizim için daha hızlı daha düzenli ve daha kolay olur
         */
        //kullaniciAdi, kullaniciSifre, submitButton elementlerini bul

        //Driver.getDriver.findElement(By.xpath("locate");
        OpenSourcePage_Locates openSourcePage=new OpenSourcePage_Locates();
        openSourcePage.username.sendKeys(ConfigReader.getProperty("username"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("password"));
        openSourcePage.login.click();

        //Login Testinin basarili oldugunu test et
        Assert.assertTrue(openSourcePage.dashboard.isDisplayed());

        Driver.closeDriver();
    }
}
