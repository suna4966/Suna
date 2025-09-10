package com.example.sprouthelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Tip extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tip);

        ImageView homeoff,caloff,monon,chatoff,myoff;
        ImageButton mole,tipbtn;

        mole = findViewById(R.id.mole);
        tipbtn = findViewById(R.id.tipbtn);
        homeoff = findViewById(R.id.homeoff);
        caloff = findViewById(R.id.caloff);
        monon = findViewById(R.id.monon);
        chatoff = findViewById(R.id.chatoff);
        myoff = findViewById(R.id.myoff);

        mole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tip.this, Money.class);
                startActivity(intent);
            }
        });
        tipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tip.this,Mission.class);
                startActivity(intent);
            }
        });

        //하단바 아이콘 이동설정
        homeoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tip.this, Login_page.class);
                startActivity(intent);
            }
        });
        caloff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tip.this, Calendar.class);
                startActivity(intent);
            }
        });
        monon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tip.this, Startmoney.class);
                startActivity(intent);
            }
        });
        chatoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tip.this, Chat.class);
                startActivity(intent);
            }
        });
        myoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tip.this, My.class);
                startActivity(intent);
            }

        });
    }
}
