package my.javapr.addressbook.tests;

import my.javapr.addressbook.model.ContactData;
import org.testng.annotations.Test;

/**
 * Created by allan on 3/2/2016.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testsContactModification() {
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Peter1", "Sidoroff", "5557774456", "peter1.sidoroff@host.com"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
