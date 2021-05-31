package com.example.chongbaostore.ui.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chongbaostore.R;
import com.example.chongbaostore.ui.login.LoginActivity;
import com.github.clans.fab.FloatingActionButton;
import com.gyf.immersionbar.ImmersionBar;

public class RegisterActivity extends AppCompatActivity {

    private EditText username;
    private EditText pwd_one;
    private EditText pwd_two;
    private FloatingActionButton register_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);

        ImmersionBar.with(this)
                .fitsSystemWindows(true)
                .transparentStatusBar()
                .statusBarDarkFont(true, 0.2f)
                .init();

        username = findViewById(R.id.register_name);
        pwd_one = findViewById(R.id.register_pwd_one);
        pwd_two = findViewById(R.id.register_pwd_two);
        register_button = findViewById(R.id.register_button);

        RegisterUser();
        
    }

    public void RegisterUser(){

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = username.getText().toString();
                String pwd1 = pwd_one.getText().toString();
                String pwd2 = pwd_two.getText().toString();
                if (pwd1.equals(pwd2)){
                    Log.e("pwd1",pwd1);
                    Log.e("pwd2",pwd2);
                    Toast.makeText(getApplicationContext(), "默认的Toast", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
//                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "默认的Toast", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}