package com.example.zhangk.myapplication;

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

        FrameLayout frameLayout = findViewById(R.id.myLayout);
        final RabbitView rabbit = new RabbitView(MainActivity.this);
        rabbit.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN :
                        rabbit.setDow(motionEvent);
                        break;
                    case MotionEvent.ACTION_UP :
                        rabbit.setUp();
                        break;
                    case MotionEvent.ACTION_MOVE :
                        rabbit.setMove(motionEvent);
                        break;
                }
                return true;
            }
        });

        frameLayout.addView(rabbit);
    }
}
