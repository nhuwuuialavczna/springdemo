package com.chamcode.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TAIKHOAN", schema = "dbo", catalog = "luyencode")
public class Taikhoan {
    private String username;
    private String password;
    private String ten;
    private Integer diembaitap;
    private Integer diemthuthach;
    private String thoigiangianhap;
    private String thanhtichthuthach;
    private String namsinh;
    private String email;
    private String facebook;
    private String baitapdalam;
    private String thuthachdalam;
    private String gioithieu;
    private Integer level;
    private String loaithuthach;
    private String thamgiathuthach;
    private Integer lamoi;
    private String role;
    private String hinhanh;
    private Collection<Baitapcode> baitapcodesByUsername;
    private Collection<Binhluan> binhluansByUsername;
    private Collection<Thuthach> thuthachesByUsername;

    @Id
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "hinhanh")
    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }


    @Basic
    @Column(name = "ten")
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }


    @Basic
    @Column(name = "diembaitap")
    public Integer getDiembaitap() {
        return diembaitap;
    }

    public void setDiembaitap(Integer diembaitap) {
        this.diembaitap = diembaitap;
    }

    @Basic
    @Column(name = "diemthuthach")
    public Integer getDiemthuthach() {
        return diemthuthach;
    }

    public void setDiemthuthach(Integer diemthuthach) {
        this.diemthuthach = diemthuthach;
    }

    @Basic
    @Column(name = "thoigiangianhap")
    public String getThoigiangianhap() {
        return thoigiangianhap;
    }

    public void setThoigiangianhap(String thoigiangianhap) {
        this.thoigiangianhap = thoigiangianhap;
    }

    @Basic
    @Column(name = "thanhtichthuthach")
    public String getThanhtichthuthach() {
        return thanhtichthuthach;
    }

    public void setThanhtichthuthach(String thanhtichthuthach) {
        this.thanhtichthuthach = thanhtichthuthach;
    }

    @Basic
    @Column(name = "namsinh")
    public String getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "facebook")
    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    @Basic
    @Column(name = "baitapdalam")
    public String getBaitapdalam() {
        return baitapdalam;
    }

    public void setBaitapdalam(String baitapdalam) {
        this.baitapdalam = baitapdalam;
    }

    @Basic
    @Column(name = "thuthachdalam")
    public String getThuthachdalam() {
        return thuthachdalam;
    }

    public void setThuthachdalam(String thuthachdalam) {
        this.thuthachdalam = thuthachdalam;
    }

    @Basic
    @Column(name = "gioithieu")
    public String getGioithieu() {
        return gioithieu;
    }

    public void setGioithieu(String gioithieu) {
        this.gioithieu = gioithieu;
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
    @Column(name = "loaithuthach")
    public String getLoaithuthach() {
        return loaithuthach;
    }

    public void setLoaithuthach(String loaithuthach) {
        this.loaithuthach = loaithuthach;
    }

    @Basic
    @Column(name = "thamgiathuthach")
    public String getThamgiathuthach() {
        return thamgiathuthach;
    }

    public void setThamgiathuthach(String thamgiathuthach) {
        this.thamgiathuthach = thamgiathuthach;
    }

    @Basic
    @Column(name = "lamoi")
    public Integer getLamoi() {
        return lamoi;
    }

    public void setLamoi(Integer lamoi) {
        this.lamoi = lamoi;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taikhoan taikhoan = (Taikhoan) o;
        return Objects.equals(username, taikhoan.username) &&
                Objects.equals(password, taikhoan.password) &&
                Objects.equals(ten, taikhoan.ten) &&
                Objects.equals(diembaitap, taikhoan.diembaitap) &&
                Objects.equals(diemthuthach, taikhoan.diemthuthach) &&
                Objects.equals(thoigiangianhap, taikhoan.thoigiangianhap) &&
                Objects.equals(thanhtichthuthach, taikhoan.thanhtichthuthach) &&
                Objects.equals(namsinh, taikhoan.namsinh) &&
                Objects.equals(email, taikhoan.email) &&
                Objects.equals(facebook, taikhoan.facebook) &&
                Objects.equals(baitapdalam, taikhoan.baitapdalam) &&
                Objects.equals(thuthachdalam, taikhoan.thuthachdalam) &&
                Objects.equals(gioithieu, taikhoan.gioithieu) &&
                Objects.equals(level, taikhoan.level) &&
                Objects.equals(loaithuthach, taikhoan.loaithuthach) &&
                Objects.equals(thamgiathuthach, taikhoan.thamgiathuthach) &&
                Objects.equals(role, taikhoan.role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, password, ten, diembaitap, diemthuthach, thoigiangianhap, thanhtichthuthach, namsinh, email, facebook, baitapdalam, thuthachdalam, gioithieu, level, loaithuthach, thamgiathuthach, role);
    }

    @OneToMany(mappedBy = "taikhoanByUsername")
    public Collection<Baitapcode> getBaitapcodesByUsername() {
        return baitapcodesByUsername;
    }

    public void setBaitapcodesByUsername(Collection<Baitapcode> baitapcodesByUsername) {
        this.baitapcodesByUsername = baitapcodesByUsername;
    }

    @OneToMany(mappedBy = "taikhoanByUsername")
    public Collection<Binhluan> getBinhluansByUsername() {
        return binhluansByUsername;
    }

    public void setBinhluansByUsername(Collection<Binhluan> binhluansByUsername) {
        this.binhluansByUsername = binhluansByUsername;
    }

    @OneToMany(mappedBy = "taikhoanByUsername")
    public Collection<Thuthach> getThuthachesByUsername() {
        return thuthachesByUsername;
    }

    public void setThuthachesByUsername(Collection<Thuthach> thuthachesByUsername) {
        this.thuthachesByUsername = thuthachesByUsername;
    }
}
