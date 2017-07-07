package com.gsww.www.flux_demo.store;

import android.util.Log;

import com.gsww.www.flux_demo.actions.Act;
import com.gsww.www.flux_demo.actions.RegistAction;
import com.gsww.www.flux_demo.model.User;

/**
 * Author   : luweicheng on 2017/7/7 0007 08:51
 * E-mail   ：1769005961@qq.com
 * GitHub   : https://github.com/luweicheng24
 * funcation:
 */

public class RegistStore extends Store {
    private User user = new User();


    public User getUser(){
        return user;
    }
    @Override
    public void onAction(Act action) {
        String type = action.getType();
        switch (type){
            case RegistAction.REGIST_START:
                Log.i("flux", "onAction:开始注册");
                user = (User) action.getData();
                emitChangeEvent(type,"开始注册"+((User)action.getData()).toString());
                break;
            case RegistAction.REGIST_SUCCESS:
                Log.i("flux", "onAction: 注册完成");
                user = (User) action.getData();
                emitChangeEvent(type,"注册完成"+((User)action.getData()).toString());
                break;
            case RegistAction.REGIST_FAIL:
                Log.i("flux", "onAction: 注册失败");
                emitChangeEvent(type,"注册失败");
                break;
        }


    }

    @Override
    public StoreEventChange eventChange(String type) {
        return new StoreEventChange(type);
    }

    @Override
    public StoreEventChange eventChange(String type, String message) {
        return new StoreEventChange(type,message);
    }

}
