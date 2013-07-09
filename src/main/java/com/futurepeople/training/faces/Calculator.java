package com.futurepeople.training.faces;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * todo
 */
@Named
@RequestScoped
public class Calculator {


  private double number1=12;
  private double number2;
  private double answer;


  public void add() {
    answer = number1+number2;
  }
  public void minus() {
    answer = number1-number2;
  }


  public double getNumber1() {
    return number1;
  }

  public void setNumber1(double number1) {
    this.number1 = number1;
  }

  public double getNumber2() {
    return number2;
  }

  public void setNumber2(double number2) {
    this.number2 = number2;
  }

  public double getAnswer() {
    return answer;
  }

  public void setAnswer(double answer) {
    this.answer = answer;
  }


}
