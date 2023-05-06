package techproed.tests.day24_Properties_Pages.SmokeTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class NegativeTest {
    /*
        Description:
        Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali
        Acceptance Criteria
        Customer email: fake@bluerentalcars.com
        Customer password: fakepass
        Error:
        User with email fake@bluerentalcars.com not found
         */
    @Test
    public void testName() {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalAcar_Url"));
        Reporter.log("BlueRentalAcar sayfasina gidildi"); //TestNG'den gelir. Listener kullanilirsa bu da yazdirilir

        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();
        Reporter.log("Login butonuna tiklandi");

        blueRentalPage.email.sendKeys(ConfigReader.getProperty("blueRentAcar_FakeEmail"),
                Keys.TAB, ConfigReader.getProperty("blueRentAcar_FakePassword"), Keys.ENTER);
        Reporter.log("Email ve password gidildi");//Listener kullanilirsa bu da yazdirilir

        ReusableMethods.bekle(3);
        ReusableMethods.tumSayfaScreenShoot();
        Reporter.log("Sayfanin remi alindi");//Listener kullanilirsa bu da yazdirilir

        Assert.assertTrue(blueRentalPage.hataMesaji.isDisplayed());
        Reporter.log("Hata mesahi goruntulendi");//Listener kullanilirsa bu da yazdirilir

        Driver.closeDriver();
        Reporter.log("Sayfa kapatildi");//Listener kullanilirsa bu da yazdirilir

    }
}
