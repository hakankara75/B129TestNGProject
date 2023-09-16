package general.tests.day23_DependsOnMethods;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Day23_DependsOnMethods{
    /*
  Test NG'de @Test metotları birbirinden bağımsız çalışır.
  Methodları bağımlı çalıştırmak istiyorsak "dependsOnMethods" parametresi kullanılır.
  Aşağıda searchTest() methodu homePageTest() methoduna bağlıdır.
  Eğer homePageTest() çalışırsa searchTest() de çalışır.
  Eğer homePageTest() fail olursa searchTest() çalışmaz, "ignore" edilir.
   */
    @Test
    public void homePage() {

        assertEquals(1,2); /*bu false verecegi icin asagidaki metotlar da calismaz. "hard assertion"
        //dolayisiyla java calismaz, sonraki kodalar calismaz.

       "hard assertion" veren kodlar:
        1- assertEquals
        2- assertFalse
        3- assertTrue

        */
        System.out.println("Anasayfaya gidildi");
    }

    @Test(dependsOnMethods = "homePage")
    public void searchTest() {
        System.out.println("Arama yapildi.");
    }
    @Test(dependsOnMethods = "homePage")
    public void signInTest() {
        System.out.println("Giris yapildi.");
    }
}
