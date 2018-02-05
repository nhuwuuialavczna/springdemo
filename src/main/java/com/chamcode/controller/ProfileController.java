package com.chamcode.controller;

import com.chamcode.model.Taikhoan;
import com.chamcode.service.TaiKhoanService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
public class ProfileController {

    @Autowired
    TaiKhoanService taiKhoanService;

    @RequestMapping(value = "/Profile")
    public String Profile(HttpServletRequest request, HttpSession session) {
        session.setAttribute("active", "Profile");
        String username = request.getParameter("username");
        Taikhoan taikhoan = null;
        if (username == null || username.equals("")) {
            taikhoan = (Taikhoan) session.getAttribute("taikhoan");
            session.setAttribute("profile", taikhoan);
        } else {
            taikhoan = taiKhoanService.getTaiKhoanTheoUsername(username);
            session.setAttribute("profile", taikhoan);
        }
        return "Profile";

    }

    @RequestMapping(value = "/Profile/Logout")
    public String Profile(HttpSession session) {
        session.removeAttribute("taikhoan");
        return "redirect:/";
    }

    @RequestMapping(value = "/Profile/ChangeFaceBook", produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String ChangeFB(HttpServletRequest request, HttpSession session) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String fb = request.getParameter("fb");
        String email = request.getParameter("email");
        String gioithieu = request.getParameter("gioithieu");
        String ten = request.getParameter("ten");
        String hinhanh = request.getParameter("hinhanh");
        Taikhoan taikhoan = (Taikhoan) session.getAttribute("taikhoan");
        taikhoan.setFacebook(fb);
        taikhoan.setEmail(email);
        taikhoan.setGioithieu(gioithieu);
        taikhoan.setTen(ten);
        taikhoan.setHinhanh(hinhanh);
        taiKhoanService.updateTaiKhoan(taikhoan);
        return "OK";
    }

    @RequestMapping(value = "/Profile/ChangePass", produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String ChangePass(HttpServletRequest request, HttpSession session) {
        Taikhoan taikhoan = (Taikhoan) session.getAttribute("taikhoan");
        String pass = request.getParameter("pass");
        taiKhoanService.changPass(taikhoan.getUsername(), pass);
        return "OK";
    }
}
