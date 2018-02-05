package com.chamcode.controller;

import com.chamcode.dao.TaiKhoanDAO;
import com.chamcode.model.Taikhoan;
import com.chamcode.service.BaiNopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/")
public class WelcomeController {

    @Autowired
    BaiNopService baiNopService;

    @Autowired
    TaiKhoanDAO taiKhoanDAO;

    @RequestMapping(value = "/")
    public String Welcome() {
        return "Welcome";
    }

    @RequestMapping(value = "/Login",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String Login(@RequestParam(name="username") String username, @RequestParam(name = "password") String password) {
        Taikhoan taikhoan = taiKhoanDAO.getTaiKhoanTheoUsernameVaPass(username, password);

        if(taikhoan!=null){
            return "OK";
        }
        return "incorrect username or password";
    }
}
