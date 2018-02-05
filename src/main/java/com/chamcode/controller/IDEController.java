package com.chamcode.controller;

import com.chamcode.chamdiem.hethong.IMark;
import com.chamcode.chamdiem.huongthutuc.MarkStruct;
import com.chamcode.model.Bainop;
import com.chamcode.model.Baitapcode;
import com.chamcode.model.Taikhoan;
import com.chamcode.service.BaiNopService;
import com.chamcode.service.BaiTapCodeService;
import com.chamcode.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Trọng  tâm project
 */
@Controller
public class IDEController {

    @Autowired
    BaiTapCodeService baiTapCodeService;

    @Autowired
    TaiKhoanService taiKhoanService;

    @Autowired
    BaiNopService baiNopService;

//    @RequestMapping(value = "/IDE")
//    public String IDE(HttpSession session) {
//        return "IDE";
//    }

    @RequestMapping(value = "/IDE/GoToIDE")
    public String GoToIDE(@RequestParam(name = "mbc") String mbc, HttpSession session) {
        Baitapcode baitapcode = baiTapCodeService.getBaiTapCodeTheoMaBaiTap(mbc);
        session.setAttribute("baicodehientai", baitapcode);
        return "IDE";
    }

    @RequestMapping(value = "/IDE/ChamDiem")
    public String ChamDiem(HttpServletRequest request, HttpSession session, ModelMap modelMap) {
        Taikhoan taikhoan = (Taikhoan) session.getAttribute("taikhoan");
        String username = taikhoan.getUsername();
        String code = request.getParameter("code");
        Baitapcode baitapcode = (Baitapcode) session.getAttribute("baicodehientai");
        String duLieuTest = baitapcode.getDulieutest();
        String duLieuOutput = baitapcode.getDulieuoutput();
        String kieuTraVe = baitapcode.getKieutrave();
        String maBaiCode = baitapcode.getMabaicode();
        String rangBuoc = baitapcode.getRangbuoc();
        String thongBao = null;
        IMark mark = new MarkStruct(null, null, code.trim(), duLieuTest, duLieuOutput, kieuTraVe, rangBuoc.trim());
        int diem = mark.mart();
        int diemNguyen = diem;
        if (isDaLam(maBaiCode, taikhoan)) {
            List<Bainop> baiNopTheoUsername = baiNopService.getBaiNopTheoUsername(username);
            List<Bainop> collect = baiNopTheoUsername.stream().filter(p -> p.getMabaicode().equals(maBaiCode)).collect(Collectors.toList());
            int max = collect.get(0).getDiem();
            for (Bainop bainop : collect) {
                if (bainop.getDiem() > max) {
                    max = bainop.getDiem();
                }
            }
            diem = diem - max;
            thongBao = "Bạn nhận được: " + diemNguyen + " điểm cho bài làm này.\nBạn đã làm bài này rồi. Điểm chỉ được cập nhật";
        } else {
            thongBao = "Bạn nhận được: " + diemNguyen + " điểm cho bài làm này.\nLần sau làm lại điểm sẽ được cập nhật";
            taiKhoanService.capNhatBaiCodeDaLam(taikhoan.getBaitapdalam() + "," + maBaiCode, username);
        }
        taiKhoanService.congDiemKhiLamBaiTap(diem, taikhoan);
        Bainop baiNop = new Bainop();
        baiNop.setMabaicode(maBaiCode);
        baiNop.setUsername(username);
        baiNop.setDiem(diemNguyen);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String thoiGian = dateFormat.format(date); //2016/11/16 12:08:43
        baiNop.setThoigian(thoiGian);
        baiNopService.add(baiNop);
        modelMap.put("thongbao", thongBao);
        modelMap.put("code", code);
        return "IDE";
    }

    public boolean isDaLam(String maBaiCode, Taikhoan taikhoan) {
        return taikhoan.getBaitapdalam() != null && taikhoan.getBaitapdalam().contains(maBaiCode);
    }
}
