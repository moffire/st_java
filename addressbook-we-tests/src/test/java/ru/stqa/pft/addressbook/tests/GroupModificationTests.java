package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (! app.group().isGroupPresents()) {
            app.group().create(new GroupData("test1", null, null));
        }
    }

    @Test
    public void testGroupModification(){
        List<GroupData> before = app.group().groupList();
        int index = before.size() - 1;
        GroupData group = new GroupData(before.get(index).getId(), "test1", null, null);
        app.group().modify(index, group);
        List<GroupData> after = app.group().groupList();
        Assert.assertEquals(before.size(), after.size());

        before.remove(index);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

}
