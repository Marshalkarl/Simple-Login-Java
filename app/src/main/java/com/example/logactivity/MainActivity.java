package com.example.logactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bttig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bttig = findViewById(R.id.menu_pro);
        bttig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bttig.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, EmploiDuTempsActivity2.class);
                        MainActivity.this.startActivity(intent);
                    }
                });
            }
        });

    }
}