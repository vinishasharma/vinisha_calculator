package com.calc;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

/**
 * Operations class.
 */

public class Operations {

  private double result;

  double addition(double leftOperand, double rightOperand) {

    result = leftOperand + rightOperand;
    return result;
  }

  double subtraction(double leftOperand, double rightOperand) {
    result = leftOperand - rightOperand;
    return result;
  }

  double multiplication(double leftOperand, double rightOperand) {

    result = leftOperand * rightOperand;
    return result;
  }

  double division(double leftOperand, double rightOperand) {

    try {
      result = leftOperand / rightOperand;

    } catch (ArithmeticException e) {
      System.out.println("Can't be divided by Zero" + e);
    }
    return result;
  }

  double power(double leftOperand, double rightOperand) {

    result = Math.pow(leftOperand, rightOperand);
    return result;
  }

  double absolute(double leftOperand) {

    result = Math.abs(leftOperand);
    return result;
  }

  double modulus(double leftOperand, double rightOperand) {

    result = leftOperand % rightOperand;
    return result;
  }

  double maximum(double leftOperand, double rightOperand) {

    if (leftOperand > rightOperand) {
      result = leftOperand;
    } else {
      result = rightOperand;
    }
    return result;
  }

  double minimum(double leftOperand, double rightOperand) {

    if (leftOperand < rightOperand) {
      result = leftOperand;
    } else {
      result = rightOperand;
    }
    return result;
  }

  void write_data(double leftOperand, double rightOperand, String operation, double result) {

    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/CALCULATOR_ASSIGNMENT", "root", "root");
      String query = " insert into CALCULATOR_DETAILS (left_operand,right_operand,operation,result)"
          + " values (?, ?, ?, ?)";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString(1, Double.toString(leftOperand));
      preparedStmt.setString(2, Double.toString(rightOperand));
      preparedStmt.setString(3, operation);
      preparedStmt.setString(4, Double.toString(result));
      preparedStmt.execute();
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }

  }

  void write_dataAbsolute(double leftOperand, String operation, double result) {

    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/CALCULATOR_ASSIGNMENT", "root", "root");
      String query = " insert into CALCULATOR_DETAILS (left_operand,operation,result)"
          + " values (?, ?, ?)";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString(1, Double.toString(leftOperand));
      preparedStmt.setString(2, operation);
      preparedStmt.setString(3, Double.toString(result));
      preparedStmt.execute();
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }

  }
}
