package ch.hearc.odi.koulutus.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Participant {

  private Long id;
  private String firstName;
  private String lastName;
  private Date birthdate;
  private List<Course> courses;

  public Participant() {
    courses = new ArrayList<>();
  }

  public Participant(String firstName, String lastName, Date birthdate,
      List<Course> courses) {
    this();
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthdate = birthdate;
    this.courses = courses;
  }

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(Date birthdate) {
    this.birthdate = birthdate;
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }
}
