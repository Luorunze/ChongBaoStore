package com.example.chongbaostore.adapter.goods;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chongbaostore.R;
import com.example.chongbaostore.entity.goods.Goods;

import java.util.List;

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.ViewHolder> {
    private List<Goods> mGoodsList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView goodsPhoto;
        TextView goodsName;
        TextView goodsPrice;

        public ViewHolder (View view)
        {
            super(view);
            goodsPhoto = view.findViewById(R.id.goods_photo);
            goodsName = view.findViewById(R.id.goods_name);
            goodsPrice = view.findViewById(R.id.goods_price);
        }

    }

    public GoodsAdapter(List<Goods> goodsList) {
        this.mGoodsList = goodsList;
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.goods_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){

        int photo = mGoodsList.get(position).getPhoto();
        String price = mGoodsList.get(position).getPrice();
        String name = mGoodsList.get(position).getName();
        holder.goodsPhoto.setImageResource(photo);
        holder.goodsName.setText(name);
        holder.goodsPrice.setText(""+price);
    }

    @Override
    public int getItemCount(){
        return mGoodsList.size();
    }
}
