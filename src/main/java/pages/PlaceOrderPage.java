package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.CommonUtils;

import java.util.Locale;

import static utils.CommonUtils.randomStringNumber;

public class PlaceOrderPage extends BasePage{

    private Faker faker;

    public PlaceOrderPage(WebDriver driver) {
        super(driver);
        faker = new Faker(new Locale("en-us"));
    }

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    private WebElement productDropDown;

    @FindBy(id ="ctl00_MainContent_fmwOrder_txtQuantity")
    private WebElement productQuantity;

    @FindBy(xpath = "//input[@value='Calculate']")
    private WebElement calculateBtn;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    private WebElement customerNameInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    private WebElement streetInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    private WebElement cityInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    private WebElement stateInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    private WebElement zipInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    private WebElement cardnumberInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    private WebElement expDateInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    private WebElement processBtn;

    @FindBy(xpath = "//input[@value='Reset']")
    private WebElement resetBtn;

    @FindBy(tagName = "strong")
    private WebElement confirmationMessage;

    public void placeNewOrder(){
        filloutProductInformation();
        filloutAddressInformation();
        fillOutPaymentInformation();

        Assert.assertTrue(processBtn.isEnabled(), "Process btn is not enabled");
        Assert.assertEquals(confirmationMessage.getText().trim(), "New Order has been added");
        processBtn.click();
    }

    private void filloutProductInformation(){
        Select select = new Select(productDropDown);
        select.selectByIndex(CommonUtils.generateRandomNumber(0,2));
        productQuantity.sendKeys(CommonUtils.generateRandomNumber(5,10) + "");
        Assert.assertTrue(calculateBtn.isEnabled(), "Calculate is not enabled");
        calculateBtn.click();
    }

    private void filloutAddressInformation(){
        customerNameInput.sendKeys(faker.name().fullName());
        streetInput.sendKeys(faker.address().streetAddress());
        cityInput.sendKeys(faker.address().cityName());
        stateInput.sendKeys(faker.address().stateAbbr());
        String stateAbbr = faker.address().stateAbbr();
        String zip = faker.address().zipCodeByState(stateAbbr);
        stateInput.sendKeys(stateAbbr);
        zipInput.sendKeys(zip);

    }

    private void fillOutPaymentInformation(){
        int randomIndex = CommonUtils.generateRandomNumber(0, 2);
        WebElement card = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_" +randomIndex));
        String randomCardNumber = (randomIndex ==2) ? randomStringNumber(15) : randomStringNumber(16);

        int randomMonth = (int)(Math.random()*13); //this should be between 0 and 12
        String randomDate =(randomMonth/10 == 0 ? "0" +randomMonth : randomMonth) +"/" + (int)((Math.random() *6) +23);
        expDateInput.sendKeys(randomDate);



    }


}
