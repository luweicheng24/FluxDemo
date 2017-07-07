package com.gsww.www.flux_demo.dispatcher;

import android.util.Log;

import com.gsww.www.flux_demo.actions.Act;
import com.gsww.www.flux_demo.store.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * Author   : luweicheng on 2017/7/6 0006 17:02
 * E-mail   ：1769005961@qq.com
 * GitHub   : https://github.com/luweicheng24
 * funcation: 分发器 内部维护了一个store的集合
 *               全局只有一个一个分发器 ，
 */

public class Disptcher {
    public static Disptcher instance ;
    private final  List<Store> stores = new ArrayList<>();
    private Disptcher(){}
    /*创建单例保持全局只有一个*/
    public static Disptcher getInstance(){
        if(instance==null){
            instance = new Disptcher();
        }
        return  instance;
    }
   /* 将维护UI(Activity、fragment)的界面状态和数据 需要将UI注册到该Store上,*/
    public void regist(Store store) {
        if (!stores.contains(store)) {
            stores.add(store);
        } else {
            Log.i("flux", "unRegist: " + store.getClass().getName() + "已注册");
        }
    }

    public void unRegist(Store store){
        if(stores.contains(store)){
           stores.remove(store);
        }else{
            Log.i("flux", "unRegist: "+store.getClass().getName()+"未注册");
        }
    }

    /**
     * 分发到所以注册到该dispatcher中的store的onAction中
     * 然后在根据action的type进行相应的处理
     * @param action
     */
    public void dispatcher(Act action){
        for (Store s: stores) {
            s.onAction(action);
        }
    }


}
