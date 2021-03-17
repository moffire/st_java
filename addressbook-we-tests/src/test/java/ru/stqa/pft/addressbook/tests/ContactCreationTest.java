package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase{

    @Test
    public void testCreateContact(){
        app.getNavigationHelper().goToContactsPage();
        app.getContactHelper().fillContactForm(new ContactData(
                "Ivan",
                "Petrov",
                "OOOPPP",
                "Title",
                "Company_1",
                "SPb",
                "+79990101010",
                "aaa@mail.ru"));
        app.getContactHelper().submitContactCreation();
    }
}
