package com.example.pro_samsung;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText e_name,e_second_name,e_school,e_clas_s;
    public String name,second_name,school,clas_s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start = findViewById(R.id.var3);
        e_name = findViewById(R.id.name);
        e_second_name = findViewById(R.id.sec_name);
        e_school = findViewById(R.id.school);
        
        e_clas_s = findViewById(R.id.clas_s);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = e_name.getText().toString();
                second_name = e_second_name.getText().toString();
                school = e_school.getText().toString();
                clas_s = e_clas_s.getText().toString();
                if(name.isEmpty() || second_name.isEmpty() || school.isEmpty() || clas_s.isEmpty()||name.equals("Имя")||second_name.equals("Фамилия")||school.equals("Школа(номер/название)")||clas_s.equals("Класс(номер, буква)")){
                   Toast.makeText(getApplicationContext(), "Заполните/измените все поля!!!", Toast.LENGTH_SHORT).show();

                }else {
                    Intent i = new Intent(MainActivity.this, TestActivity.class);
                    i.putExtra("name",name);
                    i.putExtra("second_name",second_name);
                    i.putExtra("school",school);
                    i.putExtra("clas_s",clas_s);

                    startActivity(i);
                }

            }
        });



    }

    public String getName() {
        return name;
    }

    public String getSecond_name() {
        return second_name;
    }
}