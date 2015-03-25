package com.example.priteshpatel.sharedprefs;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


//This App will be basically used to store single variables in a file called as shared preferences
public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    public static String filename="MysharedPrefs";
    EditText et;
    Button save,load;
    SharedPreferences sp;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=getSharedPreferences(filename,0);
        initStuffs();
    }

    public void initStuffs(){
        //Initialize all the elements
        save=(Button)findViewById(R.id.saveButton);
        load=(Button)findViewById(R.id.loadButton);
        et=(EditText)findViewById(R.id.editText1);
        tv=(TextView)findViewById(R.id.textView);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            //If user taped on Save button
            case R.id.saveButton:
                if(isEmpty(et)==true)
                {
                    Toast.makeText(this, " Enter something ",Toast.LENGTH_SHORT).show();
                    et.requestFocus();
                    break;
                }
                else {
                    String saveData = et.getText().toString();

                    SharedPreferences.Editor editor = sp.edit();//Create an editer to actually save the data
                    editor.putString("EdittextData", saveData);//save data in preference with a key-value parameter
                    editor.commit();//Need to actually commit to save into file
                    Toast.makeText(this, "'"+saveData + "' has been saved", Toast.LENGTH_SHORT).show();
                    break;
                }
            case R.id.loadButton:
                sp=getSharedPreferences(filename,0);
                String show=sp.getString("EdittextData","Data not found");//First parameter is actual key, 2nd is a message if data not found for the key
                tv.setText(show);
                break;
        }
    }
    public boolean isEmpty(EditText et)
    {
        if(et.getText().toString().trim().length()>0)
        {
            return false;
        }
        else
        {

            return true;
        }

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
