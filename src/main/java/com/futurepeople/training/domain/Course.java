package com.futurepeople.training.domain;

import java.util.Date;

/**
 * todo
 */
public class Course extends Event{
  private int duration;


  public Course(Date startDate, int duration, String title) {
    super(startDate, title);
    this.duration = duration;

  }



  @Override
  public int getPriceInTokens() {
    int pricePerDay = 1;
    return duration * pricePerDay;
  }
}
