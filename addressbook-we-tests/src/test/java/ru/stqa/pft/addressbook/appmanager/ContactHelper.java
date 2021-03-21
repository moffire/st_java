package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends NavigationHelper {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void createContact(ContactData contactData) {
        fillField(By.name("firstname"), contactData.getFirstname());
        fillField(By.name("lastname"), contactData.getLastname());
        fillField(By.name("nickname"), contactData.getNickname());
        fillField(By.name("title"), contactData.getTitle());
        fillField(By.name("company"), contactData.getCompany());
        fillField(By.name("address"), contactData.getAddress());
        fillField(By.name("mobile"), contactData.getMobile());
        fillField(By.name("email"), contactData.getEmail());
        enterButton();
    }

    public void updateContact(String newData) {
        fillField(By.name("firstname"), newData);
    }

    public boolean isContactPresents() {
        return isElementPresent(By.name("entry"));
    }

    public int getContactsCount() {
        return driver.findElements(By.name("selected[]")).size();
    }
}
