package com.chamcode.service.impl;

import com.chamcode.dao.MonThuThachDAO;
import com.chamcode.model.Monthuthach;
import com.chamcode.model.Thuthach;
import com.chamcode.service.MonThuThachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonThuThachServiceImpl implements MonThuThachService {

    @Autowired
    MonThuThachDAO monThuThachDAO;


    @Override
    public List<Monthuthach> getAll() {
        return monThuThachDAO.getAll();
    }

    @Override
    public void add(Monthuthach monthuthach) {
        monThuThachDAO.add(monthuthach);
    }

    @Override
    public void remove(String maMonThuThach) {
        monThuThachDAO.remove(maMonThuThach);
    }

    @Override
    public Monthuthach getMonthuthachTheoMa(String maMonThuThach) {
        return monThuThachDAO.getMonthuthachTheoMa(maMonThuThach);
    }

    @Override
    public void updateMonthuthach(Monthuthach monthuthach) {
        monThuThachDAO.updateMonthuthach(monthuthach);
    }

    @Override
    public List<Thuthach> listThuThach(String maMonThuThach) {
        return monThuThachDAO.listThuThach(maMonThuThach);
    }
}
