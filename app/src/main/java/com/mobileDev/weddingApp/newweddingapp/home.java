package com.mobileDev.weddingApp.newweddingapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.szugyi.circlemenu.view.CircleImageView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;

public class home extends AppCompatActivity implements View.OnClickListener {
    CircleImageView  locationIcon,contactIcon,galleryIcon,calenderIcon,messageIcon;
    static  String dateFormat="yyyy-MM-dd HH:mm";
    public ArrayList<String>alarmTimeArray=new ArrayList<>();

    private PendingIntent pendingIntent;

    AlarmManager alarmManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        locationIcon=(CircleImageView) findViewById(R.id.locationView);
        contactIcon=(CircleImageView)findViewById(R.id.contactView);
        galleryIcon=(CircleImageView)findViewById(R.id.galleryView);
        calenderIcon=(CircleImageView)findViewById(R.id.calenderView);
        messageIcon=(CircleImageView)findViewById(R.id.messageView);

        locationIcon.setOnClickListener(this);
        contactIcon.setOnClickListener(this);
        galleryIcon.setOnClickListener(this);
        calenderIcon.setOnClickListener(this);
        messageIcon.setOnClickListener(this);
        alarmTimeArray.add("2016-12-2 08:30");
        alarmTimeArray.add("2016-12-3 08:30");
        alarmTimeArray.add("2016-12-4 08:30");

        SetAlarm();
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){

            case R.id.messageView:
                 i=new Intent(getApplicationContext(),Invitation.class);
                startActivity(i);
            break;

            case R.id.locationView :
                 i=new Intent(getApplicationContext(),MyLocation.class);
                startActivity(i);
                break;
            case R.id.calenderView :
                i=new Intent(getApplicationContext(),MyEvents.class);
                startActivity(i);
                break;

            case R.id.galleryView :
                i=new Intent(getApplicationContext(),MyGallery.class);
                startActivity(i);
                break;


            case R.id.contactView :
                i=new Intent(getApplicationContext(),MyContact.class);
                startActivity(i);
                break;


        }
    }

        public void SetAlarm(){

            for(int i=0;i<alarmTimeArray.size();i++) {
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat(home.dateFormat);

                try {
                    cal.setTime(sdf.parse(alarmTimeArray.get(i)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }


                Intent myIntent = new Intent(home.this, AlarmReceiver.class);
                pendingIntent = PendingIntent.getBroadcast(home.this, 0, myIntent, 0);
                alarmManager.set(AlarmManager.RTC, cal.getTimeInMillis(), pendingIntent);
            }
    }


}
