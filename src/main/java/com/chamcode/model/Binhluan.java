package com.chamcode.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "BINHLUAN",schema = "dbo",catalog = "luyencode")
public class Binhluan {
    private String mabinhluan;
    private String username;
    private String binhluan;
    private Taikhoan taikhoanByUsername;
    private Collection<Traloibinhluan> traloibinhluansByMabinhluan;

    @Id
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

    @Basic
    @Column(name = "binhluan")
    public String getBinhluan() {
        return binhluan;
    }

    public void setBinhluan(String binhluan) {
        this.binhluan = binhluan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Binhluan binhluan1 = (Binhluan) o;
        return Objects.equals(mabinhluan, binhluan1.mabinhluan) &&
                Objects.equals(username, binhluan1.username) &&
                Objects.equals(binhluan, binhluan1.binhluan);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mabinhluan, username, binhluan);
    }

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username",insertable = false,updatable = false)
    public Taikhoan getTaikhoanByUsername() {
        return taikhoanByUsername;
    }

    public void setTaikhoanByUsername(Taikhoan taikhoanByUsername) {
        this.taikhoanByUsername = taikhoanByUsername;
    }

    @OneToMany(mappedBy = "binhluanByMabinhluan")
    public Collection<Traloibinhluan> getTraloibinhluansByMabinhluan() {
        return traloibinhluansByMabinhluan;
    }

    public void setTraloibinhluansByMabinhluan(Collection<Traloibinhluan> traloibinhluansByMabinhluan) {
        this.traloibinhluansByMabinhluan = traloibinhluansByMabinhluan;
    }
}
