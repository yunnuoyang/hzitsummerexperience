package com.a.lamda;

public class Employe {
    private String name;
    private Double salary;

    public Employe(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
