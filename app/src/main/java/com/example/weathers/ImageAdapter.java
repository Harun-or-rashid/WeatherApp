package com.example.weathers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.myHolder>{
    private List<ImagePojo> imgs;
    private Context context;

    public ImageAdapter(List<ImagePojo> imgs, Context context) {
        this.imgs = imgs;
        this.context = context;
    }



    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
       LayoutInflater layoutInflater=LayoutInflater.from(context);
       View views=layoutInflater.inflate(R.layout.image_layout,parent,false);
       myHolder myHolder=new myHolder(views);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
        ImagePojo image=imgs.get(position);
        ImageView images=holder.adpImg;
        images.setImageResource(image.getImage());

            
    }

    @Override
    public int getItemCount() {
        return imgs.size();
    }

    public class myHolder extends RecyclerView.ViewHolder {
        ImageView adpImg;

        public myHolder(@NonNull View itemView) {
            super(itemView);
            adpImg=(ImageView) itemView.findViewById(R.id.adaptImg);
        }
    }
}
