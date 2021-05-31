package com.example.chongbaostore.ui.goods;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.constraintlayout.solver.Cache;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.chongbaostore.R;
import com.example.chongbaostore.adapter.goods.GoodsAdapter;
import com.example.chongbaostore.entity.data.Data;
import com.example.chongbaostore.entity.goods.Goods;
import com.example.chongbaostore.entity.goods.StaggeredGridAdater;
import com.example.chongbaostore.ui.add.AddMainActivity;
import com.example.chongbaostore.ui.search.SearchActivity;
import com.github.clans.fab.FloatingActionButton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GoodsFragment extends Fragment {
    private View view;
    private FloatingActionButton searchgoods;
    private FloatingActionButton addgoods;
    private List<Goods> homeList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(view==null){
            view = inflater.inflate(R.layout.fragment_goods, container, false);

            onclickevent();
            initGoods();
            addData();

        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        return view;
    }

    //处理悬浮按钮的点击事件
    public void onclickevent(){
        searchgoods = view.findViewById(R.id.searchgoods);
        searchgoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
        addgoods = view.findViewById(R.id.addgoods);
        addgoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), AddMainActivity.class);
                startActivity(intent);
            }
        });
    }

    //初始化recyclerView
    public void initGoods(){
        RecyclerView recyclerView = view.findViewById(R.id.goods_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        StaggeredGridAdater staggeredGridAdater = new StaggeredGridAdater(this.getActivity(),homeList);
        recyclerView.setAdapter(staggeredGridAdater);
    }
    //给recyclerView添加数据
    public void addData(){
        final Data app = (Data) getActivity().getApplication();
        if (app.getFlag().equals("1")){
            Log.e("flag","1");
            String[] names = new String[]{
                    "1","2","3","4","5","6","7","8","9","10","11","12"};
            int[] ImageId = new int[]{
                    R.drawable.petclothes,R.drawable.petfood,R.drawable.petfosten,R.drawable.petshop,R.drawable.petwash,R.drawable.petwash,R.drawable.petwash,R.drawable.petwash,R.drawable.petwash,R.drawable.petwash,R.drawable.petwash,R.drawable.petwash};
            String[] prices = new String[]{
                    "11","22","33","44","55","66","77","88","99","1010","1111","1212"
            };
            for(int i = 0 ;i < names.length ; i++){
                this.homeList.add(new Goods(prices[i],names[i],ImageId[i]));
            }
        }
        if (app.getFlag().equals("2")){
            Log.e("flag","2");
            String[] names = new String[]{
                    "车位查询","车位预定","与车间距"};
            int[] ImageId = new int[]{
                    R.drawable.petclothes,R.drawable.petfood,R.drawable.petfosten};
            String[] prices = new String[]{
                    "11","22","33"
            };
            for(int i = 0 ;i < names.length ; i++){
                this.homeList.add(new Goods(prices[i],names[i],ImageId[i]));
            }
        }
        app.setGoodsList2(homeList);
    }
}