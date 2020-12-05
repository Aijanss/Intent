package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

     private TextView textView;
     private ImageView imageView;
     private Button enter;
     private Button emile;



     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enter=findViewById(R.id.button);
        textView=findViewById(R.id.text);
        emile=findViewById(R.id.buttonEnter);
        imageView=findViewById(R.id.image);

        imageView.setImageURI((Uri)getIntent().getParcelableExtra("img"));
        textView.setText(getIntent().getStringExtra("Результат"));
    }

    public void Email(View view) {
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, emile.getText().toString());
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Choose Mail App"));

        }
         public void buttonEnter(View view) {
        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent);


    }


    }
