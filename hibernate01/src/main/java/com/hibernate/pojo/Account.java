package com.hibernate.pojo;

import java.util.Collection;
import java.util.Objects;

public class Account {
    private int accid;
    private String accname;
    private String accpass;
    private Detail detailByAccid;

    public int getAccid() {
        return accid;
    }

    public void setAccid(int accid) {
        this.accid = accid;
    }

    public String getAccname() {
        return accname;
    }

    public void setAccname(String accname) {
        this.accname = accname;
    }

    public String getAccpass() {
        return accpass;
    }

    public void setAccpass(String accpass) {
        this.accpass = accpass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accid == account.accid &&
                Objects.equals(accname, account.accname) &&
                Objects.equals(accpass, account.accpass);
    }

    @Override
    public int hashCode() {

        return Objects.hash(accid, accname, accpass);
    }

    public Detail getDetailByAccid() {
        return detailByAccid;
    }

    public void setDetailByAccid(Detail detailByAccid) {
        this.detailByAccid = detailByAccid;
    }

}
