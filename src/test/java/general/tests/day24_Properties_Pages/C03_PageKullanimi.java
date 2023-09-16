package general.tests.day24_Properties_Pages;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import general.pages.TestCenterPage_Locate;
import general.utilities.ConfigReader;
import general.utilities.Driver;

public class C03_PageKullanimi {
    //https://testcenter.techproeducation.com/index.php?page=form-authentication
    //Page object Model kullanarak sayfaya giriş yapildigini test edin
    //Sayfadan cikis yap ve cikis yapildigini test et
    @Test
    public void testName() {
        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("testCenter_Url"));

        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        TestCenterPage_Locate test=new TestCenterPage_Locate();

        test.userName.sendKeys(ConfigReader.getProperty("kullaniciAdi" ), Keys.TAB,
                                 ConfigReader.getProperty("kullaniciPassword" ), Keys.ENTER);

        Assert.assertTrue(test.loginDogrulama.isDisplayed());

        //Sayfadan cikis yap ve cikis yapildigini test et
        test.logOut.click();
        Assert.assertTrue(test.giris.isDisplayed());

        Driver.closeDriver();


    }
}
