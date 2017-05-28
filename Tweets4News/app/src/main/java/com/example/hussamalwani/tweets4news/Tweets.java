package com.example.hussamalwani.tweets4news;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Tweets extends Activity {

    ListView lv;
    TextView tv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweets);

        lv = (ListView) findViewById(R.id.tweetsList);
        tv = (TextView) findViewById(R.id.textView4);

        List<String> list = new ArrayList<>();
        String[] stringArr;

        try{
            BufferedReader bfr = new BufferedReader(new InputStreamReader(getAssets().open("tweetsDB.txt")));

            String str;

            while((str = bfr.readLine()) != null){
                if(!str.startsWith("$")){
                    list.add(str);
                }
            }
            stringArr = list.toArray(new String[0]);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.activity_newstitles, R.id.textView, stringArr);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String itemValue = (String) lv.getItemAtPosition(i);

                    Toast.makeText(getApplicationContext(),
                            "Position :" + i + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                            .show();

                    Intent intent = new Intent(view.getContext(), Tweets.class);
                    startActivity(intent);
                }
            });

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}