package general.tests.day25_ExcelUtils;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import general.pages.BlueRentalPage;
import general.utilities.ConfigReader;
import general.utilities.Driver;
import general.utilities.ExcelUtils;
import general.utilities.ReusableMethods;

import static org.testng.Assert.assertTrue;

public class C03_BlueRentalExcelTest2 {
    @Test
    public void testName() {
/*
EXCEL dosyasindaki tum email ve passwordler ile
BlueRentalCar sayfasina gidip login olalim?
 */
        //Excel ile baglanti kurdum
        ExcelUtils excelUtils=new ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx", "customer_info");

        //sayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalAcar_Url"));

        //bir loop olusturup excell dosyasindaki tum bilgileri girecegim
        BlueRentalPage blueRentalPage=new BlueRentalPage();

        for (int i = 1; i <= excelUtils.rowCount(); i++) {
            String email = excelUtils.getCellData(i, 0);
            String password = excelUtils.getCellData(i, 1);
            ReusableMethods.bekle(2);
            blueRentalPage.login.click();
            blueRentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);
            assertTrue(blueRentalPage.verify.isDisplayed()) ; //giris yaptigimi dogruladim
            //assert blueRentalPage.verify.isDisplayed();  java metodu
            ReusableMethods.bekle(2);
            blueRentalPage.logOut1.click(); //log out yapacagim
            blueRentalPage.logOut2.click(); //log out yaptim
            blueRentalPage.ok.click();  //sayfayi kapattim

        }

        Driver.closeDriver();

    }
}
