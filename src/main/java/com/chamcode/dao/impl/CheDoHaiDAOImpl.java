package com.chamcode.dao.impl;

import com.chamcode.dao.CheDoHaiDAO;
import com.chamcode.model.Chedohai;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CheDoHaiDAOImpl implements CheDoHaiDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Chedohai> getAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM Chedohai").list();
    }

    @Override
    public void add(Chedohai chedohai) {
        sessionFactory.getCurrentSession().save(chedohai);
        sessionFactory.getCurrentSession().beginTransaction().commit();
    }
}
