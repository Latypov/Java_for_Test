package my.javapr.addressbook.tests;

import my.javapr.addressbook.model.ContactData;
import my.javapr.addressbook.model.Contacts;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Contacts before = (Contacts) app.contact().all();
    File photo = new File("src/test/resources/TC.png");
    ContactData contact = new ContactData()
            .withLastname("Sidoroff").withFirstname("Peter").withAllPhones("5557774455").withPhoto(photo);
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
//    assertThat(after, equalTo(
//            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadContactCreation() {
    app.goTo().homePage();
    Contacts before = (Contacts) app.contact().all();
    ContactData contact = new ContactData()
            .withLastname("Sidoroff").withFirstname("Peter'").withMobilePhone("5557774455");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }
}
