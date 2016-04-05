package my.javapr.addressbook.tests;

import my.javapr.addressbook.model.ContactData;
import my.javapr.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by allan on 3/2/2016.
 */
public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (! app.contact().isThereAContact()) {
      app.contact().create(new ContactData().
              withFirstname("Peter").withLastname("Sidoroff").withMobilePhone("5557774455"));
    }
  }

  @Test
  public void testContactDeletion() {
    if (app.db().contacts().size() == 0) {
    app.goTo().homePage();
    app.contact().create(new ContactData().withFirstname("Peter").withLastname("Sidoroff").withMobilePhone("5557774455"));
    }
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
