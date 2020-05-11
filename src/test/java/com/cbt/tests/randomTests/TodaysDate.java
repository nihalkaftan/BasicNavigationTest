package com.cbt.tests.randomTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TodaysDate {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void test(){

        Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select day = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        String currentYear = year.getFirstSelectedOption().getText();
        String currentMonth = month.getFirstSelectedOption().getText();
        String currentDay = day.getFirstSelectedOption().getText();

        Assert.assertEquals(currentYear, "2020");
        Assert.assertEquals(currentMonth, "May");
        Assert.assertEquals(currentDay,"11");

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
