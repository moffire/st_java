package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;


public class GroupDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (! app.group().isGroupPresents()) {
      app.group().create(new GroupData().
              withGroupName("newGroup"));
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {
    Set<GroupData> before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedGroup);
    Assert.assertEquals(before, after);
  }


}
