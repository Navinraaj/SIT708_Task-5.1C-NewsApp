package com.example.newtasknews;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    RecyclerView HRecycler,VRecycler;
    RecyclerView.LayoutManager HlayoutManager,VlayoutManager;
    ArrayList<NewsModel> news;

    NewsAdaptor newsAdaptorHorizontal,newsAdaptorVertical;
    Boolean viewHorizontal = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HRecycler = findViewById(R.id.recyclerView);
        VRecycler = findViewById(R.id.recyclerViewVertical);

        HlayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        VlayoutManager = new LinearLayoutManager(this);
        news = new ArrayList<>();

        for (int i = 1;i <= 10; i++){
            populateNews(i);
        }
        newsAdaptorHorizontal = new NewsAdaptor(this,news,viewHorizontal);
        newsAdaptorVertical   = new NewsAdaptor(this,news,false);
        HRecycler.setAdapter(newsAdaptorHorizontal);
        VRecycler.setAdapter(newsAdaptorVertical);
        HRecycler.setLayoutManager(HlayoutManager);
        VRecycler.setLayoutManager(VlayoutManager);
    }

    public void populateNews(int num) {
        news.add(new NewsModel("testing"+num,"Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
                "\n" +
                "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.\n" +
                "\n"+num,R.drawable.news,true));
    }

    @Override
    public void onClick(View view) {

    }
}