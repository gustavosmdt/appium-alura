package com.alura.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverConfig {

    public final AppiumDriver driver;
    private static AppiumDriverConfig _instance;

    public static AppiumDriverConfig Instance() {
        if (AppiumDriverConfig._instance == null) {
            AppiumDriverConfig._instance = new AppiumDriverConfig();
        }
        return AppiumDriverConfig._instance;
    }

    private AppiumDriverConfig() {

        File apk = new File("C:\\Users\\gusta\\OneDrive\\Documentos\\projects\\courses\\alura\\appium\\AluraAppium\\src\\main\\resources\\alura_esporte.apk");
        DesiredCapabilities settings = new DesiredCapabilities();
        settings.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        settings.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        settings.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        URL urlConnection = null;
        try {
            urlConnection = new URL("http://127.0.01:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driver = new AppiumDriver<>(urlConnection, settings);
    }
}
