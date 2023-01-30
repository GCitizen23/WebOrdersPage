package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static config.ConfigReader.getProperty;
import static org.testng.Assert.assertEquals;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //this line initializes all of the methods below (findby)

    }

    @FindBy(id= "ctl00_MainContent_username")
    private WebElement userNameInput;

    @FindBy(id= "ctl00_MainContent_password")
    private WebElement passwordInput;

    @FindBy(id= "ctl00_MainContent_login_button")
    private WebElement loginBtn;

    @FindBy(id = "ctl00_MainContent_status")
    private WebElement errormessage;

    /**
     * this method will navigate to the url
     */

    public void navigatetoLoginPage(){
        driver.get(getProperty("url"));
        assertEquals(driver.getTitle(), "Web Orders Login", "Login Page Titles do not match");
    }
    /**
     * This method is used to log in to that application
     * We are importing Configreader statically and using it instead of hardcoding username and password
     */
    public void login(){
        userNameInput.sendKeys(getProperty("username"));
        passwordInput.sendKeys(getProperty("password"));
        loginBtn.click();
    }

    public void loginNegative(){
        userNameInput.sendKeys("Tester");
        passwordInput.sendKeys("abcd");
        loginBtn.click();
        Assert.assertTrue(errormessage.isDisplayed(), "Error Message is not displayed");

    }
}

