package com.chamcode.dao.impl;

import com.chamcode.dao.BaiTapCodeDAO;
import com.chamcode.model.Baitapcode;
//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class BaiTapCodeDAOImpl implements BaiTapCodeDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Baitapcode> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROm Baitapcode").list();
    }

    @Override
    public void add(Baitapcode baitapcode) {
        Session session = sessionFactory.getCurrentSession();
        session.save(baitapcode);
        session.beginTransaction().commit();
    }

    @Override
    public void remove(String maBaiTap) {
        Session session = sessionFactory.getCurrentSession();

        Baitapcode baiTapCodeTheoMaBaiTap = getBaiTapCodeTheoMaBaiTap(maBaiTap);
        if (baiTapCodeTheoMaBaiTap != null) {
            session.delete(baiTapCodeTheoMaBaiTap);
            session.beginTransaction().commit();
        }

    }

    @Override
    public Baitapcode getBaiTapCodeTheoMaBaiTap(String maBaiTap) {
        Session session = sessionFactory.getCurrentSession();

        List<Baitapcode> frOm_baitapcode = session.createQuery("FROm Baitapcode where mabaicode='" + maBaiTap + "'").list();
        return !frOm_baitapcode.isEmpty() ? frOm_baitapcode.get(0) : null;
    }

    @Override
    public List<Baitapcode> getBaiTapCodeTheoChuong(String loaiBai) {
        Session session = sessionFactory.getCurrentSession();
        List<Baitapcode> frOm_baitapcode = session.createQuery("FROm Baitapcode where loaibai='" + loaiBai + "'").list();
        return frOm_baitapcode;
    }

    @Override
    public List<Baitapcode> getBaiTapCodeTheoUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        List<Baitapcode> frOm_baitapcode = session.createQuery("FROm Baitapcode where username='" + username + "'").list();
        return frOm_baitapcode;
    }

    @Override
    public List<Baitapcode> getBaiTapCodeTheoCapDo(String capDo) {
        Session session = sessionFactory.getCurrentSession();
        List<Baitapcode> frOm_baitapcode = session.createQuery("FROm Baitapcode where mucdo='" + capDo + "'").list();
        return frOm_baitapcode;
    }

    @Override
    public void updateBaiTapCode(Baitapcode baitapcode) {

    }

    @Override
    public List<Baitapcode> getNew() {
        Session session = sessionFactory.getCurrentSession();
        List<Baitapcode> frOm_baitapcode = session.createQuery("FROm Baitapcode where lamoi=1").list();
        return frOm_baitapcode;
    }
}
