package com.chamcode.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CHEDOHAI",schema = "dbo",catalog = "luyencode")
public class Chedohai {
    private String mamonhoc;
    private String thoigian;
    private String username;
    private Integer soluong;

    @Basic
    @Column(name = "mamonhoc")
    public String getMamonhoc() {
        return mamonhoc;
    }

    public void setMamonhoc(String mamonhoc) {
        this.mamonhoc = mamonhoc;
    }

    @Id
    @Column(name = "thoigian")
    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "soluong")
    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chedohai chedohai = (Chedohai) o;
        return Objects.equals(mamonhoc, chedohai.mamonhoc) &&
                Objects.equals(thoigian, chedohai.thoigian) &&
                Objects.equals(username, chedohai.username) &&
                Objects.equals(soluong, chedohai.soluong);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mamonhoc, thoigian, username, soluong);
    }
}
