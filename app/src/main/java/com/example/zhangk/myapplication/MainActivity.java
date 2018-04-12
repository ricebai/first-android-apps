package com.example.zhangk.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showRabbitView(View view) {
        Intent intent =new Intent(MainActivity.this,RabbitActivity.class);
//        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        startActivity(intent);
    }


    public void showLoginView(View view) {
        Intent intent =new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}
