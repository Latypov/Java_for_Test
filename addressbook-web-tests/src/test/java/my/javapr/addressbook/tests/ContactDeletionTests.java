package my.javapr.addressbook.tests;

import my.javapr.addressbook.model.ContactData;
import org.testng.annotations.Test;

/**
 * Created by allan on 3/2/2016.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Peter", "Sidoroff", "5557774455", "test2"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().isAlertPresent();
    app.getContactHelper().confirmContactsDeletion();
  //  app.getContactHelper().returnToHomePage();
  }
}
