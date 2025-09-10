package com.example.sprouthelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Login_page extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_page);

        ImageButton card,know,todout;
        ImageView homeon,caloff,monoff,chatoff,myoff;

        card = findViewById(R.id.card);
        know = findViewById(R.id.know);
        todout = findViewById(R.id.todout);
        homeon = findViewById(R.id.homeon);
        caloff = findViewById(R.id.caloff);
        monoff = findViewById(R.id.monoff);
        chatoff = findViewById(R.id.chatoff);
        myoff = findViewById(R.id.myoff);

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_page.this, Creditcard.class);
                startActivity(intent);
            }
        });
        know.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_page.this, Available.class);
                startActivity(intent);
            }
        });

        todout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_page.this, Todayout.class);
                startActivity(intent);
            }
        });

        //하단바 아이콘 이동설정
        homeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_page.this, Login_page.class);
                startActivity(intent);
            }
        });
        caloff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_page.this, Calendar.class);
                startActivity(intent);
            }
        });
        monoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_page.this, Startmoney.class);
                startActivity(intent);
            }
        });
        chatoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_page.this, Chat.class);
                startActivity(intent);
            }
        });
        myoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_page.this, My.class);
                startActivity(intent);
            }
        });


    }
}
