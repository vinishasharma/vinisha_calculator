package com.calc;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.Statement;

import java.util.Scanner;

/**
 * Calculator class.
 * used for providing an interface.
 * to use calculator.
 */

public class Calculator {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    Operations op = new Operations();
    double result = 0;
    double leftOperand = 0;
    double rightOperand = 0;
    int operatorChoice;
    char choice = 'y';
    while ((choice == 'y') || (choice == 'Y')) {

      System.out.println("enter calculator operation to be performed from following menu: ");
      System.out.println("1:Addition");
      System.out.println("2:Subtraction");
      System.out.println("3:Multiplication");
      System.out.println("4:Division");
      System.out.println("5:Power");
      System.out.println("6:Modulus");
      System.out.println("7:Maximum of two numbers");
      System.out.println("8:Minimum of two numbers");
      System.out.println("9:Absolute of a number");
      System.out.println("DATABASE OPERATIONS: ");
      System.out.println("10.Read operation from table ");
      System.out.println("11.Read all operation of specific order from table  ");
      operatorChoice = input.nextInt();
      switch (operatorChoice) {
        case 1:
          try {
            System.out.println("Enter left operand: ");
            if (!input.hasNextDouble()) {
              System.out.println("try again entering a number");
            } else {
              leftOperand = input.nextDouble();
            }
            System.out.println("Enter right operand: ");
            rightOperand = input.nextDouble();
            result = op.addition(leftOperand, rightOperand);
            System.out.println("SUM IS:" + result);
          } catch (Exception e) {
            System.out.println("value entered should be numeric");
          }
          op.write_data(leftOperand, rightOperand, "Addition", result);
          break;

        case 2:
          try {
            System.out.println("Enter left operand: ");
            leftOperand = input.nextDouble();
            System.out.println("Enter right operand: ");
            rightOperand = input.nextDouble();
            result = op.subtraction(leftOperand, rightOperand);
            System.out.println("DIFFERENCE IS:" + result);
          } catch (Exception e) {
            System.out.println("value entered should be numeric");
          }
          op.write_data(leftOperand, rightOperand, "Subtraction", result);
          break;
        case 3:
          try {
            System.out.println("Enter left operand: ");
            leftOperand = input.nextDouble();
            System.out.println("Enter right operand: ");
            rightOperand = input.nextDouble();
            result = op.multiplication(leftOperand, rightOperand);
            System.out.println("PRODUCT IS:" + result);
          } catch (Exception e) {
            System.out.println("value entered should be numeric");
          }
          op.write_data(leftOperand, rightOperand, "Multiplication", result);
          break;
        case 4:
          try {
            System.out.println("Enter left operand: ");
            leftOperand = input.nextDouble();
            System.out.println("Enter right operand: ");
            rightOperand = input.nextDouble();
            result = op.division(leftOperand, rightOperand);
            System.out.println("QUOTIENT IS:" + result);
          } catch (Exception e) {
            System.out.println("value entered should be numeric");
          }
          op.write_data(leftOperand, rightOperand, "Division", result);
          break;
        case 5:
          try {
            System.out.println("Enter left operand: ");
            leftOperand = input.nextDouble();
            System.out.println("Enter right operand: ");
            rightOperand = input.nextDouble();
            result = op.power(leftOperand, rightOperand);
            System.out.println(leftOperand + " raised to the power " + rightOperand + ":" + result);
          } catch (Exception e) {
            System.out.println("value entered should be numeric");
          }
          op.write_data(leftOperand, rightOperand, "Power", result);
          break;
        case 6:
          try {
            System.out.println("Enter left operand: ");
            leftOperand = input.nextDouble();
            System.out.println("Enter right operand: ");
            rightOperand = input.nextDouble();
            result = op.modulus(leftOperand, rightOperand);
            System.out.println("REMAINDER IS:" + result);
          } catch (Exception e) {
            System.out.println("value entered should be numeric");
          }
          op.write_data(leftOperand, rightOperand, "Modulus", result);
          break;
        case 7:
          try {
            System.out.println("Enter left operand: ");
            leftOperand = input.nextDouble();
            System.out.println("Enter right operand: ");
            rightOperand = input.nextDouble();
            result = op.maximum(leftOperand, rightOperand);
            System.out.println("MAXIMUM NUMBER IS:" + result);
          } catch (Exception e) {
            System.out.println("value entered should be numeric");
          }
          op.write_data(leftOperand, rightOperand, "Maximum", result);
          break;
        case 8:
          try {
            System.out.println("Enter left operand: ");
            leftOperand = input.nextDouble();
            System.out.println("Enter right operand: ");
            rightOperand = input.nextDouble();
            result = op.minimum(leftOperand, rightOperand);
            System.out.println("MINIMUM NUMBER IS:" + result);
          } catch (Exception e) {
            System.out.println("value entered should be numeric");
          }
          op.write_data(leftOperand, rightOperand, "Minimum", result);
          break;
        case 9:
          try {
            System.out.println("Enter operand for absolute value: ");
            leftOperand = input.nextDouble();
            System.out.println("Right operand not applicable for absolute function.. ");
            result = op.absolute(leftOperand);
            System.out.println("ABSOLUTE VALUE IS:" + result);
          } catch (Exception e) {
            System.out.println("value entered should be numeric");
          }
          op.write_dataAbsolute(leftOperand, "Absolute", result);
          break;
        case 10:
          try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/CALCULATOR_ASSIGNMENT", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from CALCULATOR_DETAILS");
            while (rs.next()) {
              System.out.println(rs.getInt(1) + "  " + rs.getTimestamp(2)
                  + "  " + rs.getString(3) + "  " + rs.getString(4)
                  + "  " + rs.getString(5) + "  " + rs.getString(6));
            }
            con.close();
          } catch (Exception e) {
            System.out.println(e);
          }
          break;
        case 11:
          System.out.println("Enter your operation choice to view data from table");
          System.out.println("Enter the number of the particular Operation you want to read:");
          System.out.println("1.Addition,2. Subtraction,3. Multiplication,4. Division,5. Power");
          System.out.println("6.Modulus,7. Maximum,8. Minimum,9. Absolute");
          int readChoice = input.nextInt();
          String operChoice = "";
          switch (readChoice) {
            case 1:
              operChoice = "Addition";
              break;
            case 2:
              operChoice = "Subtraction";
              break;
            case 3:
              operChoice = "Multiplication";
              break;
            case 4:
              operChoice = "Division";
              break;
            case 5:
              operChoice = "Power";
              break;
            case 6:
              operChoice = "Modulus";
              break;
            case 7:
              operChoice = "Maximum";
              break;
            case 8:
              operChoice = "Minimum";
              break;
            case 9:
              operChoice = "Absolute";
              break;
            default:
              System.out.println("wrong choice entered..please choose from above menu");

          }
          try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/CALCULATOR_ASSIGNMENT", "root", "root");
            PreparedStatement statement = con.prepareStatement("select * from CALCULATOR_DETAILS "
                + "where operation =?");
            statement.setString(1, operChoice);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
              System.out.println(rs.getInt(1)
                  + "  " + rs.getTimestamp(2)
                  + "  " + rs.getString(3) + "  " + rs.getString(4)
                  + "  " + rs.getString(5) + "  " + rs.getString(6));
            }
            con.close();
          } catch (Exception e) {
            System.out.println(e);
          }
          break;
        default:
          System.out.println("Wrong operation choice");
      }

      System.out.println("Press Y/y to view the menu else press n/N ");
      choice = input.next().charAt(0);
    }

  }
}
