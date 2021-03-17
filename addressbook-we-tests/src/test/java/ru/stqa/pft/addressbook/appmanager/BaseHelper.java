package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseHelper {
    protected FirefoxDriver driver;

    public BaseHelper(FirefoxDriver driver) {
        this.driver = driver;
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void deleteContact() {
        click(By.cssSelector("input[value=Delete]"));
        driver.switchTo().alert().accept();
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void fillField(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }
}
