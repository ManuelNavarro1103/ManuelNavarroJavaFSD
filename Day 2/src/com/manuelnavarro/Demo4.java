package com.manuelnavarro;

class Employee{
    public int empId;
    public String name;
    public static String companyName = "McDonalds";

    public Employee(int empId, String name){
        this.empId = empId;
        this.name = name;
    }

    public void printInfo(){
        System.out.println("\nId: "+ empId+ "\nName: "+ name+ "\nCompany Name: "+ companyName);
    }
}

public class Demo4 {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Manuel");
        Employee emp2 = new Employee(2, "Sara");
        emp1.printInfo();
        emp2.printInfo();
        Employee.companyName = "Testing";
        emp1.printInfo();
        emp2.printInfo();
    }
}
