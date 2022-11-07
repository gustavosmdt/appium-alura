package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class Products extends Main{

    private MobileElement listProduct;
    private final By listProductID;

    public Products(AppiumDriver driver) {

        super(driver);
        listProductID = By.id("br.com.alura.aluraesporte:id/lista_produtos_recyclerview");
    }

    @Override
    public void getElements() {
        listProduct = (MobileElement) driver.findElement(listProductID);
    }
}
