package my.javapr.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by allan on 3/2/2016.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().isAlertPresent();
    app.getContactHelper().confirmContactsDeletion();
  //  app.getContactHelper().returnToHomePage();
  }
}
