package com.academy.techcenture;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OrdersPage;
import pages.PlaceOrderPage;

import static driver.Driver.getDriver;


public class PlaceOrderTest {

    @Test
    public void placeOrderPositiveTest() {


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



    }
}

