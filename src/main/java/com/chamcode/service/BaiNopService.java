package com.chamcode.service;

import com.chamcode.model.Bainop;

import java.util.List;

public interface BaiNopService {
    /**
     * Lấy toàn bộ các bài nộp
     * Nếu trong database rỗng nó sẽ trả về 1 danh sách rỗng.
     */
    List<Bainop> getAll();

    /**
     * Thêm mới 1 bài nộp
     */
    void add(Bainop bainop);

    /**
     * Xóa 1 bài nộp dựa trên mã của nó
     * Nếu không tìm thấy theo mã thì nó sẽ không xóa
     */
    void remove(String maBaiNop);


    /**
     * Lấy bài nộp dưa trên mã của nó. Nếu không tìm thấy sẽ trả về 1 giá trị null
     *
     * @param maBaiNop
     * @return {@link Bainop}
     */
    Bainop getBaiNopTheoMa(String maBaiNop);

    /**
     * Lấy danh sách bài nộp dưa trên người đã nộp đó. Nếu không tìm thấy thì 1 danh sách rỗng sẽ được trả về
     *
     * @param username
     * @return {@link Bainop}
     */
    List<Bainop> getBaiNopTheoUsername(String username);


    /**
     * Lấy danh sách bài nộp dựa trên 1 số điểm nào đó. Phương thức dành cho chức năng thống kê. Nếu không tìm thấy 1 danh sách rỗng sẽ được trả về
     *
     * @param diem
     * @return {@link List<Bainop>}
     */
    List<Bainop> getBaiNopTheoDiem(int diem);

    /**
     * Lấy danh sách bài nộp theo tháng và năm. Nó dùng cho việc thống kê. Nếu không tìm thấy 1 danh sách rỗng sẽ được trả về
     *
     * @param thang
     * @return {@link List<Bainop>}
     */
    List<Bainop> getBaiNopTheoThangVaNam(int thang, int nam);

    /**
     * Cập nhật lại 1 bài nộp, phương thức này không có trường hợp sử dụng cụ thể
     *
     * @param baiNop No return
     */

    @Deprecated
    void updateBaiNop(Bainop baiNop);
}
