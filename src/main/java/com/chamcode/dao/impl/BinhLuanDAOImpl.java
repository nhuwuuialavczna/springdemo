package com.chamcode.dao.impl;

import com.chamcode.dao.BinhLuanDAO;
import com.chamcode.model.Binhluan;
import com.chamcode.model.Traloibinhluan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class BinhLuanDAOImpl implements BinhLuanDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Binhluan> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("From Binhluan ORDER BY thoigian desc ").list();
    }

    @Override
    public void add(Binhluan binhluan) {
        Session session = sessionFactory.getCurrentSession();
        session.save(binhluan);
//        session.beginTransaction().commit();
    }

    @Override
    public void remove(String maBinhLuan) {
        Session session = sessionFactory.getCurrentSession();
        Binhluan binhLuanTheoMa = getBinhLuanTheoMa(maBinhLuan);
        if (binhLuanTheoMa != null) {
            session.delete(binhLuanTheoMa);
            session.beginTransaction().commit();
        }

    }

    @Override
    public Binhluan getBinhLuanTheoMa(String maBinhLuan) {
        Session session = sessionFactory.getCurrentSession();
        List<Binhluan> ds = session.createQuery("From Binhluan where mabinhluan='" + maBinhLuan + "'").list();
        return !ds.isEmpty() ? ds.get(0) : null;
    }

    @Override
    public List<Binhluan> getBinhLuanTheoUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("From Binhluan where username='" + username + "'").list();
    }

    @Override
    public void updateBinhLuan(Binhluan binhluan) {

    }

    @Override
    public List<Traloibinhluan> listTraloibinhluans(String maBinhLuan) {
        return new ArrayList<>(getBinhLuanTheoMa(maBinhLuan).getTraloibinhluansByMabinhluan());
    }


}
