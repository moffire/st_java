package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testModifyContact(){
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
        app.getNavigationHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData(
                "Aleksey",
                "Ivanov",
                "Moff",
                "title",
                "company_1",
                "Spb",
                "+722255588",
                "aaa@mail.ru"));
        app.getNavigationHelper().updateButton();
    }
}
