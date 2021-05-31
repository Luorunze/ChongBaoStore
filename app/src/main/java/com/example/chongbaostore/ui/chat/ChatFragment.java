package com.example.chongbaostore.ui.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.chongbaostore.R;

public class ChatFragment extends Fragment implements View.OnClickListener{

    private View view;
    private WebView webView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(view==null){
            view = inflater.inflate(R.layout.chat_dashboard, container, false);
            inittianqi();
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        return view;
    }

    public void inittianqi(){
        webView=view.findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.weather.com.cn");

        Button bj=view.findViewById(R.id.bj);
        bj.setOnClickListener(this);

        Button sh=view.findViewById(R.id.sh);
        sh.setOnClickListener(this);

        Button heb=view.findViewById(R.id.heb);
        heb.setOnClickListener(this);

        Button cc=view.findViewById(R.id.cc);
        cc.setOnClickListener(this);

        Button sy=view.findViewById(R.id.sy);
        sy.setOnClickListener(this);

        Button gz=view.findViewById(R.id.gz);
        gz.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.bj:
                openUrl("101010100");
                break;

            case R.id.sh:
                openUrl("101020100");
                break;

            case R.id.heb:
                openUrl("101050101");
                break;

            case R.id.cc:
                openUrl("101060101");
                break;

            case R.id.sy:
                openUrl("101070101");
                break;

            case R.id.gz:
                openUrl("101280101");
                break;
        }
    }

    private void openUrl(String id){
        webView.loadUrl("http://m.weather.com.cn/mweather/"+id+".shtml");
    }
}