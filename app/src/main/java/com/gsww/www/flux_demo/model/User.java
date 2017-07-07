package com.gsww.www.flux_demo.model;

/**
 * Author    : luweicheng on 2017/7/6 0006 18:05
 * E-mail    ：1769005961@qq.com
 * GitHub    : https://github.com/luweicheng24
 * funcation :
 */

public class User {
    private String name;

    private String psw;
    public User(){}
    public User(String name, String psw, String gender) {
        this.name = name;
        this.psw = psw;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String gender;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", psw='" + psw + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
