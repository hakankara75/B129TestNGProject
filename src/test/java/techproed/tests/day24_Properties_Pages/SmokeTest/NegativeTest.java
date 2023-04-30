package techproed.tests.day24_Properties_Pages.SmokeTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
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
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();

        blueRentalPage.email.sendKeys(ConfigReader.getProperty("blueRentAcar_FakeEmail"),
                Keys.TAB, ConfigReader.getProperty("blueRentAcar_FakePassword"), Keys.ENTER);

        ReusableMethods.bekle(3);
        ReusableMethods.tumSayfaScreenShoot();
        Assert.assertTrue(blueRentalPage.hataMesaji.isDisplayed());

        Driver.closeDriver();

    }
}
