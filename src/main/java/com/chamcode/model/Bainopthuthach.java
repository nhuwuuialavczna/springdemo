package com.chamcode.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(BainopthuthachPK.class)
@Table(name = "BAINOPTHUTHACH",schema = "dbo",catalog = "luyencode")
public class Bainopthuthach {
    private String macauhoi;
    private String username;
    private Integer soluong;
    private String thoigian;

    @Basic
    @Column(name = "macauhoi")
    public String getMacauhoi() {
        return macauhoi;
    }

    public void setMacauhoi(String macauhoi) {
        this.macauhoi = macauhoi;
    }

    @Id
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

    @Id
    @Column(name = "thoigian")
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
        Bainopthuthach that = (Bainopthuthach) o;
        return Objects.equals(macauhoi, that.macauhoi) &&
                Objects.equals(username, that.username) &&
                Objects.equals(soluong, that.soluong) &&
                Objects.equals(thoigian, that.thoigian);
    }

    @Override
    public int hashCode() {

        return Objects.hash(macauhoi, username, soluong, thoigian);
    }
}
