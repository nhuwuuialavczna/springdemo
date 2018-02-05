package com.chamcode.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TRALOIBINHLUAN", schema = "dbo", catalog = "luyencode")
public class Traloibinhluan {
    private String macautraloi;
    private String cautraloi;
    private String mabinhluan;
    private String username;
    private Binhluan binhluanByMabinhluan;

    @Id
    @Column(name = "macautraloi")
    public String getMacautraloi() {
        return macautraloi;
    }

    public void setMacautraloi(String macautraloi) {
        this.macautraloi = macautraloi;
    }

    @Basic
    @Column(name = "cautraloi")
    public String getCautraloi() {
        return cautraloi;
    }

    public void setCautraloi(String cautraloi) {
        this.cautraloi = cautraloi;
    }

    @Basic
    @Column(name = "mabinhluan")
    public String getMabinhluan() {
        return mabinhluan;
    }

    public void setMabinhluan(String mabinhluan) {
        this.mabinhluan = mabinhluan;
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
        Traloibinhluan that = (Traloibinhluan) o;
        return Objects.equals(macautraloi, that.macautraloi) &&
                Objects.equals(cautraloi, that.cautraloi) &&
                Objects.equals(mabinhluan, that.mabinhluan) &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {

        return Objects.hash(macautraloi, cautraloi, mabinhluan, username);
    }

    @ManyToOne
    @JoinColumn(name = "mabinhluan", referencedColumnName = "mabinhluan", insertable = false, updatable = false)
    public Binhluan getBinhluanByMabinhluan() {
        return binhluanByMabinhluan;
    }

    public void setBinhluanByMabinhluan(Binhluan binhluanByMabinhluan) {
        this.binhluanByMabinhluan = binhluanByMabinhluan;
    }
}
