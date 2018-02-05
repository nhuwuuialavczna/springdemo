package com.chamcode.dao.impl;

import com.chamcode.dao.ChuongDAO;
import com.chamcode.model.Chuong;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ChuongDAOImpl implements ChuongDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Chuong> getAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM Chuong").list();
    }

    @Override
    public Chuong getChuong(int chuong) {
        List<Chuong> list = sessionFactory.getCurrentSession().createQuery("FROM Chuong where chuong=" + chuong).list();
        return !list.isEmpty() ? list.get(0) : null;
    }
}
