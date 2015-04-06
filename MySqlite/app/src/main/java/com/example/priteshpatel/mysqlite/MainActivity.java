package com.example.priteshpatel.mysqlite;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    EditText et;
    TextView tv;
    MyDBHandler myDBHandler;
    InputMethodManager im;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=(EditText)findViewById(R.id.pseditText);
        tv=(TextView)findViewById(R.id.displayText);
        next=(Button)findViewById(R.id.nextButton);
        myDBHandler=new MyDBHandler(this,null,null,1);
        printDatabase();
    }
//Add the text to the database
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public void addbuttonClicked(View view){
        String addtext=et.getText().toString();
        if(addtext.isEmpty())
        {
            Toast.makeText(this,"You can't left it blank",Toast.LENGTH_SHORT).show();
            et.requestFocus();
        }
        else {
            Products products = new Products(addtext);
            myDBHandler.addProducts(products);
            Toast.makeText(this,addtext+" has been added to SQLite!",Toast.LENGTH_SHORT).show();
            et.requestFocus();

        }
        printDatabase();

        im=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(et.getWindowToken(),0);



    }
    public void onNextClick(View view){
        ProgressDialog progressbar=new ProgressDialog(this);
        progressbar.setMessage("Sending Next");
        progressbar.setMax(10);
        progressbar.show();

        setContentView(R.layout.nextpage);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        progressbar.dismiss();

    }
    public void onBackClick(View view){
        setContentView(R.layout.activity_main);
    }

    // Delete data
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public void deleteClicked(View view){

        String dbString=et.getText().toString();
        if(dbString.isEmpty())
        {
            Toast.makeText(this,"Enter something to Delete!!",Toast.LENGTH_SHORT).show();
            et.requestFocus();
        }
        else{
        myDBHandler.deleteProducts(dbString);
            Toast.makeText(this,dbString+" has been deleted!!",Toast.LENGTH_SHORT).show();
            et.requestFocus();
        }
        printDatabase();
        im=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(et.getWindowToken(),0);

    }
    //Print data to the textview field
    public void printDatabase(){
        tv.setText(myDBHandler.dataToString());
        et.setText("");

    }

}
