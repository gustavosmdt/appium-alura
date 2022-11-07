package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class Signin extends Main{

    private MobileElement signupButton;
    private MobileElement signinUserInput;
    private MobileElement signinPassInput;
    private MobileElement signinButton;
    private final By errorLoginID;
    private final By signupButtonId;
    private final By signinUserInputID;
    private final By signinPassInputID;
    private final By signinButtonID;

    public Signin(AppiumDriver driver) {

        super(driver);
        errorLoginID = By.id("br.com.alura.aluraesporte:id/mensagem_erro_login");
        signupButtonId = By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        signinUserInputID = By.id("br.com.alura.aluraesporte:id/input_usuario");
        signinPassInputID = By.id("br.com.alura.aluraesporte:id/input_senha");
        signinButtonID = By.id("br.com.alura.aluraesporte:id/login_botao_logar");
    }

    @Override
    public void getElements() {

        signupButton = (MobileElement) driver.findElement(signupButtonId);
        signinUserInput = (MobileElement) driver.findElement(signinUserInputID);
        signinPassInput = (MobileElement) driver.findElement(signinPassInputID);
        signinButton = (MobileElement) driver.findElement(signinButtonID);
    }

    private void fillForm(String user, String pass) {

        signinUserInput.setValue(user);
        signinPassInput.setValue(pass);
    }

    public Products signin(String user, String pass) {

        fillForm(user, pass);
        signinButton.click();
        return new Products(driver);
    }

    public Signup goSignup() {

        getElements();
        signupButton.click();
        return new Signup(this.driver);
    }

    public String errorMessage() {
        return error(errorLoginID);
    }
}
