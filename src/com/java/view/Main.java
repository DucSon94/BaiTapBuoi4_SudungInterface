package com.java.view;

import java.util.Scanner;

import com.java.absnhanvien.NhanVien;
import com.java.controller.QuanLyNhanVien;

public class Main {
	public static void main(String[] args) {
		QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
		NhanVien[] danhSach = null;

		while (true) {
			System.out.println("1.  Nhập danh sách nhân viên văn phòng, công nhân, quản lý");
			System.out.println("2.	Hiện nhân viên đã có trong hệ thống.");
			System.out.println("3.	Tìm nhân viên có thu nhập cao nhất theo: Gioi Tinh hoac Phogn ban");
			System.out.println("4.Thoat");
			int chon = new Scanner(System.in).nextInt();
			switch (chon) {
			case 1:
				danhSach = quanLyNhanVien.nhapDanhSach();
				break;
			case 2:
				quanLyNhanVien.hienDanhSach(danhSach);
				break;
			case 3:
				System.out.println("1. Tim nhan vien luong cao nhat theo gioi tinh");
				System.out.println("2. Tim nhan vien luong cao nhat theo phong ban");
				int chonTimKiem = new Scanner(System.in).nextInt();
				switch (chonTimKiem) {
				case 1:
					quanLyNhanVien.luongCaoNhatTheoGioiTinh(danhSach);

					break;
				case 2:
					quanLyNhanVien.luongCaoNhatTheoPhongBan(danhSach);

					break;
				}
				break;
			case 4:
				System.out.println(" Cam on ban da su dung chuong trinh");
				System.exit(0);
			default:
				System.out.println(" Vui long chon 1 hoac 2 hoac 3 hoac 4");

			}

		}
	}

}
