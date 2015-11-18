package com.example.priteshpatel.t_me;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;


public class MainActivity extends Activity {

    private String items[];
    private DrawerLayout dl;
    private ListView listView;
    private FrameLayout fm;
      /*  MyService myservice;
        boolean isBound=false;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dl=(DrawerLayout)findViewById(R.id.drawerOnleft);
        items=getResources().getStringArray(R.array.list_items);
        listView=(ListView)findViewById(R.id.left_list);

        //Set adapter for this list
        listView.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items));
        setContentView(R.layout.activity_main);




    }
   /* public void showTime(View view){
        String time=myservice.getCurrentTime();
        TextView tv=(TextView)findViewById(R.id.time_text);
        tv.setText(time);
    }
*/
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

    /*private ServiceConnection sc=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyLocalBinder localBind=(MyLocalBinder)service;
            myservice=localBind.getService();
            isBound=true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound=false;

        }
    };*/
}
