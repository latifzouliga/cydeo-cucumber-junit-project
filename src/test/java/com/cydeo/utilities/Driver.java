package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {


    // Create a private constructor to remove access to this object
    private Driver() {

    }

    /**
     * We make the WebDriver private, because we want to close access from outside the class.
     * We are making it static, because we will use it in a static method.
     */
    //private static WebDriver driver;
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /**
     * This method which will return the same driver instance once we call it.
     * If an instance doesn't exist, it will create first, and then it will always return same instance.
     */
    public static WebDriver getDriver() {

        if (driverPool.get() == null) {
            // read the browser type from the configuration.properties file.
            // this way, we control which browser is opened from outside our code.
            String browserType = ConfigurationReader.getProperty("browser");
            /**
             * Depending on the browserType returned from the configuration. properties switch statement
             * will determine the "case", and open the matching browser
             */
            switch (browserType) {
                case "chrome":
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "safari":
                    driverPool.set(new SafariDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "edge":
                    driverPool.set(new EdgeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }
        }


        return driverPool.get();


    }

    /**
     * closeDriver; it will use quit() method to quit browsers,
     * and then set the driver value back to null to avoid NoSuchSessionException
     */
    public static void closeDriver() {
        if (driverPool.get() != null) {
            // this line will terminate the driver
            driverPool.get().quit();
            //re-assign the value back to null
            driverPool.remove();
        }
    }


}
