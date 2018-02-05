package com.chamcode.service.impl;

import com.chamcode.dao.BaiNopDAO;
import com.chamcode.model.Bainop;
import com.chamcode.service.BaiNopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaiNopServiceImpl implements BaiNopService {
    @Autowired
    BaiNopDAO baiNopDAO;


    @Override
    public List<Bainop> getAll() {
        return baiNopDAO.getAll();
    }

    @Override
    public List<Bainop> get10CauGanNhat() {
        return baiNopDAO.getCauGanNhat();
    }

    @Override
    public void add(Bainop bainop) {
        baiNopDAO.add(bainop);
    }

    @Override
    public void remove(String maBaiNop) {
        baiNopDAO.remove(maBaiNop);
    }

    @Override
    public Bainop getBaiNopTheoMa(String maBaiNop) {
        return baiNopDAO.getBaiNopTheoMa(maBaiNop);
    }

    @Override
    public List<Bainop> getBaiNopTheoUsername(String username) {
        return baiNopDAO.getBaiNopTheoUsername(username);
    }

    @Override
    public List<Bainop> getBaiNopTheoDiem(int diem) {
        return baiNopDAO.getBaiNopTheoDiem(diem);
    }

    @Override
    public List<Bainop> getBaiNopTheoThangVaNam(int thang, int nam) {
        return baiNopDAO.getBaiNopTheoThangVaNam(thang, nam);
    }

    @Override
    public void updateBaiNop(Bainop baiNop) {

    }
}
