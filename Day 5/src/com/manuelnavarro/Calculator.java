package com.manuelnavarro;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Calculations calculations = new Calculations();

        System.out.println("\n*******************************");
        System.out.println("Welcome to My Calculator App!");
        System.out.println("*******************************");


        boolean keepCalculating = true;
        do {
            double num1 = 0;
            double num2 = 0;
            System.out.println("\nEnter First Number:");
            Scanner firstNum = new Scanner(System.in);
            while (!firstNum.hasNextDouble()){
                System.out.println("\nPlease enter a number:");
                firstNum.next();
            }
            num1 = firstNum.nextDouble();

            System.out.println("\nEnter Second Number:");
            Scanner secondNum = new Scanner(System.in);
            while (!secondNum.hasNextDouble()){
                System.out.println("\nPlease enter a number:");
                secondNum.next();
            }
            num2 = secondNum.nextDouble();

            System.out.println("\nSelect an Option:");
            System.out.println("1 - Add");
            System.out.println("2 - Subtract");
            System.out.println("3 - Multiply");
            System.out.println("4 - Divide");
            Scanner option = new Scanner(System.in);

            while (!option.hasNextInt()) {
                System.out.println("\nPlease enter a number:");
                option.next();
            }

            int optionSelect = option.nextInt();
            while (optionSelect > 4 || optionSelect < 1) {
                System.out.println("\nNot a valid entry please try again.");
                Scanner option1 = new Scanner(System.in);
                optionSelect = option1.nextInt();
            }

            switch (optionSelect) {
            case 1:
                calculations.Add(num1, num2);
                break;
            case 2:
                calculations.Subtract(num1, num2);
                break;
            case 3:
                calculations.Multiply(num1, num2);
                break;
            case 4:
                calculations.Divide(num1, num2);
                break;
            }

            System.out.println("\nWould you like to keep calculating?");
            System.out.println("1 - Keep Calculating");
            System.out.println("2 - Quit");
            Scanner endOption = new Scanner(System.in);

            while (!endOption.hasNextInt()) {
                System.out.println("\nPlease enter a number:");
                endOption.next();
            }

            int endOptionSelect = endOption.nextInt();
            while (endOptionSelect > 2 || endOptionSelect < 1) {
                System.out.println("\nNot a valid entry please try again.");
                Scanner endOption1 = new Scanner(System.in);
                endOptionSelect = endOption1.nextInt();
            }
            switch (endOptionSelect) {
                case 1:
                    break;
                case 2:
                    keepCalculating = false;
                    break;
            }

        } while (keepCalculating == true);

    }
}
