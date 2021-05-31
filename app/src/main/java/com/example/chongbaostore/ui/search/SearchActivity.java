package com.example.chongbaostore.ui.search;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chongbaostore.MainActivity;
import com.example.chongbaostore.R;
import com.example.chongbaostore.entity.data.Data;
import com.example.chongbaostore.ui.goods.GoodsFragment;
import com.github.clans.fab.FloatingActionButton;
import com.gyf.immersionbar.ImmersionBar;

import java.lang.reflect.Field;

public class SearchActivity extends AppCompatActivity {

    private FloatingActionButton back;
    private Button search;
    private EditText input;
//    private TextView searchname;
//    private TextView searchprice;
//    private ImageView searchimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ImmersionBar.with(this)
                .fitsSystemWindows(true)
                .transparentStatusBar()
                .statusBarDarkFont(true, 0.2f)
                .init();
        onclickevent();

        search = findViewById(R.id.search);
        input = findViewById(R.id.search_input);
//        searchname = findViewById(R.id.search_name);
//        searchprice = findViewById(R.id.search_price);
//        searchimg = findViewById(R.id.search_img);
        searchGoods();
    }

    //处理悬浮按钮的点击事件
    public void onclickevent(){
        back = findViewById(R.id.serch_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    //处理搜索按钮的点击事件
    public void searchGoods(){
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = input.getText().toString();
                final Data app = (Data)getApplication();
                for (int i=0;i<app.getGoodsList2().size();i++){
                    if (app.getGoodsList2().get(i).getName().equals(name)){
//                        searchname.setText(app.getGoodsList2().get(i).getName());
//                        searchprice.setText(app.getGoodsList2().get(i).getPrice());
//                        searchimg.setImageResource(app.getGoodsList2().get(i).getPhoto());
                        Log.e("名字",app.getGoodsList2().get(i).getName());
                    }
                }
            }
        });
    }
}