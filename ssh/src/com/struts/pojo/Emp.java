package com.struts.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Emp {
    private long id;
    private String name;
    private Dept deptById;
    private Dept deptByDept;

    @Id
    @Column(name = "ID", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return id == emp.id &&
                Objects.equals(name, emp.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @OneToOne
    @JoinColumn(name = "ID", referencedColumnName = "ID", nullable = false)
    public Dept getDeptById() {
        return deptById;
    }

    public void setDeptById(Dept deptById) {
        this.deptById = deptById;
    }

    @ManyToOne
    @JoinColumn(name = "DEPT", referencedColumnName = "ID")
    public Dept getDeptByDept() {
        return deptByDept;
    }

    public void setDeptByDept(Dept deptByDept) {
        this.deptByDept = deptByDept;
    }
}
