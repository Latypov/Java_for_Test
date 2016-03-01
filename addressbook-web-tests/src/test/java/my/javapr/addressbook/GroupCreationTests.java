package my.javapr.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    goToGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test1", "test11", "test111"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
