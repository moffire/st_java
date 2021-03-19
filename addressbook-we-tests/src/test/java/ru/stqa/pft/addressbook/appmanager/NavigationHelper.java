package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper {


    public NavigationHelper(WebDriver driver){
        super(driver);
    }

    public void gotoGroupPage() {
      click(By.linkText("groups"));
    }

    public void goToContactsPage(){
        click(By.linkText("add new"));
    }

    public void goToMainPage() {
        driver.get("http://localhost/addressbook/index.php");
    }
}
