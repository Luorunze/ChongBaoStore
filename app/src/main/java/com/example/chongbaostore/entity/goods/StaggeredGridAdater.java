package com.example.chongbaostore.entity.goods;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.chongbaostore.R;

import java.util.ArrayList;
import java.util.List;

public class StaggeredGridAdater extends RecyclerView.Adapter<StaggeredGridAdater.HomeViewHolder> {


    private Context mContext;
    private List<Goods> homeList = new ArrayList<>();

    public StaggeredGridAdater(Context context,List<Goods> homeList){

        this.mContext = context;
        this.homeList = homeList;
    }

    //创建列表组件
    @NonNull
    @Override
    public StaggeredGridAdater.HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item,null);
        return new StaggeredGridAdater.HomeViewHolder(view,this);
    }

    //绑定数据
    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {

        holder.imageIdIv.setImageResource(homeList.get(position).getPhoto());
        holder.nameTv.setText(homeList.get(position).getName());
        holder.priceTv.setText(homeList.get(position).getPrice());
    }

    //返回列表数据总数
    @Override
    public int getItemCount() {

        return homeList.size();
    }


    public class HomeViewHolder extends RecyclerView.ViewHolder{

        TextView nameTv;
        ImageView imageIdIv;
        TextView priceTv;
        private RecyclerView.Adapter adapter;
        public HomeViewHolder(@NonNull View itemView,RecyclerView.Adapter adapter) {

            super(itemView);
            this.nameTv = itemView.findViewById(R.id.name2222);
            this.imageIdIv = itemView.findViewById(R.id.home_item_mage);
            this.priceTv = itemView.findViewById(R.id.price2222);
            this.adapter = adapter;
        }
    }
}