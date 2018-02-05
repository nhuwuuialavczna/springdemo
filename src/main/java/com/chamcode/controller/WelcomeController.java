package com.chamcode.controller;

import com.chamcode.dao.TaiKhoanDAO;
import com.chamcode.model.Taikhoan;
import com.chamcode.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/")
public class WelcomeController {

    @Autowired
    BaiNopService baiNopService;

    @Autowired
    MonThuThachService monThuThachService;

    @Autowired
    TaiKhoanService taiKhoanService;

    @Autowired
    ChuongService chuongService;

    @RequestMapping(value = "/")
    public String Welcome() {
        return "Welcome";
    }

    @RequestMapping(value = "/Login", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String Login(HttpSession session, @RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        Taikhoan taikhoan = taiKhoanService.getTaiKhoanTheoUsernameVaPass(username, password);

        if (taikhoan != null) {
            session.setAttribute("taikhoan", taikhoan);
            session.setAttribute("chuong", chuongService.getAll());
            session.setAttribute("dsthuthach",monThuThachService.getAll());
            return "OK";
        }
        return "incorrect username or password";
    }
}
