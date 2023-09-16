package general.tests.day23_DependsOnMethods;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class Day23_SoftAssertion {
    @Test
    public void softAssertTest(){

        //Soft assertion yapabilmek için 3 adım izliyoruz:
        //1. Adım: Soft Assert objesi oluşturun:
        SoftAssert softAssert= new SoftAssert();

        //2. Adım: Assertion yapın:
        // 1. assertion
        softAssert.assertEquals(1,2);//soft assertion kullanildigi icin java calismayi durdurmaz.
        System.out.println("Assertion 1 calisti");

        // 2. assertion
        softAssert.assertTrue("Selenium".contains("a")); //ustteki assertion fail oldugu halde bu assertion da calisti
        //cunku soft assertion kullanildi
        System.out.println("Assertion 2 calisti");

        // 3. assertion
        softAssert.assertTrue(false);
        System.out.println("Assertion 3 calisti");

        //3. Adım: assertAll() methodunu çalıştırın:
        softAssert.assertAll(); //yukaridaki assert ler false verirse bu da durur, gecerse bu da calisir.

        System.out.println("Bu kod calisti");
    }
}
