package com.chamcode.service.impl;

import com.chamcode.dao.TaiKhoanDAO;
import com.chamcode.model.Baitapcode;
import com.chamcode.model.Binhluan;
import com.chamcode.model.Taikhoan;
import com.chamcode.model.Thuthach;
import com.chamcode.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {

    @Autowired
    TaiKhoanDAO taiKhoanDAO;


    @Override
    public List<Taikhoan> getAll() {
        return taiKhoanDAO.getAll();
    }

    @Override
    public List<Taikhoan> getTheoLevel(int level) {
        return taiKhoanDAO.getTheoLevel(level);
    }

    @Override
    public List<Taikhoan> getTheoMaBaiCodeDaLam(String maBaiCode) {
        return taiKhoanDAO.getTheoMaBaiCodeDaLam(maBaiCode);
    }

    @Override
    public List<Taikhoan> getTheoMaBaiThuThachDaLam(String maBaiThuThach) {
        return taiKhoanDAO.getTheoMaBaiThuThachDaLam(maBaiThuThach);
    }

    @Override
    public void add(Taikhoan taikhoan) {
        taiKhoanDAO.add(taikhoan);
    }

    @Override
    public void remove(String username) {
        taiKhoanDAO.remove(username);
    }

    @Override
    public Taikhoan getTaiKhoanTheoUsername(String username) {
        return taiKhoanDAO.getTaiKhoanTheoUsername(username);
    }

    @Override
    public Taikhoan getTaiKhoanTheoUsernameVaPass(String username, String password) {
        return taiKhoanDAO.getTaiKhoanTheoUsernameVaPass(username, password);
    }

    @Override
    public void capNhatDiemBaiTap(int diemBaiTap, String username) {
        taiKhoanDAO.capNhatDiemBaiTap(diemBaiTap, username);
    }

    @Override
    public void capNhatDiemThuThach(int diemThuThach, String username) {
        taiKhoanDAO.capNhatDiemThuThach(diemThuThach, username);
    }

    @Override
    public void congDiemKhiLamBaiTap(int diemBaiTap, Taikhoan taikhoan) {
        taiKhoanDAO.congDiemKhiLamBaiTap(diemBaiTap, taikhoan);
    }

    @Override
    public void congDiemKhiLamThuThach(int diemThuThach, Taikhoan taikhoan) {
        taiKhoanDAO.congDiemKhiLamThuThach(diemThuThach, taikhoan);
    }

    @Override
    public void capNhatLevel(String username) {
        taiKhoanDAO.capNhatLevel(username);
    }

    @Override
    public void capNhatThanhTichTHuTHach(String thanhTich, String username) {
        taiKhoanDAO.capNhatThanhTichTHuTHach(thanhTich, username);
    }

    @Override
    public void capNhatQuyenThamGiaTHuThach(String thamGia, String username) {
        taiKhoanDAO.capNhatQuyenThamGiaTHuThach(thamGia, username);
    }

    @Override
    public void capNhatLoaiThuThach(String thuThachNew, String username) {
        taiKhoanDAO.capNhatLoaiThuThach(thuThachNew, username);
    }

    @Override
    public void xoaBoToanBoBaiCodeDaLam(String username) {
        taiKhoanDAO.xoaBoToanBoBaiCodeDaLam(username);
    }

    @Override
    public void xoaBoToanBoThuThachDaLam(String username) {
        taiKhoanDAO.xoaBoToanBoThuThachDaLam(username);
    }

    @Override
    public void chinhSuaThongTinCaNhan(String username, String ten, String namSinh, String email, String fb, String gioiThieu) {
        taiKhoanDAO.chinhSuaThongTinCaNhan(username, ten, namSinh, email, fb, gioiThieu);
    }

    @Override
    public void changPass(String username, String password) {
        taiKhoanDAO.changPass(username, password);
    }

    @Override
    public void updateTaiKhoan(Taikhoan taikhoan) {
        taiKhoanDAO.updateTaiKhoan(taikhoan);
    }

    @Override
    public List<Thuthach> listThuThach(String username) {
        return taiKhoanDAO.listThuThach(username);
    }

    @Override
    public List<Baitapcode> listBaiTapCode(String username) {
        return taiKhoanDAO.listBaiTapCode(username);
    }

    @Override
    public List<Binhluan> listBinhLuan(String username) {
        return taiKhoanDAO.listBinhLuan(username);
    }

    @Override
    public List<String> danhSachMaBaiCode(String username) {
        return taiKhoanDAO.danhSachMaBaiCode(username);
    }

    @Override
    public List<String> danhSachMaTHuThach(String username) {
        return taiKhoanDAO.danhSachMaTHuThach(username);
    }
}
