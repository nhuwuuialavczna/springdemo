package com.chamcode.dao;

import com.chamcode.model.Bainopthuthach;

import java.util.List;
/**
 * Giao diện thao tác dữ liệu cho bài nộp các thử thách.
 * */
public interface BaiNopThuThachDAO {

    /**
     * Lấy toàn bộ bài nộp của thử thách. Nếu trong database rỗng sẽ trả về 1 danh sách rỗng
     */
    List<Bainopthuthach> getAll();

    /**
     * THêm mới 1 bài nộp thử thách. ĐƯợc sử dụng khi người dùng kết  thúc 1 phiên làm việc thử thách
     *
     * @param bainopthuthach
     */

    void add(Bainopthuthach bainopthuthach);

    /**
     * Xóa đi 1 bài nộp thử thách. Chỉ dùng cho admin
     *
     * @param maBaiNop
     */

    void remove(String maBaiNop);


    /**
     * Lấy 1 bài nộp thử thách dựa trên mã của nó. Null sẽ là giá trị trả về nếu không tìm thấy mã này
     *
     * @param maBaiNopThuThach
     * @return {@link Bainopthuthach}
     */
    Bainopthuthach getBaiNopTheoMa(String maBaiNopThuThach);


    /**
     * Lấy danh sách bài nộp thử thách dựa trên username nào đó.
     *
     * @param username
     * @return {@link List<Bainopthuthach>}
     */
    List<Bainopthuthach> getBaiNopTheoUsername(String username);


    /**
     * Lấy danh sách bài nộp thử thách trong 1 tháng nào đó trong năm nào đó
     *
     * @param thang
     * @return {@link List<Bainopthuthach>}
     */
    List<Bainopthuthach> getBaiNopTheoThangVaNam(int thang,int nam);

    /**
     * Chỉnh sủa lại {@link Bainopthuthach} phương thức này không khả dụng
     */

    @Deprecated
    void updateBaiNop(Bainopthuthach bainopthuthach);
}
