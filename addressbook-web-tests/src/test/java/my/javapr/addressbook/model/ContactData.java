package my.javapr.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String mobphone;
  private final String group;

  public ContactData(String firstname, String lastname, String mobphone, String group) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.mobphone = mobphone;
    this.group = group;
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

  public String getGroup() {    return group;  }

}
