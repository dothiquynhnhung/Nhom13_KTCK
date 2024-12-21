package com.ktck124.lop124LTDD04.nhom13;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TrangChu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private ViewPager viewPager;
    private PhotoAdapter photoAdapter;
    private List<Photo> mListPhoto;
    private Timer timer;
    private SliderPhimAdapter slidephimAdapter;
    private ViewPager2 mViewPagerFilm;
    private List<Phim> mListPhim;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ImageView imgMenu;
    private Button btn_book;
    private TextView txt_Name, txt_Email;


    private void AnhXa(){
        viewPager = findViewById(R.id.viewPager);
        mViewPagerFilm = findViewById(R.id.viewPager_film);
        navigationView = findViewById(R.id.nav_view);
        imgMenu = findViewById(R.id.btnMenu);
        drawerLayout = findViewById(R.id.drawer_layout);
        txt_Name = findViewById(R.id.textView_Name);
        txt_Email = findViewById(R.id.textView_Email);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_trang_chu);

        AnhXa();

        mListPhoto = getListPhoto();

        photoAdapter = new PhotoAdapter(this, getListPhoto());
        viewPager.setAdapter(photoAdapter);
        photoAdapter = new PhotoAdapter(this, mListPhoto);

        mViewPagerFilm.setOffscreenPageLimit(3);
        mViewPagerFilm.setClipToPadding(false);
        mViewPagerFilm.setClipChildren(false);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(20));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });
        mViewPagerFilm.setPageTransformer(compositePageTransformer);

        mListPhim = getListPhim();
        SliderPhimAdapter sliderPhimAdapter = new SliderPhimAdapter(mListPhim);
        mViewPagerFilm.setAdapter(sliderPhimAdapter);

        autoSlideImages();

        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);


        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        return false;
    }

    private List<Phim> getListPhim() {
        List<Phim> list = new ArrayList<>();
        list.add(new Phim(R.drawable.doanhcongduoctoi));
        list.add(new Phim(R.drawable.hanhtrinhsolo));
        list.add(new Phim(R.drawable.lookback));
        list.add(new Phim(R.drawable.modomdom));
        list.add(new Phim(R.drawable.cam));
        list.add(new Phim(R.drawable.treuroiyeu));
        list.add(new Phim(R.drawable.robothoangda));
        list.add(new Phim(R.drawable.mada));
        list.add(new Phim(R.drawable.caubecaheo));
        list.add(new Phim(R.drawable.lamgiauvoima));

        return list;
    }


    private List<Photo> getListPhoto() {
        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.thobaymau));
        list.add(new Photo(R.drawable.ly));
        list.add(new Photo(R.drawable.khuyenmai));

        return list;
    }


    private void autoSlideImages(){
        if(mListPhoto == null || mListPhoto.isEmpty() || viewPager == null){
            return;
        }
        if(timer == null){
            timer = new Timer();
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPager.getCurrentItem();
                        int totalItem = mListPhoto.size() - 1;
                        if (currentItem < totalItem){
                            currentItem ++;
                            viewPager.setCurrentItem(currentItem);
                        }else {
                            viewPager.setCurrentItem(0);
                        }
                    }
                });
            }
        }, 500, 2000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer !=null){
            timer.cancel();
            timer = null;
        }
    }

}
