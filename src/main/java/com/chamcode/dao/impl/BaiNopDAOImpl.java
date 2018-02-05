package com.chamcode.dao.impl;

import com.chamcode.dao.BaiNopDAO;
import com.chamcode.model.Bainop;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class BaiNopDAOImpl implements BaiNopDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Bainop> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Bainop").list();
    }

    @Override
    public List<Bainop> getCauGanNhat() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Bainop ORDER BY thoigian desc ");
        return query.list();
    }

    @Override
    public void add(Bainop bainop) {
        Session session = sessionFactory.getCurrentSession();
        session.save(bainop);
//        Transaction transaction = session.getTransaction();
//        try {
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) transaction.rollback();
//        }

    }

    @Override
    public void remove(String maBaiNop) {
        Session session = sessionFactory.getCurrentSession();
        Bainop baiNopTheoMa = getBaiNopTheoMa(maBaiNop);
        if (baiNopTheoMa != null) {
            session.delete(baiNopTheoMa);
            session.beginTransaction().commit();
        }

    }

    @Override
    public Bainop getBaiNopTheoMa(String maBaiNop) {
        Session session = sessionFactory.getCurrentSession();
        List<Bainop> list = session.createQuery("FROM Bainop where mabaicode='" + maBaiNop + "'").list();
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<Bainop> getBaiNopTheoUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        List<Bainop> list = session.createQuery("FROM Bainop where username='" + username + "'").list();
        return list;
    }

    @Override
    public List<Bainop> getBaiNopTheoDiem(int diem) {
        Session session = sessionFactory.getCurrentSession();
        List<Bainop> ds = session.createQuery("FROM Bainop where diem=" + diem).list();
        return ds;
    }

    @Override
    public List<Bainop> getBaiNopTheoThangVaNam(int thang, int nam) {
        List<Bainop> ds = getAll();
        return ds.stream().filter(p -> Integer.parseInt(p.getThoigian().split("-")[1].split("/")[1].trim()) == thang && Integer.parseInt(p.getThoigian().split("-")[1].split("/")[2].trim()) == nam).collect(Collectors.toList());
    }


    @Override
    public void updateBaiNop(Bainop baiNop) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update Bainop set diem=" + baiNop.getDiem() + " ,thoigian='" + baiNop.getThoigian() + "' where mabaicode='" + baiNop.getMabaicode() + "'").executeUpdate();
        session.beginTransaction().commit();
    }
}
