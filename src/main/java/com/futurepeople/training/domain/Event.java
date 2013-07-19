package com.futurepeople.training.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * todo
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "event_type")
public abstract class Event {
  Date startDate;
  private String title;

  @Id
  @GeneratedValue
  private Long id;

  protected Event() {
  }

  public abstract int
                getPriceInTokens();

  public Event(Date startDate, String title){
    this.startDate = startDate;
    this.title = title;
  }


  public String getTitle() {
    return title;
  }

  public Date getStartDate() {
    return startDate;
  }
}
