package com.chamcode.service;

import com.chamcode.model.Chuong;

import java.util.List;

public interface ChuongService {
    List<Chuong> getAll();
    Chuong getChuong(int chuong);

}
