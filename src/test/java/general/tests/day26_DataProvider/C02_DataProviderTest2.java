package general.tests.day26_DataProvider;

import org.testng.annotations.Test;
import general.utilities.DataProviderUtils;

public class C02_DataProviderTest2 {
    @Test(dataProvider= "sehirVerileri", dataProviderClass = DataProviderUtils.class)
    public void testName(String ad, String bolge, String plaka) {
        System.out.println("Şehir ad: " + ad+ ", Bolge: " + bolge+ ", Plaka: " + plaka);

    }

    @Test(dataProvider= "kullaniciBilgileri", dataProviderClass = DataProviderUtils.class)
    public void test2(String ad, String sifre) {

        System.out.println("Kullanıcı Adı: " + ad+ ", Şifre: " + sifre);
    }

    @Test(dataProvider= "customerData", dataProviderClass = DataProviderUtils.class, groups = "RegressionGroup1")
    public void test3(String username, String password) {

        System.out.println("Kullanıcı Adı: " + username+ ", Şifre: " + password);
    }
}
