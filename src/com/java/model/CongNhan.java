package com.java.model;

import java.util.Scanner;

import com.java.absnhanvien.NhanVien;

public class CongNhan extends NhanVien {
	private float luong;
	private float ngayCong;

	@Override
	public void nhapThongTin() {
		// TODO Auto-generated method stub
		super.nhapThongTin();
		System.out.println("Nhap so luong: ");
		luong = new Scanner(System.in).nextFloat();
		System.out.println("nhap so ngay cong: ");
		ngayCong = new Scanner(System.in).nextFloat();
	}

	@Override
	public void xuatThongTin() {
		// TODO Auto-generated method stub
		super.xuatThongTin();
		System.out
				.println("luong: " + this.luong + "So ngay cong: " + this.ngayCong + "Thu nhap: " + this.getThuNhap());
	}

	public CongNhan() {
		super();
	}

	public float getLuong() {
		return luong;
	}

	public void setLuong(float luong) {
		this.luong = luong;
	}

	public float getNgayCong() {
		return ngayCong;
	}

	public void setNgayCong(float ngayCong) {
		this.ngayCong = ngayCong;
	}

	@Override
	public float getThuNhap() {
		// TODO Auto-generated method stub
		float thuNhap = this.luong + (this.ngayCong / 26) * this.luong;
		return thuNhap;

	}

}
