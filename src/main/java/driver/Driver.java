package driver;

import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    private Driver() {  //we are hiding the constructor
    }

    //here we are establishing instance of driver to not repeate ourselves in the main method.

    //the driver is static is outside in order to create multiple conditions/methods

    private static WebDriver driver;

    public static WebDriver getDriver(String driverType){

        String browser = ConfigReader.getProperty("browser").trim().toLowerCase();

        /*
        //Another alternative to if and else statement is to use switch cases

        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
                driver.manage().window().maximize();
                return driver;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
                driver.manage().window().maximize();
                return driver;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
                driver.manage().window().maximize();
                return driver;
            default:
                break;


                //also to print the loadtime and implicit time we can use the following method signatures
                int pageLoadTime = Integer.parseInt(ConfigReader.getproperty("pageLoadTime"));
                int implicitWait = Integer.parseInt(ConfigReader.getproperty("implicitWait"));
        }
*/


        if(driverType.toLowerCase().equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
            driver.manage().window().maximize();
            return driver;
        }
        else if (driverType.toLowerCase().equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
            driver.manage().window().maximize();
            return driver;
        }
        else if (driverType.toLowerCase().equals("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
            driver.manage().window().maximize();
            return driver;
        }
        return null;
    }

    //we can call this method in other classes

    public static void quitDriver(){
        if(driver != null){
            driver.quit();
        }
    }


}