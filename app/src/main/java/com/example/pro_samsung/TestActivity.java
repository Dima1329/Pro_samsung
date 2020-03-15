package com.example.pro_samsung;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {
    private TextView Ex_name;
    private Button var1;
    private Button var2;
    private Button var3;
    private TextView text;

    private int num_of_ex = 5;
    private String [] ex_name = {"2 * 2 =", "12 / 2 =", "7 - 5 =", "2 + 2 =", "Math.pow(4, 2) == 4"};
    private String [] ex_answer1 = {"6", "2", "7","2","False"};
    private String [] ex_answer2 = {"4", "12", "2","0","True"};
    private String [] ex_answer3 =  {"2","6","12","4","What?"};
    private int [] ex_correct_answer = {2, 3,2,3,1};
    private int [] correct_answer_or_not = new  int [num_of_ex];
    private int i = 0;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.test_layout);
        Bundle arguments = getIntent().getExtras();
        String name = arguments.get("name").toString();
        String sec_name = arguments.get("second_name").toString();
        String school = arguments.get("school").toString();
        String clas_s = arguments.get("clas_s").toString();

        TextView TextStudent = findViewById(R.id.Name);
        TextStudent.setText("Привет, "+name+" "+sec_name + " учащийся(яся) в школе " + school + " из класса " + clas_s +  "!");
        Ex_name =  findViewById(R.id.Ex_name);
        text = findViewById(R.id.text);
        var1 =  findViewById(R.id.var1);
        var2=  findViewById(R.id.var2);
        var3 =  findViewById(R.id.var3);

        var1.setOnClickListener(onClickListener);
        var2.setOnClickListener(onClickListener2);
        var3.setOnClickListener(onClickListener3);

        Ex_name.setText(ex_name [i]);
        var1.setText(ex_answer1 [i]);
        var2.setText(ex_answer2[i]);
        var3.setText(ex_answer3[i]);
        text.setVisibility(View.INVISIBLE);



    }
    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(1 == ex_correct_answer[i]){
                correct_answer_or_not[i] = 1;
            }
            if(i==num_of_ex-1){
                //Ex_name.setText(String.valueOf(show_result()));
                show_result();
            }else {
                i++;
                Ex_name.setText(ex_name [i]);
                var1.setText(ex_answer1 [i]);
                var2.setText(ex_answer2[i]);
                var3.setText(ex_answer3[i]);
            }

        }
    };
    private final View.OnClickListener onClickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(2 == ex_correct_answer[i]){
                correct_answer_or_not[i] = 1;
            }
            if(i==num_of_ex-1){
                show_result();
            }else {
                i++;
                Ex_name.setText(ex_name [i]);
                var1.setText(ex_answer1 [i]);
                var2.setText(ex_answer2[i]);
                var3.setText(ex_answer3[i]);
            }
        }
    };
    private final View.OnClickListener onClickListener3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(3 == ex_correct_answer[i]){
                correct_answer_or_not[i] = 1;
            }
            if(i==num_of_ex-1){
                show_result();
            }else {
                i++;
                Ex_name.setText(ex_name [i]);
                var1.setText(ex_answer1 [i]);
                var2.setText(ex_answer2[i]);
                var3.setText(ex_answer3[i]);
            }
        }
    };
    private void show_result() {
        int num_of_cor_ansver = 0;
        var1.setVisibility(View.INVISIBLE);
        var2.setVisibility(View.INVISIBLE);
        var3.setVisibility(View.INVISIBLE);
        for (int i = 0; i < num_of_ex; i++) {
            if (correct_answer_or_not[i] == 1) {
                num_of_cor_ansver++;
            }
        }
        Ex_name.setText("Твоя оценка " + String.valueOf(num_of_cor_ansver));

    }
}