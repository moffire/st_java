package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends BaseHelper {

    public ContactHelper(FirefoxDriver driver) {
        super(driver);
    }

    public void fillContactForm(ContactData contactData) {
        fillField(By.name("firstname"), contactData.getFirstname());
        fillField(By.name("lastname"), contactData.getLastname());
        fillField(By.name("nickname"), contactData.getNickname());
        fillField(By.name("title"), contactData.getTitle());
        fillField(By.name("company"), contactData.getCompany());
        fillField(By.name("address"), contactData.getAddress());
        fillField(By.name("mobile"), contactData.getMobile());
        fillField(By.name("email"), contactData.getEmail());
    }
}
