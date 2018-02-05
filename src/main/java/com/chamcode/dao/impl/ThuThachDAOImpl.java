package com.chamcode.dao.impl;

import com.chamcode.dao.ThuThachDAO;
import com.chamcode.model.Taikhoan;
import com.chamcode.model.Thuthach;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class ThuThachDAOImpl implements ThuThachDAO {


    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Thuthach> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("From Thuthach").list();
    }

    @Override
    public List<Thuthach> getThuThachTheoLevel(int level) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("From Thuthach where level=" + level).list();
    }

    @Override
    public List<Thuthach> getThuThachTheoMaMon(String maMonHoc) {
        Session session = sessionFactory.getCurrentSession();
        List<Thuthach> list = session.createQuery("From Thuthach where mamonhoc='" + maMonHoc + "'").list();
        return list;
    }

    @Override
    public List<Thuthach> getThuThachTheoLevelVaNgoaiDanhSach(int level, List<String> maThuThach) {
        Session session = sessionFactory.getCurrentSession();
        return getThuThachTheoLevel(level).stream().filter(p -> !maThuThach.contains(p.getMacauhoi())).collect(Collectors.toList());
    }

    @Override
    public List<Thuthach> getThuThachTheoLevelVaNgoaiDanhSachDaLam(int level, Taikhoan taikhoan) {
        Session session = sessionFactory.getCurrentSession();
        String s = taikhoan.getThuthachdalam();
        List<String> maThuThach = new LinkedList<>();
        if (s == null || s.equals("")) {
            return getThuThachTheoLevel(level);
        } else {
            String[] ds = s.split(",");
            maThuThach.addAll(Arrays.asList(ds));
        }

        return getThuThachTheoLevelVaNgoaiDanhSach(level, maThuThach);
    }

    @Override
    public Thuthach getThuThachKeTiepChoNguoiDung(Taikhoan taikhoan, String maMonHoc) {
        Session session = sessionFactory.getCurrentSession();
        List<Thuthach> list = new ArrayList<>();
        if (maMonHoc == null) {
            int level = taikhoan.getLevel();
            list = getThuThachTheoLevelVaNgoaiDanhSachDaLam(level, taikhoan);
        } else {
            list = list.stream().filter(p -> p.getMamonhoc().equals(maMonHoc)).collect(Collectors.toList());
        }
        return !list.isEmpty() ? list.get(0) : null;

    }

    @Override
    public void add(Thuthach thuthach) {
        Session session = sessionFactory.getCurrentSession();
        session.save(thuthach);
        session.beginTransaction().commit();
    }


    @Override
    public void remove(String maThuThach) {
        Session session = sessionFactory.getCurrentSession();
        Thuthach thuThachTheoMaTHuThach = getThuThachTheoMaTHuThach(maThuThach);
        if (thuThachTheoMaTHuThach != null) {
            session.delete(thuThachTheoMaTHuThach);
            session.beginTransaction().commit();
        }
    }

    @Override
    public Thuthach getThuThachTheoMaTHuThach(String maThuThach) {
        Session session = sessionFactory.getCurrentSession();
        List<Thuthach> list = session.createQuery("From Thuthach where macauhoi='" + maThuThach + "'").list();
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public void updateThuThach(Thuthach thuthach) {

    }


}
