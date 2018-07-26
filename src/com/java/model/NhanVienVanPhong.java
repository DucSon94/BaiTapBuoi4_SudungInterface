package com.java.model;

import java.util.Scanner;

import com.java.absnhanvien.NhanVien;

public class NhanVienVanPhong extends NhanVien {
	private float luong;
	private float heSo;

	public NhanVienVanPhong() {
		super();
	}

	public float getLuong() {
		return luong;
	}

	public void setLuong(float luong) {
		this.luong = luong;
	}

	public float getHeSo() {
		return heSo;
	}

	public void setHeSo(float heSo) {
		this.heSo = heSo;
	}

	@Override
	public float getThuNhap() {
		// TODO Auto-generated method stub
		float thuNhap = this.luong + this.luong * this.heSo;
		return thuNhap;
	}

	@Override
	public void nhapThongTin() {
		// TODO Auto-generated method stub
		super.nhapThongTin();
		System.out.println("Nhap luong: ");
		this.luong = new Scanner(System.in).nextFloat();
		System.out.println("Nhap he so: ");
		this.heSo = new Scanner(System.in).nextFloat();
	}

	@Override
	public void xuatThongTin() {
		// TODO Auto-generated method stub
		super.xuatThongTin();
		System.out.println("Luong: " + this.luong + "\t He so: " + this.heSo + "\t Thu nhap: " + this.getThuNhap());
	}

}
