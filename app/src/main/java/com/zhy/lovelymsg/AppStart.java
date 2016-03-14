package com.zhy.lovelymsg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.zhy.lovelymsg.ui.MainActivity;

public class AppStart extends Activity implements Animation.AnimationListener {

    private RelativeLayout mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mainView = (RelativeLayout) findViewById(R.id.rl_splash);

        AnimationSet animSet = createAnimationSet();
        mainView.startAnimation(animSet);
        animSet.setAnimationListener(this);
    }

    @NonNull
    private AnimationSet createAnimationSet() {
        AnimationSet animSet = new AnimationSet(false);
        Animation rotateAnim = AnimationUtils.loadAnimation(this, R.anim.splash_rotate);
        animSet.addAnimation(rotateAnim);

        ScaleAnimation scaleAnim =
                new ScaleAnimation(0.0f, 1f, 0.0f, 1f,
                        Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
        scaleAnim.setDuration(1000);
        animSet.addAnimation(scaleAnim);

        AlphaAnimation alphaAnim = new AlphaAnimation(0f, 1f);
        alphaAnim.setDuration(1000);
        animSet.addAnimation(alphaAnim);
        return animSet;
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
