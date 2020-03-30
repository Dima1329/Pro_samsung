package com.example.pro_samsung;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestActivity extends AppCompatActivity {
    private TextView Ex_name;
    private Button var1;
    private Button var2;
    private Button var3;

    private List<Question> questions =new ArrayList<Question>();

    private int num_of_ex = 5;

    private int [] correct_answer_or_not = new  int [num_of_ex];
    private int i = 0;
    String name ;
    String sec_name;
    String school;
    String clas_s;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);

        Bundle arguments = getIntent().getExtras();
        name = arguments.get("name").toString();
        sec_name = arguments.get("second_name").toString();
        school = arguments.get("school").toString();
        clas_s = arguments.get("clas_s").toString();

        TextView TextStudent = findViewById(R.id.Name);
        TextStudent.setText("Привет, "+name+" "+sec_name + " учащийся(яся) в школе " + school + " из класса " + clas_s +  "!");

        Ex_name =  findViewById(R.id.Ex_name);
        var1 =  findViewById(R.id.var1);
        var2=  findViewById(R.id.var2);
        var3 =  findViewById(R.id.var3);

        var1.setOnClickListener(onClickListener);
        var2.setOnClickListener(onClickListener2);
        var3.setOnClickListener(onClickListener3);


        questions.add(new Question("2 * 2 =","6","4","2",2));
        questions.add(new Question("12 / 2 =","2","12","6",3));
        questions.add(new Question("7 - 5 =","7","2","12",2));
        questions.add(new Question("2 + 2 =","2","0","4",3));
        questions.add(new Question("Math.pow(4, 2) == 4","False","True","What?",1));
        Collections.shuffle(questions);

        update_texts();

    }
    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(1 == questions.get(i).getAnswer()){
                correct_answer_or_not[i] = 1;
            }
            if(i==num_of_ex-1){
                //Ex_name.setText(String.valueOf(show_result()));
                show_result();
            }else {
                i++;
                update_texts();
            }

        }
    };
    private final View.OnClickListener onClickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(2 == questions.get(i).getAnswer()){
                correct_answer_or_not[i] = 1;
            }
            if(i==num_of_ex-1){
                show_result();
            }else {
                i++;
                update_texts();

            }
        }
    };
    private final View.OnClickListener onClickListener3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(3 == questions.get(i).getAnswer()){
                correct_answer_or_not[i] = 1;
            }
            if(i==num_of_ex-1){
                show_result();
            }else {
                i++;
                update_texts();

            }
        }
    };
    private void show_result() {
        int num_of_cor_ansver = 0;
        for (int i = 0; i < num_of_ex; i++) {
            if (correct_answer_or_not[i] == 1) {
                num_of_cor_ansver++;
            }
        }
        if(num_of_cor_ansver<2){
            num_of_cor_ansver = 2;
        }
        Intent i = new Intent(TestActivity.this, ResultActivity.class);
        i.putExtra("name",name);
        i.putExtra("second_name",sec_name);
        i.putExtra("school",school);
        i.putExtra("clas_s",clas_s);
        i.putExtra("mark", num_of_cor_ansver) ;
        startActivity(i);

    }
    private void update_texts() {
        Ex_name.setText(questions.get(i).getQuestion());
        var1.setText(questions.get(i).getVariant1());
        var2.setText(questions.get(i).getVariant2());
        var3.setText(questions.get(i).getVariant3());
    }
}