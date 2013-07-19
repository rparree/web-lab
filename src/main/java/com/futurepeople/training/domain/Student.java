package com.futurepeople.training.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class Student {

  @Id
  @GeneratedValue
  private Long id;

  private int tokens = 10;
  private String email;
  private String fullname;
  private String password;
  private String language;


  private Date registrationDate;
  @ManyToMany
  private List<Event> registeredEvents = new ArrayList<>();
  private boolean active;
  private String name;

  protected Student(){

  }

  public Student(String email) {
    this.email = email;
    this.tokens = 10;
    this.registrationDate = new Date();
    this.active = false;
  }

  public void changePassword(String newPassword){
    this.password = newPassword;
  }

  public void setFullname(String fullname){
    this.fullname = fullname;
  }

  public void activateMembership(){
    this.active = true;
  }
  public void register(Event e) throws InactiveMembershipException, InsufficientTokensException {
    if (!active)
       throw new InactiveMembershipException("account is inactive");
    int price = e.getPriceInTokens();
    if (this.tokens < price) {

      throw new InsufficientTokensException("insufficient tokens");

    }
    this.tokens = this.tokens - price;
    this.registeredEvents.add(e);
    System.out.println("registering for " + e);


  }


  public void buyTokens(int tokens) {
    this.tokens = this.tokens + tokens;
  }

  public int getNumberOfTokens() {
    return this.tokens;
  }

  public Date getRegistrationDate() {
    return this.registrationDate;
  }

  public List<Event> getAllRegisteredEvents(){
    return this.registeredEvents; //todo ugh small by ref problem
  }

  @Override
  public String toString() {
    return this.email;
  }

  public String getEmail() {
    return email;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getName() {
    return fullname;
  }

  public String getPassword() {
    return password;
  }
}
