package general.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import general.utilities.Driver;

public class OpenSourcePage_Locates {
    /*
     Locate'lerimizi tek bir yerde düzenli bir şekilde tutabilmek için;
         1-İlk olarak oluşturmuş olduğumuz page class'ımızda bir constructor oluştururuz
         2-PageFactory class'ından initelements methodu ile driver'i tanıtırız
         3-@FindBy notasyonu kullanarak locatelerimizi alırız
      */
    public OpenSourcePage_Locates() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Driver.getDriver.findElement(By.xpath("locate");
    //yukaridaki bu kod yerine @FindBy kullanilir
    @FindBy(xpath = "//*[@name='username']")
    public WebElement username;
    @FindBy(xpath = "//*[@name='password']")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement login;
    @FindBy(xpath = "//h6")
    public WebElement dashboard;



}
