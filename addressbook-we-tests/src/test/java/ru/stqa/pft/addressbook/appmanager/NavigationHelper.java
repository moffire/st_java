package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends BaseHelper {


    public NavigationHelper(FirefoxDriver driver){
        super(driver);
    }

    public void gotoGroupPage() {
      click(By.linkText("groups"));
    }

    public void goToContactsPage(){
        click(By.linkText("add new"));
    }
}
