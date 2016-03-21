package my.javapr.addressbook.tests;

import my.javapr.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by allan on 3/2/2016.
 */
public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (! app.contact().isThereAContact()) {
      app.contact().create(new ContactData("Peter", "Sidoroff", "5557774455"));
    }
  }

  @Test
  public void testContactDeletion() {
    app.goTo().homePage();
    if (app.group().list().size() == 0) {
      app.contact().create(new ContactData("Peter", "Sidoroff", "5557774455"));
    }
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    app.goTo().homePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }
}
