package com.chamcode.dao;

import com.chamcode.model.Chuong;

import java.util.List;

public interface ChuongDAO {
    List<Chuong> getAll();
    Chuong getChuong(int chuong);

}
