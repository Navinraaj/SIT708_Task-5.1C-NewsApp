package com.example.sit708_task_51c_newsapp;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class singleNewsFragment extends Fragment implements View.OnClickListener{
    TextView singleTitle,descriptionSingle;
    ImageView imageViewSingle,backBTN;
    String title, desc;
    int image;
    LinearLayout layout;
    public singleNewsFragment(String title, String desc, int image) {
        this.title = title;
        this.desc  = desc;
        this.image = image;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_single_news, container, false);
        view.setBackgroundColor(Color.WHITE);
        singleTitle = view.findViewById(R.id.singleTitle);
        descriptionSingle = view.findViewById(R.id.descriptionSingle);
        imageViewSingle = view.findViewById(R.id.imageViewSingle);
//        layout = (LinearLayout) view.findViewById(R.id.singleNewsLayout);

        singleTitle.setText(title);
        descriptionSingle.setText(desc);
        imageViewSingle.setImageResource(image);
        backBTN = view.findViewById(R.id.backButton);
        backBTN.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        Log.v("dssd","dss");
        getActivity().onBackPressed();
    }
}