package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModification(){
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isGroupPresents()) {
            app.getGroupHelper().createGroup(new GroupData("newGroup", "groupHeader", "groupFooter"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("modified", "test", "test"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().gotoGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(before.size(), after.size());
    }
}
