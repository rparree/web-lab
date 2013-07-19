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
@DiscriminatorValue(value = "S")
@Access(AccessType.FIELD)
public class Seminar extends Event {


  private int priceInTokens;

  public Seminar(Date startDate,
                 String title,
                 int priceInTokens){
    super(startDate, title);

    this.priceInTokens = priceInTokens;
  }

  protected Seminar() {
  }

  @Override
  public int getPriceInTokens() {
    return this.priceInTokens;
  }
}
