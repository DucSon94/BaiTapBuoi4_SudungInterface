package com.java.model;

import java.util.Scanner;

import com.java.absnhanvien.NhanVien;

public class QuanLy extends NhanVien {
	private float luong;
	private int soNhanVien;

	private float getPhuCap() {
		if (this.soNhanVien < 10) {
			return 500;
		} else if (this.soNhanVien >= 10 || this.soNhanVien < 20) {
			return 1000;
		} else
			return 2000;
	}

	public QuanLy() {
		super();
	}

	public float getLuong() {
		return luong;
	}

	public void setLuong(float luong) {
		this.luong = luong;
	}

	public int getSoNhanVien() {
		return soNhanVien;
	}

	public void setSoNhanVien(int soNhanVien) {
		this.soNhanVien = soNhanVien;
	}

	@Override
	public float getThuNhap() {
		// TODO Auto-generated method stub
		float thuNhap = this.luong + this.getPhuCap();
		return 0;
	}

	@Override
	public void nhapThongTin() {
		// TODO Auto-generated method stub
		super.nhapThongTin();
		System.out.println("Nhap luong: ");
		this.luong = new Scanner(System.in).nextFloat();
		System.out.println("Nhap So nhan vien: ");
		this.soNhanVien = new Scanner(System.in).nextInt();
	}

	@Override
	public void xuatThongTin() {
		// TODO Auto-generated method stub
		super.xuatThongTin();
		System.out.println("Luong: " + this.luong + "\t So nhan vien: " + this.soNhanVien);
	}

}
