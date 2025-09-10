package com.example.sprouthelper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Mychange extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.my);

        ImageView homeoff,caloff,monoff,chatoff,myon;
        ImageButton mole;

        homeoff = findViewById(R.id.homeoff);
        caloff = findViewById(R.id.caloff);
        monoff = findViewById(R.id.monoff);
        chatoff = findViewById(R.id.chatoff);
        myon = findViewById(R.id.myon);
        mole = findViewById(R.id.mole);

        mole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mychange.this, My.class);
                startActivity(intent);
            }
        });

        //하단바 아이콘 이동설정
        homeoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mychange.this, Login_page.class);
                startActivity(intent);
            }
        });
        caloff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mychange.this, Calendar.class);
                startActivity(intent);
            }
        });
        monoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mychange.this, Startmoney.class);
                startActivity(intent);
            }
        });
        chatoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mychange.this, Chat.class);
                startActivity(intent);
            }
        });
        myon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mychange.this, Mychange.class);
                startActivity(intent);
            }
        });


    }
}
