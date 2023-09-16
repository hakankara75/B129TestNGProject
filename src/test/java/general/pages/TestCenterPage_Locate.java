package general.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import general.utilities.Driver;

public class TestCenterPage_Locate {
    public TestCenterPage_Locate(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Driver.getDriver.findElement(By.xpath("locate");
    //yukaridaki bu kod yerine @FindBy kullanilir
    @FindBy(xpath = "//input[@id='exampleInputEmail1']")
    public WebElement userName;
    @FindBy(xpath = "//input[@id='exampleInputPassword1']")
    public WebElement password;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement loginDogrulama;
    @FindBy(xpath = "//i[@class='fa fa-sign-out-alt']")
    public WebElement logOut;
    @FindBy(xpath = "//h2[text()='Login Page']")
    public WebElement giris;
}
