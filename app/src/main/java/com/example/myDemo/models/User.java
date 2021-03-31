package com.example.myDemo.models;

public class User {
 String userName;
 String email;
 String numberPhone;

    public User(String userName, String email, String numberPhone) {
        this.userName = userName;
        this.email = email;
        this.numberPhone = numberPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
}
