package com.hibernate.pojo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Employee {
    private int eno;
    private String ename;
    private Set<Project> projects=new HashSet<>();

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public int getEno() {
        return eno;
    }

    public void setEno(int eno) {
        this.eno = eno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return eno == employee.eno &&
                Objects.equals(ename, employee.ename);
    }

    @Override
    public int hashCode() {

        return Objects.hash(eno, ename);
    }
}
