package com.futurepeople.training.faces;

import com.futurepeople.training.service.RegistrationException;
import com.futurepeople.training.service.StudentManagement;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * todo
 */

@Named
@RequestScoped
public class RegistrationController {

  private String password;
  private String fullname;
  private String email;

  @Inject
  private StudentManagement management;

  public String register() {
    try {
      management.registerNewStudent(email, fullname, password);
      return "thanks";
    } catch (RegistrationException e) {
      FacesMessage msg = new FacesMessage("email address already registered");
      FacesContext context = FacesContext.getCurrentInstance();
      context.addMessage("registrationForm:email", msg);
      return null;
    }
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}

