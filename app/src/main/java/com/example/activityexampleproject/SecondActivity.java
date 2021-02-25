package com.example.activityexampleproject;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView mTextView;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mTextView = (TextView)findViewById(R.id.userNameText);
        mEditText =(EditText) findViewById(R.id.editTextTextPersonName2);

        String str = getIntent().getStringExtra("Username");
        mTextView.setText(str);
    }

    public void sendResultBack(View view) {
        //this code is to send back the result
        Intent intent = new Intent();
        intent.putExtra("getResultName",mEditText.getText().toString());
        setResult(RESULT_OK,intent);//this is to send the result back
        finish();
    }

}