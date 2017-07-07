package com.gsww.www.flux_demo.actions;

import com.gsww.www.flux_demo.model.User;

/**
 * Author   : luweicheng on 2017/7/7 0007 08:55
 * E-mail   ：1769005961@qq.com
 * GitHub   : https://github.com/luweicheng24
 * funcation: 注册的Action 定义了相应的类型
 */

public class RegistAction extends Act<User> {
    public final static String REGIST_START = "REGIST_START";
    public final static String REGIST_SUCCESS = "REGIST_SUCCESS";
    public final static String REGIST_FAIL = "REGIST_FAIL";
    RegistAction(String type, User data) {
        super(type, data);
    }
}
