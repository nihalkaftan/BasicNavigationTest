package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    protected static WebDriver driver;

    public Driver(){}

    public static WebDriver getDriver(String driverType){
        switch (driverType){
            case "chrome":
                WebDriverManager.chromedriver().version("79").setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "chromeHeadless":
                //to run chrome without interface (headless mode)
                WebDriverManager.chromedriver().version("79").setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.setHeadless(true);
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().version("79").setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Wrong browser name!");
        }
        return driver;
    }

    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
