package my.javapr.addressbook.tests;

import my.javapr.addressbook.model.ContactData;
import org.testng.annotations.Test;

/**
 * Created by allan on 3/2/2016.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testsContactModification() {
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Peter", "Sidoroff", "5557774455", "test2"));
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Peter", "Sidoroff", "5557774455", null));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
