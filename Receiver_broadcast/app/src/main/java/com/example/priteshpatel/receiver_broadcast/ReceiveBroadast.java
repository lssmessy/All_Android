package com.example.priteshpatel.receiver_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
public class ReceiveBroadast extends BroadcastReceiver {
    public ReceiveBroadast() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Broadcast message received!!",Toast.LENGTH_LONG).show();
    }
}
