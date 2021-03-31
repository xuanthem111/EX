package com.example.myDemo.mvvm.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myDemo.R;
import com.example.myDemo.mvvm.ForgotPassword;

import com.example.myDemo.mvvm.HomeActivity;
import com.example.myDemo.mvvm.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    TextView tvforgot, tvdangky;
    Button btnDangNhap;
    EditText edtTk, edtMk;
    //FirebaseAuth mAuth;
    MainViewModel viewModel = new MainViewModel(this.getApplication());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        init();


        //mAuth = FirebaseAuth.getInstance();
        tvdangky.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this,SignUp.class);
            startActivity(i);
        });
        tvforgot.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, ForgotPassword.class);
            startActivity(i);
        });

        btnDangNhap.setOnClickListener(v -> {
            String Tk = edtTk.getText().toString().trim();
            String Mk = edtMk.getText().toString().trim();
            if (TextUtils.isEmpty(Tk) || TextUtils.isEmpty(Mk)) {
                Toast.makeText(this, "Invalid Information", Toast.LENGTH_SHORT).show();
            }else{
              viewModel.login(Tk, Mk, result -> {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                });
            }
        });
    }


    private  void init(){
        tvforgot = findViewById(R.id.tv_forgot);
        tvdangky = findViewById(R.id.tv_dangky);
        btnDangNhap = findViewById(R.id.btn_dangnhap);
        edtTk = findViewById(R.id.edt_TK);
        edtMk = findViewById(R.id.edt_MK);
    }
}