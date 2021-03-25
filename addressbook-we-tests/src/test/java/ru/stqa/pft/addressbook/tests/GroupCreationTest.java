package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Random;
import java.util.Set;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    Set<GroupData> before = app.group().all();

    Random rand = new Random();
    int randId = rand.nextInt(99999);

    GroupData group = new GroupData()
            .withId(String.valueOf(randId))
            .withGroupName("newGroup");
    app.group().create(group);

    Set<GroupData> after = app.group().all();

    before.add(group);
    Assert.assertEquals(after, before);
  }

}
