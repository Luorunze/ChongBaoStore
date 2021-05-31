package com.example.chongbaostore.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.chongbaostore.MainActivity;
import com.example.chongbaostore.R;
import com.example.chongbaostore.entity.data.Data;
import com.example.chongbaostore.ui.register.RegisterActivity;
import com.github.clans.fab.FloatingActionButton;
import com.gyf.immersionbar.ImmersionBar;
import com.xuexiang.xui.utils.StatusBarUtils;
import com.xuexiang.xui.widget.button.roundbutton.RoundButton;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Field;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText ed_name;
    private EditText ed_pwd;
    private FloatingActionButton jump;
    private RoundButton register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            try {
//                Class decorViewClazz = Class.forName("com.android.internal.policy.DecorView");
//                Field field = decorViewClazz.getDeclaredField("mSemiTransparentStatusBarColor");
//                field.setAccessible(true);
//                field.setInt(getWindow().getDecorView(), Color.TRANSPARENT);  //改为透明
//            } catch (Exception e) {
//            }
//        }
        setContentView(R.layout.activity_login);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        }
        ImmersionBar.with(this)
                .statusBarDarkFont(true, 0.2f)
                .init();

        LayoutInflater layoutInflater = this.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.fragment_settings,null);
        ed_name = findViewById(R.id.user_name);
        ed_pwd = findViewById(R.id.user_pwd);
        jump = findViewById(R.id.jump);
        register = findViewById(R.id.register);

        Jump();
        register();

    }

    //跳转
    public void Jump(){
        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Data app = (Data) getApplication();
                String name = ed_name.getText().toString();
                String pwd = ed_pwd.getText().toString();
                app.setUsername(name);
                app.setUserpwd(pwd);
                if (name.equals("123456")){
                    Log.e("name",name);
                    Log.e("pwd",pwd);
                    app.setFlag("1");
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                if (name.equals("456789")){
                    Log.e("name",name);
                    Log.e("pwd",pwd);
                    app.setFlag("2");
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void register(){
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}