package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testDeleteContact(){
        app.getNavigationHelper().goToMainPage();
        if (! app.getContactHelper().isContactPresents()) {
            app.getContactHelper().createContact(new ContactData(
                    "Firstname",
                    "Lastname"));
        }
        List<ContactData> beforeList = app.getContactHelper().getContactList();
        int before = app.getContactHelper().getContactsCount();
        int index = 0;
        app.getContactHelper().selectContact(index);
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().goToMainPage();
        int after = app.getContactHelper().getContactsCount();

        Assert.assertEquals(after, before - 1);

        List<ContactData> afterList = app.getContactHelper().getContactList();
        beforeList.remove(index);
        Assert.assertTrue(afterList.containsAll(beforeList));
    }
}
