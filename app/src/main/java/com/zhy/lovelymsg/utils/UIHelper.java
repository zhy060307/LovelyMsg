package com.zhy.lovelymsg.utils;

import android.content.Context;
import android.content.DialogInterface;

/**
 * TODO 功能描述
 * <p/>
 * 创建时间: 16/2/11 上午11:28 <br/>
 *
 * @author zhaohaiyang
 * @since v0.0.1
 */
public class UIHelper {


    /**
     * 发送App异常崩溃报告
     *
     * @param context
     */
    public static void sendAppCrashReport(final Context context) {

        DialogHelp.getConfirmDialog(context, "程序发生异常", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // 退出
                System.exit(-1);
            }
        }).show();
    }
}
