package com.futurepeople.training.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

/**
 * todo
 */
@Entity
@DiscriminatorValue(value = "C")
@Access(AccessType.FIELD)
public class Course extends Event{
  private int duration;


  public Course(Date startDate, int duration, String title) {
    super(startDate, title);
    this.duration = duration;

  }

  protected Course() {
  }


  @Override
  public int getPriceInTokens() {
    int pricePerDay = 1;
    return duration * pricePerDay;
  }

  public int getDuration() {
    return duration;
  }
}
