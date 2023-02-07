package com.academy.techcenture;

import config.ConfigReader;
import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OrdersPage;
import pages.PlaceOrderPage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

import static driver.Driver.getDriver;


public class PlaceOrderTest {

    private WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = getDriver("browser");
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }

    @Test
    public void placeOrderPositiveTest() {



/*
        //WebDriver driver = Driver.getDriver(); With the below method we can import driver statically and pass into login page

        WebDriver driver = getDriver();

        LoginPage loginPage = new LoginPage();
        loginPage.navigatetoLoginPage();

        OrdersPage ordersPage = new OrdersPage();
        ordersPage.clickOnOrdersLink();

        PlaceOrderPage placeOrderPage = new PlaceOrderPage(getDriver());
        placeOrderPage.placeNewOrder();

        Thread.sleep(3000);

        placeOrderPage.logout();

        //ConfigReader.getProperty(columnname)

        DateTimeFormatter f = DateTimeFormatter.ofPattern("MM//DD/YYYY");


*/


        }

    }

