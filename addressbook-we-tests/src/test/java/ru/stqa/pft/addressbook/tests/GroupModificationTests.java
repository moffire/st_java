package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

public class GroupModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (! app.group().isGroupPresents()) {
            app.group().create(new GroupData()
                    .withGroupName("newGroup")
                    .withFormHeader("header")
                    .withFormFooter("footer"));
        }
    }

    @Test
    public void testGroupModification(){
        Set<GroupData> before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId())
                .withGroupName("test1")
                .withFormHeader("header")
                .withFormFooter("footer");
        app.group().modify(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(before.size(), after.size());

        before.remove(modifiedGroup);
        before.add(group);
        Assert.assertEquals(before, after);
    }

}
