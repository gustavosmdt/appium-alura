package com.alura.appium;

import com.alura.appium.PageObjects.Products;
import com.alura.appium.PageObjects.Signin;
import com.alura.appium.PageObjects.Signup;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchElementException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FeatureSignupAndSignup {

    String pass = "123";
    String user = "Gustavo";

    @Order(1)
    @Test
    public void should_not_signup_with_different_pass() {

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Signin signinView = new Signin(driver);
        Signup signupView = signinView.goSignup();
        signupView.getElements();
        signupView.signup(user, pass, "321");

        Assertions.assertEquals("Senhas não conferem", signupView.errorMessage());
        driver.navigate().back();
    }

    @Order(2)
    @Test
    public void should_signup_with_same_password() throws NoSuchElementException {

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Signin signinView = new Signin(driver);
        Signup signupView = signinView.goSignup();
        signupView.getElements();
        signinView = signupView.signup(user, pass, pass);
        signinView.getElements();
    }

    @Order(3)
    @Test
    public void should_not_signup_with_same_existing_user_credential() {

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Signin signinView = new Signin(driver);
        Signup signupView = signinView.goSignup();
        signupView.getElements();
        signinView = signupView.signup(user, pass, pass);

        Assert.assertEquals("Usuario já Cadastrado", signupView.errorMessage());
        driver.navigate().back();
    }

    @Order(4)
    @Test
    public void should_not_signin_with_wrong_credential() {

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Signin signinView = new Signin(driver);
        signinView.getElements();
        signinView.signin(user, "321");
        Assertions.assertEquals("Usuário ou senha inválidos", signinView.errorMessage());
    }

    @Order(5)
    @Test
    public void should_signin_with_correct_credentials() {

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Signin signinView = new Signin(driver);
        signinView.getElements();
        Products listProducts = signinView.signin(user, pass);
        listProducts.getElements();
    }
}
