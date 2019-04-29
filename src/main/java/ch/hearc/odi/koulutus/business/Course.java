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
public class Course {

  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private Long id;
  private Quarter quarter;
  private int year;
  private int maxNumberOfParticipants;
  private Status status;

  @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
  @JoinColumn(name = "course_id")
  private List<Session> sessions;

  //private List<Participant> participants;

  public Course() {
    sessions = new ArrayList<>();
  }

  public Course(Quarter quarter, int year, int maxNumberOfParticipants,
      Status status, List<Session> sessions) {
    this();
    this.quarter = quarter;
    this.year = year;
    this.maxNumberOfParticipants = maxNumberOfParticipants;
    this.status = status;
    this.sessions = sessions;
  }

  public Long getId() {
    return id;
  }

  public Quarter getQuarter() {
    return quarter;
  }

  public void setQuarter(Quarter quarter) {
    this.quarter = quarter;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getMaxNumberOfParticipants() {
    return maxNumberOfParticipants;
  }

  public void setMaxNumberOfParticipants(int maxNumberOfParticipants) {
    this.maxNumberOfParticipants = maxNumberOfParticipants;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public List<Session> getSessions() {
    return sessions;
  }

  public void setSessions(List<Session> sessions) {
    this.sessions = sessions;
  }

  public void update(Course newCourse) {
    setQuarter(newCourse.getQuarter());
    setYear(newCourse.getYear());
    setMaxNumberOfParticipants(newCourse.getMaxNumberOfParticipants());
    setStatus(newCourse.getStatus());
    setSessions(newCourse.getSessions());
  }
}
