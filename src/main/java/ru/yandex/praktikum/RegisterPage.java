package ru.yandex.praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //Поел имени
    public By nameField = By.xpath(".//fieldset[1]//input");

    //Поле имейла
    public By emailField = By.xpath(".//fieldset[2]//input");

    //Поле пароля
    public By passwordField = By.xpath(".//input[@type= 'password']");

    //Кнопка зарегистрироваться
    public By registrationButton = By.xpath(".//button[text()= 'Зарегистрироваться']");

    //Ошибка при некорректном пароле
    public By errorIncorrectPassword = By.className("input__error");;

    //Кнопка для авторизации
    public By signInButton = By.className("Auth_link__1fOlj");

    //Заполнить имя
    @Step("Fill the name")
    public void fillNameField(String name) {
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
    }

    //Заполнить емейл
    @Step("Fill the email")
    public void fillEmailField(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    //Заполнить пароль
    @Step("Fill the password")
    public void fillPasswordField(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    //Нажать на кнопку регистрации
    @Step("Click signUp button on signUp form")
    public void clickSignUpButton() {
        driver.findElement(registrationButton).click();
    }

    //Зарегистрировать пользователя
    @Step("Sign up user")
    public void registerUser(String name, String email, String password) {
        fillNameField(name);
        fillEmailField(email);
        fillPasswordField(password);
        clickSignUpButton();
    }

    @Step("Проверить текст ошибки у поля пароля")
    public String getPasswordErrorText() {
        return driver.findElement(errorIncorrectPassword).getText();
    }


    //Нажатие на кнопку авторизации
    @Step("Click signIn button on signUp page")
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(signInButton));
    }


}
