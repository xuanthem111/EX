package com.example.myDemo.mvvm.database.firebase_auth;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.myDemo.mvvm.view.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

public class FireBaseAuth{
    private Context context;
    FirebaseAuth auth;
    private MutableLiveData<FirebaseUser> userLiveData;
    private MutableLiveData<Boolean> loggedOutLiveData;


    public void dangNhap(String Tk, String Mk, CallBack callBack) {
        auth.signInWithEmailAndPassword(Tk, Mk).addOnCompleteListener((Executor) context, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    callBack.success(true);
                }
            }
        });
    }
    public void logOut() {
        auth.signOut();
        loggedOutLiveData.postValue(true);
    }

    public interface CallBack{
        void success(boolean result);
    }

}
