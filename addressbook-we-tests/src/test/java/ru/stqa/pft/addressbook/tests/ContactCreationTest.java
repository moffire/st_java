package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase{

    @Test
    public void testCreateContact() {
        app.getNavigationHelper().goToMainPage();
        int before = app.getContactHelper().getContactsCount();
        app.getNavigationHelper().goToContactCreationPage();
        app.getContactHelper().createContact(new ContactData(
                "Ivan",
                "Petrov",
                "OOOPPP",
                "Title",
                "Company_1",
                "SPb",
                "+79990101010",
                "aaa@mail.ru"));
        app.getNavigationHelper().goToMainPage();
        int after = app.getContactHelper().getContactsCount();
        Assert.assertEquals(after, before + 1);
    }
}
