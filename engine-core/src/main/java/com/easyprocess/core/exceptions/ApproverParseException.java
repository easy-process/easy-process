package com.easyprocess.core.exceptions;

public class ApproverParseException extends RuntimeException {

  public ApproverParseException() {
  }

  public ApproverParseException(String message) {
    super(message);
  }

  public ApproverParseException(String message, Throwable cause) {
    super(message, cause);
  }

  public ApproverParseException(Throwable cause) {
    super(cause);
  }

  public ApproverParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
