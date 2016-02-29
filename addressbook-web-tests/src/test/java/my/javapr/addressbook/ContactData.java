package my.javapr.addressbook;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String mobphone;
  private final String email;

  public ContactData(String firstname, String lastname, String mobphone, String email) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.mobphone = mobphone;
    this.email = email;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getMobphone() {
    return mobphone;
  }

  public String getEmail() {
    return email;
  }
}
