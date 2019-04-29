package ch.hearc.odi.koulutus.business;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Program {

  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private Long id;
  private String name;
  private String richDescription;
  private String field;
  private int price;

  @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
  @JoinColumn(name = "program_id")
  private List<Course> courses;

  public Program() {
    courses = new ArrayList<>();
  }

  public Program(String name, String richDescription, String field, int price,
      List<Course> courses) {
    this();
    this.name = name;
    this.richDescription = richDescription;
    this.field = field;
    this.price = price;
    this.courses = courses;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRichDescription() {
    return richDescription;
  }

  public void setRichDescription(String richDescription) {
    this.richDescription = richDescription;
  }

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

  public void update(Program newProgram) {
    setName(newProgram.getName());
    setRichDescription(newProgram.getRichDescription());
    setField(newProgram.getField());
    setPrice(newProgram.getPrice());
    setCourses(newProgram.getCourses());
  }
}
