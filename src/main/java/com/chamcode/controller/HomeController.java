package com.chamcode.controller;

import com.chamcode.service.*;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/Home")
public class HomeController {

    @Autowired
    TaiKhoanService taiKhoanService;

    @Autowired
    MonThuThachService monThuThachService;

    @Autowired
    BaiNopService baiNopService;

    @Autowired
    BaiTapCodeService baiTapCodeService;

    @Autowired
    BinhLuanService binhLuanService;

    @RequestMapping(value = "/Introduce")
    public String Introduce(HttpSession session) {
        session.setAttribute("active", "Introduce");
        session.setAttribute("new-exercise", baiTapCodeService.getNew());
        return "Introduce";
    }

    @RequestMapping(value = "/RankExercise")
    public String RankExercise(HttpSession session) {
        session.setAttribute("active", "RankExercise");
        session.setAttribute("rank-exercise", taiKhoanService.getTaiKhoanGiamDanTheoDiemBaiTap());
        return "RankExercise";
    }

    @RequestMapping(value = "/RankChallenges")
    public String RankChallenges(HttpSession session) {
        session.setAttribute("active", "RankChallenges");
        session.setAttribute("rank-challenges", taiKhoanService.getTaiKhoanGiamDanTheoDiemThuTHach());
        return "RankChallenges";
    }

    @RequestMapping(value = "/Submission")
    public String Submission(HttpSession session) {
        session.setAttribute("active", "Submission");
        session.setAttribute("submission", baiNopService.get10CauGanNhat());
        return "Submission";
    }

    @RequestMapping(value = "/Question")
    public String Question(HttpSession session) {
        session.setAttribute("monhoc", monThuThachService.getAll());
        session.setAttribute("comment", binhLuanService.getAll());
        session.setAttribute("active", "Question");
        return "Comment";
    }
}
