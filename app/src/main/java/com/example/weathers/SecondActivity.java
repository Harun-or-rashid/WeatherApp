package com.example.weathers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    List<ImagePojo> images;
     RecyclerView recycler;
    Context context;
    private ImageAdapter imgadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        images=new ArrayList<>();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        recycler=(RecyclerView) findViewById(R.id.recycle);
        imgadapter=new ImageAdapter(images,context);
        recycler.setAdapter(imgadapter);

        ImagePojo img=new ImagePojo(R.drawable.ic_beach_sunset);
        images.add(img);
        ImagePojo imgs=new ImagePojo(R.drawable.ic_ph_sunset);
        images.add(imgs);
        ImagePojo imgse=new ImagePojo(R.drawable.ic_sunrise);
        images.add(imgse);
        ImagePojo imgss=new ImagePojo(R.drawable.ic_sunset);
        images.add(imgss);
        ImagePojo imgser=new ImagePojo(R.drawable.ic_sunrise);
        images.add(imgser);
        ImagePojo imgt=new ImagePojo(R.drawable.ic_sunrise_pink);
        images.add(imgt);
    }
}
