package techproed.tests.day02_practice;

import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.TestBaseRapor;

import static org.testng.AssertJUnit.assertTrue;

public class C02_Raporlama extends TestBaseRapor {
    /*
     'https://www.amazon.com' adresine gidin
     arama kutusuna "Java" yazip aratın
     sonuc yazisinin "Java" icerdigini test edin
     kontrollu olarak yeni bir sayfa acın
     yeni acılan sayfada "Kitap" aratın
     sonuc yazisinin Kitap icerdigini test edin
     test raporu alınız
     */

    @Test
    public void testName() {

        AmazonPage amazonPage=new AmazonPage();
        extentTest= extentReports.createTest("amazon", "amz");
        // 'https://www.amazon.com' adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.pass("AMAZON SAYFASINA GİDİLDİ");

        // arama kutusuna "Java" yazip aratın
        amazonPage.aramaMotoru.sendKeys("Java", Keys.ENTER);
        extentTest.pass("ARAMA KUTUSUNA JAVA YAZIP ARATILDI");

        // sonuc yazisinin "Java" icerdigini test edin
        assertTrue(amazonPage.sonucYazisi1.getText().contains("Java" ));
        extentTest.pass("SONUC YAZISININ JAVA İCERDİGİ TEST EDİLDİ");

        // kontrollu olarak yeni bir sayfa acın
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        extentTest.pass("KONTROLLU YENİ SAYFA ACILDI");

        // yeni acılan sayfada "Kitap" aratın
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        amazonPage.aramaMotoru.sendKeys("Kitap", Keys.ENTER);
        extentTest.pass("YENİ ACILAN SAYFADA KİTAP ARATILDI");

        // sonuc yazisinin Kitap icerdigini test edin
        assertTrue(amazonPage.sonucYazisi2.getText().contains("Kitap" ));
        extentTest.pass("SONUC YAZISININ KİTAP İCERDİGİ TEST EDİLDİ");

        // test raporu alınız
       //@after notasyonu yapiyor
    }
}
