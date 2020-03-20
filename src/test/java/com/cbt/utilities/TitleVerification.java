package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        String expectedTitle = "Practice";
        String expectedUrl = "http://practice.cybertekschool.com";

        int countTitle = 0;
        int countUrl = 0;

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://google.com");

        for (int i = 0; i < urls.size(); i++) {
            driver.navigate().to(urls.get(i));
            String actualTitle = driver.getTitle();
            if(expectedTitle.equals(actualTitle)){
                countTitle++;
            }
            if(driver.getCurrentUrl().startsWith(expectedUrl)){
                countUrl++;
            }
        }

        if(countTitle == 3){
            System.out.println("TEST PASSED!");
            System.out.println("All the pages have the same title...");
        }

        if(countUrl == 3){
            System.out.println("TEST PASSED!");
            System.out.println("All the pages start with 'http://practice.cybertekschool.com'");
        }

        driver.quit();
    }
}
