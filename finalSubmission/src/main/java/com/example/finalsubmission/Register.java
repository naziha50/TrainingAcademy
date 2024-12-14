package com.example.finalsubmission;

import java.io.Serializable;

public class Register implements Serializable {
    private String email;
    private String phone;
    private String userName;

    public Register(String email, String phone, String userName) {
        this.email = email;
        this.phone = phone;
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
