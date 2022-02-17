package com.example.bai5;

public class KhachHang {
    private String tenKH;
    private int soLuong;
    private int thanhTien;
    private boolean vip;

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getSoLuong(){
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
    public boolean getVip(){
        return vip;
    }
}
