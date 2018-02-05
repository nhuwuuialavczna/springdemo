package com.chamcode.dao.impl;

import com.chamcode.dao.MonThuThachDAO;
import com.chamcode.model.Monthuthach;
import com.chamcode.model.Thuthach;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class MonThuThachDAOImpl implements MonThuThachDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Monthuthach> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("From Monthuthach").list();
    }

    @Override
    public void add(Monthuthach monthuthach) {
        Session session = sessionFactory.getCurrentSession();
        session.save(monthuthach);
        session.beginTransaction().commit();
    }

    @Override
    public void remove(String maMonThuThach) {
        Session session = sessionFactory.getCurrentSession();
        Monthuthach monthuthachTheoMa = getMonthuthachTheoMa(maMonThuThach);
        if (monthuthachTheoMa != null) {
            session.delete(monthuthachTheoMa);
            session.beginTransaction().commit();
        }

    }

    @Override
    public Monthuthach getMonthuthachTheoMa(String maMonThuThach) {
        Session session = sessionFactory.getCurrentSession();
        List<Monthuthach> ds = session.createQuery("From Monthuthach where mamonhoc='" + maMonThuThach + "'").list();
        return !ds.isEmpty() ? ds.get(0) : null;
    }

    @Override
    public void updateMonthuthach(Monthuthach monthuthach) {

    }

    @Override
    public List<Thuthach> listThuThach(String maMonThuThach) {
        Session session = sessionFactory.getCurrentSession();
        return new ArrayList<>(getMonthuthachTheoMa(maMonThuThach).getThuthachesByMamonhoc());
    }


}
