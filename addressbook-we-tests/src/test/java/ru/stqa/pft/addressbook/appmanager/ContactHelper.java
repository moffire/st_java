package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ContactHelper extends NavigationHelper {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void create(ContactData contactData) {
        fillField(By.name("firstname"), contactData.getFirstname());
        fillField(By.name("lastname"), contactData.getLastname());
        enterButton();
    }

    public List<ContactData> contactList() {
        List<ContactData> contactData = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.name("entry"));
        for (WebElement element: elements) {
            String lastName = element.findElements(By.tagName("td")).get(1).getText();
            String firstName = element.findElements(By.tagName("td")).get(2).getText();
            ContactData data = new ContactData(firstName, lastName);
            contactData.add(data);
        }
        return contactData;
    }

    public void updateContact(String newData) {
        fillField(By.name("firstname"), newData);
    }

    public boolean isContactPresents() {
        return isElementPresent(By.name("entry"));
    }

    public int count() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public void selectContact(int index) {
        try {
            driver.findElements(By.name("selected[]")).get(index).click();
        } catch (IndexOutOfBoundsException ex) {
            driver.findElements(By.name("selected[]")).get(0).click();
        }

    }


}
