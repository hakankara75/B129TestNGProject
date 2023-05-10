package techproed.tests.day02_practice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import static org.testng.AssertJUnit.assertTrue;

public class C01_PageClassKullanimi {

    /*
     amazon sayfasına gidin
     dropdown'dan "Computers" optionunu secin
     arama motoruna "Asus" yazıp aratın
     ikinci urunun fotografını cekin
     ikinci urune tıklayın
     title'ının "ASUS" icerdigini test edin
     sayfayı kapatın
    */

    @Test
    public void testName() {
        AmazonPage amazonPage = new AmazonPage();
        // amazon sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // dropdown'dan "Computers" optionunu secin
        Select select = new Select(amazonPage.ddm);
        select.selectByVisibleText("Computers");

        // arama motoruna "Asus" yazıp aratın
        amazonPage.aramaMotoru.sendKeys("Asus", Keys.ENTER);

        // ikinci urunun fotografını cekin
        ReusableMethods.webElementScreenShoot(amazonPage.ikinciUrun);

        // ikinci urune tıklayın
        amazonPage.ikinciUrun.click();

        // title'ının "ASUS" icerdigini test edin
        String str = Driver.getDriver().getTitle();
        assertTrue(str.contains("ASUS"));

        // sayfayı kapatın
        Driver.closeDriver();


    }
}
