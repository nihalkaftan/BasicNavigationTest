package com.cbt.tests.randomTests;

import com.cbt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.HttpURLConnection;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ValidLinks {

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get("https://www.selenium.dev/documentation/en/");
    }

    @Test
    public void test(){
        List<WebElement> links = Driver.getDriver().findElements(By.tagName("a"));
        //WebElement select = Driver.getDriver().findElement(By.xpath("//a[@class='padding']//div[@class='select-style']"));
        HttpURLConnection huc = null;
        int respCode = 200;
        for (int i = 0; i < links.size(); i++) {
            //System.out.println(links.get(i).getText() + ":: " + links.get(i).getAttribute("href"));
//            if(links.get(i).equals(select)){
//                respCode = 401;
//            }
            try {
                huc = (HttpURLConnection)(new URL(links.get(i).getAttribute("href")).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = huc.getResponseCode();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            if(links.get(i).getAttribute("href").isEmpty() || links.get(i).getAttribute("href") == null){
//                count++;
//            }
            if(respCode >= 400){
                System.out.println(links.get(i).getText() + ":: " + links.get(i).getAttribute("href")+" is a broken link and code is " +respCode);
            }
            else{
                System.out.println(links.get(i).getText() + ":: " + links.get(i).getAttribute("href")+" is a valid link and code is "+respCode);
            }

            if (links.get(i).getAttribute("href") == null){
                Assert.assertEquals(respCode,200);
            }
        }
        //Assert.assertEquals(respCode < 400,true);
    }

    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }

}
