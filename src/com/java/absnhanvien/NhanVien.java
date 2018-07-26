package com.java.absnhanvien;

import java.util.Scanner;

import com.java.gioitinh.GioiTinh;
import com.java.interfacenhanvien.INhanVien;

public abstract class NhanVien implements INhanVien {
	private static int maTuTang = 0;
	private int ma;
	private String ten;
	private GioiTinh gioiTinh;

	public NhanVien() {
		this.ma = ++maTuTang;
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public GioiTinh getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(GioiTinh gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	@Override
	public void nhapThongTin() {
		System.out.println("Nhap ten:");
		ten = new Scanner(System.in).nextLine();
		System.out.println("vui long chon gioi tinh: 1 => Nam, -1 => Nu, # => KXD");
		int chonGioiTinh = new Scanner(System.in).nextInt();
		this.gioiTinh = GioiTinh.setGioiTinh(chonGioiTinh);

	}

	@Override
	public void xuatThongTin() {
		// TODO Auto-generated method stub
		System.out.println(
				"Ma nhan vien: " + this.ma + "\t Ten: " + this.ten + "\t Gioi tinh: " + this.gioiTinh.getTenGioiTinh());

	}

}
