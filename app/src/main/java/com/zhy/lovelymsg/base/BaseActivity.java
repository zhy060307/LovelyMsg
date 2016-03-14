package com.zhy.lovelymsg.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;

import com.zhy.lovelymsg.AppManager;
import com.zhy.lovelymsg.R;
import com.zhy.lovelymsg.ui.dialog.IDialogView;
import com.zhy.lovelymsg.utils.DialogHelp;

import org.xutils.x;

/**
 * <p>
 * 创建时间: 16/2/11 下午12:08 <br/>
 *
 * @author zhaohaiyang
 * @since v0.0.1
 */
public abstract class BaseActivity extends Activity implements IDialogView {

    private boolean isVisible;
    private ProgressDialog waitDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);

        onBeforeSetContentLayout();
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        x.view().inject(this);
        init(savedInstanceState);
        initView();
        initData();
        isVisible = true;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        isVisible = false;
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void init(Bundle savedInstanceState);

    /**
     * 获取layoutId
     *
     * @return
     */
    protected int getLayoutId() {
        return 0;
    }

    protected abstract void onBeforeSetContentLayout();


    @Override
    public ProgressDialog showWaitDialog() {
        return showWaitDialog(R.string.loading);
    }

    @Override
    public void hideWaitDialog() {
        if (waitDialog != null && isVisible) {
            if(waitDialog.isShowing()){
                waitDialog.dismiss();
            }
        }
    }

    @Override
    public ProgressDialog showWaitDialog(int resId) {
        return showWaitDialog(getString(resId));
    }

    @Override
    public ProgressDialog showWaitDialog(String message) {
        if (isVisible) {
            if (null != waitDialog) {
                waitDialog = DialogHelp.getWaitDialog(this, message);
            } else {
                waitDialog.setMessage(message);
            }

            waitDialog.show();
        }

        return waitDialog;
    }
}
