package general.tests.day23_DependsOnMethods;

import org.testng.annotations.Test;
import general.utilities.ConfigReader;
import general.utilities.Driver;

import static org.testng.Assert.assertTrue;

public class Day23_Driver_ConfigReader_Test {

    @Test
    public void driverTest(){
        // "https://techproeducation.com/" sayfasina gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("techproeducation_url"));

        //title testi yapiniz
        assertTrue(Driver.getDriver().getTitle().contains("Techpro"));
        System.out.println(ConfigReader.getProperty("username"));
        System.out.println(ConfigReader.getProperty("userpassword"));

        //sayfayi kapatiniz
        Driver.closeDriver();
    }
}
