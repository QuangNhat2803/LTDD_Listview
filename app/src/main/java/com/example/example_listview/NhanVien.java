package com.example.example_listview;

public class NhanVien {
    private String name;
    private String birthday;
    private String sex;
    private int hinhanh;

    public NhanVien(String name, String birthday, String sex, int hinhanh) {
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.hinhanh = hinhanh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }
}
