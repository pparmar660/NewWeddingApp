package com.mobileDev.weddingApp.newweddingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.szugyi.circlemenu.view.CircleImageView;

public class home extends AppCompatActivity implements View.OnClickListener {
    CircleImageView  locationIcon,contactIcon,galleryIcon,calenderIcon,messageIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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


        }
    }
}
