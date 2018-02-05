package com.chamcode.service.impl;

import com.chamcode.dao.CheDoHaiDAO;
import com.chamcode.model.Chedohai;
import com.chamcode.service.CheDoHaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheDoHaiServiceImpl implements CheDoHaiService {

    @Autowired
    CheDoHaiDAO cheDoHaiDAO;

    @Override
    public List<Chedohai> getAll() {
        return cheDoHaiDAO.getAll();
    }

    @Override
    public void add(Chedohai chedohai) {
        cheDoHaiDAO.add(chedohai);
    }
}
