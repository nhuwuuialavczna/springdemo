package com.chamcode.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CHUONG",schema = "dbo",catalog = "luyencode")
public class Chuong {
    private int chuong;
    private String tenchuong;

    @Id
    @Column(name = "chuong")
    public int getChuong() {
        return chuong;
    }

    public void setChuong(int chuong) {
        this.chuong = chuong;
    }

    @Basic
    @Column(name = "tenchuong")
    public String getTenchuong() {
        return tenchuong;
    }

    public void setTenchuong(String tenchuong) {
        this.tenchuong = tenchuong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chuong chuong1 = (Chuong) o;
        return chuong == chuong1.chuong &&
                Objects.equals(tenchuong, chuong1.tenchuong);
    }

    @Override
    public int hashCode() {

        return Objects.hash(chuong, tenchuong);
    }
}
