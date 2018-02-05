package com.chamcode.dao;


import com.chamcode.model.Binhluan;
import com.chamcode.model.Traloibinhluan;

import java.util.List;

/**
 * Giao diện thao tác với các bình luận trên hệ thống
 * */
public interface BinhLuanDAO {
    /**
     * Lấy danh sách tất cả bình luận. Nếu không tìm thấy sẽ trả về 1 danh sách rỗng
     */
    List<Binhluan> getAll();

    /**
     * Thêm mới 1 bình luận. Phương thức này được gọi khi người dùng bình luận
     *
     * @param binhluan
     */
    void add(Binhluan binhluan);

    /**
     * Xóa đi 1 bình luận. Phương thức này khả dụng cho admin. Nếu không tìm thấy sẽ không thao tác xóa
     *
     * @param maBinhLuan
     */

    void remove(String maBinhLuan);

    /**
     * Lấy 1 bình luận theo mã của nó
     */
    Binhluan getBinhLuanTheoMa(String maBinhLuan);


    /**
     * Lấy danh sách bình luận của 1 user nào đó
     *
     * @param username
     * @return {@link List<Binhluan>}
     */
    List<Binhluan> getBinhLuanTheoUsername(String username);

    /**
     * Chỉnh sủa bình luận. Phương thức khả dụng cho người dùng không áp dụng cho admin
     * @deprecated
     */
    void updateBinhLuan(Binhluan binhluan);


    /**
     * Phương thức nhận vào 1 mã bình luận. Lấy danh sách các câu trả lời cho bình luận đó
     *
     * @param maBinhLuan
     * @return {@link List<Traloibinhluan>}
     */
    List<Traloibinhluan> listTraloibinhluans(String maBinhLuan);

}
