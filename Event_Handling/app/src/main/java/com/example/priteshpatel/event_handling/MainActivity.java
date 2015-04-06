package com.example.priteshpatel.event_handling;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.view.GestureDetector.SimpleOnGestureListener;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=(Button)findViewById(R.id.p_button);
        btn.setOnClickListener(new Button.OnClickListener(){

                                   public void onClick(View v){
                                       TextView p_text=(TextView)findViewById(R.id.p_text);
                                       p_text.setText("You've changed me my Button :-) ");
                                   }
                               }


        );

        btn.setOnLongClickListener(new Button.OnLongClickListener(){

            public boolean onLongClick(View v){
                TextView p_text=(TextView)findViewById(R.id.p_text);
                p_text.setText("You've Hold me tight ");
                return true;
            }
        });

        /*btn.setOnDragListener(new Button.OnDragListener(){
            public boolean onDrag(View v, DragEvent e){
                TextView p_text=(TextView)findViewById(R.id.p_text);
                p_text.setText("Draggin happened ");
                return true;
            }
        });*/
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
