package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testDeleteContact(){
        app.goTo().mainPage();
        if (! app.contact().isContactPresents()) {
            app.contact().create(new ContactData(
                    "Firstname",
                    "Lastname"));
        }
        List<ContactData> beforeList = app.contact().contactList();
        int before = app.contact().count();
        int index = 0;
        app.contact().selectContact(index);
        app.contact().deleteContact();
        app.goTo().mainPage();
        int after = app.contact().count();

        Assert.assertEquals(after, before - 1);

        List<ContactData> afterList = app.contact().contactList();
        beforeList.remove(index);
        Assert.assertTrue(afterList.containsAll(beforeList));
    }
}
