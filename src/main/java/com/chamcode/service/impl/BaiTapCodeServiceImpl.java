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
    public List<Baitapcode> getNew() {
        return baiTapCodeDAO.getNew();
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
        return baiTapCodeDAO.getBaiTapCodeTheoMaBaiTap(maBaiTap);
    }

    @Override
    public List<Baitapcode> getBaiTapCodeTheoChuong(String loaiBai) {
        return baiTapCodeDAO.getBaiTapCodeTheoChuong(loaiBai);
    }

    @Override
    public List<Baitapcode> getBaiTapCodeTheoUsername(String username) {
        return baiTapCodeDAO.getBaiTapCodeTheoUsername(username);
    }

    @Override
    public List<Baitapcode> getBaiTapCodeTheoCapDo(String capDo) {
        return baiTapCodeDAO.getBaiTapCodeTheoCapDo(capDo);
    }

    @Override
    public void updateBaiTapCode(Baitapcode baitapcode) {
        baiTapCodeDAO.updateBaiTapCode(baitapcode);
    }
}
