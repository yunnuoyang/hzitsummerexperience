package com.hibernate.pojo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Project {
    private int pno;
    private String pname;
    private Set<Employee> employees=new HashSet<>();

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return pno == project.pno &&
                Objects.equals(pname, project.pname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pno, pname);
    }
}
