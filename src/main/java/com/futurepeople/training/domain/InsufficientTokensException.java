package com.futurepeople.training.domain;

/**
 * todo
 */
public class InsufficientTokensException extends Exception {
  public InsufficientTokensException() {
  }

  public InsufficientTokensException(String message) {
    super(message);
  }

  public InsufficientTokensException(String message, Throwable cause) {
    super(message, cause);
  }

  public InsufficientTokensException(Throwable cause) {
    super(cause);
  }
}
