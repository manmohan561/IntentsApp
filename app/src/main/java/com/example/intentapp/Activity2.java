package com.example.intentapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {
    Button b2,b1;
    RadioButton r1,r2,r3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        Toast.makeText(this,"Welcome in activity2",Toast.LENGTH_LONG).show();
        Intent i=getIntent();
        String s=i.getStringExtra("key");

        TextView textView=findViewById(R.id.textView2);
        textView.setText("Welcome Mr. "+s);
        b1=findViewById(R.id.back);
        b2=(Button) findViewById(R.id.submit);
        b2.setOnClickListener(this);

        r1=(RadioButton)findViewById(R.id.radioButton1);
        r2=(RadioButton)findViewById(R.id.radioButton2);
        r3=(RadioButton)findViewById(R.id.radioButton3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {

        if(r1.isChecked()){
            TextView t1=(TextView) findViewById(R.id.edit1);
            String msg=t1.getText().toString();

            Intent sendIntent = new Intent(Intent.ACTION_VIEW);
            sendIntent.setData(Uri.parse("sms:"));

            sendIntent.putExtra("sms_body", msg);
            startActivity(sendIntent);
        }
        else if(r2.isChecked()){
            TextView t1=(TextView) findViewById(R.id.edit1);
            String msg=t1.getText().toString();

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT, "sub intent app");
            intent.putExtra(Intent.EXTRA_TEXT, msg);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
        else if(r3.isChecked()){
            TextView t1=(TextView) findViewById(R.id.edit1);
            String msg=t1.getText().toString();
            Uri uri = Uri.parse("https://www.google.com/search?q="+msg);

            Intent i3=new Intent(Intent.ACTION_VIEW, uri);
            startActivity(i3);
        }
    }
}