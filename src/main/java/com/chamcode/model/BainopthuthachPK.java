package com.chamcode.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class BainopthuthachPK implements Serializable {
    private String username;
    private String thoigian;

    @Column(name = "username")
    @Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "thoigian")
    @Id
    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BainopthuthachPK that = (BainopthuthachPK) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(thoigian, that.thoigian);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, thoigian);
    }
}
