package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {

    public static void main(String[] args) {

        testingChrome();
        testingFirefox();
        testingSafari();

    }

    public static void testingChrome(){

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://google.com");
        String titleGoogle = driver.getTitle();

        driver.navigate().to("https://etsy.com");
        String titleEtsy = driver.getTitle();

        driver.navigate().back();
        String titleGoogle2 = driver.getTitle();

        String result = StringUtility.verifyEquals(titleGoogle, titleGoogle2);
        System.out.println(result);

        driver.navigate().forward();
        String titleEtsy2 = driver.getTitle();

        String result2 = StringUtility.verifyEquals(titleEtsy, titleEtsy2);
        System.out.println(result2);

        driver.quit();

    }

    public static void testingFirefox(){

        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.get("https://google.com");
        String titleGoogle = driver.getTitle();

        driver.navigate().to("https://etsy.com");
        String titleEtsy = driver.getTitle();

        driver.navigate().back();
        String titleGoogle2 = driver.getTitle();

        String result = StringUtility.verifyEquals(titleGoogle, titleGoogle2);
        System.out.println(result);

        driver.navigate().forward();
        String titleEtsy2 = driver.getTitle();

        String result2 = StringUtility.verifyEquals(titleEtsy, titleEtsy2);
        System.out.println(result2);

        driver.quit();

    }

    public static void testingSafari(){

        WebDriver driver = BrowserFactory.getDriver("Safari");
        driver.get("https://google.com");
        String titleGoogle = driver.getTitle();

        driver.navigate().to("https://etsy.com");
        String titleEtsy = driver.getTitle();

        driver.navigate().back();
        String titleGoogle2 = driver.getTitle();

        String result = StringUtility.verifyEquals(titleGoogle, titleGoogle2);
        System.out.println(result);

        driver.navigate().forward();
        String titleEtsy2 = driver.getTitle();

        String result2 = StringUtility.verifyEquals(titleEtsy, titleEtsy2);
        System.out.println(result2);

        driver.quit();

    }

}
