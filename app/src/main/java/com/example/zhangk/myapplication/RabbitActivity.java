package com.example.zhangk.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.example.zhangk.myapplication.R;
import com.example.zhangk.myapplication.view.RabbitView;

public class RabbitActivity extends AppCompatActivity {

    private RabbitView rabbit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rabbit);

        FrameLayout frameLayout = findViewById(R.id.myLayout);
        rabbit = new RabbitView(RabbitActivity.this);
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


    public void backClick(View view) {
        finish();
    }
}
