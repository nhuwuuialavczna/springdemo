package com.chamcode.service;

import com.chamcode.model.Chedohai;

import java.util.List;

public interface CheDoHaiService {
    List<Chedohai> getAll();

    void add(Chedohai chedohai);
}
