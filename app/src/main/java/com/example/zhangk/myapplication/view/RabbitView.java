package com.example.zhangk.myapplication.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;

import com.example.zhangk.myapplication.R;

public class RabbitView extends View{

    private boolean isPaint = true;
    private float bitmapX ;
    private float bitmapY ;
    private float spaceX = 0;
    private float spaceY = 0;
    private Bitmap bitmap;

    public RabbitView(Context context) {
        super(context);
        bitmapX = 100;
        bitmapY = 20;
        bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_launcher_96);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(isPaint){
            isPaint = false;
            bitmapX = canvas.getWidth()/2-bitmap.getWidth()/2;
            bitmapY = canvas.getHeight()/2-bitmap.getHeight()/2;
        }


        Paint paint = new Paint();
        canvas.drawBitmap(bitmap, bitmapX - spaceX, bitmapY - spaceY, paint);

        if(bitmap.isRecycled()){
            bitmap.recycle();
        }
    }


    public void setMove(MotionEvent motionEvent) {
        bitmapX = motionEvent.getX();
        bitmapY = motionEvent.getY();
        invalidate();
    }

    public void setDow(MotionEvent motionEvent) {
        spaceX = motionEvent.getX() - bitmapX;
        spaceY = motionEvent.getY() - bitmapY;
    }

    public void setUp(){
        bitmapX = bitmapX - spaceX;
        bitmapY = bitmapY - spaceY;

        spaceX = 0;
        spaceY = 0;
    }
}
