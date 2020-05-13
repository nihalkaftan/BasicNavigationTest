package com.cbt.tests.randomTests;

import com.cbt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Cart {

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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'OXO 1130780 Good Grips Wooden Spoon Set, 3-Piece,B')]")));

        String name = "OXO 1130780 Good Grips Wooden Spoon Set, 3-Piece,Brown";
        String price = "$11.99";
        String quantity = "1";

        WebElement name1 = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'OXO 1130780 Good Grips Wooden Spoon Set, 3-Piece,B')]"));
        name1.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title")));

        WebElement name2 = Driver.getDriver().findElement(By.id("title"));
        WebElement price2 = Driver.getDriver().findElement(By.id("priceblock_ourprice"));
        WebElement quantity2 = Driver.getDriver().findElement(By.xpath("//span[@class='a-dropdown-prompt'][contains(text(),'1')]"));
        WebElement addToCart = Driver.getDriver().findElement(By.id("add-to-cart-button"));

        Assert.assertEquals(quantity2.getText(),quantity);
        Assert.assertEquals(name2.getText(), name);
        Assert.assertEquals(price2.getText(), price);
        Assert.assertTrue(addToCart.isDisplayed());
    }

    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }

}
