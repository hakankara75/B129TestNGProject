package general.tests.day24_Properties_Pages;

import org.testng.annotations.Test;
import general.utilities.ConfigReader;
import general.utilities.Driver;

public class C01_ClassWork {
    @Test
    public void testName() {
        Driver.getDriver().get(ConfigReader.getProperty("amazon_Url"));
        Driver.closeDriver();
        Driver.getDriver().get(ConfigReader.getProperty("techproeducation_Url"));


    }
}
