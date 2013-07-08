package com.futurepeople.training.domain;

/**
 * todo
 */
public class InactiveMembershipException extends Exception {
  public InactiveMembershipException() {
  }

  public InactiveMembershipException(String message) {
    super(message);
  }

  public InactiveMembershipException(String message, Throwable cause) {
    super(message, cause);
  }

  public InactiveMembershipException(Throwable cause) {
    super(cause);
  }
}
