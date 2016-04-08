package my.javapr.addressbook.tests;

import my.javapr.addressbook.model.ContactData;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Nurulla on 3/26/2016.
 */
public class ContactDetailsTest extends TestBase {

  @Test
  public void testContactDetails() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    app.goTo().homePage();
    ContactData contactInfoFromDetailsForm = app.contact().infoFromDetailsForm(contact);

    assertThat(mergeDetailsForm(contactInfoFromDetailsForm), equalTo(mergeEditForm(contactInfoFromEditForm)));
  }

  private String mergeEditForm(ContactData contact) {
    return Arrays.asList(contact.getFirstname(), contact.getLastname(), contact.getAddress(), contact.getHomePhone()
            , contact.getMobilePhone(), contact.getWorkPhone(), contact.getEmail()).stream()
            .filter((s) -> !s.equals("")).map(ContactDetailsTest::cleaned).collect(Collectors.joining(""));
  }

  private String mergeDetailsForm(ContactData contact) {
    return Arrays.asList(contact.getContactDetails()).stream()
            .filter((s) -> !s.equals("")).map(ContactDetailsTest::cleaned).collect(Collectors.joining(""));
  }

  public static String cleaned(String edit) {
    return edit.replaceAll("\\s", "").replaceAll("\\n", "").replaceAll("(H:)", "")
            .replaceAll("(M:)", "").replaceAll("(W:)", "");
  }
}
