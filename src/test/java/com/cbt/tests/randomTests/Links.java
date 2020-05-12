package com.cbt.tests.randomTests;

import com.cbt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Links {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get("https://www.w3schools.com/");
    }

    @Test
    public void test(){
        List<WebElement> links = Driver.getDriver().findElements(By.xpath("//a"));
        for (int i = 0; i < links.size() ; i++) {
            if (links.get(i).isDisplayed()){
                System.out.println(links.get(i).getText()+ " --> "+links.get(i).getAttribute("href"));
            }
        }
    }

    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }

}
