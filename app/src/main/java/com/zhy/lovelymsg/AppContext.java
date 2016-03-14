package com.zhy.lovelymsg;

import android.app.Application;

import org.xutils.x;

/**
 *
 * <p/>
 * 创建时间: 16/2/11 上午10:45 <br/>
 *
 * @author zhaohaiyang
 * @since v0.0.1
 */
public class AppContext extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        x.Ext.init(this);
        x.Ext.setDebug(true); // 是否输出debug日志
    }
}
