package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class OrdersPage extends BasePage{

    private WebDriver driver;

    public OrdersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(className = "login_info")
    private WebElement loginInfo;

    @FindBy(linkText = "Logout")
    private WebElement LogoutLink;

    @FindBy(tagName = "h1")
    private WebElement logo;

    @FindBy(xpath = "//input[starts-with(@id,'ctl00_MainContent_orderGrid_ctl0')]")
    List<WebElement> orders;

    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    private List<WebElement> checkAllBtn;

    @FindBy(linkText = "View all orders")
    private WebElement viewAllOrdersLink;

    @FindBy(id = "ctl00_MainContent_btnDelete")
    private WebElement deleteSelectedBtn;


    public void checkAllOrder() {
        //this method should check all order on the order table

        for (int i = 0; i < orders.size(); i++) {
            assertTrue(orders.get(i).isSelected(), "Order" + (i + 1) + "failed");
        }
    }

    public void deleteOrder() {
        int orderSize = orders.size();
        int random = (int)(Math.random()*8) +2;
        String xpath = "ctl00_MainContent_orderGrid_ctl0"+random+"OrderSelector";
        WebElement randomOrderInput = driver.findElement(By.xpath(xpath));
        randomOrderInput.click();
        assertTrue(deleteSelectedBtn.isEnabled(), "Delete Button is not enabled");
        deleteSelectedBtn.click();

        assertTrue(orders.size()==orderSize-1, "order was not deletd");
    }
}


