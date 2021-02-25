package com.example.activityexampleproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText =(EditText) findViewById(R.id.editTextTextPersonName);
        button = (Button)findViewById(R.id.button);
        textView = (TextView)findViewById(R.id.textView2);

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    public void goToSecond(View view) {

        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("Username",editText.getText().toString());
        startActivityForResult(intent,123);

    }
    //Override tjhis method to check whether the result we received is correct or not
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==123){
            String str = data.getStringExtra("getResultName").toString();
            textView.setText(str);
        }
    }
    //This function opens the location on map based on longitude and lattitude specified
    public void gotoMyHouse(View view) {
        //12.9446438,77.7323522,15z
        Intent intent =new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:12.9446438,77.7323522,15z"));
        Intent intentChooser = intent.createChooser(intent,"Choose app :");
        startActivity(intentChooser);

    }

//open app
    public void openApp(View view) {
        Intent intent =new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=com.ted.android.tv&hl=en_IN&gl=US"));
        Intent intentChooser = intent.createChooser(intent,"open app :");
        startActivity(intentChooser);

    }

    // this is to send email
    public void sendMail(View view) {
        Intent intent =new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String to[] ={"get2shyamala@gmail.com","nagesh341@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL,to);
        intent.putExtra(Intent.EXTRA_SUBJECT,"Hello from android");
        intent.putExtra(Intent.EXTRA_TEXT,"This is samy from android");
        intent.setType("message/rfc822");
        Intent intentChooser = intent.createChooser(intent,"Email :");
        startActivity(intentChooser);
    }


    public void sendText(View view) {
        EditText text = (EditText) findViewById(R.id.textMsg);
        String sharemsg = text.getText().toString();
        Intent intent =new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,sharemsg);
        Intent intentChooser = intent.createChooser(intent,"Share Text :");
        startActivity(intentChooser);
    }

    public void gotoLifeCycle(View view) {
        Intent intent = new Intent(this,LifeCycleActivity.class);
         startActivity(intent);
    }

    public void makeaPhoneCall(View view) {
        Intent intent =new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:919880356447"));
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);

    }
}