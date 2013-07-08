package com.futurepeople.training.domain;

/**
 * todo
 */
public class Person {
  private String firstName;
  private String lastName;

  @Override
  public int hashCode() {
    return 31*firstName.hashCode() + lastName.hashCode();
  }
}
