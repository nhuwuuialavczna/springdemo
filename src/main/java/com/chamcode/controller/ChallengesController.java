package com.chamcode.controller;

import com.chamcode.dao.MonThuThachDAO;
import com.chamcode.model.Chedohai;
import com.chamcode.model.Monthuthach;
import com.chamcode.model.Taikhoan;
import com.chamcode.model.Thuthach;
import com.chamcode.service.CheDoHaiService;
import com.chamcode.service.MonThuThachService;
import com.chamcode.service.TaiKhoanService;
import com.chamcode.service.ThuThachService;
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
import java.util.*;

@Controller
public class ChallengesController {

    @Autowired
    ThuThachService thuThachService;

    @Autowired
    MonThuThachService monThuThachService;

    @Autowired
    TaiKhoanService taiKhoanService;

    @Autowired
    CheDoHaiService cheDoHaiService;

    /**
     * Khi bắt đầu vào trang
     */
    @RequestMapping(value = "/Challenges")
    public String Challenges(@RequestParam(name = "mmh") String mmh, HttpSession session, ModelMap map, HttpServletRequest request) {
        String tb = (String) session.getAttribute("thongbao");
        session.setAttribute("active", "Challenges");
        session.setAttribute("diemthuduoc", 0);
        session.setAttribute("monhoc", monThuThachService.getMonthuthachTheoMa(mmh));
        session.setAttribute("baidamduoc", new LinkedList<String>());
        Taikhoan taikhoan = (Taikhoan) session.getAttribute("taikhoan");
        // danh sách các bài có thể làm
        System.out.println(mmh);
        List<Thuthach> thuThachTheoLevelVaNgoaiDanhSachDaLam = thuThachService.getThuThachKeTiepChoNguoiDung(taikhoan, mmh);
        System.out.println(thuThachTheoLevelVaNgoaiDanhSachDaLam);
        session.setAttribute("danhsachcothemlam", thuThachTheoLevelVaNgoaiDanhSachDaLam);
        if (tb != null && !tb.equals("null")) {
            map.put("thongbao", tb);
            session.removeAttribute("thongbao");
        }
        return "Challenges";
    }

    /**
     * Bấm nút next hoặc start
     */
    @RequestMapping(value = "/Challenges/next")
    public @ResponseBody
    String next(@RequestParam(name = "dachon") String dachon, HttpSession session) {
        Taikhoan taikhoan = (Taikhoan) session.getAttribute("taikhoan");
        Thuthach thuthachHienTai = (Thuthach) session.getAttribute("bailamhientai");

        LinkedList<String> linkedList = (LinkedList<String>) session.getAttribute("baidamduoc");
        int diemThuDuoc = (int) session.getAttribute("diemthuduoc");
        if (thuthachHienTai.getDapAnDung().equals(dachon) && taikhoan.getLoaithuthach().equals("loai")) {
            linkedList.add(thuthachHienTai.getMacauhoi());
            session.setAttribute("baidamduoc", linkedList);
            diemThuDuoc += 10;
            session.setAttribute("diemthuduoc", diemThuDuoc);
            List<Thuthach> thuthachList = (List<Thuthach>) session.getAttribute("danhsachcothemlam");
            if (thuthachList == null || thuthachList.isEmpty()) {
                return "end"; // làm hết rồi
            }

            Thuthach thuthach = thuthachList.remove(0);
            session.setAttribute("danhsachcothemlam", thuthachList);
            session.setAttribute("bailamhientai", thuthach);
            return thuthach.toString();
        }

        if (!taikhoan.getLoaithuthach().equals("loai")) {
            if (thuthachHienTai.getDapAnDung().equals(dachon)) {
                diemThuDuoc += 10;
            }
            session.setAttribute("diemthuduoc", diemThuDuoc);
            List<Thuthach> thuthachList = (List<Thuthach>) session.getAttribute("danhsachcothemlam");
            if (thuthachList == null || thuthachList.isEmpty()) {
                return "end"; // làm hết rồi
            }

            Thuthach thuthach = thuthachList.remove(0);
            session.setAttribute("danhsachcothemlam", thuthachList);
            session.setAttribute("bailamhientai", thuthach);
            return thuthach.toString();
        }
        return "fail";

    }


    @RequestMapping(value = "/Challenges/start")
    public @ResponseBody
    String next(HttpSession session) {
        List<Thuthach> thuthachList = (List<Thuthach>) session.getAttribute("danhsachcothemlam");
        if (thuthachList == null || thuthachList.isEmpty()) {
            return "end"; // làm hết rồi
        }
        Thuthach thuthach = thuthachList.remove(0);
        session.setAttribute("danhsachcothemlam", thuthachList);
        session.setAttribute("bailamhientai", thuthach);
        return thuthach.toString();
    }

    /**
     * Bấm nút stop
     */
    @RequestMapping(value = "/Challenges/stop")
    public String stop(HttpSession session, HttpServletRequest request) {
        int diemThuDuoc = (int) session.getAttribute("diemthuduoc");
        LinkedList<String> linkedList = (LinkedList<String>) session.getAttribute("baidamduoc");
        Taikhoan taikhoan = (Taikhoan) session.getAttribute("taikhoan");
        String lamhet = request.getParameter("end");
        System.out.println("null o dau" + lamhet);
        if (lamhet != null && !lamhet.equals("")) {
            session.setAttribute("thongbao", "Bạn vừa làm xong với số câu trả  lời đúng liên tiếp là: " + linkedList.size() + " và tổng " +
                    "điểm đạt được là: " + diemThuDuoc + ". Xin lỗi bạn sẽ phải dừng tại đây do không còn câu hỏi nữa !");
        } else {
            session.setAttribute("thongbao", "Bạn vừa làm xong với số câu trả  lời đúng liên tiếp là: " + linkedList.size() + " và tổng " +
                    "điểm đạt được là: " + diemThuDuoc);
        }

        if (taikhoan.getThuthachdalam() != null && !taikhoan.getThuthachdalam().equals("")) {
            linkedList.addAll(Arrays.asList(taikhoan.getThuthachdalam().split(",")));
        }
        Monthuthach monhoc = (Monthuthach) session.getAttribute("monhoc");
        if (taikhoan.getLoaithuthach().equals("loai")) {
            taiKhoanService.congDiemKhiLamThuThach(diemThuDuoc, taikhoan);
            taiKhoanService.capNhatThuThachDaLam(String.join(",", linkedList), taikhoan.getUsername());
            session.setAttribute("taikhoan", taiKhoanService.getTaiKhoanTheoUsername(taikhoan.getUsername()));
        } else {
            // thêm vào 1 bảng mới
            Chedohai chedohai = new Chedohai();
            chedohai.setMamonhoc(monhoc.getMamonhoc());
            chedohai.setSoluong(linkedList.size());
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String thoiGian = dateFormat.format(date); //2016/11/16 12:08:43
            chedohai.setThoigian(thoiGian);
            chedohai.setUsername(taikhoan.getUsername());
            cheDoHaiService.add(chedohai);
        }

        return "redirect:/Challenges?mmh=" + monhoc.getMamonhoc();
    }
}
