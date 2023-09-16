package general.tests.day02_practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import general.pages.HerokuapPage;
import general.utilities.ConfigReader;
import general.utilities.Driver;

import static org.testng.AssertJUnit.assertTrue;

public class C03_NegativeLoginDataProvider {
    /*
        https://id.heroku.com/login sayfasına gidin
     dataProvider kullanarak email ve passwordleri giriniz
     login butonuna tıklayınız
     "There was a problem with your login." texti gorunur oldugunu test edin
     sayfayı kapatınız
     */

    @DataProvider
    public static Object[][] dataProvider() {
        Object[][] kullaniciBilgileri= {{"hakan@gmail.com", "1223333"},
                {"veli@gimmal.com", "lkı99877"}, {"yhaup@yhaa.com", "kjgdu09nöf9"}};
        return kullaniciBilgileri;
    }

    @Test (dataProvider = "dataProvider")
    public void testName(String email, String password) {
        HerokuapPage herokuapPage;
        // https://id.heroku.com/login sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("herokuUrl"));

        // dataProvider kullanarak email ve passwordleri giriniz
        herokuapPage=new HerokuapPage();
        herokuapPage.email.sendKeys(email);
        herokuapPage.password.sendKeys(password);

        // login butonuna tıklayınız
        herokuapPage=new HerokuapPage();
        herokuapPage.loginButton.click();

        // "There was a problem with your login." texti gorunur oldugunu test edin
        assertTrue(herokuapPage.text.isDisplayed());

        // sayfayı kapatınız
        Driver.closeDriver();
    }


}
