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

public class Prime {
    @BeforeMethod
    public void setup(){
        Driver.getDriver().get("https://amazon.com");
    }

    @Test
    public void test(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        WebElement search = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        WebElement searchButton = Driver.getDriver().findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']"));
//        search.sendKeys("wooden spoon", Keys.ENTER);
        search.sendKeys("wooden spoon");
        searchButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'OXO 1058024 Good Grips Large Wooden Spoon, Beech')]")));

        List<WebElement> items = Driver.getDriver().findElements(By.tagName("h2"));
        List<WebElement> primeItems = Driver.getDriver().findElements(By.tagName("h2"));
//        String name = "OXO 1058024 Good Grips Large Wooden Spoon, Beech";
//        String price = "$11.99";
//        String quantity = "1";

        WebElement prime = Driver.getDriver().findElement(By.xpath("//li[@id='p_85/2470955011']//i[@class='a-icon a-icon-checkbox']"));
        prime.click();

        Assert.assertEquals(items.get(0),primeItems.get(0));

        WebElement brand = Driver.getDriver().findElement(By.xpath("//li[@id='p_89/AOOSY']//i[@class='a-icon a-icon-checkbox']"));
        brand.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'AOOSY Wood Cooking Utensils, Wooden " +
                "Kitchen Utensil Set, Wooden Spoons for Cooking, 5pcs Japanese Style Reusable Heat Scratch Resistant Non-Stick Pans Utensils " +
                "Set including Soup Spoon Spatula')]")));
        List<WebElement> brandList = Driver.getDriver().findElements(By.tagName("h2"));

        Assert.assertNotEquals(primeItems.get(0),brandList.get(0));
    }

    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }
}
