package com.example.chongbaostore.ui.settings;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.chongbaostore.MainActivity;
import com.example.chongbaostore.R;
import com.example.chongbaostore.entity.data.Data;
import com.example.chongbaostore.ui.login.LoginActivity;

public class SettingsFragment extends Fragment {

    private View view;
    private Button loginout;
    private TextView name;
    private TextView phone;
    private ImageView head;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(view==null){
            view = inflater.inflate(R.layout.fragment_settings, container, false);
            info();
            loginout();
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        return view;
    }

    public void loginout(){
        loginout = view.findViewById(R.id.btn_loginout);
        loginout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public void info(){
        final Data app = (Data) getActivity().getApplication();
        name = view.findViewById(R.id.text_name);
        phone = view.findViewById(R.id.text_phone);
        head = view.findViewById(R.id.image_head);
        if (app.getFlag().equals("1")){
            Log.e("flag","1");
            name.setText("毛也");
            phone.setText("123456");
            head.setImageResource(R.drawable.dog);
        }
        if (app.getFlag().equals("2")){
            Log.e("flag","2");
            name.setText("玛利亚");
            phone.setText("456789");
            head.setImageResource(R.drawable.head);
        }
    }
}