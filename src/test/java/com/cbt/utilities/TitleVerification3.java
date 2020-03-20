package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {
    public static void main(String[] args) {

        List<String> urls = Arrays.asList(
                "https://wayfair.com/",
                "https://walmart.com"
        );


        for (int i = 0; i < urls.size(); i++) {
            openAndClose(urls.get(i));
        }



    }

    public static void openAndClose(String url){

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get(url);

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
            if(url.contains(expected.substring(0,index).toLowerCase())){
                System.out.println("TEST PASSED!!!");
            }
            driver.close();

    }
}
