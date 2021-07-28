package com.manuelnavarro;

class Student {
    public int rollNumber;
    public String name;
    static public String schoolName = "ABC School";
}

public class Demo1 {

    public static void main(String[] args) {
        Student student = new Student();
        student.rollNumber = 1;
        student.name = "Maanuel";

        Student student1 = new Student();
        student1.rollNumber = 2;
        student1.name = "Sara";
    }
}
