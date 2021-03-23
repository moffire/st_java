package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTest extends TestBase{

    @Test
    public void testCreateContact() {
        app.goTo().mainPage();
        int before = app.contact().count();
        List<ContactData> beforeList = app.contact().contactList();
        app.goTo().contactPage();
        ContactData newContact = new ContactData("Ivan", "Petrov");
        app.contact().create(newContact);
        app.goTo().mainPage();
        int after = app.contact().count();
        List<ContactData> afterList = app.contact().contactList();

        Assert.assertEquals(after, before + 1);
        beforeList.add(newContact);
        Assert.assertTrue(beforeList.containsAll(afterList));
    }
}
