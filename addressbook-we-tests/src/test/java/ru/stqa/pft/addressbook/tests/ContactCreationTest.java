package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTest extends TestBase{

    @Test
    public void testCreateContact() {
        app.getNavigationHelper().goToMainPage();
        int before = app.getContactHelper().getContactsCount();
        List<ContactData> beforeList = app.getContactHelper().getContactList();
        app.getNavigationHelper().goToContactCreationPage();
        ContactData newContact = new ContactData("Ivan", "Petrov");
        app.getContactHelper().createContact(newContact);
        app.getNavigationHelper().goToMainPage();
        int after = app.getContactHelper().getContactsCount();
        List<ContactData> afterList = app.getContactHelper().getContactList();
        Assert.assertEquals(after, before + 1);
        beforeList.add(newContact);
        Assert.assertTrue(beforeList.containsAll(afterList));
    }
}
