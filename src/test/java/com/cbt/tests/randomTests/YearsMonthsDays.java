package com.cbt.tests.randomTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class YearsMonthsDays {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void test(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        List<WebElement> year = driver.findElements(By.xpath("//select[@id='year']"));
        int yearSize = year.size();
        int randomNumber = ThreadLocalRandom.current().nextInt(0,yearSize);
        year.get(randomNumber).click();
        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByVisibleText("January");
        List<WebElement> daysExpected = new ArrayList<>(Arrays.asList(driver.findElement(By.xpath("//select[@id='day']//option[1]")),
                driver.findElement(By.xpath("//select[@id='day']//option[2]")), driver.findElement(By.xpath("//select[@id='day']//option[3]")),
                driver.findElement(By.xpath("//select[@id='day']//option[4]")), driver.findElement(By.xpath("//select[@id='day']//option[5]")),
                driver.findElement(By.xpath("//select[@id='day']//option[6]")), driver.findElement(By.xpath("//select[@id='day']//option[7]")),
                driver.findElement(By.xpath("//select[@id='day']//option[8]")), driver.findElement(By.xpath("//select[@id='day']//option[9]")),
                driver.findElement(By.xpath("//select[@id='day']//option[contains(text(),'10')]")), driver.findElement(By.xpath("//select[@id='day']//option[contains(text(),'11')]")),
                driver.findElement(By.xpath("//select[@id='day']//option[contains(text(),'12')]")), driver.findElement(By.xpath("//select[@id='day']//option[contains(text(),'13')]")),
                driver.findElement(By.xpath("//select[@id='day']//option[contains(text(),'14')]")), driver.findElement(By.xpath("//select[@id='day']//option[contains(text(),'15')]")),
                driver.findElement(By.xpath("//select[@id='day']//option[contains(text(),'16')]")), driver.findElement(By.xpath("//select[@id='day']//option[contains(text(),'17')]")),
                driver.findElement(By.xpath("//select[@id='day']//option[contains(text(),'18')]")), driver.findElement(By.xpath("//select[@id='day']//option[contains(text(),'19')]")),
                driver.findElement(By.xpath("//select[@id='day']//option[contains(text(),'20')]")), driver.findElement(By.xpath("//select[@id='day']//option[contains(text(),'21')]")),
                driver.findElement(By.xpath("//select[@id='day']//option[contains(text(),'22')]")), driver.findElement(By.xpath("//select[@id='day']//option[contains(text(),'23')]")),
                driver.findElement(By.xpath("//select[@id='day']//option[contains(text(),'24')]")), driver.findElement(By.xpath("//select[@id='day']//option[contains(text(),'25')]")),
                driver.findElement(By.xpath("//select[@id='day']//option[contains(text(),'26')]")), driver.findElement(By.xpath("//select[@id='day']//option[contains(text(),'27')]")),
                driver.findElement(By.xpath("//select[@id='day']//option[contains(text(),'28')]")), driver.findElement(By.xpath("//select[@id='day']//option[contains(text(),'29')]")),
                driver.findElement(By.xpath("//select[@id='day']//option[contains(text(),'30')]")), driver.findElement(By.xpath("//select[@id='day']//option[contains(text(),'31')]"))));
        Select days = new Select(driver.findElement(By.id("day")));
        List<WebElement> daysActual = days.getOptions();
        Assert.assertEquals(daysActual,daysExpected);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
