package com.ktck124.lop124LTDD04.nhom13;

import java.io.Serializable;

public class Member implements Serializable {
    private String email, name, phone;
    private int id;

    public Member() {
    }

    public Member(String email, String name, String phone, int id) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getId() {
        return id;
    }
}
