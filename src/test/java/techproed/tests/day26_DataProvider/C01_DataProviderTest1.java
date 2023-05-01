package techproed.tests.day26_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

public class C01_DataProviderTest1 {

    @DataProvider()
        public Object [][] customerData(){
        String path="src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName="customer_info";

        ExcelUtils excelUtils= new ExcelUtils(path,sheetName);
        return excelUtils.getDataArrayWithoutFirstRow();

    }
    @Test(dataProvider="customerData")
    public void dataProviderExcellTest(String email, String password) {
    //sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalAcar_Url"));

        //Excel dosyamızdan aldıgımız emaıl ve password ıle sayfaya login olalım.
        BlueRentalPage blueRentalPage= new BlueRentalPage();
        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);
        ReusableMethods.bekle(2);
        Driver.closeDriver();

    }
}
