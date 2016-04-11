package com.zhy.lovelymsg.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.zhy.lovelymsg.R;
import com.zhy.lovelymsg.ui.fragment.AboutMeFragment;
import com.zhy.lovelymsg.ui.fragment.ChatsFragment;
import com.zhy.lovelymsg.ui.fragment.DiscoverFragment;
import com.zhy.lovelymsg.ui.view.GradientIconView;
import com.zhy.lovelymsg.ui.view.GradientTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 主界面
 * <p/>
 * 创建时间: 16/2/12 上午8:13 <br/>
 *
 * @author zhaohaiyang
 * @since v0.0.1
 */
public class MainActivity extends FragmentActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ViewPager mViewPager;
    private List<Fragment> mTabs = new ArrayList<Fragment>();
    private FragmentPagerAdapter mAdapter;

    private List<GradientIconView> mTabIconIndicator = new ArrayList<GradientIconView>();
    private List<GradientTextView> mTabTextIndicator = new ArrayList<GradientTextView>();
    private GradientIconView mChatsIconView;
    private GradientIconView mDiscoverIconView;
    private GradientIconView mAboutMeIconView;

    private GradientTextView mTvChats;
    private GradientTextView mTvDiscover;
    private GradientTextView mTvAboutMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

        mChatsIconView = (GradientIconView) findViewById(R.id.id_iconfont_chat);
        mChatsIconView.setOnClickListener(this);
        mTabIconIndicator.add(mChatsIconView);
        mChatsIconView.setIconAlpha(1.0f);


        mDiscoverIconView = (GradientIconView) findViewById(R.id.id_iconfont_faxian);
        mDiscoverIconView.setOnClickListener(this);
        mTabIconIndicator.add(mDiscoverIconView);

        mAboutMeIconView = (GradientIconView) findViewById(R.id.id_iconfont_me);
        mAboutMeIconView.setOnClickListener(this);
        mTabIconIndicator.add(mAboutMeIconView);

        mTvChats = (GradientTextView) findViewById(R.id.id_chats_tv);
        mTvChats.setOnClickListener(this);
        mTabTextIndicator.add(mTvChats);
        mTvChats.setTextViewAlpha(1.0f);


        mTvDiscover = (GradientTextView) findViewById(R.id.id_discover_tv);
        mTvDiscover.setOnClickListener(this);
        mTabTextIndicator.add(mTvDiscover);

        mTvAboutMe = (GradientTextView) findViewById(R.id.id_about_me_tv);
        mTvAboutMe.setOnClickListener(this);
        mTabTextIndicator.add(mTvAboutMe);

        initFragments();
    }

    private void initFragments() {
        mTabs.add(ChatsFragment.newInstance("", ""));
        mTabs.add(DiscoverFragment.newInstance("", ""));
        mTabs.add(AboutMeFragment.newInstance("", ""));

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return mTabs.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return mTabs.get(arg0);
            }
        };

        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(this);
    }

    /**
     * 重置其他的Tab
     */
    private void resetOtherTabs() {
        resetOtherTabIcons();
        resetOtherTabText();
    }

    /**
     * 重置其他的Tab icon
     */
    private void resetOtherTabIcons() {
        for (int i = 0; i < mTabIconIndicator.size(); i++) {
            mTabIconIndicator.get(i).setIconAlpha(0);
        }
    }

    /**
     * 重置其他的Tab text
     */
    private void resetOtherTabText() {
        for (int i = 0; i < mTabTextIndicator.size(); i++) {
            mTabTextIndicator.get(i).setTextViewAlpha(0);
        }
    }

    @Override
    public void onClick(View v) {
        resetOtherTabs();
        switch (v.getId()) {
            case R.id.id_iconfont_chat:
            case R.id.id_chats_tv:
                mTabIconIndicator.get(0).setIconAlpha(1.0f);
                mTabTextIndicator.get(0).setTextViewAlpha(1.0f);
                mViewPager.setCurrentItem(0, false);
                break;
            case R.id.id_iconfont_faxian:
            case R.id.id_discover_tv:
                mTabIconIndicator.get(1).setIconAlpha(1.0f);
                mTabTextIndicator.get(1).setTextViewAlpha(1.0f);
                mViewPager.setCurrentItem(1, false);
                break;
            case R.id.id_iconfont_me:
            case R.id.id_about_me_tv:
                mTabIconIndicator.get(2).setIconAlpha(1.0f);
                mTabTextIndicator.get(2).setTextViewAlpha(1.0f);
                mViewPager.setCurrentItem(2, false);
                break;
        }
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (positionOffset > 0) {
            GradientIconView iconLeft = mTabIconIndicator.get(position);
            GradientIconView iconRight = mTabIconIndicator.get(position + 1);

            GradientTextView textLeft = mTabTextIndicator.get(position);
            GradientTextView textRight = mTabTextIndicator.get(position + 1);

            iconLeft.setIconAlpha(1 - positionOffset);
            textLeft.setTextViewAlpha(1 - positionOffset);
            iconRight.setIconAlpha(positionOffset);
            textRight.setTextViewAlpha(positionOffset);
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

