package com.example.sprouthelper;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import eightbitlab.com.blurview.BlurView;

public class Calall extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.calall);

        ImageView homeoff, calon, monoff, chatoff, myoff;

        homeoff = findViewById(R.id.homeoff);
        calon = findViewById(R.id.calon);
        monoff = findViewById(R.id.monoff);
        chatoff = findViewById(R.id.chatoff);
        myoff = findViewById(R.id.myoff);

        Spinner spinner = findViewById(R.id.spinner);

        RecyclerView recyclerView = findViewById(R.id.calendar);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 7));

        BlurView blurView = findViewById(R.id.blurView);
        ViewGroup rootView = findViewById(android.R.id.content);
        Drawable windowBackground = getWindow().getDecorView().getBackground();

        if (blurView != null) {
            blurView.setupWith(rootView)
                    .setFrameClearDrawable(windowBackground)
                    .setBlurRadius(20f)
                    .setOverlayColor(Color.parseColor("#66000000"));
            blurView.setVisibility(View.GONE);
        }


        String [] items = {"전체","수입","지출"};
        ArrayAdapter<String> spinneradapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item,items
        );
        //드롭다운 펼쳤을 때 모양
        spinneradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //스피너에 어댑터 연결
        spinner.setAdapter(spinneradapter);
        spinner.setSelection(0);

        //수입,지출,전체 페이지로 이동
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String selected = items[position];

                if (selected.equals("전체")) {
                } else if (selected.equals("수입")) {
                    Intent intent = new Intent(Calall.this, Calendar.class);
                    startActivity(intent);
                } else if (selected.equals("지출")) {
                    Intent intent = new Intent(Calall.this, Calout.class);
                    startActivity(intent);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        // 달력 데이터 만들기
        List<DayData> days = new ArrayList<>();

        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(java.util.Calendar.DAY_OF_MONTH, 1);

// 이번 달 1일이 무슨 요일인지 (일요일=1, 월요일=2, … 토요일=7)
        int startDayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK) - 1;

// 이번 달이 며칠까지 있는지
        int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

// 빈칸 추가
        for (int i = 0; i < startDayOfWeek; i++) {
            days.add(new DayData(0));
        }

// 날짜 추가
        for (int d = 1; d <= daysInMonth; d++) {
            DayData dayData = new DayData(d);

            if (d == 8) dayData.addAmount(18100);
            if (d == 7) dayData.addAmount(-18100);
            if (d == 17) {
                dayData.addAmount(18100);
                dayData.addAmount(-20100);
            }

            days.add(dayData);
        }


        // 어댑터 붙이기
        CalendarAdapter adapter = new CalendarAdapter(days);
        recyclerView.setAdapter(adapter);


        //하단바 아이콘 이동설정
        homeoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calall.this, Login_page.class);
                startActivity(intent);
            }
        });
        calon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calall.this, Calendar.class);
                startActivity(intent);
            }
        });
        monoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calall.this, Startmoney.class);
                startActivity(intent);
            }
        });
        chatoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calall.this, Chat.class);
                startActivity(intent);
            }
        });
        myoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calall.this, My.class);
                startActivity(intent);
            }
        });




    }
}
