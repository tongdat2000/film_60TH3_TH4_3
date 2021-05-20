package com.congnghephanmem.filmhay.Model;

public class DanhMuc {
    private int img;
    private String tenTheLoai;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public DanhMuc() {
    }

    public DanhMuc(int img, String tenTheLoai) {
        this.img = img;
        this.tenTheLoai = tenTheLoai;
    }
}
