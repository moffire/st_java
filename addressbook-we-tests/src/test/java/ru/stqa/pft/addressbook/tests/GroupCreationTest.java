package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("newGroup", "groupHeader", "groupFooter"));
    int after = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().gotoGroupPage();
    Assert.assertEquals(after, before + 1);
  }

}
