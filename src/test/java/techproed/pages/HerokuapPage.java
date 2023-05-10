package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class HerokuapPage {
    public HerokuapPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
@FindBy (id="email")
    public WebElement email;
    @FindBy (id="password")
    public WebElement password;
    @FindBy (xpath="//button[@name='commit']")
    public WebElement loginButton;
    @FindBy (xpath="//div[@class='alert alert-danger']")
    public WebElement text;
}
