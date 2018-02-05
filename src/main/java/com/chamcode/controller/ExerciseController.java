package com.chamcode.controller;

import com.chamcode.model.Baitapcode;
import com.chamcode.service.BaiTapCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

@Controller
public class ExerciseController {

    @Autowired
    BaiTapCodeService baiTapCodeService;


    @RequestMapping(value = "/ExercisePage")
    public String ExercisePage(HttpSession session) {
        session.setAttribute("active", "ExercisePage");
        return "Exercise";
    }

    @RequestMapping(value = "/Exercise/GetTheoChuong")
    public @ResponseBody
    String GetTheoChuong(@RequestParam(name = "chuong") String chuong) {
        List<String> s = new LinkedList<>();
        List<Baitapcode> baiTapCodeTheoChuong = baiTapCodeService.getBaiTapCodeTheoChuong(chuong);
        for (Baitapcode baitapcode : baiTapCodeTheoChuong) {
            s.add(baitapcode.theoChuong());
        }
        return String.join("|", s);
    }

    @RequestMapping(value = "/Exercise/GetTheoMa")
    public @ResponseBody
    String GetTheoMa(@RequestParam(name = "mbc") String mbc) {
        Baitapcode baiTapCodeTheoChuong = baiTapCodeService.getBaiTapCodeTheoMaBaiTap(mbc);
        return baiTapCodeTheoChuong.toString();
    }


}
