package com.example.priteshpatel.autolay;

import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import  android.widget.Button;
import android.graphics.Color;
import android.widget.EditText;
import android.content.res.Resources;
import android.util.TypedValue;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //Set Layout
        RelativeLayout rl=new RelativeLayout(this);
        rl.setBackgroundColor(Color.parseColor("#00CCFF"));

        //button
        Button btn=new Button(this);
        btn.setText("Log in ");
        btn.setBackgroundColor(Color.parseColor("#A5ABAB"));

        RelativeLayout.LayoutParams btnparams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        btnparams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        btnparams.addRule(RelativeLayout.CENTER_VERTICAL);

        //username
        EditText username=new EditText(this);
        username.setHint("Username");
        btn.setId(1);
        username.setId(2);


        EditText password=new EditText(this);
        password.setHint("Password");
        password.setId(3);
        password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);

        //setting rules
        RelativeLayout.LayoutParams usrparams=new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        usrparams.addRule(RelativeLayout.ABOVE,password.getId());
        usrparams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        usrparams.setMargins(0,0,0,50);
        //password
                RelativeLayout.LayoutParams passparams=new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        passparams.addRule(RelativeLayout.ABOVE, btn.getId());
        passparams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        passparams.setMargins(0,0,0,50);



        //type cast device pixels and setting widthfor username
        Resources rs=getResources();
        int pxls=(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,320,rs.getDisplayMetrics());
        username.setWidth(pxls);
        password.setWidth(pxls);
       //add button to View
        rl.addView(btn,btnparams);
        rl.addView(username,usrparams);
        rl.addView(password,passparams);

        setContentView(rl);
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
