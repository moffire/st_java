package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    // update button is broken and deleting record instead of updating
    @Test
    public void testModifyContact(){
        app.getNavigationHelper().goToMainPage();
        int before = app.getContactHelper().getContactsCount();
        if (! app.getContactHelper().isContactPresents()) {
            app.getNavigationHelper().goToContactCreationPage();
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
        app.getContactHelper().selectContact(before - 1);
        app.getNavigationHelper().initContactModification();
        app.getContactHelper().updateContact("EditedFirstName");
        app.getNavigationHelper().updateButton();
        app.getNavigationHelper().goToMainPage();
        int after = app.getContactHelper().getContactsCount();
        Assert.assertEquals(before, after);
    }
}
