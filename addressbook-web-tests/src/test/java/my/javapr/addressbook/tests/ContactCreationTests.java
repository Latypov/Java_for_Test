package my.javapr.addressbook.tests;

import my.javapr.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testsContactCreation() {
    app.goToAddNewContactPage();
    app.fillContactForm(new ContactData("Peter", "Sidoroff", "5557774455", "peter.sidoroff@host.com"));
    app.submitContactCreation();
    app.returnToHomePage();
  }

}
