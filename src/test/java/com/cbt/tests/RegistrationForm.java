package com.cbt.tests;

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

public class RegistrationForm {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement link = driver.findElement(By.linkText("Registration Form"));
        link.click();
    }

    @Test
    public void test1(){
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        Assert.assertTrue(driver.findElement(By.xpath("//small[contains(text(),'The date of birth is not valid')]")).isDisplayed());
    }

    @Test
    public void test2(){
        int expected = 3;
        int actual = 0;
        if(driver.findElement(By.xpath("//label[contains(text(),'C++')]")).isDisplayed()){
            actual++;
        }
        if(driver.findElement(By.xpath("//div[@class='form-group']//div[2]//label[1]")).isDisplayed()){
            actual++;
        }
        if(driver.findElement(By.xpath("//label[contains(text(),'JavaScript')]")).isDisplayed()){
            actual++;
        }
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void test3(){
        WebElement lastname = driver.findElement(By.name("firstname"));
        lastname.sendKeys("n");
        Assert.assertTrue(driver.findElement(By.xpath("//small[contains(text(),'first name must be more than 2 and less than 64')]")).isDisplayed());
    }

    @Test
    public void test4(){
        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.sendKeys("k");
//        String expected = "The last name must be more than 2 and less than 64 characters long";
//        String actual = driver.findElement(By.xpath("//small[contains(text(),'The last name must be more than 2 and less than 64')]")).getText();
//        Assert.assertEquals(actual,expected, "Expected: " + expected + "\nbut was: " + actual);
        Assert.assertTrue(driver.findElement(By.xpath("//small[contains(text(),'The last name must be more than 2 and less than 64')]")).isDisplayed());
    }

    @Test
    public void test5(){
        driver.findElement(By.name("firstname")).sendKeys("Naruto");
        driver.findElement(By.name("lastname")).sendKeys("Uzumaki");
        driver.findElement(By.name("username")).sendKeys("narutouzumaki");
        driver.findElement(By.name("email")).sendKeys("narutouzumaki@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Naruto123");
        driver.findElement(By.name("phone")).sendKeys("571-123-4567");
        driver.findElement(By.xpath("//div[@class='col-sm-5']//div[1]//label[1]//input[1]")).click();
        driver.findElement(By.name("birthday")).sendKeys("01/01/1995");
        Select dropdown = new Select(driver.findElement(By.name("department")));
        dropdown.selectByVisibleText("Department of Engineering");
        Select dropdown2 = new Select(driver.findElement(By.name("job_title")));
        dropdown2.selectByVisibleText("SDET");
        driver.findElement(By.xpath("//input[@id='inlineCheckbox2']")).click();
        driver.findElement(By.xpath("//button[@id='wooden_spoon']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),\"You've successfully completed registration!\")]")).isDisplayed());
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
