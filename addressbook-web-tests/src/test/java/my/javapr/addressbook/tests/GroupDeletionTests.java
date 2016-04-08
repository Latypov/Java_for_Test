package my.javapr.addressbook.tests;

import my.javapr.addressbook.model.GroupData;
import my.javapr.addressbook.model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
  if (app.db().groups().size() == 0) {
    app.goTo().groupPage();
    app.group().create(new GroupData().withName("test2"));
    }
  }

  @Test
  public void testGroupDeletion() {
    Groups before = app.db().groups();
    GroupData deletedGroup = before.iterator().next();
    app.goTo().groupPage();
    app.group().delete(deletedGroup);
    assertEquals(app.group().count(), before.size() - 1);
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.without(deletedGroup)));
    verifyGroupListInUI();
  }
}
