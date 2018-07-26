package com.java.gioitinh;

public enum GioiTinh {
	Nam(1, "Nam"), Nu(0, "Nu"), KXD(-1, "Khong Xac Dinh");
	private int ma;
	private String tenGioiTinh;

	public int getMaGioiTinh() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public String getTenGioiTinh() {
		return tenGioiTinh;
	}

	public void setTenGioiTinh(String tenGioiTinh) {
		this.tenGioiTinh = tenGioiTinh;
	}

	private GioiTinh(int ma, String tenGioiTinh) {
		this.ma = ma;
		this.tenGioiTinh = tenGioiTinh;
	}

	public static GioiTinh setGioiTinh(int ma) {
		switch (ma) {

		case 0:
			return Nu;

		case 1:
			return Nam;
		default:
			return KXD;
		}

	}

}
