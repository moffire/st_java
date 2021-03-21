package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testDeleteContact(){
        app.getNavigationHelper().goToContactsPage();
        if (! app.getContactHelper().isContactPresents()) {
            app.getContactHelper().createContact(new ContactData(
                    "Firstname",
                    "Lastname",
                    "Nickname",
                    "Title",
                    "Company",
                    "Address",
                    "Mobile",
                    "Email"));
        }
        app.getContactHelper().click(By.name("selected[]"));
        app.getContactHelper().deleteContact();
    }
}
