package com.example.hussamalwani.tweets4news;

import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class TextAnalyzer {

    private static final String TAG = TextAnalyzer.class.getName();
    public String analyze(String input, String tool) {
        //Disable AsyncTask Exception
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String result = "";
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://tools.nlp.itu.edu.tr/SimpleApi");
        List<NameValuePair> parameters = new ArrayList<>(3);

        try {
        /*    String[] split = input.split("\\s+");

            for (int i = 0; i < split.length; i++) {
                split[i] = split[i] + " " + split[i] + EXTENSIONS;
            }

            String modifiedData = "";

            for (int i = 0; i < split.length; i++) {
                modifiedData = modifiedData + split[i] + "\n";
            }
*/
            parameters.add(new BasicNameValuePair("tool", tool));
            parameters.add(new BasicNameValuePair("input", input));
            parameters.add(new BasicNameValuePair("token", "CHANGE THIS"));

            post.setEntity(new UrlEncodedFormEntity(parameters, "UTF-8"));
            HttpResponse resp = client.execute(post);

            result = EntityUtils.toString(resp.getEntity());

            //Toast.makeText(this, EntityUtils.toString(resp.getEntity()), Toast.LENGTH_LONG).show();
        }
        catch (Exception e) {
            Log.d(TAG, e.toString());
            //Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
        return result;
    }

}
