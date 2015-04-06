package com.example.priteshpatel.swipper;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;


public class MainActivity extends ActionBarActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener{

    private TextView p_text;
    private GestureDetectorCompat gdc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p_text=(TextView)findViewById(R.id.p_text);
        this.gdc=new GestureDetectorCompat(this,this);
        gdc.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        p_text.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        p_text.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        p_text.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        p_text.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        p_text.setText("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        p_text.setText("onFling");
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        p_text.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        p_text.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        p_text.setText("onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gdc.onTouchEvent(event);
        return super.onTouchEvent(event);
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
