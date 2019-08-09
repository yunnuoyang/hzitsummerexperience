package com.struts.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Chairman {
    private long id;
    private String name;
    private Long nationId;

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

    @Basic
    @Column(name = "NATION_ID", nullable = true)
    public Long getNationId() {
        return nationId;
    }

    public void setNationId(Long nationId) {
        this.nationId = nationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chairman chairman = (Chairman) o;
        return id == chairman.id &&
                Objects.equals(name, chairman.name) &&
                Objects.equals(nationId, chairman.nationId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, nationId);
    }
}
