package com.example.graduationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.graduationproject.Kids_A7adith.Kids_Activity;
import com.example.graduationproject.A7adith_levels.Levels_Activity;

public class MainActivity extends AppCompatActivity {
Button btn_test;
Button btn_kids;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_test = findViewById(R.id.btn_test);
        btn_kids = findViewById(R.id.btn_kids);
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Levels_Activity.class);
                startActivity(i);
            }
        });
        btn_kids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Kids_Activity.class);
                startActivity(i);
            }
        });

        
    }
}