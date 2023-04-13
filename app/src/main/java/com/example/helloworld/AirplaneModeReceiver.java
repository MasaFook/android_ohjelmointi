package com.example.helloworld;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {

    public static final String TAG = "AirplaneModeReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");

        boolean state = intent.getBooleanExtra("state", false);
        Log.e(TAG,"Tuleeko onReceive() metodiin? " + state);

        int duration = Toast.LENGTH_SHORT;

        if(state == true){
            CharSequence text = "AirplaneMode on";
            Toast toast = Toast.makeText(context,text, duration);
            toast.show();
        }
        else {
            CharSequence text = "AirplaneMode off";
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}