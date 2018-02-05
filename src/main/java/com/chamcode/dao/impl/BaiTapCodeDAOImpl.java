package com.chamcode.dao.impl;

import com.chamcode.dao.BaiTapCodeDAO;
import com.chamcode.model.Baitapcode;
//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BaiTapCodeDAOImpl implements BaiTapCodeDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Baitapcode> getAll() {
        Session session = sessionFactory.openSession();


        return session.createQuery("FROm Baitapcode").list();
    }

    @Override
    public void add(Baitapcode baitapcode) {
        Session session = sessionFactory.openSession();

        session.save(baitapcode);
        session.beginTransaction().commit();
    }

    @Override
    public void remove(String maBaiTap) {
        Session session = sessionFactory.openSession();

        Baitapcode baiTapCodeTheoMaBaiTap = getBaiTapCodeTheoMaBaiTap(maBaiTap);
        if (baiTapCodeTheoMaBaiTap != null) {
            session.delete(baiTapCodeTheoMaBaiTap);
            session.beginTransaction().commit();
        }

    }

    @Override
    public Baitapcode getBaiTapCodeTheoMaBaiTap(String maBaiTap) {
        Session session = sessionFactory.openSession();

        List<Baitapcode> frOm_baitapcode = session.createQuery("FROm Baitapcode where mabaicode='" + maBaiTap + "'").list();
        return frOm_baitapcode != null ? frOm_baitapcode.get(0) : null;
    }

    @Override
    public List<Baitapcode> getBaiTapCodeTheoLoaiBai(String loaiBai) {
        Session session = sessionFactory.openSession();

        List<Baitapcode> frOm_baitapcode = session.createQuery("FROm Baitapcode where loaibai='" + loaiBai + "'").list();
        return frOm_baitapcode;
    }

    @Override
    public List<Baitapcode> getBaiTapCodeTheoUsername(String username) {
        Session session = sessionFactory.openSession();

        List<Baitapcode> frOm_baitapcode = session.createQuery("FROm Baitapcode where username='" + username + "'").list();
        return frOm_baitapcode;
    }

    @Override
    public List<Baitapcode> getBaiTapCodeTheoCapDo(String capDo) {
        Session session = sessionFactory.openSession();

        List<Baitapcode> frOm_baitapcode = session.createQuery("FROm Baitapcode where mucdo='" + capDo + "'").list();
        return frOm_baitapcode;
    }

    @Override
    public void updateBaiTapCode(Baitapcode baitapcode) {

    }
}
