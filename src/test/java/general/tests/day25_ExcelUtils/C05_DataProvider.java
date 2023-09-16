package general.tests.day25_ExcelUtils;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import general.pages.BlueRentalPage;
import general.utilities.ConfigReader;
import general.utilities.Driver;
import general.utilities.ReusableMethods;

import static org.testng.Assert.assertTrue;

public class C05_DataProvider {


    /*
           sam.walker@bluerentalcars.com   c!fas_art
           kate.brown@bluerentalcars.com   tad1$Fas
           raj.khan@bluerentalcars.com v7Hg_va^
           pam.raymond@bluerentalcars.com  Nga^g6!
           Verileri kullanarak bluerentalcar sayfasına login olalim
            */
    @DataProvider
    public static Object[][] blueRental() {
        return new Object[][]{{"sam.walker@bluerentalcars.com", "c!fas_art"}, {"kate.brown@bluerentalcars.com", "tad1$Fas"},
                {"raj.khan@bluerentalcars.com", "v7Hg_va^"}, {" pam.raymond@bluerentalcars.com", "Nga^g6!"}};

    }
    @Test(dataProvider="blueRental")
    public void testName(String email, String password) {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalAcar_Url"));

        //Excel dosyamızdan aldıgımız emaıl ve password ıle sayfaya login olalım.
        BlueRentalPage blueRentalPage= new BlueRentalPage();
        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);
        ReusableMethods.bekle(2);

        //giris yaptiginş dogrula
        assertTrue(blueRentalPage.verify.isDisplayed()) ;
        Driver.closeDriver();

    }
}
