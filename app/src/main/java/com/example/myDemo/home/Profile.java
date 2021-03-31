package com.example.myDemo.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myDemo.R;
import com.example.myDemo.mvvm.HomeActivity;

public class Profile extends AppCompatActivity {
    ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.activity_profile);

        imgBack = findViewById(R.id.img_backprofile);
        imgBack.setOnClickListener(v -> {
            Intent intent = new Intent(Profile.this, HomeActivity.class);
            startActivity(intent);
        });
    }
}