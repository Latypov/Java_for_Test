package my.javapr.addressbook.tests;

import my.javapr.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testsContactCreation() {
    app.goToAddNewContactPage();
    app.getContactHelper().fillContactForm(new ContactData("Peter", "Sidoroff", "5557774455", "peter.sidoroff@host.com"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }

}
