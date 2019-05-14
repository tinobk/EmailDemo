package com.sun.tino.emaildemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControls();
        setEvents();
    }

    private void setControls() {
        mTabLayout = findViewById(R.id.tabs);
        mViewPager = findViewById(R.id.viewpager);

    }

    private void setEvents() {
        setupViewPager();
        mTabLayout.setupWithViewPager(mViewPager);
        setTabIcon();
    }

    private void setupViewPager() {
        ViewPagerAdapter mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mAdapter.addFragment(new MainFragment(), getResources().getString(R.string.main_box));
        mAdapter.addFragment(new SpamFragment(), getResources().getString(R.string.spam_box));
        mViewPager.setAdapter(mAdapter);
    }

    private void setTabIcon(){
        int[] mTabIcons = {R.drawable.email, R.drawable.email_spam};
        mTabLayout.getTabAt(0).setIcon(mTabIcons[0]);
        mTabLayout.getTabAt(1).setIcon(mTabIcons[1]);
    }
}
