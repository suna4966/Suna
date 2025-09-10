package com.example.sprouthelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class My extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.my);

        ImageView homeoff,caloff,monoff,chatoff,myon;
        TextView change;

        change = findViewById(R.id.change);
        homeoff = findViewById(R.id.homeoff);
        caloff = findViewById(R.id.caloff);
        monoff = findViewById(R.id.monoff);
        chatoff = findViewById(R.id.chatoff);
        myon = findViewById(R.id.myon);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(My.this, Mychange.class);
                startActivity(intent);
            }
        });

        //하단바 아이콘 이동설정
        homeoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(My.this, Login_page.class);
                startActivity(intent);
            }
        });
        caloff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(My.this, Calendar.class);
                startActivity(intent);
            }
        });
        monoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(My.this, Startmoney.class);
                startActivity(intent);
            }
        });
        chatoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(My.this, Chat.class);
                startActivity(intent);
            }
        });
        myon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(My.this, My.class);
                startActivity(intent);
            }
        });


    }
}
