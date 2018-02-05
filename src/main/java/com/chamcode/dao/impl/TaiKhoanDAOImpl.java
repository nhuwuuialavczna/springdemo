package com.chamcode.dao.impl;

import com.chamcode.dao.TaiKhoanDAO;
import com.chamcode.model.Baitapcode;
import com.chamcode.model.Binhluan;
import com.chamcode.model.Taikhoan;
import com.chamcode.model.Thuthach;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class TaiKhoanDAOImpl implements TaiKhoanDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Taikhoan> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("From Taikhoan").list();
    }

    @Override
    public List<Taikhoan> getTheoLevel(int level) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("From Taikhoan where level=" + level).list();
    }

    @Override
    public List<Taikhoan> getTaiKhoanGiamDanTheoDiemBaiTap() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Taikhoan ORDER BY diembaitap desc ");
        return query.list();
    }

    @Override
    public List<Taikhoan> getTaiKhoanGiamDanTheoDiemThuTHach() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Taikhoan ORDER BY diemthuthach desc ");
        return query.list();
    }

    @Override
    public List<Taikhoan> getTheoMaBaiCodeDaLam(String maBaiCode) {
        Session session = sessionFactory.getCurrentSession();
        return getAll().stream().filter(p -> p.getBaitapdalam().indexOf(maBaiCode) >= 0).collect(Collectors.toList());
    }

    @Override
    public List<Taikhoan> getTheoMaBaiThuThachDaLam(String maBaiThuThach) {
        Session session = sessionFactory.getCurrentSession();
        return getAll().stream().filter(p -> p.getThuthachdalam().indexOf(maBaiThuThach) >= 0).collect(Collectors.toList());
    }

    @Override
    public void add(Taikhoan taikhoan) {
        Session session = sessionFactory.getCurrentSession();
        session.save(taikhoan);
        session.beginTransaction().commit();
    }

    @Override
    public void remove(String username) {
        Session session = sessionFactory.getCurrentSession();
        Taikhoan taiKhoanTheoUsername = getTaiKhoanTheoUsername(username);
        if (taiKhoanTheoUsername != null) {
            session.delete(taiKhoanTheoUsername);
            session.beginTransaction().commit();
        }
    }

    @Override
    public Taikhoan getTaiKhoanTheoUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        List<Taikhoan> list = session.createQuery("From Taikhoan where username='" + username + "'").list();
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public Taikhoan getTaiKhoanTheoUsernameVaPass(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        List<Taikhoan> list = session.createQuery("From Taikhoan where username='" + username + "' and password='" + password + "'").list();
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public void capNhatDiemBaiTap(int diemBaiTap, String username) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update Taikhoan set diembaitap=" + diemBaiTap + " where username='" + username + "'").executeUpdate();
//        session.beginTransaction().commit();
    }

    @Override
    public void capNhatDiemThuThach(int diemThuThach, String username) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update Taikhoan set diemthuthach=" + diemThuThach + " where username='" + username + "'").executeUpdate();
//        session.beginTransaction().commit();
    }

    @Override
    public void capNhatThuThachDaLam(String thuThachDaLam, String username) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update Taikhoan set thuthachdalam='" + thuThachDaLam + "' where username='" + username + "'").executeUpdate();
//        session.beginTransaction().commit();
    }

    @Override
    public void capNhatBaiCodeDaLam(String baiCodeDaLam, String username) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update Taikhoan set baitapdalam='" + baiCodeDaLam + "' where username='" + username + "'").executeUpdate();
//        session.beginTransaction().commit();
    }

    @Override
    public void congDiemKhiLamBaiTap(int diemBaiTap, Taikhoan taikhoan) {
        Session session = sessionFactory.getCurrentSession();
        int diemHienTai = taikhoan.getDiembaitap();
        int diemMoi = diemHienTai + diemBaiTap;
        int level = diemMoi / 1000;

        if (level + 1 > taikhoan.getLevel()) {
            capNhatLevel(taikhoan.getUsername());
        }
        capNhatDiemBaiTap(diemMoi, taikhoan.getUsername());

    }

    @Override
    public void congDiemKhiLamThuThach(int diemThuThach, Taikhoan taikhoan) {
        Session session = sessionFactory.getCurrentSession();
        int diemHienTai = taikhoan.getDiemthuthach();
        int diemMoi = diemHienTai + diemThuThach;
        if (diemThuThach >= 200) {
            capNhatLevel(taikhoan.getUsername());
        }
        capNhatDiemThuThach(diemMoi, taikhoan.getUsername());
    }

    @Override
    public void capNhatLevel(String username) {
        Session session = sessionFactory.getCurrentSession();
        int levelHienTai = getTaiKhoanTheoUsername(username.trim()).getLevel();
        session.createQuery("update Taikhoan set level=" + (levelHienTai + 1) + " where username='" + username + "'").executeUpdate();
//        session.beginTransaction().commit();
    }

    @Override
    public void capNhatThanhTichTHuTHach(String thanhTich, String username) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update Taikhoan set thanhtichthuthach='" + thanhTich + "' where username='" + username + "'").executeUpdate();
//        session.beginTransaction().commit();
    }

    @Override
    public void capNhatQuyenThamGiaTHuThach(String thamGia, String username) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update Taikhoan set thamgiathuthach='" + thamGia + "' where username='" + username + "'").executeUpdate();
//        session.beginTransaction().commit();
    }

    @Override
    public void capNhatLoaiThuThach(String thuThachNew, String username) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update Taikhoan set loaithuthach='" + thuThachNew + "' where username='" + username + "'").executeUpdate();
//        session.beginTransaction().commit();
    }

    @Override
    public void xoaBoToanBoBaiCodeDaLam(String username) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update Taikhoan set baitapdalam=null where username='" + username + "'").executeUpdate();
//        session.beginTransaction().commit();
    }

    @Override
    public void xoaBoToanBoThuThachDaLam(String username) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update Taikhoan set thuthachdalam=null where username='" + username + "'").executeUpdate();
//        session.beginTransaction().commit();
    }

    @Override
    public void chinhSuaThongTinCaNhan(String username, String namSinh, String email, String fb, String gioiThieu) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update Taikhoan set hinhanh='" + namSinh + "'," +
                "email='" + email + "'," +
                "facebook='" + fb + "'," +
                "gioithieu='" + gioiThieu + "'" +
                " where username='" + username + "'").executeUpdate();
    }

    @Override
    public void changPass(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update Taikhoan set password='" + password + "' where username='" + username + "'").executeUpdate();
//        session.beginTransaction().commit();
    }

    @Override
    public void updateTaiKhoan(Taikhoan taikhoan) {
        Session session = sessionFactory.getCurrentSession();
        session.update(taikhoan);
    }

    @Override
    public List<Thuthach> listThuThach(String username) {
        return new ArrayList<>(getTaiKhoanTheoUsername(username).getThuthachesByUsername());
    }

    @Override
    public List<Baitapcode> listBaiTapCode(String username) {
        return new ArrayList<>(getTaiKhoanTheoUsername(username).getBaitapcodesByUsername());
    }

    @Override
    public List<Binhluan> listBinhLuan(String username) {
        return new ArrayList<>(getTaiKhoanTheoUsername(username).getBinhluansByUsername());
    }

    @Override
    public List<String> danhSachMaBaiCode(String username) {
        return Arrays.asList(getTaiKhoanTheoUsername(username).getBaitapdalam().split(","));
    }

    @Override
    public List<String> danhSachMaTHuThach(String username) {
        return Arrays.asList(getTaiKhoanTheoUsername(username).getThuthachdalam().split(","));
    }
}
