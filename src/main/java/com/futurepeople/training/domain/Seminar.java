package com.futurepeople.training.domain;

import java.util.Date;

/**
 * todo
 */

public class Seminar extends Event {


  private int priceInTokens;

  public Seminar(Date startDate,
                 String title,
                 int priceInTokens){
    super(startDate, title);

    this.priceInTokens = priceInTokens;
  }

  @Override
  public int getPriceInTokens() {
    return this.priceInTokens;
  }
}
