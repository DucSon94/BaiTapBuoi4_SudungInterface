package com.java.controller;

import java.util.Scanner;
import com.java.model.*;

import com.java.absnhanvien.NhanVien;
import com.java.gioitinh.GioiTinh;
import com.java.interfacequanlynhanvien.IQuanLyNhanVien;

public class QuanLyNhanVien implements IQuanLyNhanVien {

    private final int CONG_NHAN = 1;
    private final int NHANVIEN_VANPHONG = 2;
    private final int QUAN_LY = 3;
    //

    private NhanVien taoNhanVien(int chonNhanVien) {
        switch (chonNhanVien) {
            case CONG_NHAN:
                return new CongNhan();
            case NHANVIEN_VANPHONG:
                return new NhanVienVanPhong();
            default:
                return new QuanLy();
        }
    }

    @Override

    public NhanVien[] nhapDanhSach() {
        NhanVien[] danhSach = null;
        NhanVien nv = null;
        System.out.println("nhap so luong nhan vien: ");
        int soLuongNhanVien = new Scanner(System.in).nextInt();
        danhSach = new NhanVien[soLuongNhanVien];
        for (int i = 0; i < danhSach.length; i++) {
            System.out.println("1.Cong nhan, 2:Nhan vien van phong, 3:Quan ly");
            int chonNhanVien = new Scanner(System.in).nextInt();
            nv = taoNhanVien(chonNhanVien);// em dùng hàm taoNhanVien ở phía trên;
            danhSach[i] = nv;
            nv.nhapThongTin();
        }
        // TODO Auto-generated method stub
        return danhSach;
    }

    @Override
    public void hienDanhSach(NhanVien[] danhSach) {
        if (danhSach != null) {
            NhanVien nv = null;
            for (int i = 0; i < danhSach.length; i++) {
                nv = danhSach[i];
                nv.xuatThongTin();
            }
        } else {
            System.out.println("Khong co nhan vien nao vui long chon 1 de nhap danh sach nahn vien truoc");
        }

        // TODO Auto-generated method stub
    }

    public void luongCaoNhatTheoGioiTinh(NhanVien[] danhSach) {
        NhanVien nv = null;
        System.out.println("Vui long chon gioi tinh: 1 => Nam, -1 => Nu, # =>Kxd");
        int chonGioiTinh = new Scanner(System.in).nextInt();
        GioiTinh gioiTinh = GioiTinh.setGioiTinh(chonGioiTinh);
        nv = nhanVienLuongCaoNhatTheoGioitinh(danhSach, gioiTinh);
        if (nv != null) {
            nv.xuatThongTin();
        } else {
            System.out
                    .println("Khong tim thay nhan vien gioi tinh " + gioiTinh.getTenGioiTinh() + "  co luong cao nhat");
        }
    }

    public void luongCaoNhatTheoPhongBan(NhanVien[] danhSach) {
        NhanVien nv = null;
        System.out.println("Vui long chon phong ban 1 => Cong nhan, 2=> NhanVienVanPhong, # => QuanLy");
        int chonPhongBan = new Scanner(System.in).nextInt();
        nv = nhanVienLuongCaoNhatTheoPhongBan(danhSach, chonPhongBan);
        if (nv != null) {
            if (chonPhongBan == 1) {
                System.out.println("Cong nhan co luong cao nhat la: ");
                nv.xuatThongTin();
            } else if (chonPhongBan == 2) {
                System.out.println("Nhan Vien Van phogn co luong cao nhat la");
                nv.xuatThongTin();
            } else {
                System.out.println("Quan ly co luong cao nhat la: ");
                nv.xuatThongTin();
            }

        } else {
            System.out.println("khong tim thay nhan vien  co luong cao nhat");
        }

    }

    @Override
    public NhanVien nhanVienLuongCaoNhatTheoGioitinh(NhanVien[] danhSach, GioiTinh gioiTinh) {
        if (danhSach != null) {
            float maxLuong = 0;
            NhanVien nhanVienLuongCaoNhat = null;
            for (int i = 0; i < danhSach.length; i++) {
                NhanVien nv = danhSach[i];
                if (nv.getGioiTinh().getMaGioiTinh() == gioiTinh.getMaGioiTinh() && nv.getThuNhap() > maxLuong) {
                    nhanVienLuongCaoNhat = nv;
                }
            }
            return nhanVienLuongCaoNhat;
        }
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public NhanVien nhanVienLuongCaoNhatTheoPhongBan(NhanVien[] danhSach, int phongBan) {
        // TODO Auto-generated method stub
        if (danhSach != null) {
            int count = 0;
            for (int i = 0; i < danhSach.length; i++) {
                NhanVien nhanVien = danhSach[i];
                if (getTypeNhanVien(nhanVien) == phongBan) {// dùng hàm getType ở dưới cùng để xem từng nhân viên 
                    //trong danh sách có thuộc phòng ban mình đang tìm k
                    count++; // dùng count để xác định có nhân vien thuộc phòng ban mà mình đang tim trong danh sách không nếu có thì break thoát ra khỏi hàm luôn
                    // chỉ cần có 1 nhân viên thuộc phòng ban mà mình đang tìm là dc vì nếu có duy nhất 1 người d tìm thấy thì
                    // cũng đồng nghĩa là người đấy có lương cao nhất
                    break;
                }
            }
            // sau khi tim dc count  ở phía trên nếu count > 0 thì ta thực hiện tìm kiếm nhân viên có lương cao nhât trong danh sách rồi trả về dữ liệu nhân viên
            // nếu count <0 thì phải return null vì là danhSach mặc dù khác null nhưng trong danhSach lại không có nhân viên
            // thuộc phòng ban mình đang tìm kiếm do vậy ta phải return null nếu không sẽ bị lỗi null pointer;
            if (count > 0) {
                float maxLuong = 0; // cái này mình nhái lạibài hôm trước của đạt làm khá hay cho một biến Maxlương có cùng kiểu dữ liệu trả về của hàm thuNhap 
                //trong nhan vien rồi dùng thuạt toán sắp xếp kiểu nổi bọt là tìm dc cái lớn nhất nếu trong danh sách có từ 2 nhân viên thuộc cùng một phòng ban trở lên 
                NhanVien nv = null;
                for (int i = 0; i < danhSach.length; i++) {
                    NhanVien nhanVien = danhSach[i];
                    if (getTypeNhanVien(nhanVien) == phongBan && nhanVien.getThuNhap() > maxLuong) {
                        nv = nhanVien;
                    }
                }
                return nv;
            }
            return null;
        }

        return null;
    }

    private int getTypeNhanVien(NhanVien nv) {
        if (nv instanceof CongNhan) {
            return CONG_NHAN; // trả về kiểu giá trị CONG_NHAN =1 mà mình đã gán ở trên đầu bài
        } else if (nv instanceof NhanVienVanPhong) {
            return NHANVIEN_VANPHONG;
        } else {
            return QUAN_LY;
        }
    }

}
