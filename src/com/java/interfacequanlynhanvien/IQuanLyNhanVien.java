package com.java.interfacequanlynhanvien;

import com.java.absnhanvien.NhanVien;
import com.java.gioitinh.GioiTinh;

public interface IQuanLyNhanVien {
	NhanVien[] nhapDanhSach();

	void hienDanhSach(NhanVien[] danhSach);

	// int getNhanVien(NhanVien nv);
	NhanVien nhanVienLuongCaoNhatTheoGioitinh(NhanVien[] danhSach, GioiTinh gioiTinh);

	NhanVien nhanVienLuongCaoNhatTheoPhongBan(NhanVien[] danhSach, int phongBan);

}
