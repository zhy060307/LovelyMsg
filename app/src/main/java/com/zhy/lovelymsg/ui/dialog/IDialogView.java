package com.zhy.lovelymsg.ui.dialog;

import android.app.ProgressDialog;

/**
 * TODO 功能描述
 * <p>
 * 创建时间: 16/2/12 上午8:00 <br/>
 *
 * @author zhaohaiyang
 * @since v0.0.1
 */
public interface IDialogView {

    ProgressDialog showWaitDialog();

    ProgressDialog showWaitDialog(int resId);

    ProgressDialog showWaitDialog(String message);

    void hideWaitDialog();
}
