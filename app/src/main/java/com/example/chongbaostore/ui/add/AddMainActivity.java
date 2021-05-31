package com.example.chongbaostore.ui.add;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.chongbaostore.MainActivity;
import com.example.chongbaostore.R;
import com.github.clans.fab.FloatingActionButton;
import com.gyf.immersionbar.ImmersionBar;

public class AddMainActivity extends AppCompatActivity {

    private FloatingActionButton addback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_main);

        ImmersionBar.with(this)
                .fitsSystemWindows(true)
                .transparentStatusBar()
                .statusBarDarkFont(true, 0.2f)
                .init();

        onclickevent();
    }

    //处理悬浮按钮的点击事件
    public void onclickevent(){
        addback = findViewById(R.id.add_back);
        addback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddMainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}