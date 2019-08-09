package com.disk.intercepter.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Netuser {
    private String username;
    private String password;
    private Integer usertype;
    private String email;

    @Override
    public String toString() {
        return "Netuser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", usertype=" + usertype +
                ", email='" + email + '\'' +
                ", activeCode='" + activeCode + '\'' +
                '}';
    }

    private String activeCode;

    @Id
    @Column(name = "username", nullable = false, length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "usertype", nullable = true)
    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "activeCode", nullable = true, length = 32)
    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Netuser netuser = (Netuser) o;
        return Objects.equals(username, netuser.username) &&
                Objects.equals(password, netuser.password) &&
                Objects.equals(usertype, netuser.usertype) &&
                Objects.equals(email, netuser.email) &&
                Objects.equals(activeCode, netuser.activeCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, password, usertype, email, activeCode);
    }
}
