package com.chamcode.service.impl;

import com.chamcode.dao.ThuThachDAO;
import com.chamcode.model.Taikhoan;
import com.chamcode.model.Thuthach;
import com.chamcode.service.ThuThachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThuThachServiceImpl implements ThuThachService {
    @Autowired
    ThuThachDAO thuThachDAO;


    @Override
    public List<Thuthach> getAll() {
        return thuThachDAO.getAll();
    }

    @Override
    public List<Thuthach> getThuThachTheoLevel(int level) {
        return thuThachDAO.getThuThachTheoLevel(level);
    }

    @Override
    public List<Thuthach> getThuThachTheoMaMon(String maMonHoc) {
        return thuThachDAO.getThuThachTheoMaMon(maMonHoc);
    }

    @Override
    public List<Thuthach> getThuThachTheoLevelVaNgoaiDanhSach(int level, List<String> maThuThach) {
        return thuThachDAO.getThuThachTheoLevelVaNgoaiDanhSach(level, maThuThach);
    }

    @Override
    public List<Thuthach> getThuThachTheoLevelVaNgoaiDanhSachDaLam(int level, Taikhoan taikhoan) {
        return thuThachDAO.getThuThachTheoLevelVaNgoaiDanhSachDaLam(level, taikhoan);
    }

    @Override
    public Thuthach getThuThachKeTiepChoNguoiDung(Taikhoan taikhoan, String maMonHoc) {
        return thuThachDAO.getThuThachKeTiepChoNguoiDung(taikhoan, maMonHoc);
    }

    @Override
    public void add(Thuthach thuthach) {
        thuThachDAO.add(thuthach);
    }

    @Override
    public void remove(String maThuThach) {
        thuThachDAO.remove(maThuThach);
    }

    @Override
    public Thuthach getThuThachTheoMaTHuThach(String maThuThach) {
        return thuThachDAO.getThuThachTheoMaTHuThach(maThuThach);
    }

    @Override
    public void updateThuThach(Thuthach thuthach) {
        thuThachDAO.updateThuThach(thuthach);
    }
}
