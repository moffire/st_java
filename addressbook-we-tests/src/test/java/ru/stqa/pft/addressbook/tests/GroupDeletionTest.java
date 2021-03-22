package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    if (! app.getGroupHelper().isGroupPresents()) {
      app.getGroupHelper().createGroup(new GroupData("newGroup", "groupHeader", "groupFooter"));
    }
    app.getGroupHelper().selectGroup(before - 1);
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().gotoGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before - 1);
  }

}
