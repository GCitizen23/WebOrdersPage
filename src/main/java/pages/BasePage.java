package pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.temporal.ValueRange;

import static org.testng.Assert.assertTrue;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "login_info")
    protected WebElement loginInfo;

    @FindBy(linkText = "Logout")
    protected WebElement LogoutLink;

    @FindBy(tagName = "h1")
    protected WebElement logo;

    @FindBy(id = "ctl00_menu")
    protected WebElement menuItems;

    public void logout() {
        assertTrue(LogoutLink.isDisplayed(), "Logout link is not displayed");
        LogoutLink.click();
    }

    public void clickOnViewAllOrdersLink() {
        WebElement viewAllOrders = menuItems.findElement(By.linkText("View all orders"));
        assertTrue(viewAllOrders.isDisplayed(), "View all orders not displayed");
        viewAllOrders.click();

    }

    public void clickOnViewAllProductsLink() {
        WebElement viewAllProducts = menuItems.findElement(By.linkText("View all orders"));
        assertTrue(viewAllProducts.isDisplayed(), "View all products not displayed");
        viewAllProducts.click();
    }

    public void clickOnOrdersLink() {
        WebElement order = menuItems.findElement(By.linkText("Order"));
        assertTrue(order.isDisplayed(), "Order not displayed");
        order.click();

    }
}
