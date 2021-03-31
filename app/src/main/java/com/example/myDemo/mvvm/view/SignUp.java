package com.example.myDemo.mvvm.view;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myDemo.R;
import com.example.myDemo.mvvm.viewmodel.MainViewModel;

public class SignUp extends AppCompatActivity {
    TextView tvhaveAccount;
    Button btnDangKy;
    EditText edtTk, edtMk, edtEmail,edtSDT;
    private MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        mainViewModel = new MainViewModel(getApplication());

        setContentView(R.layout.activity_sign_up);
        edtTk = findViewById(R.id.edt_user);
        edtMk = findViewById(R.id.edt_password);
        edtEmail = findViewById(R.id.edt_email);
        edtSDT = findViewById(R.id.edt_phone);
        btnDangKy = findViewById(R.id.btn_dangky1);
        tvhaveAccount = findViewById(R.id.tv_haveAccount);
        tvhaveAccount.setOnClickListener(v->{
            finish();
        });
    }
}