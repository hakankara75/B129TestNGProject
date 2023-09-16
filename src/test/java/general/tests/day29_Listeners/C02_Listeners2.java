package general.tests.day29_Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import general.pages.BlueRentalPage;
import general.utilities.ConfigReader;
import general.utilities.Driver;
@Listeners(general.utilities.Listeners.class) //asagidaki metotlarin tamami icin ITestListener metotlarinin tamamini calistirir
/*(techproed.utilities.Listeners.class) == > calistirdigi metotlar asagida
onStart()== > tum testlerden once bir kez calisir. yani classtan once
        onTestStart()== > herbir @Test'ten once bir kez calisir.
onTestSkipped()== > sadece SKIP olan @Test'lerden sonra calisir.
        onTestStart()== > herbir @Test'ten once bir kez calisir.
onTestFailure()== > sadece FAIL olan @Test'lerden sonra calisir.
onTestStart()== > herbir @Test'ten once bir kez calisir.
onTestSuccess()== > sadece PASS olan @Test'lerden sonra calisir.
onTestStart()== > herbir @Test'ten once bir kez calisir.
onTestSuccess()== > sadece PASS olan @Test'lerden sonra calisir.
onFinish()== > tum testlerden sonra bir kez calisir. yani classtan sonra
*/
public class C02_Listeners2 {

    @Test(retryAnalyzer = general.utilities.Listeners.class) //hata vermesi durumunda 1 kez daha calisacak retryAnalyzer sayesinde
    public void test1() {
        Driver.getDriver().get(ConfigReader.getProperty("techproeducation_Url"));
        Driver.getDriver().findElement(By.xpath("//*[class='dsfgsdg']"));//yanlis locate aldik. fail almak icin


    }

    @Test(retryAnalyzer = general.utilities.Listeners.class)
    public void test2() {
        Driver.getDriver().get(ConfigReader.getProperty("amazon_Url"));
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

    }

    @Test(retryAnalyzer = general.utilities.Listeners.class)
    public void test3() {
        BlueRentalPage blueRentalPage=new BlueRentalPage();
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalAcar_Url"));
        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys("hakan@gmail.com", Keys.TAB, "123456",Keys.ENTER);



    }

}
