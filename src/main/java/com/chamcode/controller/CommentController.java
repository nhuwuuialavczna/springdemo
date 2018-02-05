package com.chamcode.controller;

import com.chamcode.model.Binhluan;
import com.chamcode.model.Taikhoan;
import com.chamcode.model.Traloibinhluan;
import com.chamcode.service.BinhLuanService;
import com.chamcode.service.TraLoiBinhLuanService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Controller
public class CommentController {

    @Autowired
    BinhLuanService binhLuanService;

    @Autowired
    TraLoiBinhLuanService traLoiBinhLuanService;

    @RequestMapping(value = "/Comment/Get")
    public String getComment(HttpSession session, HttpServletRequest request) {
        String maBinhLuan = request.getParameter("mbl");
        Binhluan binhLuanTheoMa = binhLuanService.getBinhLuanTheoMa(maBinhLuan);
        session.setAttribute("binhluan", binhLuanTheoMa);
        session.setAttribute("tlbl", traLoiBinhLuanService.getAll(maBinhLuan));
        return "AnswerQuestion";
    }

    @RequestMapping(value = "/Comment/Add")
    public String addComment(HttpSession session, HttpServletRequest request) {
        Taikhoan taikhoan = (Taikhoan) session.getAttribute("taikhoan");
        String username = taikhoan.getUsername();
        String binhLuan = request.getParameter("bl");
        String loai = request.getParameter("monhoc");
        Random random = new Random();
        String maCauTraLoi = new Date().getTime() + "" + random.nextInt(100) + "" + random.nextInt(100) + "" + random.nextInt(100);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String thoiGian = dateFormat.format(date); //2016/11/16 12:08:43
        Binhluan binhluan = new Binhluan();
        binhluan.setMabinhluan(maCauTraLoi);
        binhluan.setUsername(username);
        binhluan.setBinhluan(binhLuan);
        binhluan.setLoai(loai);
        binhluan.setThoigian(thoiGian);
        binhLuanService.add(binhluan);
        return "redirect:/Home/Question";
    }

    @RequestMapping(value = "/Comment/AddAns")
    public String addAnswer(HttpSession session, HttpServletRequest request) {
        Binhluan binhluan = (Binhluan) session.getAttribute("binhluan");
        Taikhoan taikhoan = (Taikhoan) session.getAttribute("taikhoan");
        Random random = new Random();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String thoiGian = dateFormat.format(date); //2016/11/16 12:08:43
        String maCauTraLoi = new Date().getTime() + "" + random.nextInt(100) + "" + random.nextInt(100) + "" + random.nextInt(100);
        String cauTraLoi = request.getParameter("tl");
        String maBinhLuan = binhluan.getMabinhluan();
        String username = taikhoan.getUsername();
        Traloibinhluan traloibinhluan = new Traloibinhluan();
        traloibinhluan.setCautraloi(cauTraLoi);
        traloibinhluan.setMabinhluan(maBinhLuan);
        traloibinhluan.setThoigian(thoiGian);
        traloibinhluan.setUsername(username);
        traloibinhluan.setMacautraloi(maCauTraLoi);
        traLoiBinhLuanService.add(traloibinhluan);
        return "redirect:/Comment/Get?mbl="+maBinhLuan;
    }
}
