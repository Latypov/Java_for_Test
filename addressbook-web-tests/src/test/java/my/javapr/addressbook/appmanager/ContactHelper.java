package my.javapr.addressbook.appmanager;

import my.javapr.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("mobile"), contactData.getMobphone());
    type(By.name("email"), contactData.getEmail());
 }

  public void selectContact() {    click(By.name("selected[]"));  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void initContactModification() {
    click(By.cssSelector("img[alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void confirmContactsDeletion() {
    wd.switchTo().alert().accept();
  }
}
