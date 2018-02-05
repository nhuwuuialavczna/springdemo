package com.chamcode.dao;


import com.chamcode.model.Baitapcode;

import java.util.List;

public interface BaiTapCodeDAO {

    /**
     * Lấy danh sách bài tập code
     */
    List<Baitapcode> getAll();

    /**
     * Phương thức thêm 1 bài tập code
     *
     * @param baitapcode
     */

    void add(Baitapcode baitapcode);

    /**
     * Xóa đi 1 bài tập code.
     *
     * @param maBaiTap Mã bài tập này do admin nhập và do admin kiểm soát
     */
    void remove(String maBaiTap);


    /**
     * Lấy 1 bài tập code dựa trên mã của nó
     *
     * @param maBaiTap
     * @return {@link Baitapcode}
     */
    Baitapcode getBaiTapCodeTheoMaBaiTap(String maBaiTap);

    /**
     * Lấy danh sách bài tập code dựa trên loại bài của nó
     *
     * @param loaiBai Loại bài chỉ có thể là D (cấu trúc) hoặc O (Hướng đối tượng).
     *                Ví dụ: D10001. Trong đó: D là mã của dạng cấu trúc
     *                1 kế tiếp là chương 1
     *                0001 là bài tập thứ 0001 trong chương này
     * @return {@link List<Baitapcode>}
     */
    List<Baitapcode> getBaiTapCodeTheoLoaiBai(String loaiBai);


    /**
     * Lấy danh sách bài tập code dựa trên người đã đăng nó
     *
     * @param username
     * @return {@link List<Baitapcode>}
     */
    List<Baitapcode> getBaiTapCodeTheoUsername(String username);

    /**
     * Lấy danh sách bài tập code dựa trên độ khó của bài đó
     *
     * @param capDo
     * @return {@link List<Baitapcode>}
     */
    List<Baitapcode> getBaiTapCodeTheoCapDo(String capDo);

    void updateBaiTapCode(Baitapcode baitapcode);
}
