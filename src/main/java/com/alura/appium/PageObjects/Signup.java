package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class Signup extends Main{

    private MobileElement inputName;
    private MobileElement inputPassword;
    private MobileElement inputConfirmPassword;
    private MobileElement signupConfirmButton;;
    private final By errorId;
    private final By inputNameId;
    private final By inputPasswordId;
    private final By inputConfirmPasswordId;
    private final By signupConfirmButtonId;

    public Signup(AppiumDriver driver) {

        super(driver);
        errorId = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
        inputNameId = By.id("br.com.alura.aluraesporte:id/input_nome");
        inputPasswordId = By.id("br.com.alura.aluraesporte:id/input_senha");
        inputConfirmPasswordId = By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
        signupConfirmButtonId = By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
    }

    @Override
    public void getElements() {

        inputName = (MobileElement) driver.findElement(inputNameId);
        inputPassword = (MobileElement) driver.findElement(inputPasswordId);
        inputConfirmPassword = (MobileElement) driver.findElement(inputConfirmPasswordId);
        signupConfirmButton = (MobileElement) driver.findElement(signupConfirmButtonId);
    }

    private void fillForm(String user, String pass, String confirmPass) {

        inputName.setValue(user);
        inputPassword.setValue(pass);
        inputConfirmPassword.setValue(confirmPass);
    }

    public Signin signup(String user, String pass, String confirmPass) {

        fillForm(user, pass, confirmPass);
        signupConfirmButton.click();
        return new Signin(driver);
    }

    public String errorMessage() {
        return error(errorId);
    }
}
