package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {
    public static void main(String[] args) {
        //"https://lulugandgeorgia.com", -- page not loading
        // "https://westelm.com/" -- page not secure
        List<String> urls = Arrays.asList(
                "https://wayfair.com/",
                "https://walmart.com"
                );

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://google.com");

        for (int i = 0; i < urls.size(); i++) {
            driver.navigate().to(urls.get(i));
            String title = driver.getTitle();
            List<String> titleString = new ArrayList<>();
            for (int j = 0; j < title.length(); j++) {
                titleString.add(title.charAt(j)+"");
            }
            for (int j = 0; j < titleString.size(); j++) {
                if(titleString.get(j).equals(" ")){
                    titleString.remove(j);
                    j--;
                }
            }
            String expected = "";
            for (int j = 0; j < titleString.size(); j++) {
                expected += titleString.get(j);
            }
            int index = expected.indexOf(".");
            if(urls.get(i).contains(expected.substring(0,index).toLowerCase())){
                System.out.println("TEST PASSED!!!");
            }
//            if (urls.get(i).contains(expected.toLowerCase())){
//                System.out.println("TEST PASSED!!!");
//            }
        }

        driver.quit();
    }
}
