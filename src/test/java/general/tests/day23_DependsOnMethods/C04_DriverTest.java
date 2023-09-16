package general.tests.day23_DependsOnMethods;
import org.testng.annotations.Test;
import general.utilities.ConfigReader;
import general.utilities.Driver;

public class C04_DriverTest {
    @Test
    public void driverTest1() {
        //Driver.getDriver().get("https://techproeducation.com");
        Driver.getDriver().get("https://amazon.com");
        Driver.getDriver().get("https://facebook.com");
        Driver.getDriver().get(ConfigReader.getProperty("techproed_Url"));
        System.out.println(ConfigReader.getProperty("username"));
        System.out.println(ConfigReader.getProperty("password"));
    }
}