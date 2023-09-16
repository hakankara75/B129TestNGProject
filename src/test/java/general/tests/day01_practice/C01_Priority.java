package general.tests.day01_practice;
// amazon isimli bir test methodu olusturunuz. Ve amazona gidiniz
// bestbuy isimli bir test methodu olusturunuz. Ve bestbuy'a gidiniz
// techproeducation isimli bir test methodu olusturunuz. Ve techproeducation'a gidiniz

import org.testng.annotations.Test;
import general.utilities.Driver;
import general.utilities.TestBase;

// once techproeducation, sonra amazon, sonra bestbuy test methodu calısacak sekilde sıralama yapınız
public class C01_Priority extends TestBase {
    @Test(priority = 2) //priority default degeri 0 dir. deger vermezsek 0 olur.
    public void amazon() {

// amazon isimli bir test methodu olusturunuz. Ve amazona gidiniz
        Driver.getDriver().get("https://www.amazon.com");
    }

    @Test(priority = 3)
    public void bestbuy() {

        // bestbuy isimli bir test methodu olusturunuz. Ve bestbuy'a gidiniz
        Driver.getDriver().get("https://www.bestbuy.com");
    }

    @Test (priority = 1)
    public void techproeducation() {
        // techproeducation isimli bir test methodu olusturunuz. Ve techproeducation'a gidiniz
        Driver.getDriver().get("https://www.techproeducation.com");

        // once techproeducation, sonra amazon, sonra bestbuy test methodu calısacak sekilde sıralama yapınız
    }
}