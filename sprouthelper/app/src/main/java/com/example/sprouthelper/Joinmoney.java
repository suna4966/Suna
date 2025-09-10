package com.example.sprouthelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Joinmoney extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.joinmoney);

        ImageButton monbtnle,monbtnri,monset,monbtn;
        ImageView homeoff,caloff,monon,chatoff,myoff;

        monbtnle = findViewById(R.id.monbtnle);
        monbtnri = findViewById(R.id.monbtnri);
        monset = findViewById(R.id.monset);
        monbtn = findViewById(R.id.monbtn);
        homeoff = findViewById(R.id.homeoff);
        caloff = findViewById(R.id.caloff);
        monon = findViewById(R.id.monon);
        chatoff = findViewById(R.id.chatoff);
        myoff = findViewById(R.id.myoff);

        //예산카테고리 이동
        monset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Joinmoney.this,Moneycategroy.class);
                startActivity(intent);
            }
        });
        //예산,소비패턴 이동버튼
        monbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Joinmoney.this,Money.class);
                startActivity(intent);
            }
        });

        //하단바 아이콘 이동설정
        homeoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Joinmoney.this, Login_page.class);
                startActivity(intent);
            }
        });
        caloff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Joinmoney.this, Calendar.class);
                startActivity(intent);
            }
        });
        monon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Joinmoney.this, Startmoney.class);
                startActivity(intent);
            }
        });
        chatoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Joinmoney.this, Chat.class);
                startActivity(intent);
            }
        });
        myoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Joinmoney.this, My.class);
                startActivity(intent);
            }

        });

    }
}
