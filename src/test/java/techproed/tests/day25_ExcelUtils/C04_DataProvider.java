package techproed.tests.day25_ExcelUtils;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.security.Key;

public class C04_DataProvider {
    /*
    -- DataProvider , bir cok veriyi test caselere loop kullanmadan aktarmak icin kullanilir.
     TestNG'den gelen bir ozelliktir.
     --2 boyutlu bir object Array return eder.
    -- DDT(Data Driven Testing)icin kullanilir yani birden fazla veriyi test caselerde ayni anda
     kullanmak icin kullanilir.
     Kullanımı için @Test notasyonundan sonra parametre olarak dataprovider yazılır ve String bir isim belirtilir.
    Bu belirttiğimiz isimle @DataProvider notasyonu ile bir method oluşturulur.
      */

    @Test(dataProvider="urunler")
    public void testName(String dataProvider) {//Data providerdaki verileri alabilmek icin Test methodumuza String bir parametre atamasi yapariz.
        System.out.println(dataProvider);


    }
    @DataProvider (name="googleTest")
    public static Object[][] urunler() {
        return new Object[][]{{"Volvo"}, {"Mercedes"},{"Audi"}, {"Honda"}, {"Toyota"}, {"Opel"}, {"BMW"}};
    }
    @Test (dataProvider="googleTest")
    public void googleTest(String araclar) {
        //google sayfasina gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("google_Url"));
        ReusableMethods.bekle(2);

        //{"Volvo"}, {"Mercedes"},{"Audi"}, {"Honda"}, {"Toyota"}, {"Opel"}, {"BMW"} marka araclari aratiniz
       GooglePage googlePage= new GooglePage();
       googlePage.aramaKutusu.sendKeys(araclar, Keys.ENTER);

        //Her aratmadan sonra sayfa resmi aliniz
        ReusableMethods.tumSayfaScreenShoot();
        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }
}
