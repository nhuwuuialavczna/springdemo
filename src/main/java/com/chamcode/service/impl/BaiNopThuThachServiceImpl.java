package com.chamcode.service.impl;

import com.chamcode.dao.BaiNopThuThachDAO;
import com.chamcode.model.Bainopthuthach;
import com.chamcode.service.BaiNopThuThachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaiNopThuThachServiceImpl implements BaiNopThuThachService {
    @Autowired
    BaiNopThuThachDAO baiNopThuThachDAO;


    @Override
    public List<Bainopthuthach> getAll() {
        return baiNopThuThachDAO.getAll();
    }

    @Override
    public void add(Bainopthuthach bainopthuthach) {
        baiNopThuThachDAO.add(bainopthuthach);
    }

    @Override
    public void remove(String maBaiNop) {
        baiNopThuThachDAO.remove(maBaiNop);
    }

    @Override
    public Bainopthuthach getBaiNopTheoMa(String maBaiNopThuThach) {
        return baiNopThuThachDAO.getBaiNopTheoMa(maBaiNopThuThach);
    }

    @Override
    public List<Bainopthuthach> getBaiNopTheoUsername(String username) {
        return baiNopThuThachDAO.getBaiNopTheoUsername(username);
    }

    @Override
    public List<Bainopthuthach> getBaiNopTheoThangVaNam(int thang, int nam) {
        return baiNopThuThachDAO.getBaiNopTheoThangVaNam(thang, nam);
    }

    @Override
    public void updateBaiNop(Bainopthuthach bainopthuthach) {

    }
}
