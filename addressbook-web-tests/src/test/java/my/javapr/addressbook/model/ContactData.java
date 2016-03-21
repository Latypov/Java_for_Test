package my.javapr.addressbook.model;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String lastname;
  private String mobphone;

  public int getId() { return id;  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withMobphone(String mobphone) {
    this.mobphone = mobphone;
    return this;
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

//  public String getGroup() {    return group;  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", mobphone='" + mobphone + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    return mobphone != null ? mobphone.equals(that.mobphone) : that.mobphone == null;
  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + (mobphone != null ? mobphone.hashCode() : 0);
    return result;
  }
}
