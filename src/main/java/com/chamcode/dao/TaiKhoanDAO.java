package com.chamcode.dao;

import com.chamcode.model.Baitapcode;
import com.chamcode.model.Binhluan;
import com.chamcode.model.Taikhoan;
import com.chamcode.model.Thuthach;

import java.util.List;

/**
 * Đây là giao diện thao tác với tài khoản
 */
public interface TaiKhoanDAO {

    /**
     * Lấy danh sách tài khoản
     */
    List<Taikhoan> getAll();

    /**
     * Lấy danh sách tài khoản theo level. Danh sách rỗng rẽ được trả về
     */
    List<Taikhoan> getTheoLevel(int level);


    /**
     * Lấy danh sách tài khoản theo 1 bài code.
     *
     * @param maBaiCode
     * @return về danh sách tài khoản có làm bài code đó
     */
    List<Taikhoan> getTheoMaBaiCodeDaLam(String maBaiCode);


    /**
     * Lấy danh sách tài khoản theo 1 bài thử thách
     *
     * @param maBaiThuThach
     * @return trả về danh sách user có làm bài thử thách đó
     */
    List<Taikhoan> getTheoMaBaiThuThachDaLam(String maBaiThuThach);

    /**
     * Thêm mới 1 tài khoản
     */
    void add(Taikhoan taikhoan);

    /**
     * Xóa 1 tài khoản
     */
    void remove(String username);

    /**
     * Lấy tài khoảng dựa trên username
     */
    Taikhoan getTaiKhoanTheoUsername(String username);

    /**
     * Lấy tài khoảng dựa trên username và password
     */
    Taikhoan getTaiKhoanTheoUsernameVaPass(String username, String password);

    //================================Cập nhật==================================================


    /**
     * Cập nhật điểm bài tập. Mỗi bài tập sẽ có điểm riêng. Và được cộng dồn vào.
     */
    void capNhatDiemBaiTap(int diemBaiTap, String username);


    /**
     * Cập nhật điểm thử thách
     */
    void capNhatDiemThuThach(int diemThuThach, String username);


    /**
     * Phương thức nhận vào điểm bài tập. Trong quá trình tăng điểm sẽ kiểm tra xem có lên cấp hay không
     * Nếu lên cáp thì tăng cấp luôn
     */
    void congDiemKhiLamBaiTap(int diemBaiTap, Taikhoan taikhoan);


    /**
     * Phương thức nhận vào điểm thử thách. Trong quá trình tăng điểm sẽ kiểm tra xem có lên cấp hay không
     * Nếu lên cáp thì tăng cấp luôn
     */
    void congDiemKhiLamThuThach(int diemThuThach, Taikhoan taikhoan);


    /**
     * Cập nhật lại level của username. Cấp độ để quyết định sức mỗi người.
     * Cứ 1000 điểm bài tập  ( lên 1 level) và 500 điểm thử thách lên 1 level
     */
    void capNhatLevel(String username);


    /**
     * Cập nhật lại thành tích của username. Thành tích này chỉ ở chế độ bị loại nếu có 1 câu sai thôi.
     */
    void capNhatThanhTichTHuTHach(String thanhTich, String username);


    /**
     * Cập nhật lại quyền tham gia thử thách của user. Tham gia thì 1 ko dc thì 0
     */
    void capNhatQuyenThamGiaTHuThach(String thamGia, String username);


    /**
     * Cập nhật lại loại thử thách của username. CÓ 2 loại. 1 là loại(loai)( bị kết thúc nếu sai 1 câu) 2 là
     * theo bộ đề 20 câu(20cau). 3 là theo bộ đề tự chọn(custom) số lượng câu. Các đề đều sắp xếp theo cấp độ.
     */
    void capNhatLoaiThuThach(String thuThachNew, String username);


    /**
     * Phương thức được thực hiện bởi người dùng. Nếu như không tìm thấy bài tập phù hợp hoặc do hết câu hỏi
     * Người dùng cần xóa bài đã làm đi để tiếp tục làm tiếp. Người dùng chỉ được xóa ở level 20
     */
    void xoaBoToanBoBaiCodeDaLam(String username);


    /**
     * Phương thức được thực hiện bởi người dùng. Nếu như không tìm thấy bài tập phù hợp hoặc do hết câu hỏi
     * Người dùng cần xóa bài đã làm đi để tiếp tục làm tiếp. Người dùng chỉ được xóa ở level 20
     */
    void xoaBoToanBoThuThachDaLam(String username);


    /**
     * Chỉnh sửa thông tin cá nhân
     */
    void chinhSuaThongTinCaNhan(String username, String ten, String namSinh, String email, String fb, String gioiThieu);

    /**
     * Thay đổi mật khẩu
     */
    void changPass(String username, String password);

    /**
     * Chỉnh sửa 1 tài khoản
     */
    void updateTaiKhoan(Taikhoan taikhoan);

    //=========================================================================================

    /**
     * Lấy danh sách bài thử thách đã làm
     */
    List<Thuthach> listThuThach(String username);


    /**
     * Lấy danh sách bài code đã làm
     */
    List<Baitapcode> listBaiTapCode(String username);

    /**
     * Danh sách bình luận
     */
    List<Binhluan> listBinhLuan(String username);


    /**
     * Danh sách mã các bài code đã làm
     * */
    List<String> danhSachMaBaiCode(String username);

    List<String> danhSachMaTHuThach(String username);


}
