package com.example.priteshpatel.checksdcard;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    TextView tv1,tv2;
    String state;
    String paths[]={"Pics","Docs","Music"};
    Spinner spinner;
    File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.textView1);
        tv2=(TextView)findViewById(R.id.textView2);
        state= Environment.getExternalStorageState();

        if(state.equals(Environment.MEDIA_MOUNTED))
        {
            //read and write
            tv1.setText("True");
            tv2.setText("True");
        }
        else if(state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
            tv1.setText("Read only");
            tv2.setText("Can't Write");
        }
        else
        {
            tv1.setText("True");
            tv2.setText("True");
        }

        ArrayAdapter<String> adaper=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,paths);
        spinner=(Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(adaper);
        spinner.setOnItemSelectedListener(this);
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

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

       Log.i("postion", String.valueOf(position));
       switch (position)
       {
           case 0:

               file=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
               Log.i("path",file.toString());
               String parnt=file.getParent();
               Log.i("parent",parnt);

               break;
           case 1:
               file=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsoluteFile();
               Log.i("path",file.toString());
               String part=file.getParent();
               Log.i("parent",part);
               /*file=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
               file.getAbsolutePath();*/

               break;
           case 2:
               file=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsoluteFile();
               Log.i("path",file.toString());
               String par=file.getParent();

               Log.i("parent",par);
               //file=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
            break;
       }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
