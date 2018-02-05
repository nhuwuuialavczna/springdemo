package com.chamcode.dao;

import com.chamcode.model.Chedohai;

import java.util.List;

public interface CheDoHaiDAO {
    List<Chedohai> getAll();

    void add(Chedohai chedohai);
}
