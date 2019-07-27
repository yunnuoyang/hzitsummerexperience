package com.hibernate.pojo;

import java.sql.Date;
import java.util.Objects;

public class Detail {
    private int accid;
    private String username;
    private Date birthday;
    private String email;
    private Account accountByAccid;

    public int getAccid() {
        return accid;
    }

    public void setAccid(int accid) {
        this.accid = accid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detail detail = (Detail) o;
        return accid == detail.accid &&
                Objects.equals(username, detail.username) &&
                Objects.equals(birthday, detail.birthday) &&
                Objects.equals(email, detail.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(accid, username, birthday, email);
    }

    public Account getAccountByAccid() {
        return accountByAccid;
    }

    public void setAccountByAccid(Account accountByAccid) {
        this.accountByAccid = accountByAccid;
    }
}
