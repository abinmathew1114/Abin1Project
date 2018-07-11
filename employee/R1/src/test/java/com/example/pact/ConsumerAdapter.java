package com.example.pact;

import static java.util.Objects.requireNonNull;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConsumerAdapter {

  private final String url;

  public ConsumerAdapter(String url) {
    this.url = requireNonNull(url);
  }

  public ConsumerResponse getEmployees() {
	  try {
      URL url = new URL(this.url+"/Employees");
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.setRequestProperty("Accept", "application/json");

      ConsumerResponse response = new ConsumerResponse();
      response.setStatusCode(conn.getResponseCode());
      String answer = this.read(conn.getInputStream());
      response.setResponse(answer);
      conn.disconnect();
      return response;
  
      } catch (MalformedURLException e) {
        e.printStackTrace();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
        ConsumerResponse response = new ConsumerResponse();
        response.setStatusCode(404);
        response.setResponse("");
        return response;
      } catch (IOException e) {
        e.printStackTrace();
      }
      return null;
  }

  public ConsumerResponse getEmployeeById(String empid) {
	  try {
      URL url = new URL(this.url+"/Employees/"+empid);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.setRequestProperty("Accept", "application/json");

      ConsumerResponse response = new ConsumerResponse();
      response.setStatusCode(conn.getResponseCode());
      String answer = this.read(conn.getInputStream());
      response.setResponse(answer);
      conn.disconnect();
      return response;
  
      } catch (MalformedURLException e) {
        e.printStackTrace();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
        ConsumerResponse response = new ConsumerResponse();
        response.setStatusCode(404);
        response.setResponse("");
        return response;
      } catch (IOException e) {
        e.printStackTrace();
      }
      return null;
  }

  public ConsumerResponse addEmployee(String newRecord) {
	  try {
      URL url = new URL(this.url+"/Employees");
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("POST");
      conn.setRequestProperty("Content-Type", "application/json");
      conn.setRequestProperty("Accept", "application/json");
      conn.setDoOutput(true);
      this.sendData(conn, newRecord);

      ConsumerResponse response = new ConsumerResponse();
      response.setStatusCode(conn.getResponseCode());
      String answer = this.read(conn.getInputStream());
      response.setResponse(answer);
      conn.disconnect();
      return response;
  
      } catch (MalformedURLException e) {
        e.printStackTrace();
        return null;
      } catch (FileNotFoundException e) {
        e.printStackTrace();
        ConsumerResponse response = new ConsumerResponse();
        response.setStatusCode(404);
        response.setResponse("");
        return response;
      } catch (IOException e) {
        e.printStackTrace();
        return null;
      }
  }

  public ConsumerResponse updateEmployee(String empid, String newRecord) {
	  try {
      URL url = new URL(this.url+"/Employees/"+empid);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("PUT");
      conn.setRequestProperty("Content-Type", "application/json");
      conn.setRequestProperty("Accept", "application/json");
      conn.setDoOutput(true);
      this.sendData(conn, newRecord);

      ConsumerResponse response = new ConsumerResponse();
      response.setStatusCode(conn.getResponseCode());
      String answer = this.read(conn.getInputStream());
      response.setResponse(answer);
      conn.disconnect();
      return response;
  
      } catch (MalformedURLException e) {
        e.printStackTrace();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
        ConsumerResponse response = new ConsumerResponse();
        response.setStatusCode(404);
        response.setResponse("");
        return response;
      } catch (IOException e) {
        e.printStackTrace();
      }
      return null;
  }

  public ConsumerResponse deleteEmployee(String empid) {
	  try {
      URL url = new URL(this.url+"/Employees/"+empid);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("DELETE");

      ConsumerResponse response = new ConsumerResponse();
      response.setStatusCode(conn.getResponseCode());
      response.setResponse("");
      conn.disconnect();
      return response;
  
      } catch (MalformedURLException e) {
        e.printStackTrace();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
        ConsumerResponse response = new ConsumerResponse();
        response.setStatusCode(404);
        response.setResponse("");
        return response;
      } catch (IOException e) {
        e.printStackTrace();
      }
      return null;
  }


  protected void sendData(HttpURLConnection con, String data) throws IOException {
    DataOutputStream wr = null;
    try {
        wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(data);
        wr.flush();
        wr.close();
    } catch(IOException exception) {
        throw exception;
    } finally {
        this.closeQuietly(wr);
    }
  }

  private String read(InputStream is) throws IOException {
    BufferedReader in = null;
    String inputLine;
    StringBuilder body;
    try {
        in = new BufferedReader(new InputStreamReader(is));

        body = new StringBuilder();

        while (in!=null && (inputLine = in.readLine()) != null) {
            body.append(inputLine);
        }
        in.close();

        return body.toString();
    } catch(IOException ioe) {
        throw ioe;
    } finally {
        this.closeQuietly(in);
    }
  }

  protected void closeQuietly(Closeable closeable) {
      try {
          if( closeable != null ) {
              closeable.close();
          }
      } catch(IOException ex) {

      }
  }
}
