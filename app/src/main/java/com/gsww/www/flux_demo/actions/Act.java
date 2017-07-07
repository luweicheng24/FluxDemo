package com.gsww.www.flux_demo.actions;

/**
 * Author   : luweicheng on 2017/7/6 0006 17:20
 * E-mail   ：1769005961@qq.com
 * GitHub   : https://github.com/luweicheng24
 * funcation:  action的父类，只需要规定动作的类型和数据
 */

public class Act<T> {
    private final String type;
    private final T data;

    Act(String type, T data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public T getData() {
        return data;
    }


}
