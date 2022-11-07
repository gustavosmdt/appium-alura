package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Main {

    protected final AppiumDriver driver;
    protected Main(AppiumDriver driver) {
        this.driver = driver;
    }

    public abstract void getElements();

    public String error(By id) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(id));
        MobileElement errorElement = (MobileElement) driver.findElement(id);
        return errorElement.getText();
    }
}
