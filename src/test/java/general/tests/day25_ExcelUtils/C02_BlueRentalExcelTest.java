package general.tests.day25_ExcelUtils;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import general.pages.BlueRentalPage;
import general.utilities.ConfigReader;
import general.utilities.Driver;
import general.utilities.ExcelUtils;

import static org.testng.Assert.assertTrue;

public class C02_BlueRentalExcelTest {
    @Test
    public void testName() {
        /*
Eğer bir veriyi(datayı) .properties dosyasından almak istiyorsak, ConfigReader class'ından getProperty() methodunu
kullanarak .properties dosyamıza girdiğimiz key değerini belirtiriz ve bize bu key değerinin value sunu döndürür.
Eğer bir veriyi(datayı) excel dosyasından almak istiyorsak , oluşturmuş olduğumuz ExcelUtils Class'ında ki
methodları kullanarak istediğimiz veriyi alabiliriz.
 */
        //Excel ile baglanti kurdum
        ExcelUtils excel = new ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx", "customer_info");

        //Excellden email ve password aldim
        String email = excel.getCellData(1,0);
        String password = excel.getCellData(1,1);

        //Bluerantal car adresine gidelim.
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalAcar_Url"));

        //Excel dosyamızdan aldıgımız emaıl ve password ıle sayfaya login olalım.
        BlueRentalPage blueRentalPage= new BlueRentalPage();
        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);

        //Login oldugumuzu dogrulyalım.
        assertTrue(blueRentalPage.verify.isDisplayed());

        Driver.closeDriver();
    }
}
