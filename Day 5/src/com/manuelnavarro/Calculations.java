package com.manuelnavarro;

public class Calculations {

    public void Add(double one, double two) {
        double result = (one+two);
        System.out.println("\nThe numbers added was: "+result);
    }

    public void Subtract(double one, double two) {
        double result = (one-two);
        System.out.println("\nThe numbers subtracted was: "+result);
    }

    public void Multiply(double one, double two) {
        double result = (one*two);
        System.out.println("\nThe numbers multiplied was: "+result);
    }

    public void Divide(double one, double two) {
        if (two == 0) {
            System.out.println("Can't divide by 0.");
        }
        else {
            double result = (one/two);
            System.out.println("\nThe numbers divided was: "+result);
        }
    }
}
