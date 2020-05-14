package com.cbt.tests.randomTests;

import com.cbt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class MoreSpoons {
    @BeforeMethod
    public void setup(){
        Driver.getDriver().get("https://amazon.com");
    }

    @Test
    public void test(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        WebElement search = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        WebElement searchButton = Driver.getDriver().findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']"));

        search.sendKeys("wooden spoon");
        searchButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='p_85/2470955011']//i[@class='a-icon a-icon-checkbox']")));

        List<WebElement> brands = Driver.getDriver().findElements(By.xpath("//div[@id='brandsRefinements']//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-medium']"));
        int count = 0;
        for (WebElement brand:brands) {
            count++;
        }
        Assert.assertEquals(count,brands.size());

        WebElement prime = Driver.getDriver().findElement(By.xpath("//li[@id='p_85/2470955011']//i[@class='a-icon a-icon-checkbox']"));
        prime.click();

        int count2 = 0;
        for (WebElement brand:brands) {
            count2++;
        }
        Assert.assertEquals(count2,brands.size());

    }

    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }
}
