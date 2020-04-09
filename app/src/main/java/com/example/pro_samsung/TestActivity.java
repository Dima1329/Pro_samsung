package com.example.pro_samsung;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TestActivity extends AppCompatActivity {
    private TextView Ex_name,text1,text2,text3,text4;


    private List<Question> questions =new ArrayList<>();

    private int num_of_ex = 5;

    private int i = 0;
    String name;
    String sec_name;
    String school;
    String clas_s;
    private int num_of_corect_ans;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);

        Bundle arguments = getIntent().getExtras();
        assert arguments != null;
        name = Objects.requireNonNull(arguments.get("name")).toString();
        sec_name = Objects.requireNonNull(arguments.get("second_name")).toString();
        school = Objects.requireNonNull(arguments.get("school")).toString();
        clas_s = Objects.requireNonNull(arguments.get("clas_s")).toString();

        TextView TextStudent = findViewById(R.id.Name);
        TextStudent.setText("   Привет, "+name+" "+sec_name + " учащийся(яся) в школе " + school + " из класса " + clas_s +  "!");

        Ex_name =  findViewById(R.id.Ex_name);
        Button var1 = findViewById(R.id.var1);
        Button var2 = findViewById(R.id.var2);
        Button var3 = findViewById(R.id.var3);
        Button var4 = findViewById(R.id.var4);
        text1 = findViewById(R.id.Text1);
        text2 = findViewById(R.id.Text2);
        text3 = findViewById(R.id.Text3);
        text4 = findViewById(R.id.Text4);

        var1.setOnClickListener(onClickListener);
        var2.setOnClickListener(onClickListener2);
        var3.setOnClickListener(onClickListener3);
        var4.setOnClickListener(onClickListener4);

        questions.add(new Question("2 * 2 =","6","4","2","8",2));
        questions.add(new Question("12 / 2 =","2","12","6","4",3));
        questions.add(new Question("7 - 5 =","7","2","12","8",2));
        questions.add(new Question("2 + 2 =","2","0","4","674",3));
        questions.add(new Question("Math.pow(4, 2) == 4","False","True","What?","4",1));
        questions.add(new Question("Math.pow(4, 2) == 16","WTF","True","What?","False",4));
        questions.add(new Question("34 / 2 =","17","10","20","11",1));
        Collections.shuffle(questions);
        List<Question> all_questions = new ArrayList<>(questions);
        questions.clear();
        for (int j = 0; j < num_of_ex; j++) {
            questions.add(all_questions.get(j));
        }
        all_questions.clear();
        update_texts();

    }
    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(1==questions.get(i).getAnswer()){
               num_of_corect_ans++;
            }
            if(i==num_of_ex-1){
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
            if(2==questions.get(i).getAnswer()){
                num_of_corect_ans++;
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
            if(3==questions.get(i).getAnswer()){
                num_of_corect_ans++;
            }
            if(i==num_of_ex-1){
                show_result();
            }else {
                i++;
                update_texts();

            }
        }
    };
    private final View.OnClickListener onClickListener4 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(4==questions.get(i).getAnswer()){
                num_of_corect_ans++;
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

        if(num_of_corect_ans<2){
            num_of_corect_ans = 2;
        }
        Intent i = new Intent(TestActivity.this, ResultActivity.class);
        i.putExtra("name",name);
        i.putExtra("second_name",sec_name);
        i.putExtra("school",school);
        i.putExtra("clas_s",clas_s);
        i.putExtra("mark", num_of_corect_ans) ;
        startActivity(i);

    }
    private void update_texts() {
         text1.setText(questions.get(i).getVariant1()); text2.setText(questions.get(i).getVariant2()); text3.setText(questions.get(i).getVariant3()); text4.setText(questions.get(i).getVariant4());
        Ex_name.setText(questions.get(i).getQuestion());
    }
}