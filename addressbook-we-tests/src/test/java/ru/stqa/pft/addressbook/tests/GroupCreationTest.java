package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    List<GroupData> before = app.group().groupList();
    app.group().create(new GroupData("newGroup", "groupHeader", "groupFooter"));
    List<GroupData> after = app.group().groupList();
    app.group().groupPage();
    Assert.assertEquals(after.size(), before.size() + 1);
  }

}
