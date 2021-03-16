package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupLogin;

public class SessionHelper {
    private FirefoxDriver driver;

    public SessionHelper(FirefoxDriver driver) {
        this.driver = driver;
    }

    public void login(GroupLogin groupLogin) {
        driver.findElement(By.name("user")).click();
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(groupLogin.getAdmin());
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(groupLogin.getSecret());
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }
}
