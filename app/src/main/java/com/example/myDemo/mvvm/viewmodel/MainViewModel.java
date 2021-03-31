package com.example.myDemo.mvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.myDemo.mvvm.database.firebase_auth.FireBaseAuth;;

public class MainViewModel extends AndroidViewModel {
    FireBaseAuth auth = new FireBaseAuth();


    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public void login(String email, String pass, LoginSuccess success){
        auth.dangNhap(email, pass, result -> {
            success.success(true);
        });
    }

    public interface LoginSuccess{
        void success(boolean result);
    }
}
