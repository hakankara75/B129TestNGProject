package general.tests.day24_Properties_Pages.SmokeTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import general.pages.BlueRentalPage;
import general.utilities.ConfigReader;
import general.utilities.Driver;

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
        Reporter.log("Log tiklandi");

        blueRentalPage.email.sendKeys(ConfigReader.getProperty("blueRentAcar_Email"),
                Keys.TAB,ConfigReader.getProperty("blueRentAcar_Password"),Keys.ENTER);
        Reporter.log("E mail girildi");
        Reporter.log("Password girildi");


        Assert.assertEquals(blueRentalPage.verify.getText(),"Jack Nicholson");

        Driver.closeDriver();
    }
}
