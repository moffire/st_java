package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class BaseHelper {
    protected WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void initContactModification(){
        click(By.cssSelector("[title=Edit]"));
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void updateButton(){
        click(By.cssSelector("[name=update]"));
    }

    public void enterButton() {
        click(By.cssSelector("[value=Enter]"));
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
        if (text != null) {
            String existingText = driver.findElement(locator).getAttribute("value");
            if (! text.equals(existingText)){
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }
}
