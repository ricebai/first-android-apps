package com.example.zhangk.myapplication;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.ic_launcher_background));
        setContentView(frameLayout);

        TextView textView = new TextView(this);
        textView.setText("在代码中控制UI界面");
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, 50);
        textView.setTextColor(Color.rgb(1,1,1));
        textView.setBackgroundResource(R.color.colorPrimary);

        frameLayout.addView(textView);

        TextView textView2 = new TextView(this);
        textView2.setText("点击进入");
        textView2.setTextSize(TypedValue.COMPLEX_UNIT_PX, 50);
        textView2.setTextColor(Color.rgb(1,1,1));

        textView2.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this).setTitle("提示信息")
                .setMessage("游戏有风险，进入需谨慎，真的要进入吧？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.i("3.2", "进入游戏");
                    }
                }).setNegativeButton("退出", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.i("3.2","退出游戏");
                        finish();
                    }
                }).show();
            }
        });



        frameLayout.addView(textView2);
    }
}
