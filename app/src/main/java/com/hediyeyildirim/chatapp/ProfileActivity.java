package com.hediyeyildirim.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {

    EditText ageText;
    ImageView userImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ageText = findViewById(R.id.ageText);
        userImageView = findViewById(R.id.userImageView);

    }

    public void upload(View view){

    }

    public void selectPicture(View view){



    }
}