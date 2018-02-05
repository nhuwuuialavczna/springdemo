package com.chamcode.service.impl;

import com.chamcode.dao.ChuongDAO;
import com.chamcode.model.Chuong;
import com.chamcode.service.ChuongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChuongServiceImpl implements ChuongService {

    @Autowired
    ChuongDAO chuongDAO;

    @Override
    public List<Chuong> getAll() {
        return chuongDAO.getAll();
    }

    @Override
    public Chuong getChuong(int chuong) {
        return chuongDAO.getChuong(chuong);
    }
}
