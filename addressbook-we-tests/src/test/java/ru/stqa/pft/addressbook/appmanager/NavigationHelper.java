package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper {


    public NavigationHelper(WebDriver driver){
        super(driver);
    }

    public void groupPage() {
        if (isElementPresent(By.tagName("h1"))
                && driver.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
            return;
        }
      click(By.linkText("groups"));
    }

    public void contactPage() {
        if (isElementPresent(By.id("theform"))) {
            return;
        }
        click(By.linkText("add new"));
    }

    public void mainPage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        driver.get("http://localhost/addressbook/index.php");
    }
}
