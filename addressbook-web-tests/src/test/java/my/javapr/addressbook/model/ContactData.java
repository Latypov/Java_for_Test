package my.javapr.addressbook.model;

import java.io.File;
import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {

  @XStreamOmitField
  @Id
  @Column(name = "Id")
//  private int id = Integer.MAX_VALUE;
  private int id;

  @Expose
  @Column(name = "lastname")
  private String lastname;

  @Expose
  @Column(name = "firstname")
  private String firstname;

  @Transient
  private String group;

  @Column(name = "home")
  @Type(type = "text")
  private String homePhone;

  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilePhone;

  @Column(name = "work")
  @Type(type = "text")
  private String workPhone;

  @Transient
  @Column(name = "allPhones")
  @Type(type = "text")
  private String allPhones;

  @Transient
  private String address;

  @Transient
  private String email;

  @Transient
  private String contactDetails;

  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  public String getContactDetails() { return contactDetails;  }

  public File getPhoto() {
    return new File(photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public ContactData withContactDetails(String contactDetails) {
    this.contactDetails = contactDetails;
    return this;
  }

  public String getAddress() { return address;  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public String getEmail() { return email;  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public String getGroup() { return group; }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

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

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public int getId() { return id;  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getHomePhone() { return homePhone; }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() { return workPhone;  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", lastname='" + lastname + '\'' +
            ", firstname='" + firstname + '\'' +
            ", mobilePhone='" + mobilePhone + '\'' +
            '}';
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return mobilePhone != null ? mobilePhone.equals(that.mobilePhone) : that.mobilePhone == null;

  }
  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
    return result;
  }
}
