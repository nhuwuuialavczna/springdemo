package com.chamcode.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class BainopPK implements Serializable {
    private String mabaicode;
    private String thoigian;

    @Column(name = "mabaicode")
    @Id
    public String getMabaicode() {
        return mabaicode;
    }

    public void setMabaicode(String mabaicode) {
        this.mabaicode = mabaicode;
    }

    @Column(name = "thoigian")
    @Id
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
        BainopPK bainopPK = (BainopPK) o;
        return Objects.equals(mabaicode, bainopPK.mabaicode) &&
                Objects.equals(thoigian, bainopPK.thoigian);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mabaicode, thoigian);
    }
}
