package com.example.priteshpatel.t_me;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Binder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyService extends Service {

    private final IBinder p_binder=new MyLocalBinder();
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return p_binder;

    }
    public String getCurrentTime(){
        SimpleDateFormat df=new SimpleDateFormat("HH:mm:ss",Locale.US);
        return df.format(new Date());
    }
    public class MyLocalBinder extends Binder{
    MyService getService(){
        return  MyService.this;
    }
    }
}
