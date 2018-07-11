package com.example.pact;

public class ConsumerResponse {
  private int _statusCode;
  private String _response = "";

  public int getStatusCode() {
    return this._statusCode;
  }

  public void setStatusCode(int statusCode) {
      this._statusCode = statusCode;
  }

  public String getResponse() {
    return this._response;
  }

  public void setResponse(String response) {
      this._response = response;
  }
}