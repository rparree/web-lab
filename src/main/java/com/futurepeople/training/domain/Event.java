package com.futurepeople.training.domain;

import java.util.Date;

/**
 * todo
 */
public abstract class Event {
  Date startDate;
  private String title;

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
