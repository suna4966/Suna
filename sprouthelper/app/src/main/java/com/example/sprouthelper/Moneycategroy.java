package com.example.sprouthelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Moneycategroy extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.moneycategroy);

        ImageView homeoff,caloff,monon,chatoff,myoff;

        homeoff = findViewById(R.id.homeoff);
        caloff = findViewById(R.id.caloff);
        monon = findViewById(R.id.monon);
        chatoff = findViewById(R.id.chatoff);
        myoff = findViewById(R.id.myoff);

        //하단바 아이콘 이동설정
        homeoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Moneycategroy.this, Login_page.class);
                startActivity(intent);
            }
        });
        caloff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Moneycategroy.this, Calendar.class);
                startActivity(intent);
            }
        });
        monon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Moneycategroy.this, Startmoney.class);
                startActivity(intent);
            }
        });
        chatoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Moneycategroy.this, Chat.class);
                startActivity(intent);
            }
        });
        myoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Moneycategroy.this, My.class);
                startActivity(intent);
            }

        });
    }
}
