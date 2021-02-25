package com.example.activityexampleproject;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LifeCycleActivity  extends AppCompatActivity {

    TextView textView;
    Button button;

    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("LifeCycleActivity :: ","onCreate method");
        setContentView(R.layout.layout_lifecycle);
        textView =(TextView) findViewById(R.id.textViewCount);
        count=0;
       /*
       you can use the below code to instead of RestoreInstance state
       if(savedInstanceState!=null){
            count=savedInstanceState.getInt("myCount",0);
        }

        */
        textView.setText("Count :"+count);
    }

    public void incrementCount(View view) {
        count++;
        textView.setText("Count :"+count);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycleActivity :: ","onStart method");

    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("LifeCycleActivity :: ","onSaveInstanceState method");
        outState.putInt("myCount",count);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("LifeCycleActivity :: ","onRestoreInstanceState method");
        count=savedInstanceState.getInt("myCount",0);
        textView.setText("Count :"+count);
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycleActivity :: ","onResume method");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycleActivity :: ","onPause method");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycleActivity :: ","onStop method");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycleActivity :: ","onDestroy method");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycleActivity :: ","onRestart method");

    }

}
