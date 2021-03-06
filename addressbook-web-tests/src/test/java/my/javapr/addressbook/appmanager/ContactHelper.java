package my.javapr.addressbook.appmanager;

import my.javapr.addressbook.model.ContactData;
import my.javapr.addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

/**
 * Created by allan on 3/2/2016.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("mobile"), contactData.getMobilePhone());
//    attach(By.name("photo"), contactData.getPhoto());
    if (creation) {
      if (contactData.getGroups().size() >0) {
        Assert.assertTrue(contactData.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group")))
                .selectByVisibleText(contactData.getGroups().iterator().next().getName());
      }
      else {
        Assert.assertFalse(isElementPresent(By.name("new_group")));
      }
//    if (isElementPresent(By.name("new_group"))) {
//      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    }
  }

  public void selectContactById(int id) { wd.findElement(By.cssSelector("input[id='" + id +"']")).click();  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void initContactModification() {  click(By.cssSelector("img[alt='Edit']"));  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void confirmDeletion() {
    wd.switchTo().alert().accept();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact, true);
    submitContactCreation();
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContacts();
    isAlertPresent();
    confirmDeletion();
  }

  public void modify(ContactData contact) {
//    selectContactById(contact.getId());
    initContactModificationById(contact.getId());
//    initContactModification();
    fillContactForm(contact, true);
    submitContactModification();
    returnToHomePage();
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String address = cells.get(3).getText();
      String email = cells.get(4).getText();
      String mobilePhone = cells.get(5).getText();
      String allPhones = cells.get(5).getText();
      contacts.add(new ContactData()
              .withId(id).withFirstname(firstname).withLastname(lastname).withAddress(address)
              .withEmail(email).withMobilePhone(mobilePhone));
    }
    return contacts;
  }

  public ContactData infoFromEditForm(ContactData contact) {
      initContactModificationById(contact.getId());
      String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
      String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
      String address = wd.findElement(By.name("address")).getAttribute("value");
      String email = wd.findElement(By.name("email")).getAttribute("value");
      String home = wd.findElement(By.name("home")).getAttribute("value");
      String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
      String work = wd.findElement(By.name("work")).getAttribute("value");
      return new ContactData().withId(contact.getId()).withLastname(lastname).withFirstname(firstname)
              .withAddress(address).withEmail(email).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
  }

  public void initContactModificationById(int id) {
    wd.findElement(By.cssSelector((String.format("a[href='edit.php?id=%s']", id)))).click();
  }

  public ContactData infoFromDetailsForm(ContactData contact) {
    initContactDetailsById(contact.getId());
    String contactDetails = wd.findElement(By.id("content")).getText();
    return new ContactData().withContactDetails(contactDetails);
  }

  private void initContactDetailsById(int id) {
    wd.findElement(By.cssSelector((String.format("a[href='view.php?id=%s']", id)))).click();
  }
}
