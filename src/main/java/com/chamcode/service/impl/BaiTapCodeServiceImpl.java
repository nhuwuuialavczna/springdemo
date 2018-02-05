package com.chamcode.service.impl;

import com.chamcode.dao.BaiTapCodeDAO;
import com.chamcode.model.Baitapcode;
import com.chamcode.service.BaiTapCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaiTapCodeServiceImpl implements BaiTapCodeService {

    @Autowired
    BaiTapCodeDAO baiTapCodeDAO;


    @Override
    public List<Baitapcode> getAll() {
        return baiTapCodeDAO.getAll();
    }

    @Override
    public void add(Baitapcode baitapcode) {
        baiTapCodeDAO.add(baitapcode);
    }

    @Override
    public void remove(String maBaiTap) {
        baiTapCodeDAO.remove(maBaiTap);
    }

    @Override
    public Baitapcode getBaiTapCodeTheoMaBaiTap(String maBaiTap) {
        return null;
    }

    @Override
    public List<Baitapcode> getBaiTapCodeTheoLoaiBai(String loaiBai) {
        return null;
    }

    @Override
    public List<Baitapcode> getBaiTapCodeTheoUsername(String username) {
        return null;
    }

    @Override
    public List<Baitapcode> getBaiTapCodeTheoCapDo(String capDo) {
        return null;
    }

    @Override
    public void updateBaiTapCode(Baitapcode baitapcode) {

    }
}
