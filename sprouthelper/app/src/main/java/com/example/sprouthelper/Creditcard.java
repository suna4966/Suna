package com.example.sprouthelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Creditcard extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.creditcard);

        TextView checkcard;
        ImageView homeon,caloff,monoff,chatoff,myoff;

        checkcard = findViewById(R.id.checkcard);
        homeon = findViewById(R.id.homeon);
        caloff = findViewById(R.id.caloff);
        monoff = findViewById(R.id.monoff);
        chatoff = findViewById(R.id.chatoff);
        myoff = findViewById(R.id.myoff);

        //신용카드->체크카드
        checkcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Creditcard.this, Checkcard.class);
                startActivity(intent);
            }
        });

        //하단바 아이콘 이동설정
        homeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Creditcard.this, Login_page.class);
                startActivity(intent);
            }
        });
        caloff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Creditcard.this, Calendar.class);
                startActivity(intent);
            }
        });
        monoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Creditcard.this, Startmoney.class);
                startActivity(intent);
            }
        });
        chatoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Creditcard.this, Chat.class);
                startActivity(intent);
            }
        });
        myoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Creditcard.this, My.class);
                startActivity(intent);
            }
        });


    }
}
