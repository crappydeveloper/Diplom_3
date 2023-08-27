package ru.yandex.praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public By homePageHeader = By.xpath(".//*[text()='Соберите бургер']");

    public By primaryButton = By.className("button_button_type_primary__1O7Bx");

    public void waitForHomePage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(homePageHeader));
    }

    @Step("Проверить текст кнопки на главном экране")
    public String getPrimaryButtonText() {
        return driver.findElement(primaryButton).getText();
    }
}
