package com.example.sprouthelper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import eightbitlab.com.blurview.BlurView;

public class Calendar extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.calendar);

        ImageView homeoff, calon, monoff, chatoff, myoff;

        homeoff = findViewById(R.id.homeoff);
        calon = findViewById(R.id.calon);
        monoff = findViewById(R.id.monoff);
        chatoff = findViewById(R.id.chatoff);
        myoff = findViewById(R.id.myoff);

        Spinner spinner = findViewById(R.id.spinner);

        RecyclerView recyclerView = findViewById(R.id.calendarview);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 7));


        BlurView blurView = findViewById(R.id.blurView);

        ViewGroup rootView = findViewById(android.R.id.content); // 이렇게 바로 content 뷰 가져오기
        Drawable windowBackground = getWindow().getDecorView().getBackground();

        if (blurView != null) {
            blurView.setupWith(rootView)
                    .setFrameClearDrawable(windowBackground)
                    .setBlurRadius(20f)
                    .setOverlayColor(Color.parseColor("#66000000"));
            blurView.setVisibility(View.GONE);
        }

        blurView.setVisibility(View.GONE);


        String [] items = {"수입","지출","전체"};
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

                if (selected.equals("수입")) {
                } else if (selected.equals("지출")) {
                    Intent intent = new Intent(Calendar.this, Calout.class);
                    startActivity(intent);
                } else if (selected.equals("전체")) {
                    Intent intent = new Intent(Calendar.this, Calall.class);
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
            days.add(new DayData(0)); // ✅ 빈칸은 날짜만 0
        }

// 날짜 추가
        for (int d = 1; d <= daysInMonth; d++) {
            DayData dayData = new DayData(d);

            if (d == 8) dayData.addAmount(18100);
            if (d == 16) dayData.addAmount(18100);
            if (d == 17) dayData.addAmount(18100);


            days.add(dayData);
        }


        // 어댑터 붙이기
        CalendarAdapter adapter = new CalendarAdapter(days);
        recyclerView.setAdapter(adapter);


//하단바 아이콘 이동설정
        homeoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calendar.this, Login_page.class);
                startActivity(intent);
            }
        });
        calon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calendar.this, Calendar.class);
                startActivity(intent);
            }
        });
        monoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calendar.this, Startmoney.class);
                startActivity(intent);
            }
        });
        chatoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calendar.this, Chat.class);
                startActivity(intent);
            }
        });
        myoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calendar.this, My.class);
                startActivity(intent);
            }
        });


    }
}

// =======================
// 데이터 클래스
class DayData {
    int date;                // 날짜
    List<Integer> amounts;   // 여러 금액 저장

    DayData(int date) {
        this.date = date;
        this.amounts = new ArrayList<>();
    }

    void addAmount(int amount) {
        amounts.add(amount);
    }
}

// =======================
// 어댑터 클래스
class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder> {

    private List<DayData> dayList;

    CalendarAdapter(List<DayData> dayList) {
        this.dayList = dayList;
    }

    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.calendarday, parent, false);
        return new CalendarViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position) {
        DayData day = dayList.get(position);

        if (day.date == 0) { // 빈칸
            holder.tvDate.setText("");
            holder.tvAmount.setText("");
        } else {
            holder.tvDate.setText(String.valueOf(day.date));

            // 날짜 클릭 시 BlurView 보이기
            holder.itemView.setOnClickListener(v -> {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                BlurView blurView = activity.findViewById(R.id.blurView);
                if (blurView != null) blurView.setVisibility(View.VISIBLE);

                BottomSheetDialog dialog = new BottomSheetDialog(activity);
                View sheetView = activity.getLayoutInflater().inflate(R.layout.blurcal, null);
                dialog.setContentView(sheetView);

                // blurcal.xml 안의 TextView 설정
                TextView title = sheetView.findViewById(R.id.date);
                // 오늘 기준 년/월 가져오기
                java.util.Calendar cal = java.util.Calendar.getInstance();
                int year = cal.get(java.util.Calendar.YEAR);
                int month = cal.get(java.util.Calendar.MONTH); // 0=1월, 1=2월 ...

                // 선택된 날짜로 다시 설정
                cal.set(year, month, day.date);

                // 요일 가져오기
                int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK); // 1=일, 2=월, ... 7=토

                String[] weekDays = {"일요일", "월요일", "화요일", "수요일",
                        "목요일", "금요일", "토요일"};
                String weekDayStr = weekDays[dayOfWeek - 1];

                // TextView에 출력
                title.setText(day.date + "일 " + weekDayStr);
                // ✅ 내역 추가 버튼 클릭 처리
                View addBtn = sheetView.findViewById(R.id.plus);
                addBtn.setOnClickListener(v2 -> {
                    // BlurView 위에 또 다른 BottomSheetDialog 띄우거나
                    // 새로운 Activity/Fragment로 이동
                    Intent intent = new Intent(activity, Pluscal.class);
                    activity.startActivity(intent);

                    dialog.dismiss(); // 기존 다이얼로그 닫기
                });


                dialog.setOnDismissListener(d -> {
                    if (blurView != null) blurView.setVisibility(View.GONE);
                });

                dialog.show();
            });

            if (!day.amounts.isEmpty()) {
                SpannableStringBuilder ssb = new SpannableStringBuilder();
                DecimalFormat formatter = new DecimalFormat("#,###");

                for (int i = 0; i < day.amounts.size(); i++) {
                    int amt = day.amounts.get(i);
                    String amountStr = formatter.format(Math.abs(amt));

                    if (amt > 0) {
                        amountStr = "+" + amountStr;
                    } else {
                        amountStr = "-" + amountStr;
                    }

                    int start = ssb.length();
                    ssb.append(amountStr);

                    // 색상 적용 (+는 초록, -는 빨강)
                    int color = (amt > 0) ? Color.parseColor("#008000") : Color.parseColor("#FF0000");
                    ssb.setSpan(new ForegroundColorSpan(color),
                            start, start + amountStr.length(),
                            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                    // 줄바꿈 (마지막 줄 제외)
                    if (i < day.amounts.size() - 1) {
                        ssb.append("\n");
                    }
                }

                holder.tvAmount.setText(ssb);
            } else {
                holder.tvAmount.setText("");
            }
        }
    }



    @Override
    public int getItemCount() {
        return dayList.size();
    }

    static class CalendarViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate, tvAmount;

        CalendarViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvAmount = itemView.findViewById(R.id.tvAmount);
        }
    }

}



