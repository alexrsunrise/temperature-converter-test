package com.alexrusin.mastering.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Google {
    private WebDriver driver;
    private String baseURL;

    public Google(WebDriver driver){
        this.driver = driver;
        baseURL = "https://www.google.com/";
        driver.get(baseURL + "?gws_rd=cr,ssl&ei=qZlNVpOUMNCauQS0iYmoCA&fg=1");
        System.out.println(driver.getTitle());
        if (!driver.getTitle().equals("Google")){
            throw new WrongPageException("Incorrect page for Google Home page");
        }
    }
    public TemperatureConverterPage goToTemperatureConversionPage(String query){
        driver.findElement(By.id("lst-ib")).clear();
        driver.findElement(By.id("lst-ib")).sendKeys(query);
        driver.findElement(By.cssSelector(".lsbb input")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
        return new TemperatureConverterPage(driver);
    }
}
