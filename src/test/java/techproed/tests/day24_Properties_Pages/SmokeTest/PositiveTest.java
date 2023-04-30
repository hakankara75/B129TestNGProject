package techproed.tests.day24_Properties_Pages.SmokeTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class PositiveTest {
    /*
        Acceptance Criteria:
        Admin olarak, uygulamaya giriş yapabilmeliyim
        https://www.bluerentalcars.com/
        Admin email: jack@gmail.com
        Admin password: 12345
         */
    @Test
    public void testName() {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalAcar_Url"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();

        blueRentalPage.email.sendKeys(ConfigReader.getProperty("blueRentAcar_Email"),
                Keys.TAB,ConfigReader.getProperty("blueRentAcar_Password"),Keys.ENTER);

        Assert.assertEquals(blueRentalPage.verify.getText(),"Jack Nicholson");

        Driver.closeDriver();
    }
}
