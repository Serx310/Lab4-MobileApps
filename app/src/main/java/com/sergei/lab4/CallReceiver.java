package com.sergei.lab4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

public class CallReceiver extends BroadcastReceiver {
    private  static final String TAG = "CallReceiver";

    MainActivity mainActivity;

    public CallReceiver(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    public MainActivity getMainActivity(){
        return mainActivity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i(TAG, intent.getAction());
        String phoneState = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        String phoneNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
        Log.i(TAG, "State: " + phoneState + "Number: " +phoneNumber);
        if(phoneNumber != null){
            mainActivity.addPhoneNumberTolist(phoneNumber);
        }

    }
}
