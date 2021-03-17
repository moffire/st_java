package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupLogin;

public class SessionHelper extends BaseHelper {

    public SessionHelper(FirefoxDriver driver) {
        super(driver);
    }

    public void login(GroupLogin groupLogin) {
        fillField(By.name("user"), groupLogin.getAdmin());
        fillField(By.name("pass"), groupLogin.getSecret());
        click(By.xpath("//input[@value='Login']"));
    }
}
