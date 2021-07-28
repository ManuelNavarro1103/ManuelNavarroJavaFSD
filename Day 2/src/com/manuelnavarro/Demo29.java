package com.manuelnavarro;

class Company{
    public void test1(){
        System.out.println("test 1");
    }

    private void test2(){
        System.out.println("test 2");
    }

    protected void test3(){
        System.out.println("test 3");
    }

    void test4(){
        System.out.println("test 4");
    }
}

class SubCompany extends Company{
    public void test5(){

    }
}

public class Demo29 {
    public static void main(String[] args) {
        Company company = new Company();
        company.test1();
        //private field
//        company.test2();
        company.test3();
        company.test4();

        SubCompany subCompany = new SubCompany();
        subCompany.test5();
        //accessible in child class
        subCompany.test3();
    }
}
