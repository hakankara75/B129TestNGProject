package general.tests.day29_Listeners;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import general.utilities.ConfigReader;
import general.utilities.Driver;

import static org.testng.Assert.assertTrue;
@Listeners(general.utilities.Listeners.class) //bunu ekleyerek fail durumunda da resim aldik
public class C01_Listeners {
    @Test(retryAnalyzer = general.utilities.Listeners.class)
    public void succesTest() {
        System.out.println("PASS");
        assertTrue(true);
    }
    @Test(retryAnalyzer = general.utilities.Listeners.class)
    public void failTest() {
        System.out.println("FAIL");
        assertTrue(false);
    }
    @Test
    public void scipTest() { //testi atlar
        System.out.println("SKIP");
        assertTrue(true);
        throw new SkipException("Atlandi");
    }
    @Test(retryAnalyzer = general.utilities.Listeners.class)
    public void failTestTechpro() {
        System.out.println("Techpro FAIL test");
        Driver.getDriver().get(ConfigReader.getProperty("techproeducation_Url"));

        Driver.getDriver().findElement(By.xpath("//olmayanXPath")); //NoSuchElementException

        assertTrue(false);
    }


}
