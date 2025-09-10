package com.example.sprouthelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Joinpage extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.joinpage);

        EditText id,password,checkpassword,num;
        ImageButton mole,check,numcheck;

        id = findViewById(R.id.id);
        password = findViewById(R.id.password);
        checkpassword = findViewById(R.id.checkpassword);
        num = findViewById(R.id.num);
        mole = findViewById(R.id.mole);
        check = findViewById(R.id.check);
        numcheck = findViewById(R.id.numcheck);

        mole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Joinpage.this,Login.class);
                startActivity(intent);
            }
        });

    }
}
