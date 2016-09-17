package com.example.rahul.relive;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.text.format.Formatter;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Rahul on 17-09-2016.
 */
public class NewMoment extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("GoProHero");
        WifiManager wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        Log.d("wifiInfo", wifiInfo.toString());
        String wifiSSID = wifiInfo.getSSID();
        int ip = wifiInfo.getIpAddress();
        String ipAddress = Formatter.formatIpAddress(ip);
        String gopro = "10.5.5.100";
        String goprotwo = "10.5.5.109";

        Toast.makeText(getApplicationContext(),
                ipAddress, Toast.LENGTH_SHORT).show();
        if (ipAddress.equals(gopro)){
                Toast.makeText(this,"got connected",Toast.LENGTH_LONG).show();
                

        }

        else{
            if (ipAddress.equals(goprotwo)){
                //light le
            }
            else {
                Toast.makeText(this,"Check your connection",Toast.LENGTH_LONG).show();
               /* mTextView.setTextColor(Color.parseColor("#FF0000"));
                new AlertDialog.Builder(this)
                        .setTitle("Camera not connected")
                        .setMessage("1. Make sure your GoPro has wifi turned on by checking in the LCD screen/back screen. If not, turn it on by going to the settings and scrolling until Wifi, then set GoPro app, choose Existing\n2. Tap on Open Wifi settings below and connect to the GoPro camera. \n3. Restart the app.")
                        .setPositiveButton(R.string.wifi, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent browserIntent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                                startActivity(browserIntent);
                            }
                        })

                        .setNegativeButton(R.string.back, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(R.drawable.ic_launcher)
                        .show();*/
            }
        }
    }

    private void letsWork() {

    }
}

