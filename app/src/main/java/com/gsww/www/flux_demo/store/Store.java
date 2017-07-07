package com.gsww.www.flux_demo.store;

import com.gsww.www.flux_demo.actions.Act;
import com.squareup.otto.Bus;

/**
 * Author   : luweicheng on 2017/7/6 0006 17:08
 * E-mail   ：1769005961@qq.com
 * GitHub   : https://github.com/luweicheng24
 * funcation:
 */

public abstract class Store {
    protected Store() {
    }

    /**
     * 采用Square公司的otto来进行组件间的信息回调通知
     */
    private static final Bus bus = new Bus();

    /**
     * 对UI界面与Store进行关联，在store中由于dispatcher的回调该类中的onAction，
     * 所以在onAction根据action的type来处理数据，之后调用该类的emitChangeEvent，该类中利用bus来发送一个
     * 消息，然后在UI中通过bus的注解来跟新界面
     *
     * @param view
     */
    public void regist(Object view) {
        this.bus.register(view);
    }

    public void unRegist(Object view){
        this.bus.unregister(view);
    }

    public void emitChangeEvent(String type) {
        /**
         * 在Ui的界面寻找注解并且参数为StoreEventChange的参数
         */
        this.bus.post(eventChange(type));
    }
    public void emitChangeEvent(String type,String message) {
        /**
         * 在Ui的界面寻找注解并且参数为StoreEventChange的参数
         */
        this.bus.post(eventChange(type,message));
    }
    public abstract void onAction(Act action);

    public abstract StoreEventChange eventChange(String type);
    public abstract StoreEventChange eventChange(String type,String message);

    public class StoreEventChange {
        private String type;
        private String message;

        public StoreEventChange(String type, String message) {
            this.type = type;
            this.message = message;
        }

        public StoreEventChange(String type){
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public String getMessage() {
            return message;
        }
    }
}
