package com.chamcode.service.impl;

import com.chamcode.dao.TraLoiBinhLuanDAO;
import com.chamcode.model.Traloibinhluan;
import com.chamcode.service.TraLoiBinhLuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraLoiBinhLuanServiceImpl implements TraLoiBinhLuanService {

    @Autowired
    TraLoiBinhLuanDAO traLoiBinhLuanDAO;


    @Override
    public List<Traloibinhluan> getAll(String maBinhLuan) {
        return traLoiBinhLuanDAO.getAll(maBinhLuan);
    }

    @Override
    public List<Traloibinhluan> getTheoUsername(String maBinhLuan, String username) {
        return traLoiBinhLuanDAO.getTheoUsername(maBinhLuan, username);
    }

    @Override
    public void add(Traloibinhluan traloibinhluan) {
        traLoiBinhLuanDAO.add(traloibinhluan);
    }

    @Override
    public Traloibinhluan getCauTraloibinhluan(String maCauTraLoi) {
        return traLoiBinhLuanDAO.getCauTraloibinhluan(maCauTraLoi);
    }

    @Override
    public void remove(String maCauTraLoi) {
        traLoiBinhLuanDAO.remove(maCauTraLoi);
    }

    @Override
    public void update(Traloibinhluan traloibinhluan) {
        traLoiBinhLuanDAO.update(traloibinhluan);
    }
}
