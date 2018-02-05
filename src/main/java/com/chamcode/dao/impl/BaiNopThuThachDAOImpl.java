package com.chamcode.dao.impl;

import com.chamcode.dao.BaiNopThuThachDAO;
import com.chamcode.model.Bainopthuthach;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Transactional
@Repository
public class BaiNopThuThachDAOImpl implements BaiNopThuThachDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Bainopthuthach> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("From Bainopthuthach").list();
    }

    @Override
    public void add(Bainopthuthach bainopthuthach) {
        Session session = sessionFactory.getCurrentSession();
        session.save(bainopthuthach);
        session.beginTransaction().commit();
    }

    @Override
    public void remove(String maBaiNop) {
        Session session = sessionFactory.getCurrentSession();
        Bainopthuthach baiNopTheoMa = getBaiNopTheoMa(maBaiNop);
        if (baiNopTheoMa != null) {
            session.delete(baiNopTheoMa);
            session.beginTransaction().commit();
        }

    }

    @Override
    public Bainopthuthach getBaiNopTheoMa(String maBaiNopThuThach) {
        Session session = sessionFactory.getCurrentSession();
        List<Bainopthuthach> list = session.createQuery("From Bainopthuthach where macauhoi='" + maBaiNopThuThach + "'").list();
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<Bainopthuthach> getBaiNopTheoUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        List<Bainopthuthach> ds = session.createQuery("From Bainopthuthach where username='" + username + "'").list();
        return ds;
    }

    @Override
    public List<Bainopthuthach> getBaiNopTheoThangVaNam(int thang, int nam) {
        Session session = sessionFactory.getCurrentSession();
        List<Bainopthuthach> ds = getAll();
        return ds.stream().filter(p -> Integer.parseInt(p.getThoigian().split("-")[1].split("/")[1].trim()) == thang && Integer.parseInt(p.getThoigian().split("-")[1].split("/")[2].trim()) == nam).collect(Collectors.toList());
    }

    @Override
    public void updateBaiNop(Bainopthuthach bainopthuthach) {

    }
}
