package com.example.pw;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);


        ImageView imageView = findViewById(R.id.image);
        TextView sub = findViewById(R.id.subject);
        TextView name = findViewById(R.id.name);
        TextView qual = findViewById(R.id.qualification);

        Bundle bundle = getIntent().getExtras();

        String mName = bundle.getString("name");
        String mImage = bundle.getString("image");
        String mQual = bundle.getString("qualification");
        String mSub = bundle.getString("subject");

        Glide.with(this).load(mImage).into(imageView);
        sub.setText(mSub);
        name.setText(mName);
        qual.setText(mQual);

    }
}