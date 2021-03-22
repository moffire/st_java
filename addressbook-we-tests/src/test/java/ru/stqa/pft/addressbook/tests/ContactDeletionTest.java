package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testDeleteContact(){
        app.getNavigationHelper().goToMainPage();
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
        int before = app.getContactHelper().getContactsCount();
        app.getContactHelper().selectContact(0);
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().goToMainPage();
        int after = app.getContactHelper().getContactsCount();
        Assert.assertEquals(after, before - 1);
    }
}
