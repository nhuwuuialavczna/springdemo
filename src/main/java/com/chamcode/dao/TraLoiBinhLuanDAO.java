package com.chamcode.dao;

import com.chamcode.model.Traloibinhluan;

import java.util.List;

public interface TraLoiBinhLuanDAO {

    /**
     * Lấy danh sách bình luận theo mã bình luận
     */
    List<Traloibinhluan> getAll(String maBinhLuan);

    /**
     * Lấy danh sách bình luận theo mã bình luận và theo người trả lời
     */
    List<Traloibinhluan> getTheoUsername(String maBinhLuan, String username);

    /**
     * Thêm mới 1 trả lời bình luận
     */
    void add(Traloibinhluan traloibinhluan);

    Traloibinhluan getCauTraloibinhluan(String maCauTraLoi);

    void remove(String maCauTraLoi);

    void update(Traloibinhluan traloibinhluan);

}
