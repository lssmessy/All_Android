package com.example.priteshpatel.myreq;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeReq("Pritesh");
            }
        });
    }


    public void makeReq(String toPost){
        HttpClient httpclient=new DefaultHttpClient();
        HttpPost httpPost=new HttpPost("http://whtsnext.cuccfree.com/reverse.php");
        Log.i("I","Connected to site");
        String myName="test message";
        try{
            List<NameValuePair> namevaluepairs=new ArrayList<NameValuePair>(1);
            namevaluepairs.add(new BasicNameValuePair("action", myName));

            httpPost.setEntity(new UrlEncodedFormEntity(namevaluepairs));


            ResponseHandler<String> responsehandler=new BasicResponseHandler();
            String response=httpclient.execute(httpPost,responsehandler);

            String reverse=response;
            Toast.makeText(this, "reverse is " + reverse, Toast.LENGTH_SHORT).show();
        }catch(Exception e){}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
