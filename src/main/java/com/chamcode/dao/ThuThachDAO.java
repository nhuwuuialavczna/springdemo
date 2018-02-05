package com.chamcode.dao;


import com.chamcode.model.Taikhoan;
import com.chamcode.model.Thuthach;

import java.util.List;

/**
 * Đây là giao diện thao tác dữ liệu với bảng thử thách. Mục đích chủ yếu là đưa ra 1
 * Câu thử thách tốt cho người dùng
 */
public interface ThuThachDAO {

    /**
     * Lấy danh sách thử thách
     */
    List<Thuthach> getAll();

    /**
     * Lấy ra danh sách các thử thách theo level của nó
     *
     * @param level
     */
    List<Thuthach> getThuThachTheoLevel(int level);

    /**
     * Lấy ra danh sách các thử thách theo mã môn học của nó
     *
     * @param maMonHoc
     */
    List<Thuthach> getThuThachTheoMaMon(String maMonHoc);


    /**
     * Lấy danh sách dựa trên level và mã nằm ngoài danh sách thêm vào
     */
    List<Thuthach> getThuThachTheoLevelVaNgoaiDanhSach(int level, List<String> maThuThach);


    /**
     * Lấy danh sách dựa trên level và mã nằm ngoài các bài user đã làm
     */
    List<Thuthach> getThuThachTheoLevelVaNgoaiDanhSachDaLam(int level, Taikhoan taikhoan);


    Thuthach getThuThachKeTiepChoNguoiDung(Taikhoan taikhoan, String maMonHoc);

    /**
     * Thêm mới 1 thử thách
     */
    void add(Thuthach thuthach);

    /**
     * Xóa 1 thử thách dựa trên mã của nó
     */
    void remove(String maThuThach);

    /**
     * Lấy danh sách dựa trên level và mã nằm ngoài các bài user đã làm
     */
    Thuthach getThuThachTheoMaTHuThach(String maThuThach);

    void updateThuThach(Thuthach thuthach);
}
