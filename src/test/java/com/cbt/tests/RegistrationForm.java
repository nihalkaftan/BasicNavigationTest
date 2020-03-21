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
    }

    @Test
    public void test1(){
        WebElement link = driver.findElement(By.linkText("Registration Form"));
        link.click();
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        Assert.assertTrue(driver.findElement(By.xpath("//small[contains(text(),'The date of birth is not valid')]")).isDisplayed());
    }

    @Test
    public void test2(){
        WebElement link = driver.findElement(By.linkText("Registration Form"));
        link.click();
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
        WebElement link = driver.findElement(By.linkText("Registration Form"));
        link.click();
        WebElement lastname = driver.findElement(By.name("firstname"));
        lastname.sendKeys("n");
        Assert.assertTrue(driver.findElement(By.xpath("//small[contains(text(),'first name must be more than 2 and less than 64')]")).isDisplayed());
    }

    @Test
    public void test4(){
        WebElement link = driver.findElement(By.linkText("Registration Form"));
        link.click();
        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.sendKeys("k");
//        String expected = "The last name must be more than 2 and less than 64 characters long";
//        String actual = driver.findElement(By.xpath("//small[contains(text(),'The last name must be more than 2 and less than 64')]")).getText();
//        Assert.assertEquals(actual,expected, "Expected: " + expected + "\nbut was: " + actual);
        Assert.assertTrue(driver.findElement(By.xpath("//small[contains(text(),'The last name must be more than 2 and less than 64')]")).isDisplayed());
    }

    @Test
    public void test5(){
        WebElement link = driver.findElement(By.linkText("Registration Form"));
        link.click();
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

    @Test
    public void test6(){
        driver.navigate().to("https://www.tempmailaddress.com/");
        String fakeEmail = driver.findElement(By.id("email")).getText();
        driver.navigate().back();
        driver.findElement(By.xpath("//a[contains(text(),'Sign Up For Mailing List')]")).click();
        driver.findElement(By.name("full_name")).sendKeys("Firstname Lastname");
        driver.findElement(By.name("email")).sendKeys(fakeEmail);
        driver.findElement(By.name("wooden_spoon")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h3[@name='signup_message']")).isDisplayed());
        driver.navigate().to("https://www.tempmailaddress.com/");
        Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'do-not-reply@practice.cybertekschool.com')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'Thanks for subscribing to practice.cybertekschool.')]")).isDisplayed());
    }

    @Test
    public void test7(){
        driver.findElement(By.xpath("//a[contains(text(),'File Upload')]")).click();
        String filePath = "/Users/nihal/Desktop/upload file.txt";
        driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys(filePath);
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(),'File Uploaded!')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='uploaded-files']")).isDisplayed());
    }

    @Test
    public void test8(){
        driver.findElement(By.xpath("//a[contains(text(),'Autocomplete')]")).click();
        driver.findElement(By.xpath("//input[@id='myCountry']")).sendKeys("United States of America");
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='result']")).isDisplayed());
    }

    @Test
    public void test9(){
        driver.findElement(By.xpath("//a[contains(text(),'Status Codes')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'200')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'This page returned a 200 status code.')]")).isDisplayed());
    }

    @Test
    public void test10(){
        driver.findElement(By.xpath("//a[contains(text(),'Status Codes')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'301')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'This page returned a 301 status code.')]")).isDisplayed());
    }

    @Test
    public void test11(){
        driver.findElement(By.xpath("//a[contains(text(),'Status Codes')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'404')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'This page returned a 404 status code.')]")).isDisplayed());
    }

    @Test
    public void test12(){
        driver.findElement(By.xpath("//a[contains(text(),'Status Codes')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'500')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'This page returned a 500 status code.')]")).isDisplayed());
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
