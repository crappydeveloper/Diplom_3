package ru.yandex.praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public By enterButton = By.xpath(".//button[text()='Войти']");

    public By emailField = By.xpath(".//fieldset[1]//input");

    public By passwordField = By.xpath(".//fieldset[2]//input");

    public By loginPageHeader = By.xpath(".//*[text()='Вход']");

    public By restorePasswordButton = By.xpath(".//p[2]/a");

    @Step("Заполнить поле email")
    public void fillEmailField(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Заполнить поле пароля")
    public void fillPasswordField(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажать на кнопку авторизации")
    public void clickEntranceButton() {
        driver.findElement(enterButton).click();
    }

    @Step("Нажать на ссылку страницы восстановления пароля")
    public void clickPasswordRestoreButton() {
        driver.findElement(restorePasswordButton).click();
    }

    public void waitForLoginPage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(loginPageHeader));
    }

    @Step("Sign in user")
    public void loginUser(String email, String password) {
        fillEmailField(email);
        fillPasswordField(password);
        clickEntranceButton();

    }

    @Step("Check empty signIn page is loaded")
    public void checkEmptySignInPage() {
       // waitSignInPage();
        assert(driver.findElement(emailField).getAttribute("value").isEmpty());
        assert(driver.findElement(passwordField).getAttribute("value").isEmpty());
    }
}
