package com.gsww.www.flux_demo.actions;

import com.gsww.www.flux_demo.dispatcher.Disptcher;
import com.gsww.www.flux_demo.model.User;

/**
 * Author   : luweicheng on 2017/7/7 0007 09:35
 * E-mail   ：1769005961@qq.com
 * GitHub   : https://github.com/luweicheng24
 * funcation:  Action的创建类，全局只保持一个对象，只有在该类中能够根据UI传过来的数据创建特定的Action
 */

public class ActionCreator {

    private Disptcher disptcher;

    private ActionCreator() {
        disptcher = Disptcher.getInstance();
    }

    /**
     * 用来保持该类对象唯一的holder类
     */
    private static class ActionCreatorHolder {
        private static final ActionCreator instance = new ActionCreator();
    }

    /**
     * 获取ActionCreator实例
     *
     * @return
     */
    public static ActionCreator getInstance() {
        return ActionCreatorHolder.instance;
    }

    //**************************************
    // * 下面都是根据Action来分发的具有语义方法  *
    // * 在下面的自定义方法中进行数据存取以及网络操作 *
    // * 这里我只是将User对象进行转发 *
    //**************************************
    public void regist(User user) {
        if (user != null) {
            disptcher.dispatcher(new RegistAction(RegistAction.REGIST_START, user));
            disptcher.dispatcher(new RegistAction(RegistAction.REGIST_SUCCESS, user));
        }

    }
}
