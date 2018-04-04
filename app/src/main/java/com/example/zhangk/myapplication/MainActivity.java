package com.example.zhangk.myapplication;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView[] img = new ImageView[4];
    private int[] imagePath = new int[]{
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = findViewById(R.id.layout1);

        for(int i=0;i<imagePath.length;i++){
            img[i] = new ImageView(this);
            img[i].setImageResource(imagePath[i]);
            img[i].setMinimumWidth(100);
            img[i].setMinimumHeight(100);
            img[i].setPadding(5,5,5,5);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(253, 148);
            img[i].setLayoutParams(params);
            layout.addView(img[i]);
        }

        LinearLayout line2 = findViewById(R.id.line2);
        for(int i=0;i<20;i++){
            TextView v = new TextView(this);
            v.setText("TEST_"+i);
            v.setTextSize(30);
            v.setPadding(5,5,5,5);
            line2.addView(v);
        }


//        craeateUI();
    }

    private void craeateUI(){

        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.ic_launcher_background));
        setContentView(frameLayout);

        TextView textView = new TextView(this);
        textView.setText("在代码中控制UI界面");
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, 50);
        textView.setTextColor(Color.rgb(1,1,1));
//        textView.setBackgroundResource(R.color.colorPrimary);

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
