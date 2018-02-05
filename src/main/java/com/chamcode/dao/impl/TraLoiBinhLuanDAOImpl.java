package com.chamcode.dao.impl;

import com.chamcode.dao.TraLoiBinhLuanDAO;
import com.chamcode.model.Traloibinhluan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class TraLoiBinhLuanDAOImpl implements TraLoiBinhLuanDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Traloibinhluan> getAll(String maBinhLuan) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("From Traloibinhluan where mabinhluan='" + maBinhLuan + "'").list();
    }

    @Override
    public List<Traloibinhluan> getTheoUsername(String maBinhLuan, String username) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("From Traloibinhluan where mabinhluan='" + maBinhLuan + "' and username='" + username + "'").list();
    }

    @Override
    public void add(Traloibinhluan traloibinhluan) {
        Session session = sessionFactory.getCurrentSession();
        session.save(traloibinhluan);
        session.beginTransaction().commit();
    }

    @Override
    public Traloibinhluan getCauTraloibinhluan(String maCauTraLoi) {
        Session session = sessionFactory.getCurrentSession();
        List<Traloibinhluan> list = session.createQuery("From Traloibinhluan where macautraloi='" + maCauTraLoi + "'").list();
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public void remove(String maCauTraLoi) {
        Session session = sessionFactory.getCurrentSession();
        Traloibinhluan cauTraloibinhluan = getCauTraloibinhluan(maCauTraLoi);
        if (cauTraloibinhluan != null) {
            session.delete(cauTraloibinhluan);
            session.beginTransaction().commit();
        }

    }

    @Override
    public void update(Traloibinhluan traloibinhluan) {
        Session session = sessionFactory.getCurrentSession();

    }
}
