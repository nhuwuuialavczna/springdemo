package com.chamcode.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "THUTHACH",schema = "dbo",catalog = "luyencode")
public class Thuthach {
    private String macauhoi;
    private String cauhoi;
    private String dapanA;
    private String dapanB;
    private String dapanC;
    private String dapanD;
    private String dapAnDung;
    private String mamonhoc;
    private String thoigian;
    private Integer level;
    private String username;
    private Monthuthach monthuthachByMamonhoc;
    private Taikhoan taikhoanByUsername;

    @Id
    @Column(name = "macauhoi")
    public String getMacauhoi() {
        return macauhoi;
    }

    public void setMacauhoi(String macauhoi) {
        this.macauhoi = macauhoi;
    }

    @Basic
    @Column(name = "cauhoi")
    public String getCauhoi() {
        return cauhoi;
    }

    public void setCauhoi(String cauhoi) {
        this.cauhoi = cauhoi;
    }

    @Basic
    @Column(name = "dapanA")
    public String getDapanA() {
        return dapanA;
    }

    public void setDapanA(String dapanA) {
        this.dapanA = dapanA;
    }

    @Basic
    @Column(name = "dapanB")
    public String getDapanB() {
        return dapanB;
    }

    public void setDapanB(String dapanB) {
        this.dapanB = dapanB;
    }

    @Basic
    @Column(name = "dapanC")
    public String getDapanC() {
        return dapanC;
    }

    public void setDapanC(String dapanC) {
        this.dapanC = dapanC;
    }

    @Basic
    @Column(name = "dapanD")
    public String getDapanD() {
        return dapanD;
    }

    public void setDapanD(String dapanD) {
        this.dapanD = dapanD;
    }

    @Basic
    @Column(name = "dapAnDung")
    public String getDapAnDung() {
        return dapAnDung;
    }

    public void setDapAnDung(String dapAnDung) {
        this.dapAnDung = dapAnDung;
    }

    @Basic
    @Column(name = "mamonhoc")
    public String getMamonhoc() {
        return mamonhoc;
    }

    public void setMamonhoc(String mamonhoc) {
        this.mamonhoc = mamonhoc;
    }

    @Basic
    @Column(name = "thoigian")
    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    @Basic
    @Column(name = "level")
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Thuthach thuthach = (Thuthach) o;
        return Objects.equals(macauhoi, thuthach.macauhoi) &&
                Objects.equals(cauhoi, thuthach.cauhoi) &&
                Objects.equals(dapanA, thuthach.dapanA) &&
                Objects.equals(dapanB, thuthach.dapanB) &&
                Objects.equals(dapanC, thuthach.dapanC) &&
                Objects.equals(dapanD, thuthach.dapanD) &&
                Objects.equals(dapAnDung, thuthach.dapAnDung) &&
                Objects.equals(mamonhoc, thuthach.mamonhoc) &&
                Objects.equals(thoigian, thuthach.thoigian) &&
                Objects.equals(level, thuthach.level) &&
                Objects.equals(username, thuthach.username);
    }

    @Override
    public int hashCode() {

        return Objects.hash(macauhoi, cauhoi, dapanA, dapanB, dapanC, dapanD, dapAnDung, mamonhoc, thoigian, level, username);
    }

    @ManyToOne
    @JoinColumn(name = "mamonhoc", referencedColumnName = "mamonhoc",insertable = false,updatable = false)
    public Monthuthach getMonthuthachByMamonhoc() {
        return monthuthachByMamonhoc;
    }

    public void setMonthuthachByMamonhoc(Monthuthach monthuthachByMamonhoc) {
        this.monthuthachByMamonhoc = monthuthachByMamonhoc;
    }

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username",insertable = false,updatable = false)
    public Taikhoan getTaikhoanByUsername() {
        return taikhoanByUsername;
    }

    public void setTaikhoanByUsername(Taikhoan taikhoanByUsername) {
        this.taikhoanByUsername = taikhoanByUsername;
    }
}
