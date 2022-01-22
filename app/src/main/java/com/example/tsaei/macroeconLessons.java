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

public class macroeconLessons extends AppCompatActivity {

    ArrayList<String> nameList = new ArrayList<>();
    ArrayList<String> definitionList = new ArrayList<>();
    int pageNumber = 0;
    private Button nextButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.macroecon_lessons);
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
                    name.setText(nameList.get(0));
                    definition.setText(definitionList.get(0));
                    pageNumber++;
                    //hide back button
                } else if (p == 1) {
                    name.setText(nameList.get(1));
                    definition.setText(definitionList.get(1));
                    pageNumber++;
                } else if (p == 2) {
                    name.setText(nameList.get(2));
                    definition.setText(definitionList.get(2));
                    pageNumber++;
                } else if (p == 3) {
                    name.setText(nameList.get(3));
                    definition.setText(definitionList.get(3));
                    pageNumber++;
                } else if (p == 4) {
                    name.setText(nameList.get(4));
                    definition.setText(definitionList.get(4));
                    pageNumber++;
                } else if (p == 5) {
                    name.setText(nameList.get(5));
                    definition.setText(definitionList.get(5));
                    pageNumber++;
                } else if (p == 6) {
                    name.setText(nameList.get(6));
                    definition.setText(definitionList.get(6));
                    pageNumber++;
                } else if (p == 7) {
                    name.setText(nameList.get(7));
                    definition.setText(definitionList.get(7));
                    pageNumber++;
                } else if (p == 8) {
                    name.setText(nameList.get(8));
                    definition.setText(definitionList.get(8));
                    pageNumber++;
                } else if (p == 9) {
                    name.setText(nameList.get(9));
                    definition.setText(definitionList.get(9));
                    pageNumber++;
                } else if (p == 10) {
                    name.setText(nameList.get(10));
                    definition.setText(definitionList.get(10));
                    pageNumber++;
                } else if (p == 11) {
                    name.setText(nameList.get(11));
                    definition.setText(definitionList.get(11));
                    pageNumber++;
                } else if (p == 12) {
                    name.setText(nameList.get(12));
                    definition.setText(definitionList.get(12));
                    pageNumber++;
                } else if (p == 13) {
                    name.setText(nameList.get(13));
                    definition.setText(definitionList.get(13));
                    pageNumber++;
                } else if (p == 14) {
                    name.setText(nameList.get(14));
                    definition.setText(definitionList.get(14));
                    pageNumber++;
                } else if (p == 15) {
                    name.setText(nameList.get(15));
                    definition.setText(definitionList.get(15));
                    pageNumber++;
                } else if (p == 16) {
                    name.setText(nameList.get(16));
                    definition.setText(definitionList.get(16));
                    pageNumber++;
                } else if (p == 17) {
                    name.setText(nameList.get(17));
                    definition.setText(definitionList.get(17));
                } else {
                    Toast.makeText(getApplicationContext(), "No further content", Toast.LENGTH_LONG).show();
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
                    name.setText(nameList.get(16));
                    definition.setText(definitionList.get(16));
                    pageNumber--;
                } else if (p == 16) {
                    name.setText(nameList.get(15));
                    definition.setText(definitionList.get(15));
                    pageNumber--;
                } else if (p == 15) {
                    name.setText(nameList.get(14));
                    definition.setText(definitionList.get(14));
                    pageNumber--;
                } else if (p == 14) {
                    name.setText(nameList.get(13));
                    definition.setText(definitionList.get(13));
                    pageNumber--;
                } else if (p == 13) {
                    name.setText(nameList.get(12));
                    definition.setText(definitionList.get(12));
                    pageNumber--;
                } else if (p == 12) {
                    name.setText(nameList.get(11));
                    definition.setText(definitionList.get(11));
                    pageNumber--;
                } else if (p == 11) {
                    name.setText(nameList.get(10));
                    definition.setText(definitionList.get(10));
                    pageNumber--;
                } else if (p == 10) {
                    name.setText(nameList.get(9));
                    definition.setText(definitionList.get(9));
                    pageNumber--;
                } else if (p == 9) {
                    name.setText(nameList.get(8));
                    definition.setText(definitionList.get(8));
                    pageNumber--;
                } else if (p == 8) {
                    name.setText(nameList.get(7));
                    definition.setText(definitionList.get(7));
                    pageNumber--;
                } else if (p == 7) {
                    name.setText(nameList.get(6));
                    definition.setText(definitionList.get(6));
                    pageNumber--;
                } else if (p == 6) {
                    name.setText(nameList.get(5));
                    definition.setText(definitionList.get(5));
                    pageNumber--;
                } else if (p == 5) {
                    name.setText(nameList.get(4));
                    definition.setText(definitionList.get(4));
                    pageNumber--;
                } else if (p == 4) {
                    name.setText(nameList.get(3));
                    definition.setText(definitionList.get(3));
                    pageNumber--;
                } else if (p == 3) {
                    name.setText(nameList.get(2));
                    definition.setText(definitionList.get(2));
                    pageNumber--;
                } else if (p == 2) {
                    name.setText(nameList.get(1));
                    definition.setText(definitionList.get(1));
                    pageNumber--;
                } else if (p == 1) {
                    name.setText(nameList.get(0));
                    definition.setText(definitionList.get(0));
                    pageNumber--;
                    // hide the back button
                } else {
                    Toast.makeText(getApplicationContext(), "No previous content", Toast.LENGTH_LONG).show();
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

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                if (obj.getString("id").equals("1")) {
                    nameList.add(obj.getString("name"));
                } else if (obj.getString("id").equals("2")) {
                    nameList.add(obj.getString("name"));
                } else if (obj.getString("id").equals("3")) {
                    nameList.add(obj.getString("name"));
                } else if (obj.getString("id").equals("4")) {
                    nameList.add(obj.getString("name"));
                } else if (obj.getString("id").equals("5")) {
                    nameList.add(obj.getString("name"));
                } else if (obj.getString("id").equals("6")) {
                    nameList.add(obj.getString("name"));
                } else if (obj.getString("id").equals("7")) {
                    nameList.add(obj.getString("name"));
                } else if (obj.getString("id").equals("8")) {
                    nameList.add(obj.getString("name"));
                } else if (obj.getString("id").equals("9")) {
                    nameList.add(obj.getString("name"));
                } else if (obj.getString("id").equals("10")) {
                    nameList.add(obj.getString("name"));
                } else if (obj.getString("id").equals("11")) {
                    nameList.add(obj.getString("name"));
                } else if (obj.getString("id").equals("12")) {
                    nameList.add(obj.getString("name"));
                } else if (obj.getString("id").equals("13")) {
                    nameList.add(obj.getString("name"));
                } else if (obj.getString("id").equals("14")) {
                    nameList.add(obj.getString("name"));
                } else if (obj.getString("id").equals("15")) {
                    nameList.add(obj.getString("name"));
                } else if (obj.getString("id").equals("16")) {
                    nameList.add(obj.getString("name"));
                } else if (obj.getString("id").equals("17")) {
                    nameList.add(obj.getString("name"));
                } else if (obj.getString("id").equals("18")) {
                    nameList.add(obj.getString("name"));
                }
            }

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                if (obj.getString("id").equals("1")) {
                    definitionList.add(obj.getString("definition"));
                } else if (obj.getString("id").equals("2")) {
                    definitionList.add(obj.getString("definition"));
                } else if (obj.getString("id").equals("3")) {
                    definitionList.add(obj.getString("definition"));
                } else if (obj.getString("id").equals("4")) {
                    definitionList.add(obj.getString("definition"));
                } else if (obj.getString("id").equals("5")) {
                    definitionList.add(obj.getString("definition"));
                } else if (obj.getString("id").equals("6")) {
                    definitionList.add(obj.getString("definition"));
                } else if (obj.getString("id").equals("7")) {
                    definitionList.add(obj.getString("definition"));
                } else if (obj.getString("id").equals("8")) {
                    definitionList.add(obj.getString("definition"));
                } else if (obj.getString("id").equals("9")) {
                    definitionList.add(obj.getString("definition"));
                } else if (obj.getString("id").equals("10")) {
                    definitionList.add(obj.getString("definition"));
                } else if (obj.getString("id").equals("11")) {
                    definitionList.add(obj.getString("definition"));
                } else if (obj.getString("id").equals("12")) {
                    definitionList.add(obj.getString("definition"));
                } else if (obj.getString("id").equals("13")) {
                    definitionList.add(obj.getString("definition"));
                } else if (obj.getString("id").equals("14")) {
                    definitionList.add(obj.getString("definition"));
                } else if (obj.getString("id").equals("15")) {
                    definitionList.add(obj.getString("definition"));
                } else if (obj.getString("id").equals("16")) {
                    definitionList.add(obj.getString("definition"));
                } else if (obj.getString("id").equals("17")) {
                    definitionList.add(obj.getString("definition"));
                } else if (obj.getString("id").equals("18")) {
                    definitionList.add(obj.getString("definition"));
                }
            }
            //Toast.makeText(getApplicationContext(),nameList.toString(),Toast.LENGTH_LONG).show();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}