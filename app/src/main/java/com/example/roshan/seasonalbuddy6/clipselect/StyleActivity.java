package com.example.roshan.seasonalbuddy6.clipselect;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import com.example.roshan.seasonalbuddy6.R;

public class StyleActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    int[] tabIcons = {
            R.drawable.birthdy1,
            R.drawable.newyear4,
            R.drawable.wesak, R.drawable.xmas,R.drawable.valantine,R.drawable.pongal1,R.drawable.ramadan1
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style);

        //set custome size to the layout
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.7));

        toolbar=(android.support.v7.widget.Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new BirthDayFragment());
        viewPagerAdapter.addFragments(new NewYearFragment());
        viewPagerAdapter.addFragments(new WesakFragment());
        viewPagerAdapter.addFragments(new XmasFragment());
        viewPagerAdapter.addFragments(new ValantineFragment());
        viewPagerAdapter.addFragments(new PongalFragment());
        viewPagerAdapter.addFragments(new RamadanFragment());

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
        tabLayout.getTabAt(5).setIcon(tabIcons[5]);
        tabLayout.getTabAt(6).setIcon(tabIcons[6]);
    }

    public void getImgBitmap(Bitmap bmp){

           Intent in = new Intent();
        in.putExtra("key",bmp);
        setResult(RESULT_OK,in);
        finish();
    }

}
