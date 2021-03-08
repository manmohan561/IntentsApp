package com.example.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button) findViewById(R.id.button);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        TextView textView=findViewById(R.id.editTextTextPersonName);

        String s= textView.getText().toString();

        Intent i=new Intent (this,Activity2.class);
        i.putExtra("key",s);
        startActivity(i);
    }
}