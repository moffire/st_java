package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testDeleteContact(){
        app.getNavigationHelper().goToMainPage();
        app.getContactHelper().click(By.name("selected[]"));
        app.getContactHelper().deleteContact();
    }
}
