package com.example.tsaei;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class personalFinanceQuiz extends AppCompatActivity {

    ArrayList<String> questionList = new ArrayList<>();
    ArrayList<String> answerList = new ArrayList<>();
    ArrayList<String> wrong1List = new ArrayList<>();
    ArrayList<String> wrong2List = new ArrayList<>();
    ArrayList<String> wrong3List = new ArrayList<>();

    int pageNumber = 0;
    int correct = 0;
    int total = 37;
    boolean button1;
    boolean button2;
    boolean button3;
    boolean button4;
    private Button nextButton;
    private Button backButton;
    private Button optionB1;
    private Button optionB2;
    private Button optionB3;
    private Button optionB4;
    private Button begin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_finance_quiz);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);
        optionB1 = findViewById(R.id.option1);
        optionB2 = findViewById(R.id.option2);
        optionB3 = findViewById(R.id.option3);
        optionB4 = findViewById(R.id.option4);
        begin = findViewById(R.id.begin);

        TextView question = (TextView) findViewById(R.id.question);
        TextView selectedOptions = (TextView) findViewById(R.id.selectedOptions);

        TextView correctText = (TextView) findViewById(R.id.correct);
        correctText.setVisibility(View.GONE);
        optionB1.setVisibility(View.GONE);
        optionB2.setVisibility(View.GONE);
        optionB3.setVisibility(View.GONE);
        optionB4.setVisibility(View.GONE);
        selectedOptions.setVisibility(View.GONE);
        backButton.setVisibility(View.GONE);
        nextButton.setVisibility(View.GONE);
        question.setVisibility(View.GONE);
        get_json();

        optionB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedOptions.setText("Option 1 selected");

                button1 = true;
                button2 = false;
                button3 = false;
                button4 = false;
            }
        });
        optionB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedOptions.setText("Option 2 selected");

                button1 = false;
                button2 = true;
                button3 = false;
                button4 = false;
            }
        });
        optionB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedOptions.setText("Option 3 selected");

                button1 = false;
                button2 = false;
                button3 = true;
                button4 = false;
            }
        });
        optionB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedOptions.setText("Option 4 selected");

                button1 = false;
                button2 = false;
                button3 = false;
                button4 = true;
            }
        });

        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionB1.setVisibility(View.VISIBLE);
                optionB2.setVisibility(View.VISIBLE);
                optionB3.setVisibility(View.VISIBLE);
                optionB4.setVisibility(View.VISIBLE);
                selectedOptions.setVisibility(View.VISIBLE);
                backButton.setVisibility(View.VISIBLE);
                nextButton.setVisibility(View.VISIBLE);
                question.setVisibility(View.VISIBLE);
                begin.setVisibility(View.GONE);

                Random randNum = new Random();
                Set<Integer> set = new LinkedHashSet<Integer>();
                while (set.size() < 4) {
                    set.add(randNum.nextInt(4));
                }
                String a = answerList.get(pageNumber);
                String b = wrong1List.get(pageNumber);
                String c = wrong2List.get(pageNumber);
                String d = wrong3List.get(pageNumber);
                String[] options = new String[]{a, b, c, d};


                for (int i = 0; i < options.length; i++) {
                    int randomIndexToSwap = randNum.nextInt(options.length);
                    String temp = options[randomIndexToSwap];
                    options[randomIndexToSwap] = options[i];
                    options[i] = temp;
                }

                question.setText(questionList.get(pageNumber));
                optionB1.setText(options[0]);
                optionB2.setText(options[1]);
                optionB3.setText(options[2]);
                optionB4.setText(options[3]);
                pageNumber++;
                if (optionB1.getText().equals(answerList.get(pageNumber))) {
                    correct++;
                } else if (optionB2.getText().equals(answerList.get(pageNumber))) {
                    correct++;
                } else if (optionB3.getText().equals(answerList.get(pageNumber))) {
                    correct++;
                } else if (optionB4.getText().equals(answerList.get(pageNumber))) {
                    correct++;
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                // will have a starting screen before next button is pressed
                if (button1 || button2 || button3 || button4) {
                    next(pageNumber);
                } else {
                    Toast.makeText(getApplicationContext(), "No option selected", Toast.LENGTH_SHORT).show();
                }
            }

            public void next(int p) {
                if (p == 0) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 1) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 2) {

                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 3) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 4) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 5) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 6) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 7) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 8) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 9) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 10) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 11) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 12) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                }
                if (p == 13) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 14) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 15) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 16) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 17) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 18) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 19) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 20) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 21) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 22) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 23) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 24) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 25) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 26) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 27) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 28) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 29) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 30) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 31) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 32) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 33) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 34) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 35) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 36) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber++;
                    if (optionB1.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB2.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB3.getText().equals(answerList.get(p))) {
                        correct++;
                    } else if (optionB4.getText().equals(answerList.get(p))) {
                        correct++;
                    }
                } else if (p == 37) {
                    correctText.setVisibility(View.VISIBLE);
                    correctText.setText(" you got " + correct + "/" + total);
                    nextButton.setVisibility(View.GONE);
                    backButton.setVisibility(View.GONE);
                    selectedOptions.setVisibility(View.GONE);
                    optionB1.setVisibility(View.GONE);
                    optionB2.setVisibility(View.GONE);
                    optionB3.setVisibility(View.GONE);
                    optionB4.setVisibility(View.GONE);
                    question.setVisibility(View.GONE);

                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                // will have a starting screen before next button is pressed
                back(pageNumber - 1);
            }

            public void back(int p) {
                if (p == 36) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 35) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 34) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 33) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 32) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 31) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 30) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 29) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 28) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 27) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 26) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 25) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 24) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 23) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 22) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 21) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 20) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 19) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 18) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 17) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 16) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 15) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 14) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 13) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 12) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 11) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 10) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 9) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 8) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 7) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 6) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 5) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 4) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 3) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 2) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else if (p == 1) {
                    Random randNum = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() < 4) {
                        set.add(randNum.nextInt(4));
                    }
                    String a = answerList.get(p);
                    String b = wrong1List.get(p);
                    String c = wrong2List.get(p);
                    String d = wrong3List.get(p);
                    String[] options = new String[]{a, b, c, d};


                    for (int i = 0; i < options.length; i++) {
                        int randomIndexToSwap = randNum.nextInt(options.length);
                        String temp = options[randomIndexToSwap];
                        options[randomIndexToSwap] = options[i];
                        options[i] = temp;
                    }

                    question.setText(questionList.get(p));
                    optionB1.setText(options[0]);
                    optionB2.setText(options[1]);
                    optionB3.setText(options[2]);
                    optionB4.setText(options[3]);
                    pageNumber--;
                    if (correct == 0) {
                        correct = 0;
                    } else {
                        correct--;
                    }
                    question.setText(questionList.get(p - 1));
                    optionB2.setText(answerList.get(p - 1));
                    optionB3.setText(wrong1List.get(p - 1));
                    optionB4.setText(wrong2List.get(p - 1));
                    optionB1.setText(wrong3List.get(p - 1));
                    pageNumber--;
                } else {
                    Toast.makeText(getApplicationContext(), "No previous content", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void get_json() {
        String json;
        try {
            InputStream is = getAssets().open("personalfinancequestions.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            // question list
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                if (obj.getString("id").equals("1")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("2")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("3")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("4")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("5")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("6")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("7")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("8")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("9")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("10")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("11")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("12")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("13")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("14")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("15")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("16")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("17")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("18")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("19")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("20")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("21")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("22")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("23")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("24")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("25")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("26")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("27")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("28")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("29")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("30")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("31")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("32")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("33")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("34")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("35")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("36")) {
                    questionList.add(obj.getString("question"));
                } else if (obj.getString("id").equals("37")) {
                    questionList.add(obj.getString("question"));
                }
            }

            // answer list
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                if (obj.getString("id").equals("1")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("2")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("3")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("4")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("5")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("6")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("7")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("8")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("9")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("10")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("11")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("12")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("13")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("14")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("15")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("16")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("17")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("18")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("19")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("20")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("21")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("22")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("23")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("24")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("25")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("26")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("27")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("28")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("29")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("30")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("31")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("32")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("33")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("34")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("35")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("36")) {
                    answerList.add(obj.getString("answer"));
                } else if (obj.getString("id").equals("37")) {
                    answerList.add(obj.getString("answer"));
                }
            }

            //wrong list 1
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                if (obj.getString("id").equals("1")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("2")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("3")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("4")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("5")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("6")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("7")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("8")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("9")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("10")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("11")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("12")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("13")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("14")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("15")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("16")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("17")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("18")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("19")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("20")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("21")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("22")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("23")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("24")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("25")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("26")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("27")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("28")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("29")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("30")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("31")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("32")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("33")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("34")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("35")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("36")) {
                    wrong1List.add(obj.getString("wrong1"));
                } else if (obj.getString("id").equals("37")) {
                    wrong1List.add(obj.getString("wrong1"));
                }
            }

            //wrong list 2
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                if (obj.getString("id").equals("1")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("2")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("3")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("4")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("5")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("6")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("7")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("8")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("9")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("10")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("11")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("12")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("13")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("14")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("15")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("16")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("17")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("18")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("19")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("20")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("21")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("22")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("23")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("24")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("25")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("26")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("27")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("28")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("29")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("30")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("31")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("32")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("33")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("34")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("35")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("36")) {
                    wrong2List.add(obj.getString("wrong2"));
                } else if (obj.getString("id").equals("37")) {
                    wrong2List.add(obj.getString("wrong2"));
                }

            }

            //wrong list 3
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                if (obj.getString("id").equals("1")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("2")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("3")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("4")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("5")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("6")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("7")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("8")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("9")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("10")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("11")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("12")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("13")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("14")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("15")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("16")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("17")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("18")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("19")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("20")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("21")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("22")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("23")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("24")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("25")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("26")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("27")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("28")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("29")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("30")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("31")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("32")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("33")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("34")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("35")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("36")) {
                    wrong3List.add(obj.getString("wrong3"));
                } else if (obj.getString("id").equals("37")) {
                    wrong3List.add(obj.getString("wrong3"));
                }
            }

        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }

    }
}