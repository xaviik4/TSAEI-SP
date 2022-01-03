package com.example.tsaei;

import androidx.appcompat.app.AppCompatActivity;

//import android.content.Intent;
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

public class topic1 extends AppCompatActivity {

    ArrayList<String> numberlist = new ArrayList<>();

    private Button nextButton;
    private Button backButton;
    int pageNumber = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic1);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);
        TextView name = (TextView)findViewById(R.id.name);
        get_json();


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                // will have a starting screen before next button is pressed
                next(pageNumber);

            }

            public void next(int p) {

                if (p == 0) {
                    name.setText(numberlist.get(0));
                    pageNumber++;
                    //hide back button
                }
                else if (p == 1) {
                    name.setText(numberlist.get(1));
                    pageNumber++;
                }
                else if (p == 2) {
                    name.setText(numberlist.get(2));
                    pageNumber++;
                }
                else if (p == 3) {
                    name.setText(numberlist.get(3));
                    pageNumber++;
                }
                else if (p == 4) {
                    name.setText(numberlist.get(4));
                    pageNumber++;
                }
                else if (p == 5) {
                    name.setText(numberlist.get(5));
                    pageNumber++;
                }else if (p == 6) {
                    name.setText(numberlist.get(6));
                    pageNumber++;
                }
                else if (p == 7) {
                    name.setText(numberlist.get(7));
                    pageNumber++;
                }
                else if (p == 8) {
                    name.setText(numberlist.get(8));
                    pageNumber++;
                }
                else if (p == 9) {
                    name.setText(numberlist.get(9));
                    pageNumber++;
                }
                else if (p == 10) {
                    name.setText(numberlist.get(10));
                    pageNumber++;
                }
                else if (p == 11) {
                    name.setText(numberlist.get(11));
                    pageNumber++;
                }
                else if (p == 12) {
                    name.setText(numberlist.get(12));
                    pageNumber++;
                }
                else if (p == 13) {
                    name.setText(numberlist.get(13));
                    pageNumber++;
                }
                else if (p == 14) {
                    name.setText(numberlist.get(14));
                    pageNumber++;
                }
                else if (p == 15) {
                    name.setText(numberlist.get(15));
                    pageNumber++;
                }
                else if (p == 16) {
                    name.setText(numberlist.get(16));
                    pageNumber++;
                }
                else if (p == 17) {
                    name.setText(numberlist.get(17));
                }
                else {
                    Toast.makeText(getApplicationContext(), "ERROR",Toast.LENGTH_LONG).show();
                }
            }
        });

       backButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                // will have a starting screen before next button is pressed
                back(pageNumber);

            }

           public void back(int p) {
               if (p == 17) {
                   name.setText(numberlist.get(16));
                   pageNumber--;
               }
               else if (p == 16) {
                   name.setText(numberlist.get(15));
                   pageNumber--;
               }
               else if (p == 15) {
                   name.setText(numberlist.get(14));
                   pageNumber--;
               }
               else if (p == 14) {
                   name.setText(numberlist.get(13));
                   pageNumber--;
               }
               else if (p == 13) {
                   name.setText(numberlist.get(12));
                   pageNumber--;
               }else if (p == 12) {
                   name.setText(numberlist.get(11));
                   pageNumber--;
               }
               else if (p == 11) {
                   name.setText(numberlist.get(10));
                   pageNumber--;
               }
               else if (p == 10) {
                   name.setText(numberlist.get(9));
                   pageNumber--;
               }
               else if (p == 9) {
                   name.setText(numberlist.get(8));
                   pageNumber--;
               }
               else if (p == 8) {
                   name.setText(numberlist.get(7));
                   pageNumber--;
               }
               else if (p == 7) {
                   name.setText(numberlist.get(6));
                   pageNumber--;
               }
               else if (p == 6) {
                   name.setText(numberlist.get(5));
                   pageNumber--;
               }
               else if (p == 5) {
                   name.setText(numberlist.get(4));
                   pageNumber--;
               }
               else if (p == 4) {
                   name.setText(numberlist.get(3));
                   pageNumber--;
               }
               else if (p == 3) {
                   name.setText(numberlist.get(2));
                   pageNumber--;
               }
               else if (p == 2) {
                   name.setText(numberlist.get(1));
                   pageNumber--;
               }
               else if (p == 1) {
                   name.setText(numberlist.get(0));
                   pageNumber--;
                   // hide the back button
               }
               else {
                   Toast.makeText(getApplicationContext(), "ERROR",Toast.LENGTH_LONG).show();
               }
           }
        });

    }

    public void get_json() {
        String json;
        try {
            InputStream is = getAssets().open("investingdefinitions.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                if (obj.getString("id").equals("1")) {
                    numberlist.add(obj.getString("name"));
                }
                else if (obj.getString("id").equals("2")) {
                    numberlist.add(obj.getString("name"));
                }
                else if (obj.getString("id").equals("3")) {
                    numberlist.add(obj.getString("name"));
                }
                else if (obj.getString("id").equals("4")) {
                    numberlist.add(obj.getString("name"));
                }
                else if (obj.getString("id").equals("5")) {
                    numberlist.add(obj.getString("name"));
                }
                else if (obj.getString("id").equals("6")) {
                    numberlist.add(obj.getString("name"));
                }else if (obj.getString("id").equals("7")) {
                    numberlist.add(obj.getString("name"));
                }
                else if (obj.getString("id").equals("8")) {
                    numberlist.add(obj.getString("name"));
                }
                else if (obj.getString("id").equals("9")) {
                    numberlist.add(obj.getString("name"));
                }else if (obj.getString("id").equals("10")) {
                    numberlist.add(obj.getString("name"));
                }else if (obj.getString("id").equals("11")) {
                    numberlist.add(obj.getString("name"));
                }
                else if (obj.getString("id").equals("12")) {
                    numberlist.add(obj.getString("name"));
                }else if (obj.getString("id").equals("13")) {
                    numberlist.add(obj.getString("name"));
                }else if (obj.getString("id").equals("14")) {
                    numberlist.add(obj.getString("name"));
                }else if (obj.getString("id").equals("15")) {
                    numberlist.add(obj.getString("name"));
                }
                else if (obj.getString("id").equals("16")) {
                    numberlist.add(obj.getString("name"));
                }
                else if (obj.getString("id").equals("17")) {
                    numberlist.add(obj.getString("name"));
                }
                else if (obj.getString("id").equals("18")) {
                    numberlist.add(obj.getString("name"));
                }
            }
            //Toast.makeText(getApplicationContext(),numberlist.toString(),Toast.LENGTH_LONG).show();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}