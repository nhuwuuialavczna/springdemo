package com.chamcode.service.impl;

import com.chamcode.dao.BinhLuanDAO;
import com.chamcode.model.Binhluan;
import com.chamcode.model.Traloibinhluan;
import com.chamcode.service.BinhLuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BinhLuanServiceImpl implements BinhLuanService {

    @Autowired
    BinhLuanDAO binhLuanDAO;


    @Override
    public List<Binhluan> getAll() {
        return binhLuanDAO.getAll();
    }

    @Override
    public void add(Binhluan binhluan) {
        binhLuanDAO.add(binhluan);
    }

    @Override
    public void remove(String maBinhLuan) {
        binhLuanDAO.remove(maBinhLuan);
    }

    @Override
    public Binhluan getBinhLuanTheoMa(String maBinhLuan) {
        return binhLuanDAO.getBinhLuanTheoMa(maBinhLuan);
    }

    @Override
    public List<Binhluan> getBinhLuanTheoUsername(String username) {
        return binhLuanDAO.getBinhLuanTheoUsername(username);
    }

    @Override
    public void updateBinhLuan(Binhluan binhluan) {

    }

    @Override
    public List<Traloibinhluan> listTraloibinhluans(String maBinhLuan) {
        return binhLuanDAO.listTraloibinhluans(maBinhLuan);
    }
}
