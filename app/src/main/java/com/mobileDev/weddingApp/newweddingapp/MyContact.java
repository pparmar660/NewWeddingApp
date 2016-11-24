package com.mobileDev.weddingApp.newweddingapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Parvesh on 19-11-2016.
 */


public class MyContact extends AppCompatActivity {
    ImageView makeCallGroom,makeCallBrother,makeCallFather;
    static final Integer GROOM_CALL =1;
    static final Integer BROTHER_CALL =2;
    static final Integer FATHER_CALL =3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);

        makeCallGroom=(ImageView)findViewById(R.id.callGroom);
        makeCallBrother=(ImageView)findViewById(R.id.callBrother);
        makeCallFather=(ImageView)findViewById(R.id.callFather);

        makeCallGroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askForPermission(Manifest.permission.CALL_PHONE,GROOM_CALL);
            }
        });


    }


    private void askForPermission(String permission, Integer requestCode) {
        if (ContextCompat.checkSelfPermission(MyContact.this, permission) != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(MyContact.this, permission)) {

                //This is called if user has denied the permission before
                //In this case I am just asking the permission again
                ActivityCompat.requestPermissions(MyContact.this, new String[]{permission}, requestCode);

            } else {

                ActivityCompat.requestPermissions(MyContact.this, new String[]{permission}, requestCode);
            }
        } else {
            //Toast.makeText(this, "" + permission + " is already granted.", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(MyContact.this, new String[]{permission}, requestCode);
        }
    }




    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Intent callIntent;
        if (ActivityCompat.checkSelfPermission(this, permissions[0]) == PackageManager.PERMISSION_GRANTED) {
            switch (requestCode) {
                //Location
                case 1:
                     callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + "+91-875-077-9339"));
                    startActivity(callIntent);
                    break;
                case 2:
                     callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + "+91-962-771-1140"));
                    startActivity(callIntent);

                    break;
                //Write external Storage
                case 3:

                    callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + "+91-901-235-8084"));
                    startActivity(callIntent);

                    break;
            }
        }
    }
}

