package com.example.sprouthelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Available extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.available);

        ImageView homeon,caloff,monoff,chatoff,myoff;
        ImageButton mole;
        TextView up;

        mole = findViewById(R.id.mole);
        homeon = findViewById(R.id.homeon);
        caloff = findViewById(R.id.caloff);
        monoff = findViewById(R.id.monoff);
        chatoff = findViewById(R.id.chatoff);
        myoff = findViewById(R.id.myoff);
        up = findViewById(R.id.up);

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Available.this, Availableup.class);
                startActivity(intent);
            }
        });

        mole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Available.this, Login_page.class);
                startActivity(intent);
            }
        });

        //하단바 아이콘 이동설정
        homeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Available.this, Login_page.class);
                startActivity(intent);
            }
        });
        caloff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Available.this, Calendar.class);
                startActivity(intent);
            }
        });
        monoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Available.this, Startmoney.class);
                startActivity(intent);
            }
        });
        chatoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Available.this, Chat.class);
                startActivity(intent);
            }
        });
        myoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Available.this, My.class);
                startActivity(intent);
            }
        });
    }
}
