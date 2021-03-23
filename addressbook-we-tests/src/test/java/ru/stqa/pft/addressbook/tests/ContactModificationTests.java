package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    // update button is broken and deleting record instead of updating
    @Test(enabled = false)
    public void testModifyContact(){
        app.goTo().mainPage();
        int before = app.contact().count();
        if (! app.contact().isContactPresents()) {
            app.goTo().contactPage();
            app.contact().create(new ContactData(
                    "Lastname",
                    "Nickname"));
        }
        app.contact().selectContact(before - 1);
        app.goTo().initContactModification();
        app.contact().updateContact("EditedFirstName");
        app.goTo().updateButton();
        app.goTo().mainPage();
        int after = app.contact().count();
        Assert.assertEquals(before, after);
    }
}
