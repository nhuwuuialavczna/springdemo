package com.chamcode.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "MONTHUTHACH", schema = "dbo", catalog = "luyencode")
public class Monthuthach {
    private String mamonhoc;
    private String tenmonhoc;
    private Integer lamoi;
    private Collection<Thuthach> thuthachesByMamonhoc;

    @Id
    @Column(name = "mamonhoc")
    public String getMamonhoc() {
        return mamonhoc;
    }

    public void setMamonhoc(String mamonhoc) {
        this.mamonhoc = mamonhoc;
    }

    @Basic
    @Column(name = "tenmonhoc")
    public String getTenmonhoc() {
        return tenmonhoc;
    }

    public void setTenmonhoc(String tenmonhoc) {
        this.tenmonhoc = tenmonhoc;
    }

    @Basic
    @Column(name = "lamoi")
    public Integer getLamoi() {
        return lamoi;
    }

    public void setLamoi(Integer lamoi) {
        this.lamoi = lamoi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monthuthach that = (Monthuthach) o;
        return Objects.equals(mamonhoc, that.mamonhoc) &&
                Objects.equals(tenmonhoc, that.tenmonhoc);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mamonhoc, tenmonhoc);
    }

    @OneToMany(mappedBy = "monthuthachByMamonhoc")
    public Collection<Thuthach> getThuthachesByMamonhoc() {
        return thuthachesByMamonhoc;
    }

    public void setThuthachesByMamonhoc(Collection<Thuthach> thuthachesByMamonhoc) {
        this.thuthachesByMamonhoc = thuthachesByMamonhoc;
    }
}
