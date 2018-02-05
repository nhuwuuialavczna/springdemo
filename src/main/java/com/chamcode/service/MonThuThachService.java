package com.chamcode.service;

import com.chamcode.model.Monthuthach;
import com.chamcode.model.Thuthach;

import java.util.List;

public interface MonThuThachService {
    /**
     * Lấy danh sách các môn thử thách. Nếu không có sẽ nhận được 1 danh sách rỗng
     */
    List<Monthuthach> getAll();

    /**
     * Thêm mới 1 môn thử thách
     */
    void add(Monthuthach monthuthach);

    /**
     * Xóa 1 Môn thử thách theo mã. Phương thức này sẽ không được thực thi trên ứng dụng. Nó quá nguy hiểm
     */
    void remove(String maMonThuThach);


    /**
     * Lấy 1 môn dựa trên mã môn của nó
     */
    Monthuthach getMonthuthachTheoMa(String maMonThuThach);

    /**
     * Chỉnh sửa 1 môn thử thách
     */
    void updateMonthuthach(Monthuthach monthuthach);

    /**
     * Lấy danh sách các câu thử thách thuộc về 1 môn nào đó
     */
    List<Thuthach> listThuThach(String maMonThuThach);
}
