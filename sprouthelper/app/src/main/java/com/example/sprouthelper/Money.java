package com.example.sprouthelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Money extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.money);

        ImageView homeoff,caloff,monon,chatoff,myoff;
        ImageButton btnMole,btnMori,btn,mission,tip;


        btnMole = findViewById(R.id.btnMole);
        btnMori = findViewById(R.id.btnMori);
        btn = findViewById(R.id.btn);
        mission = findViewById(R.id.mission);
        tip = findViewById(R.id.tip);
        homeoff = findViewById(R.id.homeoff);
        caloff = findViewById(R.id.caloff);
        monon = findViewById(R.id.monon);
        chatoff = findViewById(R.id.chatoff);
        myoff = findViewById(R.id.myoff);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Money.this, Startmoney.class);
                startActivity(intent);
            }
        });
        mission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Money.this, Mission.class);
                startActivity(intent);
            }
        });
        tip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Money.this,Tip.class);
                startActivity(intent);
            }
        });

        //하단바 아이콘 이동설정
        homeoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Money.this, Login_page.class);
                startActivity(intent);
            }
        });
        caloff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Money.this, Calendar.class);
                startActivity(intent);
            }
        });
        monon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Money.this, Startmoney.class);
                startActivity(intent);
            }
        });
        chatoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Money.this, Chat.class);
                startActivity(intent);
            }
        });
        myoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Money.this, My.class);
                startActivity(intent);
            }


        });


    }
}
