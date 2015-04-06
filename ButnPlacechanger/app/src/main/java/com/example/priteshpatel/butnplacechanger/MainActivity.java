package com.example.priteshpatel.butnplacechanger;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import  android.view.ViewGroup;
import  android.view.View;
import android.transition.TransitionManager;

public class MainActivity extends ActionBarActivity {

    ViewGroup myLout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLout=(ViewGroup)findViewById(R.id.myLayout);
        myLout.setOnTouchListener(new RelativeLayout.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                moveButton();
                return true;
            }
        });
    }
    public void moveButton(){
        View my_btn=(View)findViewById(R.id.myButton);
        TransitionManager.beginDelayedTransition(myLout);

        //Change position of button
        RelativeLayout.LayoutParams positionRules=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
        my_btn.setLayoutParams(positionRules);

        //Change button size
        ViewGroup.LayoutParams sizeRules=my_btn.getLayoutParams();
        sizeRules.height=300;
        sizeRules.width=350;
        my_btn.setLayoutParams(sizeRules);

        //Moving to top right
      /*  TransitionManager.beginDelayedTransition(myLout);

        RelativeLayout.LayoutParams positiontop=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        positiontop.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
        positiontop.addRule(RelativeLayout.ALIGN_PARENT_TOP,RelativeLayout.TRUE);
        my_btn.setLayoutParams(positiontop);

        //Change button size
        ViewGroup.LayoutParams size_top_right_Rules=my_btn.getLayoutParams();
        size_top_right_Rules.height=150;
        size_top_right_Rules.width=200;
        my_btn.setLayoutParams(size_top_right_Rules);*/

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
