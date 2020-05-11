package com.cbt.tests.randomTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SelectRandomly {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        List<WebElement> checkBoxesLabel = driver.findElements(By.xpath("//input[@type='checkbox']/following-sibling::label"));
        System.out.println(checkBoxes.size());
        int counter = 0;

        while(counter < 3){
            Random random = new Random();
            int randomNum = random.nextInt(checkBoxes.size());
            if(checkBoxes.get(randomNum).isEnabled()) {
                checkBoxes.get(randomNum).click();
                System.out.println("Selected: " + checkBoxesLabel.get(randomNum).getText());
                checkBoxes.get(randomNum).click();
                if (checkBoxesLabel.get(randomNum).getText().equals("Friday")) {
                    counter++;
                }
            }
        }
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
