package com.chamcode.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(BainopPK.class)
@Table(name = "BAINOP",schema = "dbo",catalog = "luyencode")
public class Bainop {
    private String mabaicode;
    private String username;
    private Integer diem;
    private String thoigian;

    @Id
    @Column(name = "mabaicode")
    public String getMabaicode() {
        return mabaicode;
    }

    public void setMabaicode(String mabaicode) {
        this.mabaicode = mabaicode;
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
    @Column(name = "diem")
    public Integer getDiem() {
        return diem;
    }

    public void setDiem(Integer diem) {
        this.diem = diem;
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
        Bainop bainop = (Bainop) o;
        return Objects.equals(mabaicode, bainop.mabaicode) &&
                Objects.equals(username, bainop.username) &&
                Objects.equals(diem, bainop.diem) &&
                Objects.equals(thoigian, bainop.thoigian);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mabaicode, username, diem, thoigian);
    }
}
