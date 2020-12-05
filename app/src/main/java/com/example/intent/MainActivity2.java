package com.example.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

public class MainActivity2 extends AppCompatActivity {
    private EditText editText;
    private Button toActivity1;
    private ImageView buttonImageView;

    static final int GALLERY_REQUEST = 1;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText = findViewById(R.id.edText);
        toActivity1 = findViewById(R.id.button2);
        buttonImageView = findViewById(R.id.imageView2);
        buttonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, GALLERY_REQUEST);

            }
        });
    }


    public void buttonBack(View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        String text1 = editText.getText().toString();
        intent.putExtra("Результат", text1);
        intent.putExtra("img", imageUri);
        startActivity(intent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_REQUEST && resultCode == RESULT_OK && data != null) {
            imageUri = data.getData();
            buttonImageView.setImageURI(imageUri);
        }
    }
}


