package com.chamcode.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BAITAPCODE", schema = "dbo", catalog = "luyencode")
public class Baitapcode {
    private String mabaicode;
    private String tenbaicode;
    private String noidung;
    private String loaibai;
    private String dulieutest;
    private String dulieuoutput;
    private String inputvidu;
    private String outputvidu;
    private String input;
    private String output;
    private Integer lamoi;
    private Integer thoigiangioihan;
    private String vietlaihammain;
    private String interfacedata;
    private String superclass;
    private String generic;
    private String rangbuoc;
    private String tenphuongthuc;
    private String danhsachthamso;
    private String thoigian;
    private String thongtinthem;
    private String mucdo;
    private String kieutrave;
    private String username;
    private Taikhoan taikhoanByUsername;

    @Id
    @Column(name = "mabaicode")
    public String getMabaicode() {
        return mabaicode;
    }

    public void setMabaicode(String mabaicode) {
        this.mabaicode = mabaicode;
    }

    @Basic
    @Column(name = "tenbaicode")
    public String getTenbaicode() {
        return tenbaicode;
    }

    public void setTenbaicode(String tenbaicode) {
        this.tenbaicode = tenbaicode;
    }

    @Basic
    @Column(name = "noidung")
    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    @Basic
    @Column(name = "loaibai")
    public String getLoaibai() {
        return loaibai;
    }

    public void setLoaibai(String loaibai) {
        this.loaibai = loaibai;
    }

    @Basic
    @Column(name = "dulieutest")
    public String getDulieutest() {
        return dulieutest;
    }

    public void setDulieutest(String dulieutest) {
        this.dulieutest = dulieutest;
    }

    @Basic
    @Column(name = "dulieuoutput")
    public String getDulieuoutput() {
        return dulieuoutput;
    }

    public void setDulieuoutput(String dulieuoutput) {
        this.dulieuoutput = dulieuoutput;
    }


    @Basic
    @Column(name = "input")
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Basic
    @Column(name = "output")
    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }


    @Basic
    @Column(name = "inputvidu")
    public String getInputvidu() {
        return inputvidu;
    }

    public void setInputvidu(String inputvidu) {
        this.inputvidu = inputvidu;
    }

    @Basic
    @Column(name = "outputvidu")
    public String getOutputvidu() {
        return outputvidu;
    }

    public void setOutputvidu(String outputvidu) {
        this.outputvidu = outputvidu;
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
    @Column(name = "thoigiangioihan")
    public Integer getThoigiangioihan() {
        return thoigiangioihan;
    }

    public void setThoigiangioihan(Integer thoigiangioihan) {
        this.thoigiangioihan = thoigiangioihan;
    }

    @Basic
    @Column(name = "vietlaihammain")
    public String getVietlaihammain() {
        return vietlaihammain;
    }

    public void setVietlaihammain(String vietlaihammain) {
        this.vietlaihammain = vietlaihammain;
    }

    @Basic
    @Column(name = "interface")
    public String getInterfacedata() {
        return interfacedata;
    }

    public void setInterfacedata(String interfacedata) {
        this.interfacedata = interfacedata;
    }

    @Basic
    @Column(name = "superclass")
    public String getSuperclass() {
        return superclass;
    }

    public void setSuperclass(String superclass) {
        this.superclass = superclass;
    }

    @Basic
    @Column(name = "generic")
    public String getGeneric() {
        return generic;
    }

    public void setGeneric(String generic) {
        this.generic = generic;
    }

    @Basic
    @Column(name = "rangbuoc")
    public String getRangbuoc() {
        return rangbuoc;
    }

    public void setRangbuoc(String rangbuoc) {
        this.rangbuoc = rangbuoc;
    }

    @Basic
    @Column(name = "tenphuongthuc")
    public String getTenphuongthuc() {
        return tenphuongthuc;
    }

    public void setTenphuongthuc(String tenphuongthuc) {
        this.tenphuongthuc = tenphuongthuc;
    }

    @Basic
    @Column(name = "danhsachthamso")
    public String getDanhsachthamso() {
        return danhsachthamso;
    }

    public void setDanhsachthamso(String danhsachthamso) {
        this.danhsachthamso = danhsachthamso;
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
    @Column(name = "thongtinthem")
    public String getThongtinthem() {
        return thongtinthem;
    }

    public void setThongtinthem(String thongtinthem) {
        this.thongtinthem = thongtinthem;
    }

    @Basic
    @Column(name = "mucdo")
    public String getMucdo() {
        return mucdo;
    }

    public void setMucdo(String mucdo) {
        this.mucdo = mucdo;
    }

    @Basic
    @Column(name = "kieutrave")
    public String getKieutrave() {
        return kieutrave;
    }

    public void setKieutrave(String kieutrave) {
        this.kieutrave = kieutrave;
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
        Baitapcode that = (Baitapcode) o;
        return Objects.equals(mabaicode, that.mabaicode) &&
                Objects.equals(tenbaicode, that.tenbaicode) &&
                Objects.equals(noidung, that.noidung) &&
                Objects.equals(loaibai, that.loaibai) &&
                Objects.equals(dulieutest, that.dulieutest) &&
                Objects.equals(dulieuoutput, that.dulieuoutput) &&
                Objects.equals(inputvidu, that.inputvidu) &&
                Objects.equals(outputvidu, that.outputvidu) &&
                Objects.equals(thoigiangioihan, that.thoigiangioihan) &&
                Objects.equals(vietlaihammain, that.vietlaihammain) &&
                Objects.equals(interfacedata, that.interfacedata) &&
                Objects.equals(superclass, that.superclass) &&
                Objects.equals(generic, that.generic) &&
                Objects.equals(rangbuoc, that.rangbuoc) &&
                Objects.equals(tenphuongthuc, that.tenphuongthuc) &&
                Objects.equals(danhsachthamso, that.danhsachthamso) &&
                Objects.equals(thoigian, that.thoigian) &&
                Objects.equals(thongtinthem, that.thongtinthem) &&
                Objects.equals(mucdo, that.mucdo) &&
                Objects.equals(kieutrave, that.kieutrave) &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mabaicode, tenbaicode, noidung, loaibai, dulieutest, dulieuoutput, inputvidu, outputvidu, thoigiangioihan, vietlaihammain, interfacedata, superclass, generic, rangbuoc, tenphuongthuc, danhsachthamso, thoigian, thongtinthem, mucdo, kieutrave, username);
    }

    public String toString() {
        return mabaicode + "`" + tenbaicode + "`" + noidung + "`" + input + "`" + output + "`" + inputvidu + "`" + outputvidu + "`" + username;
    }

    public String theoChuong() {
        return mabaicode + "`" + tenbaicode;
    }

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    public Taikhoan getTaikhoanByUsername() {
        return taikhoanByUsername;
    }

    public void setTaikhoanByUsername(Taikhoan taikhoanByUsername) {
        this.taikhoanByUsername = taikhoanByUsername;
    }
}
