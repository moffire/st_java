package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupLogin;

public class SessionHelper extends  HelperBase {

    public SessionHelper(FirefoxDriver driver) {
        super(driver);
    }

    public void login(GroupLogin groupLogin) {
        type(By.name("user"), groupLogin.getAdmin());
        type(By.name("pass"), groupLogin.getSecret());
        click(By.xpath("//input[@value='Login']"));
    }
}
