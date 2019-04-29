package ch.hearc.odi.koulutus.business;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Session  {

  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private Long id;
  private Date startDateTime;
  private Date endDateTime;
  private Double price;
  private String room;

  public Session() {
  }

  public Session(Date startDateTime, Date endDateTime, Double price, String room) {
    this.startDateTime = startDateTime;
    this.endDateTime = endDateTime;
    this.price = price;
    this.room = room;
  }

  public Long getId() {
    return id;
  }

  public Date getStartDateTime() {
    return startDateTime;
  }

  public void setStartDateTime(Date startDateTime) {
    this.startDateTime = startDateTime;
  }

  public Date getEndDateTime() {
    return endDateTime;
  }

  public void setEndDateTime(Date endDateTime) {
    this.endDateTime = endDateTime;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getRoom() {
    return room;
  }

  public void setRoom(String room) {
    this.room = room;
  }

  public void update(Session newSession) {
    setStartDateTime(newSession.getStartDateTime());
    setEndDateTime(newSession.getEndDateTime());
    setPrice(newSession.getPrice());
    setRoom(newSession.getRoom());
  }
}
