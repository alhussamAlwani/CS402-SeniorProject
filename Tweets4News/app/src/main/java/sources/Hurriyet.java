package sources;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.*;

import com.example.hussamalwani.tweets4news.QueryVariables;
import com.example.hussamalwani.tweets4news.R;
import com.example.hussamalwani.tweets4news.TwitterSearch;

import java.io.*;
import java.net.URL;
import java.util.*;

public class Hurriyet extends Activity {

    TextView tv;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newstitles);
        tv = (TextView) findViewById(R.id.textView);
        lv = (ListView) findViewById(R.id.titleList);

        Set<String> hashSet = new LinkedHashSet<>();
        String[] stringArr;

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try{

            URL url = new URL("http://alhussamalwani.pagekite.me/android_login_api/newsTitleHurriyet.txt");
            BufferedReader bfr = new BufferedReader(new InputStreamReader(url.openStream()));

            //BufferedReader bfr = new BufferedReader(new InputStreamReader(getAssets().open("newsTitleHurriyet.txt")));

            String str;

            while((str = bfr.readLine()) != null){
                if(!str.startsWith("$")){
                    hashSet.add(str);
                }
            }

            stringArr = hashSet.toArray(new String[0]);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_newstitles, R.id.textView, stringArr);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    int itemPosition = i;
                    String itemValue = (String) lv.getItemAtPosition(itemPosition);
                    QueryVariables.queries.add(itemValue);

                    Intent intent = new Intent(view.getContext(), TwitterSearch.class);
                    startActivity(intent);
                }
            });

        }catch (IOException e){
            e.printStackTrace();
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
