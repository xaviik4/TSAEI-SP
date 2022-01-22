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

public class investingLessons extends AppCompatActivity {

    ArrayList<String> nameList = new ArrayList<>();
    ArrayList<String> definitionList = new ArrayList<>();

    private Button nextButton;
    private Button backButton;
    int pageNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.investing_lessons);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);
        TextView name = (TextView) findViewById(R.id.name);
        TextView definition = (TextView) findViewById(R.id.definitions);
        get_json();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                // will have a starting screen before next button is pressed
                next(pageNumber);

            }

            public void next(int p) {

                if (p == 0) {
                    name.setText(nameList.get(p));
                    definition.setText(definitionList.get(p));
                    pageNumber++;
                    //hide back button
                } else if (p == 1) {
                    name.setText(nameList.get(p));
                    definition.setText(definitionList.get(p));
                    pageNumber++;
                }
                else if (p == 2) {
                    name.setText(nameList.get(p));
                    definition.setText(definitionList.get(p));
                    pageNumber++;
                }
                else if (p == 3) {
                    name.setText(nameList.get(p));
                    definition.setText(definitionList.get(p));
                    pageNumber++;
                }
                else if (p == 4) {
                    name.setText(nameList.get(p));
                    definition.setText(definitionList.get(p));
                    pageNumber++;
                }
                else if (p == 5) {
                    name.setText(nameList.get(p));
                    definition.setText(definitionList.get(p));
                    pageNumber++;
                }else if (p == 6) {
                    name.setText(nameList.get(p));
                    definition.setText(definitionList.get(p));
                    pageNumber++;
                }
                else if (p == 7) {
                    name.setText(nameList.get(p));
                    definition.setText(definitionList.get(p));
                    pageNumber++;
                }
                else if (p == 8) {
                    name.setText(nameList.get(p));
                    definition.setText(definitionList.get(p));
                    pageNumber++;
                }
                else if (p == 9) {
                    name.setText(nameList.get(p));
                    definition.setText(definitionList.get(p));
                    pageNumber++;
                }
                else if (p == 10) {
                    name.setText(nameList.get(p));
                    definition.setText(definitionList.get(p));
                    pageNumber++;
                }
                else if (p == 11) {
                    name.setText(nameList.get(p));
                    definition.setText(definitionList.get(p));
                    pageNumber++;
                }
                else if (p == 12) {
                    name.setText(nameList.get(p));
                    definition.setText(definitionList.get(p));
                    pageNumber++;
                }
                else if (p == 13) {
                    name.setText(nameList.get(p));
                    definition.setText(definitionList.get(p));
                    pageNumber++;
                }
                else if (p == 14) {
                    name.setText(nameList.get(p));
                    definition.setText(definitionList.get(p));
                    pageNumber++;
                }
                else if (p == 15) {
                    name.setText(nameList.get(p));
                    definition.setText(definitionList.get(p));
                    pageNumber++;
                }
                else if (p == 16) {
                    name.setText(nameList.get(p));
                    definition.setText(definitionList.get(p));
                    pageNumber++;
                }
                else if (p == 17) {
                    name.setText(nameList.get(p));
                    definition.setText(definitionList.get(p));
                }
                else {
                    Toast.makeText(getApplicationContext(), "No further content",Toast.LENGTH_LONG).show();
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
                   name.setText(nameList.get(p - 1));
                   definition.setText(definitionList.get(p - 1));
                   pageNumber--;
               }
               else if (p == 16) {
                   name.setText(nameList.get(p - 1));
                   definition.setText(definitionList.get(p - 1));
                   pageNumber--;
               }
               else if (p == 15) {
                   name.setText(nameList.get(p - 1));
                   definition.setText(definitionList.get(p - 1));
                   pageNumber--;
               }
               else if (p == 14) {
                   name.setText(nameList.get(p - 1));
                   definition.setText(definitionList.get(p - 1));
                   pageNumber--;
               }
               else if (p == 13) {
                   name.setText(nameList.get(p - 1));
                   definition.setText(definitionList.get(p - 1));
                   pageNumber--;
               }else if (p == 12) {
                   name.setText(nameList.get(p - 1));
                   definition.setText(definitionList.get(p - 1));
                   pageNumber--;
               }
               else if (p == 11) {
                   name.setText(nameList.get(p - 1));
                   definition.setText(definitionList.get(p - 1));
                   pageNumber--;
               }
               else if (p == 10) {
                   name.setText(nameList.get(p - 1));
                   definition.setText(definitionList.get(p - 1));
                   pageNumber--;
               }
               else if (p == 9) {
                   name.setText(nameList.get(p - 1));
                   definition.setText(definitionList.get(p - 1));
                   pageNumber--;
               }
               else if (p == 8) {
                   name.setText(nameList.get(p - 1));
                   definition.setText(definitionList.get(p - 1));
                   pageNumber--;
               }
               else if (p == 7) {
                   name.setText(nameList.get(p - 1));
                   definition.setText(definitionList.get(p - 1));
                   pageNumber--;
               }
               else if (p == 6) {
                   name.setText(nameList.get(p - 1));
                   definition.setText(definitionList.get(p - 1));
                   pageNumber--;
               }
               else if (p == 5) {
                   name.setText(nameList.get(p - 1));
                   definition.setText(definitionList.get(p - 1));
                   pageNumber--;
               }
               else if (p == 4) {
                   name.setText(nameList.get(p - 1));
                   definition.setText(definitionList.get(p - 1));
                   pageNumber--;
               }
               else if (p == 3) {
                   name.setText(nameList.get(p - 1));
                   definition.setText(definitionList.get(p - 1));
                   pageNumber--;
               }
               else if (p == 2) {
                   name.setText(nameList.get(p - 1));
                   definition.setText(definitionList.get(p - 1));
                   pageNumber--;
               }
               else if (p == 1) {
                   name.setText(nameList.get(0));
                   definition.setText(definitionList.get(0));
                   pageNumber--;
                   // hide the back button
               }
               else {
                   Toast.makeText(getApplicationContext(), "No previous content",Toast.LENGTH_LONG).show();
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
                    nameList.add(obj.getString("name"));
                }
                else if (obj.getString("id").equals("2")) {
                    nameList.add(obj.getString("name"));
                }
                else if (obj.getString("id").equals("3")) {
                    nameList.add(obj.getString("name"));
                }
                else if (obj.getString("id").equals("4")) {
                    nameList.add(obj.getString("name"));
                }
                else if (obj.getString("id").equals("5")) {
                    nameList.add(obj.getString("name"));
                }
                else if (obj.getString("id").equals("6")) {
                    nameList.add(obj.getString("name"));
                }else if (obj.getString("id").equals("7")) {
                    nameList.add(obj.getString("name"));
                }
                else if (obj.getString("id").equals("8")) {
                    nameList.add(obj.getString("name"));
                }
                else if (obj.getString("id").equals("9")) {
                    nameList.add(obj.getString("name"));
                }else if (obj.getString("id").equals("10")) {
                    nameList.add(obj.getString("name"));
                }else if (obj.getString("id").equals("11")) {
                    nameList.add(obj.getString("name"));
                }
                else if (obj.getString("id").equals("12")) {
                    nameList.add(obj.getString("name"));
                }else if (obj.getString("id").equals("13")) {
                    nameList.add(obj.getString("name"));
                }else if (obj.getString("id").equals("14")) {
                    nameList.add(obj.getString("name"));
                }else if (obj.getString("id").equals("15")) {
                    nameList.add(obj.getString("name"));
                }
                else if (obj.getString("id").equals("16")) {
                    nameList.add(obj.getString("name"));
                }
                else if (obj.getString("id").equals("17")) {
                    nameList.add(obj.getString("name"));
                }
                else if (obj.getString("id").equals("18")) {
                    nameList.add(obj.getString("name"));
                }
            }

            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                if (obj.getString("id").equals("1")) {
                    definitionList.add(obj.getString("definition"));
                }
                else if (obj.getString("id").equals("2")) {
                    definitionList.add(obj.getString("definition"));
                }
                else if (obj.getString("id").equals("3")) {
                    definitionList.add(obj.getString("definition"));
                }
                else if (obj.getString("id").equals("4")) {
                    definitionList.add(obj.getString("definition"));
                }
                else if (obj.getString("id").equals("5")) {
                    definitionList.add(obj.getString("definition"));
                }
                else if (obj.getString("id").equals("6")) {
                    definitionList.add(obj.getString("definition"));
                }else if (obj.getString("id").equals("7")) {
                    definitionList.add(obj.getString("definition"));
                }
                else if (obj.getString("id").equals("8")) {
                    definitionList.add(obj.getString("definition"));
                }
                else if (obj.getString("id").equals("9")) {
                    definitionList.add(obj.getString("definition"));
                }else if (obj.getString("id").equals("10")) {
                    definitionList.add(obj.getString("definition"));
                }else if (obj.getString("id").equals("11")) {
                    definitionList.add(obj.getString("definition"));
                }
                else if (obj.getString("id").equals("12")) {
                    definitionList.add(obj.getString("definition"));
                }else if (obj.getString("id").equals("13")) {
                    definitionList.add(obj.getString("definition"));
                }else if (obj.getString("id").equals("14")) {
                    definitionList.add(obj.getString("definition"));
                }else if (obj.getString("id").equals("15")) {
                    definitionList.add(obj.getString("definition"));
                }
                else if (obj.getString("id").equals("16")) {
                    definitionList.add(obj.getString("definition"));
                } else if (obj.getString("id").equals("17")) {
                    definitionList.add(obj.getString("definition"));
                } else if (obj.getString("id").equals("18")) {
                    definitionList.add(obj.getString("definition"));
                }
            }
            //Toast.makeText(getApplicationContext(),nameList.toString(),Toast.LENGTH_LONG).show();

        } catch (UnsupportedEncodingException | JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}