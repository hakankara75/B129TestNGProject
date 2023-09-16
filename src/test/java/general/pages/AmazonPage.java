package general.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import general.utilities.Driver;

public class AmazonPage {
    public AmazonPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//select[@id='searchDropdownBox']")
    public WebElement ddm;
    @FindBy (xpath = "(//img[@class='s-image'])[2]")
    public WebElement ikinciUrun;
    @FindBy (id = "twotabsearchtextbox")
    public WebElement aramaMotoru;
    @FindBy (xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYazisi1;
    @FindBy (xpath = "(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")
    public WebElement sonucYazisi2;

}
